package com.consultcalhoun.interviewing.rewards;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.nullable;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mock;

public class CustomerRewardsControllerTest {
    @Mock
    CustomerTransactionRepository _repository;

    private CustomerRewardsController _crc;
    
    private static final SimpleDateFormat simpleDateFormat = 
            new SimpleDateFormat("MM-dd-yyyy");
    
    @BeforeEach
    public void setup() {
        _repository = mock(CustomerTransactionRepository.class);
        _crc = new CustomerRewardsController(_repository);
    }
    
    @Test
    public void calculateRewardPoints() {
        assertEquals(0, CustomerRewardsController.calculateRewardPoints(50));
        assertEquals(1, CustomerRewardsController.calculateRewardPoints(51));
        assertEquals(25, CustomerRewardsController.calculateRewardPoints(75));
        assertEquals(150, CustomerRewardsController.calculateRewardPoints(150));
        assertEquals(49, CustomerRewardsController.calculateRewardPoints(99));
        assertEquals(52, CustomerRewardsController.calculateRewardPoints(101));
        assertEquals(250, CustomerRewardsController.calculateRewardPoints(200));
        assertEquals(300, CustomerRewardsController.calculateRewardPoints(225));
    }
    
    @Test
    public void getRewardsForCustomer() {
        Date beginOfRangeDate = null;
        try {
            beginOfRangeDate = simpleDateFormat.parse("01-01-2022");
        } catch (ParseException pe) {
            fail("Unable to parse date(s) for begin/end range for test setup");
        }

        List<CustomerTransaction> transactions = new ArrayList<>();
        CustomerTransaction ct = new CustomerTransaction();
        ct.setId(101);
        ct.setCustomerId(1);
        ct.setAmount(51);
        ct.setTxDate(beginOfRangeDate);
        
        transactions.add(ct);
        
        assert(_repository != null);
        when(_repository.findByTxDateRange(nullable(Date.class), nullable(Date.class))).thenReturn(transactions);
        
        CustomerReward cw = _crc.getRewardsForCustomer(1, null, null);
        verify(_repository).findByTxDateRange(
      nullable(Date.class), 
       nullable(Date.class));

        assert(cw != null);

        assertEquals(1, cw.getTotalRewardPointsAvailable());
    }
    
    @Test
    public void getRewardsForCustomer_noRewardsAvailable() {
        List<CustomerTransaction> transactions = new ArrayList<>();
        
        assert(_repository != null);
        when(_repository.findByTxDateRange(nullable(Date.class), nullable(Date.class))).thenReturn(transactions);
        
        CustomerReward cw = _crc.getRewardsForCustomer(1, null, null);
        verify(_repository).findByTxDateRange(
      nullable(Date.class), 
       nullable(Date.class));

        assert(cw == null);
    }
    
    @Test
    public void all() {
        Date beginOfRangeDate = null;
        try {
            beginOfRangeDate = simpleDateFormat.parse("01-01-2022");
        } catch (ParseException pe) {
            fail("Unable to parse date(s) for begin/end range for test setup");
        }

        List<CustomerTransaction> transactions = new ArrayList<>();
        CustomerTransaction ct1 = new CustomerTransaction();
        ct1.setId(101);
        ct1.setCustomerId(1);
        ct1.setAmount(51);
        ct1.setTxDate(beginOfRangeDate);
        
        transactions.add(ct1);
        
        CustomerTransaction ct2 = new CustomerTransaction();
        ct2.setId(102);
        ct2.setCustomerId(2);
        ct2.setAmount(121);
        ct2.setTxDate(beginOfRangeDate);
        
        transactions.add(ct2);
        
        assert(_repository != null);
        when(_repository.findByTxDateRange(nullable(Date.class), nullable(Date.class))).thenReturn(transactions);
        
        Map<Integer, CustomerReward> cws = _crc.all(null, null);
        verify(_repository).findByTxDateRange(
      nullable(Date.class), 
       nullable(Date.class));

        assert(cws != null);
        assertEquals(2, cws.size());
        CustomerReward cr1 = cws.get(1);
        assert(cr1 != null);
        assertEquals(1, cr1.getTotalRewardPointsAvailable());
        CustomerReward cr2 = cws.get(2);
        assert(cr2 != null);
        assertEquals(92, cr2.getTotalRewardPointsAvailable());
    }
}
