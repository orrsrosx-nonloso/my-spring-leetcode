package history_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class le42 {
    private int[] nums;
    private List<Integer> path;
    private boolean[] onPath;
    private final List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        path = Arrays.asList(new Integer[nums.length]);
        onPath = new boolean[nums.length];
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; ++j) {
            if (!onPath[j]) {
                path.set(i, nums[j]);
                onPath[j] = true;
                dfs(i + 1);
                onPath[j] = false; // 恢复现场
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> b = new le42().permute(a);
//       int as = longestConsecutive(a);
    }

}
