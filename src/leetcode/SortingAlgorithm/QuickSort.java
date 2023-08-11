package leetcode.SortingAlgorithm;

/**
 * @author qingtong
 * @since 2023-04-26 23:25
 **/
public class QuickSort {

    public static void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int part = partition(nums, left, right);
        sort(nums, left, part - 1);
        sort(nums, part + 1, right);
    }



    public static int partition(int[] nums, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && nums[left] <= nums[j]) {
                j--;
            }
            while (i < j && nums[left] >= nums[i] ) {
                i++;
            }
            swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }

    public static void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,2,4,1,3,6,0};
        sort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
