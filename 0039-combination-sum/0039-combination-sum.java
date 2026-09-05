import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] a, int target) {
        Arrays.sort(a);
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, target, a, new ArrayList<>(), ans);
        return ans;
    }

    void solve(int start, int target, int[] a, List<Integer> list,
               List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < a.length && a[i] <= target; i++) {
            list.add(a[i]);
            solve(i, target - a[i], a, list, ans);
            list.remove(list.size() - 1);
        }
    }
}