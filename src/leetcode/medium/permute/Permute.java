package leetcode.medium.permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode.cn/problems/permutations/
 *
 * @author qingtong
 * @since 2023-02-26 00:11
 **/
public class Permute {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));

//        List<Integer> i = new ArrayList<>();
//        i.add(1);
//        i.add(2);
//        i.add(3);
//        System.out.println(i.subList(0, 1));
//        System.out.println(i.subList(2, 2));
    }

    public static List<List<Integer>> permute(int[] nums) {
        if (nums.length < 1 || nums.length > 6) {
            return null;
        }

        if (Arrays.stream(nums).anyMatch(num -> num < -10 || num > 10)) {
            return null;
        }

        // 1，2，3
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            List<Integer> sort = new ArrayList<>();
            sort.add(list.get(i));

            if (i+1 != list.size()) {
                test(sort, list.subList(0, i+1), list.subList(i+1, list.size()));
            }
            result.add(sort);
        }

        return result;
    }

    public static void test(List<Integer> sort, List<Integer> left, List<Integer> right) {
        List<Integer> total = new ArrayList<>();
        total.addAll(left);
        total.addAll(right);

        for (int i = 0; i < total.size(); i++) {
            sort.add(total.get(i));

            if (i+1 != total.size()) {
                test(sort, total.subList(0, i+1), total.subList(i+1, total.size()));
            }
        }
    }
}
