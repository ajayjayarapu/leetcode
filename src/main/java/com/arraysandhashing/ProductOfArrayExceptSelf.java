package com.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * leetcode: https://leetcode.com/problems/product-of-array-except-self/description/
 * neetcode: https://neetcode.io/problems/products-of-array-discluding-self/question
 *
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] out = productExceptSelfUsing2ForLoops(nums);
        for(int i = 0; i< out.length; i++){
            System.out.print(out[i]+" ");
        }
        System.out.println("\n============================================================================");
        int[] output = productExceptSelfUsingDivision(nums);
        for(int i = 0; i< output.length; i++){
            System.out.print(output[i]+" ");
        }
        System.out.println("\n============================================================================");
        int[] output11 = productExceptSelfUsingPrefixSuffixOptimal(nums);
        for(int i = 0; i< output11.length; i++){
            System.out.print(output11[i]+" ");
        }
        System.out.println("\n============================================================================");
        int[] output1 = productExceptSelfUsingPrefixSuffix(nums);
        for(int i = 0; i< output1.length; i++){
            System.out.print(output1[i]+" ");
        }


    }

    public static int[] productExceptSelfUsing2ForLoops(int[] nums) {
       if(nums.length == 0)
           return  new int[] {};
       int[] out = new int[nums.length];

       for(int i =0; i < nums.length; i++){
           int mul = 1;
           for(int j = 0; j < nums.length; j++ ){
               if(i != j) {
                   mul = mul * nums[j];
               }
           }
           out[i] = mul;
       }
      return  out;
    }
    public static int[] productExceptSelfUsingDivision(int[] nums){

        int[] out = new int[nums.length];
        int result = 1, zeroCount = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0) {
                result *= nums[i];
            }else{
                zeroCount++;
            }
        }
        if(zeroCount > 1)
            return new int[nums.length];

        for(int i =0; i<nums.length; i++){
            if (zeroCount > 0) {
                out[i] = (nums[i] == 0) ? result : 0;
            } else {
                out[i] = result / nums[i];
            }
        }
      return  out;
    }

    public static int[] productExceptSelfUsingPrefixSuffixOptimal(int[] nums){
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postfix;
            postfix *= nums[i];
        }
        return res;
    }

    public static int[] productExceptSelfUsingPrefixSuffix(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];

        pref[0] = 1;
        suff[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            pref[i] = nums[i - 1] * pref[i - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = nums[i + 1] * suff[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res[i] = pref[i] * suff[i];
        }
        return res;
    }


}
