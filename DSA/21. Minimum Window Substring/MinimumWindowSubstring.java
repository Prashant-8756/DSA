import java.util.HashMap;

public class MinimumWindowSubstring {
    
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }
        
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int left = 0;
        int minLeft = 0;
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        
        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            if (map.containsKey(rChar)) {
                map.put(rChar, map.get(rChar) - 1);
                if (map.get(rChar) >= 0) {
                    count--;
                }
            }
            
            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }
                char lChar = s.charAt(left);
                if (map.containsKey(lChar)) {
                    map.put(lChar, map.get(lChar) + 1);
                    if (map.get(lChar) > 0) {
                        count++;
                    }
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: \"" + minWindow(s1, t1) + "\"");

        String s2 = "a";
        String t2 = "a";
        System.out.println("\nInput: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: \"" + minWindow(s2, t2) + "\"");
        
        String s3 = "a";
        String t3 = "aa";
        System.out.println("\nInput: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("Output: \"" + minWindow(s3, t3) + "\"");
    }
}
