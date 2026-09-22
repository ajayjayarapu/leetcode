package com.arraysandhashing;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.Map;

/**
 *
 *  leetcode: https://leetcode.com/problems/valid-anagram/description/
 *  neetcode: https://neetcode.io/problems/is-anagram/question
 *
 */

public class ValidAnagram {

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";
        boolean result = isAnagramUsingMap(s, t);
        System.out.println(result);
        System.out.println("============================================");
        boolean res = isAnagramUsingSort(s, t);
        System.out.println(res);

    }

    public static boolean isAnagramUsingMap(String s, String t) {

        if (s == null || t == null)
            return false;

        if (s.length() != t.length())
            return false;

        Map<Character, Integer> sMap = new TreeMap<>();
        Map<Character, Integer> tMap = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0)+1);
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }

        for (Character c : sMap.keySet()) {
            if (!(tMap.containsKey(c) && tMap.get(c).equals(tMap.get(c)))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isAnagramUsingSort(String s, String t) {
        if(s == null || t == null)
            return false;
        if(s.length() != t.length())
            return false;

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
