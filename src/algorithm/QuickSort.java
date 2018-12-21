package algorithm;

/**
 * @Author: wujiapeng
 * @Description: 快速排序算法（最为推荐）
 * <p>
 * 是对冒泡算法的优化
 * <p>
 * 时间复杂度：O(nlogn)
 * @Date: created in 20:47 2018/12/19
 */
public class QuickSort {

    public static void main(String[] args) {
        // 下标为0的是自己设置的哨兵
        Integer[] integers = new Integer[]{0, 2, 5, 1, 7, 8, 4, 3};
        quickSort(integers, 1, integers.length - 1);
        System.out.println(integers);
    }

    private static void quickSort(Integer[] integers, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition(integers, low, high);
            quickSort(integers, low, pivot - 1);
            quickSort(integers, pivot + 1, high);
        }

    }

    private static int partition(Integer[] integers, int low, int high) {
        int pivotKey;
        pivotKey = integers[low];
        while (low < high) {
            while (low < high && integers[high] >= pivotKey) {
                high--;
            }
            swap(integers, low, high);

            while (low < high && integers[low] <= pivotKey) {
                low++;
            }
            swap(integers, low, high);

        }

        return low;
    }

    private static void swap(Integer[] integers, int low, int high) {
        int k = integers[low];
        integers[low] = integers[high];
        integers[high] = k;
    }

}
