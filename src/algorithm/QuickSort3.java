package algorithm;

/**
 * @Author: wujiapeng
 * @Description: 快速排序
 * <p>
 * 递归优化
 * @Date: created in 21:22 2018/12/20
 */
public class QuickSort3 {
    public static void main(String[] args) {
        // 下标为0的是自己设置的哨兵
        Integer[] integers = new Integer[]{0, 2, 5, 1, 7, 8, 4, 3};
        quickSort(integers, 1, integers.length - 1);
        System.out.println(integers);
    }

    private static void quickSort(Integer[] integers, int low, int high) {
        int pivot;
        // 减少递归
        while (low < high) {
            pivot = partition(integers, low, high);
            quickSort(integers, low, pivot - 1);
            low = pivot + 1;
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
