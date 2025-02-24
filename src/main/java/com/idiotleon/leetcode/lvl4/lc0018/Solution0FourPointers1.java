package com.idiotleon.leetcode.lvl4.lc0018;

import com.idiotleon.util.Constant;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/4sum/">lc0023</a>
 * <p>
 * Time Complexity:     O(N * lg(N)) + O(N ^ 3) ~ O(N ^ 3)
 * Space Complexity:    O(1)
 */
@SuppressWarnings(Constant.WARNING.UNUSED)
public class Solution0FourPointers1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }

        final int N = nums.length;
        Arrays.sort(nums);
        final Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                int lo = j + 1, hi = N - 1;
                while (lo < hi) {
                    int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
                    if (target == sum) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        ++lo;
                        --hi;
                    } else if (sum < target) {
                        ++lo;
                    } else {
                        --hi;
                    }
                }
            }
        }

        return new ArrayList<>(ans);
    }
}