package leetcode.SortingAlgorithm;

/**
 * @author qingtong
 * @since 2023-04-26 22:34
 **/
public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 8, 6, 234, 3546, 72, 1};

        int[] sortNums = sort(nums);

        for (int num : sortNums) {
            System.out.println(num);
        }
    }

    public static int[] sort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];
            int j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = base;
        }
        return nums;
    }
}
