package com.arraysandhashing;

import java.util.*;

public class GroupAnagrams {
    /**
     *
     * leetcode: https://leetcode.com/problems/group-anagrams/
     * neetcode: https://neetcode.io/problems/anagram-groups/question
     *
     */
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 1)
            return List.of(List.of(strs[0]));

        HashMap<String, List<String>> mapOfAnagrams = new HashMap<>();

        for (String str : strs) {
            char[] inArr = str.toCharArray();
            Arrays.sort(inArr);

            String key = new String(inArr);

            mapOfAnagrams
                    .computeIfAbsent(key,  k -> new ArrayList<>())
                    .add(str);
        }

        return new ArrayList<>(mapOfAnagrams.values());
    }
}
