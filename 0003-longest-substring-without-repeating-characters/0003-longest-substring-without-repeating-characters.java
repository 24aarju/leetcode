class Solution {
    public int lengthOfLongestSubstring(String s) {

        int low = 0, high = 0;
        int res = 0;

        HashMap<Character, Integer> f = new HashMap<>();

        for (high = 0; high < s.length(); high++) {

            f.put(s.charAt(high),
                  f.getOrDefault(s.charAt(high), 0) + 1);

            while (f.size() < high - low + 1) {

                f.put(s.charAt(low),
                      f.get(s.charAt(low)) - 1);

                if (f.get(s.charAt(low)) == 0) {
                    f.remove(s.charAt(low));
                }

                low++;
            }

            int len = high - low + 1;

            res = Math.max(res, len);
        }

        return res;
    }
}