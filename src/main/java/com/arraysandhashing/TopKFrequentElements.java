package com.arraysandhashing;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TopKFrequentElements {

    /**
     *
     * leetcode: https://leetcode.com/problems/top-k-frequent-elements/description/
     * neetcode: https://neetcode.io/problems/top-k-elements-in-list/question
     *
     */
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] res = topKFrequentUsingHashMap(nums, k);
        for(int i = 0; i<res.length; i++){
            System.out.println(res[i]);
        }

        int[] resp = topKFrequentUsingBucketSorting(nums, k);
        System.out.println("=========================================");
        for(int i = 0; i<resp.length; i++){
            System.out.println(resp[i]);
        }
    }

    public static int[] topKFrequentUsingHashMap(int[] nums, int k) {
        if(nums.length == 0)
            return new int[] {};

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i : nums){
            frequencyMap.merge(i, 1, Integer::sum);
        }

        Map<Integer, Integer> sortedMap = frequencyMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
        System.out.println(sortedMap);
        int[] result = new int[k];
        int counter = 0;
        for(Map.Entry<Integer, Integer> map : sortedMap.entrySet()){
            if(counter < k) {
                result[counter] = map.getKey();
                counter = counter+1;
            }
        }
        return result;
    }

    public static int[] topKFrequentUsingBucketSorting(int[] nums, int k){
        if(nums.length == 0)
            return new int[] {};

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for(int key : nums){
            frequencyMap.merge(key, 1, Integer::sum);
        }
        //making
        List<Integer>[]  buckets = new List[nums.length+1];
        for(int i =0; i< buckets.length;i++){
            buckets[i] = new ArrayList<Integer>();
        }

        for(Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()){
            buckets[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int index = 0;

        for(int i = buckets.length-1; i> 0 && index < k; i--){
            for(Integer num: buckets[i]){
                result[index++] = num;
                if(index == k){
                   return result;
                }
            }
        }

      return  result;
    }
}
