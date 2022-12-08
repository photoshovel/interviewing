package com.consultcalhoun.interviewing.rewards;

import java.time.Month;
import java.util.LinkedList;
import java.util.List;

import org.javatuples.Pair;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class CustomerReward {
    @JsonSerialize(using = CustomRewardsByMonthSerializer.class)
    private List<Pair<Month, Integer>> rewardsByMonth = new LinkedList<Pair<Month, Integer>>();
    private Integer totalRewardsAvailable = 0;
    
    public List<Pair<Month, Integer>> getRewardsByMonth() {
        return rewardsByMonth;
    }
    
    public void setRewardsByMonth(List<Pair<Month, Integer>> rewardsByMonth) {
        this.rewardsByMonth = rewardsByMonth;
    }
    
    public Integer getTotalRewardPointsAvailable() {
        int totalRewardPoints = 0;
        for (Pair<Month, Integer> rewardsForMonth : rewardsByMonth) {
            totalRewardPoints += (Integer) rewardsForMonth.getValue(1);
        }
        return totalRewardPoints;
    }
}