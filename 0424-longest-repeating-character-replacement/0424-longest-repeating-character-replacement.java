import java.util.HashMap;

class Solution {
    public int characterReplacement(String s, int k) {
        int low = 0;
        int high = 0;
        int res = Integer.MIN_VALUE;

        HashMap<Character, Integer> j = new HashMap<>();
        int maxFreq = 0;

        for (high = 0; high < s.length(); high++) {

            j.put(s.charAt(high),
                  j.getOrDefault(s.charAt(high), 0) + 1);

            int len = high - low + 1;

            maxFreq = Math.max(maxFreq, j.get(s.charAt(high)));

            while (len - maxFreq > k) {

                char left = s.charAt(low);

                j.put(left, j.get(left) - 1);

                low++;

                len = high - low + 1;
            }

            res = Math.max(res, len);
        }

        return res;
    }
}