package com.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     *
     * leetcode: https://leetcode.com/problems/two-sum/
     * neetcode: https://neetcode.io/problems/two-integer-sum/question
     *
     */

    public static void main(String[] args) {
        int[] nums = {4,4,11,15};
        int target = 8;
        int[] result = twoSumWithTwoForLoop(nums, target);
        for(int i = 0; i< result.length; i++){
            System.out.print(result[i]+" ");
        }
        System.out.println(" \n==========================");
        int[] res = twoSumWithHashMap(nums, target);
        for(int i = 0; i< res.length; i++){
            System.out.print(res[i]+" ");
        }

    }
    public static int[] twoSumWithTwoForLoop(int[] nums, int target) {
        for(int i =0; i < nums.length; i++){
            for(int j =i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public static int[] twoSumWithHashMap(int[] nums, int target){

        Map<Integer, Integer> lookUp = new HashMap();
        for(int i = 0; i< nums.length; i++){
            int diff = target - nums[i];
            if(lookUp.containsKey(diff))
                return new int[]{lookUp.get(diff), i};
            lookUp.put(nums[i], i);
        }
        return new int[]{};
    }

}
