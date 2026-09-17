class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0;
        int max = 0;

        int fruit1 = -1, fruit2 = -1;
        int count1 = 0, count2 = 0;

        for (int right = 0; right < fruits.length; right++) {

            if (fruits[right] == fruit1) {
                count1++;
            } 
            else if (fruits[right] == fruit2) {
                count2++;
            } 
            else {
                while (count1 > 0 && count2 > 0) {
                    if (fruits[left] == fruit1) {
                        count1--;
                    } else {
                        count2--;
                    }
                    left++;
                }

                if (count1 == 0) {
                    fruit1 = fruits[right];
                    count1 = 1;
                } else {
                    fruit2 = fruits[right];
                    count2 = 1;
                }
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}