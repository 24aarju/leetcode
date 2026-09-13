class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        int i = s.length() - 1;
        int j = t.length() - 1;
        
        int skipS = 0;
        int skipT = 0;

        while (i >= 0 || j >= 0) {

            // s ka next valid character find karo
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                } 
                else if (skipS > 0) {
                    skipS--;
                    i--;
                } 
                else {
                    break;
                }
            }

            // t ka next valid character find karo
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } 
                else if (skipT > 0) {
                    skipT--;
                    j--;
                } 
                else {
                    break;
                }
            }

            // dono mein character bacha hai
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            }
            
            // ek mein character hai aur dusra empty hai
            else if (i >= 0 || j >= 0) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }
}