package com.consultcalhoun.interviewing.rewards;

import java.time.Month;
import java.util.List;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import org.javatuples.Pair;

public class CustomerRewardTest {
    @Test
    public void testGetTotalRewardPointsAvailable() {
        List<Pair<Month, Integer>> rewardsByMonth = new LinkedList<Pair<Month, Integer>>();
        rewardsByMonth.add(new Pair<Month, Integer>(Month.JANUARY, 117));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.FEBRUARY, 0));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.MARCH, 100));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.APRIL, 200));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.MAY, 400));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.JUNE, 600));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.JULY, 800));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.AUGUST, 1000));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.SEPTEMBER, 1200));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.OCTOBER, 1400));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.NOVEMBER, 1600));        
        rewardsByMonth.add(new Pair<Month, Integer>(Month.DECEMBER, 1800));        

        CustomerReward cr = new CustomerReward();
        cr.setRewardsByMonth(rewardsByMonth);
        
        assertEquals(9217, cr.getTotalRewardPointsAvailable());
    }
}
