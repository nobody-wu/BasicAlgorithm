package leetcode.medium.sortingAlgorithm;

import java.util.Arrays;

/**
 * @author qingtong
 * @since 2023-05-03 19:55
 **/
public class MergeSort {

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = Arrays.copyOfRange(nums, left, right + 1);
        int leftStart = left - left;
        int leftEnd = mid - left;
        int rightStart = mid + 1 - left;
        int rightEnd = right - left;

        int i = leftStart;
        int j = rightStart;
        for (int k = left; k <= right; k++) {
            // 若“左子数组已全部合并完”，则选取右子数组元素，并且 j++
            if (i > leftEnd) {
                nums[k] = tmp[j];
                j++;
            } else if(j > rightEnd || tmp[i] <= tmp[j]) {
                // 否则，若“右子数组已全部合并完”或“左子数组元素 <= 右子数组元素”，则选取左子数组元素，并且 i++
                nums[k] = tmp[i];
                i++;
            } else {
                // 否则，若“左右子数组都未全部合并完”且“左子数组元素 > 右子数组元素”，则选取右子数组元素，并且 j++
                nums[k] = tmp[j];
                j++;
            }
        }
    }


    public static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        // 先递归左子数组，再递归右子数组，最后处理合并。
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 8, 6, 234, 3546, 72, 1};
        mergeSort(nums, 0, nums.length-1);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
