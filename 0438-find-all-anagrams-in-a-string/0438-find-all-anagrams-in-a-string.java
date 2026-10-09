class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        if (s.length()<p.length()){
            return ans;
        }
        int[] freq =new int[26];
        int[] wind =new int [26];
        for (int i=0;i<p.length();i++){
            freq[p.charAt(i)-'a']++;
            wind[s.charAt(i)-'a']++; 
        }
        if (Arrays.equals(freq,wind)){
            ans.add(0);
        }
        int left =0;
        for (int right= p.length();right<s.length();right++){
            wind[s.charAt(left)-'a']--;
            left++;
            wind[s.charAt(right)-'a']++;
            if(Arrays.equals(freq,wind)){
                ans.add(left);
            }
        }
        return ans;
    }
}