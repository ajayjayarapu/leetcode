package com.arraysandhashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * leetcode:
 * neetcode: https://neetcode.io/problems/string-encode-and-decode/question
 *
 */
public class EncodeDecodeStrings {
    public static void main(String[] args) {
     List<String> strs = List.of("", "");
     String encoded = encodeS(strs);
     System.out.println(encoded);
     List<String> decoded = decodeS(encoded);
     System.out.println(decoded);

    }
    public static String encode(List<String> strs) {
        if(strs.size() == 0)
            return "€ñ€ñ";
        return  strs.stream().map(word -> word.length() == 0 ? "€": word)
                .collect(Collectors.joining("€ñ","",""));
    }

    public static List<String> decode(String str) {
        if("€ñ€ñ".equals(str))
            return List.of();
      if(!str.contains("€ñ"))
              return str.contains("€") ? List.of("") : List.of(str);

      return Arrays.stream(str.split("€ñ")).map(word -> word.contains("€") ? "\""+"\"" : word).collect(Collectors.toList());
    }

    public static String encodeS(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('#').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decodeS(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < str.length()) {
            int delimiterPos = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, delimiterPos));
            i = delimiterPos + 1;

            result.add(str.substring(i, i + length));
            i += length;
        }

        return result;
    }
}
