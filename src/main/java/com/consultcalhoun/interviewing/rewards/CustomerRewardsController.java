package com.consultcalhoun.interviewing.rewards;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import org.javatuples.Pair;

@RestController
public class CustomerRewardsController {
    private final CustomerTransactionRepository repository;
    private static final Date DEFAULT_BEGIN_OF_DATE_RANGE;
    private static final Date DEFAULT_END_OF_DATE_RANGE; 
    private static final SimpleDateFormat simpleDateFormat;
    
    static {
        simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date omittedBeginOfRangeDate = null;
        Date omittedEndOfRangeDate = null;
        
        try {
            omittedBeginOfRangeDate = simpleDateFormat.parse("01-01-1970");
            omittedEndOfRangeDate  = simpleDateFormat.parse("12-31-2122");
        } catch (ParseException pe) {
            throw new RuntimeException("Unable to parse date(s) for begin/end range");
        }
        DEFAULT_BEGIN_OF_DATE_RANGE = omittedBeginOfRangeDate;
        DEFAULT_END_OF_DATE_RANGE = omittedEndOfRangeDate;
    }
    
    CustomerRewardsController(CustomerTransactionRepository repository) {
        this.repository = repository;
    }
    
    @GetMapping("/customer/rewards")
    public Map<Integer, CustomerReward> all(
            @RequestParam(required=false) String beginDate,
            @RequestParam(required=false) String endDate) {
        /*
        A customer receives 2 points for every dollar spent over $100 in each 
        transaction, plus 1 point for every dollar spent between $50 and
        $100 in each transaction.

        (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
        
        Given a record of every transaction during a three month period, 
        calculate the reward points earned for each customer per month and
        total.
        */
        
        // Hard-coded 3-month time interval.  Could provide query parameters.
        Date parsedBeginDate = null;
        Date parsedEndDate = null;
        
        if (beginDate != null) {
            try {
                parsedBeginDate = simpleDateFormat.parse(beginDate);
            } catch (ParseException pe) {
                throw new RuntimeException("Unable to parse date(s) for beginning of range");
            }
        }
        
        if (endDate != null) {
            try {
                parsedEndDate = simpleDateFormat.parse(endDate);
            } catch (ParseException pe) {
                throw new RuntimeException("Unable to parse date(s) for end of range");
            }
        }
        
        if (beginDate != null && endDate == null) {
            // Set parsedEndDate to the far-future.
            parsedEndDate = DEFAULT_END_OF_DATE_RANGE;
        } else if (endDate != null && beginDate == null) {
            // Set parsedBeginDate to the distant past.
            parsedBeginDate = DEFAULT_BEGIN_OF_DATE_RANGE;
        }
        
        Map<Integer, CustomerReward> rewardsByCustomerId = 
                new HashMap<>();
        
        List<CustomerTransaction> transactions = repository.findByTxDateRange(parsedBeginDate == null ? DEFAULT_BEGIN_OF_DATE_RANGE: parsedBeginDate, 
                parsedEndDate == null ? DEFAULT_END_OF_DATE_RANGE: parsedEndDate);

        // Loop through all transactions, creating CustomerReward entries 
        // in Map as appropriate.
        Map<Integer, Map<Month, Integer>> ledger = new HashMap<Integer, Map<Month, Integer>>();
        Calendar calendar = new GregorianCalendar();
        
        for (CustomerTransaction txn : transactions) {
            ledger.putIfAbsent(txn.getCustomerId(), new HashMap<>());
            int txnRewardPoints = calculateRewardPoints(txn.getAmount());

            calendar.setTime((Date)txn.getTxDate());
            // Adding 1 to get around zero-based month list of Calendar.
            Month month = Month.of(calendar.get(Calendar.MONTH) + 1);

            // If putIfAbsent returns non-null, then add calculateRewardPoints to that value.
            Integer currentPointsForMonth = ledger.get(txn.getCustomerId())
                    .putIfAbsent(month, txnRewardPoints);
            
            if (currentPointsForMonth != null) {
                ledger.get(txn.getCustomerId()).put(
                        month, 
                        currentPointsForMonth + txnRewardPoints);
            }
        }
        
        for (Integer customerId : ledger.keySet()) {
            CustomerReward reward = new CustomerReward();
            Map<Month, Integer> customerRewardPointsByMonth = ledger.get(customerId);
            List<Pair<Month, Integer>> rewardsByMonth = new LinkedList<>();

            for (Month month : customerRewardPointsByMonth.keySet()) {
                rewardsByMonth.add(new Pair<>(month, customerRewardPointsByMonth.get(month)));
            }
            reward.setRewardsByMonth(rewardsByMonth);
            rewardsByCustomerId.put(customerId, reward);
        }

        return rewardsByCustomerId;
    }
    
    static int calculateRewardPoints(Integer amountSpent) {
        if (amountSpent <= 50) return 0;
        if (amountSpent <= 100) return amountSpent - 50;
        return ((amountSpent - 100) * 2) + 50;
    }
    
    @GetMapping("/customer/{customerId}/rewards")
    public CustomerReward getRewardsForCustomer(
            @PathVariable Integer customerId,
            @RequestParam(required=false) String beginDate,
            @RequestParam(required=false) String endDate)
    {
        // TODO: Optimize by not fetching all rewards.  This was a Short Cut.
        Map<Integer, CustomerReward> customersRewards = all(beginDate, endDate);
        return customersRewards.get(customerId);
    }
    
}
