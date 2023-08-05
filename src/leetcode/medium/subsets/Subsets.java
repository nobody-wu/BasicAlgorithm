package leetcode.medium.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * https://leetcode.cn/problems/subsets/solution/zi-ji-by-leetcode-solution/
 * @author qingtong
 * @since 2023-04-22 17:09
 **/
public class Subsets {

    /***
     * 递归实现
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> start = new ArrayList<>();
        List<List<Integer>> subsets = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> subsets1 = new ArrayList<>();
            List<Integer> currentNumList = new ArrayList<>();
            int currentNum = nums[i];
            currentNumList.add(currentNum);

            for (int i1 = 0; i1 < subsets.size(); i1++) {
                List<Integer> subset = new ArrayList<>(subsets.get(i1));
                subset.add(currentNum);
                subsets1.add(subset);
            }
            subsets1.add(currentNumList);
            subsets.addAll(subsets1);
        }
        subsets.add(start);
        return subsets;
    }

    public static List<List<Integer>> subsets = new ArrayList<>();
    public static int n;

    /**
     * 回溯算法实现
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsets2(int[] nums) {
        n = nums.length;
        for (int i = 0; i <= n; i++) {
            backtrack(0, i, new ArrayList<>(), nums);
        }
        return subsets;
    }

    public static void backtrack(int start, int k, List<Integer> tmp, int[] nums) {
        if (k==0) {
            subsets.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = start; i < n; i++) {
            tmp.add(nums[i]);
            backtrack(i+1, k-1, tmp, nums);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
//        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets2(new int[]{1, 2, 3}));
    }
}
