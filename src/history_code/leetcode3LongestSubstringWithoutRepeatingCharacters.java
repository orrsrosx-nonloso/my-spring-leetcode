package history_code;

import java.util.HashMap;

public class leetcode3LongestSubstringWithoutRepeatingCharacters {
    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) != null) {
                continue;
            }
            Integer min = map.getOrDefault(nums[i] - 1, 0);
            Integer max = map.getOrDefault(nums[i] + 1, 0);
            int now = max + min + 1;
            if (min == 0 && max == 0) {
                map.put(nums[i], 1);
            }else if (min == 0) {
                map.put(nums[i] + max, now);
                map.put(nums[i], now);
            } else if (max == 0) {
                map.put(nums[i], now);
                map.put(nums[i] - min, now);
            } else {
                map.put(nums[i] + max, now);
                map.put(nums[i] - min, now);
                map.put(nums[i], now);
            }
            res = Math.max(res, now);
        }
        return res;

    }
}
