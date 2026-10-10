class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int slow = i, fast = i;
            boolean forward = nums[i] > 0;

            while (true) {
                slow = next(nums, slow, forward);
                if (slow == -1) break;

                fast = next(nums, fast, forward);
                if (fast == -1) break;

                fast = next(nums, fast, forward);
                if (fast == -1) break;

                if (slow == fast) return true;
            }
        }
        return false;
    }

    private int next(int[] nums, int i, boolean forward) {
        if (nums[i] == 0 || (nums[i] > 0) != forward)
            return -1;

        int n = nums.length;
        int j = ((i + nums[i]) % n + n) % n;

        if (j == i) return -1;
        return j;
    }
}