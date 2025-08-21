import java.util.HashMap;
// Problem Link: https://leetcode.com/problems/sum-of-beauty-of-all-substrings/
public class SumBeuty {
       public int beautySum(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> mpp = new HashMap<>();
            for (int j = i; j < n; j++) {
                mpp.put(s.charAt(j), mpp.getOrDefault(s.charAt(j), 0) + 1);
                int min = Integer.MAX_VALUE;
                int max = Integer.MIN_VALUE;
                for (int value : mpp.values()) {
                    if (value > 0) {
                        max = Math.max(max, value);
                        min = Math.min(min, value);
                    }
                }
                ans += (max - min);
            }

        }
        return ans;

    }
    
}
