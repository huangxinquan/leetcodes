package leetcode.algorithm.p1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * p1: https://leetcode.com/problems/two-sum/
 *
 * @author xinquan.huangxq
 */
public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!map.containsKey(target - nums[i])) {
                continue;
            }
            int j = map.get(target - nums[i]);
            if (i != j) {
                return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("illegal argument");
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(Solution.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
