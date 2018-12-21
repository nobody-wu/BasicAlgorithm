package algorithm;

/**
 * @Author: wujiapeng
 * @Description: 快速排序优化
 * <p>
 * 优化1：由于pivotKey数值过大或者过小都会对性能产生较大的影响，
 * 可以通过三数取中法（即：取三个关键字先进性排序，将中间数作为枢纽，一般取左端，右端和中间三个数,也可以随机选择）对pivotKey进行赋值
 *
 * 优化2：交换 -> 赋值
 *
 * @Date: created in 20:35 2018/12/20
 */
public class QuickSort2 {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{0, 2, 5, 1, 7, 8, 4, 3};

        quickSort(integers, 1, integers.length - 1);

        System.out.println(integers);
    }

    private static void quickSort(Integer[] integers, int low, int high) {
        int pivot;
        if (low < high) {
            pivot = partition2(integers, low, high);
            quickSort(integers, low, pivot - 1);
            quickSort(integers, pivot + 1, high);
        }

    }

    private static int partition(Integer[] integers, int low, int high) {
        int pivotKey = getPrivot(integers, low, high);
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

    /**
     * 优化，交换改成赋值
     *
     * @param integers
     * @param low
     * @param high
     * @return
     */
    private static int partition2(Integer[] integers, int low, int high) {
        int pivotKey = integers[low];
        integers[0] = pivotKey;

        while (low < high) {
            while (low < high && integers[high] >= pivotKey) {
                high--;
            }
            integers[low] = integers[high];

            while (low < high && integers[low] <= pivotKey) {
                low++;
            }
            integers[high] = integers[low];
        }

        integers[low] = integers[0];
        return low;
    }

    /**
     * 优化原快速排序,确保取到中间值
     *
     * @param integers
     * @param low
     * @param high
     * @return
     */
    private static int getPrivot(Integer[] integers, int low, int high) {
        int m = low + (high - low) / 2; // 计算中间元素的下标
        if (integers[low] > integers[high]) {
            swap(integers, low, high); // 交换数列中的元素，使得左边小，右边大
        }

        if (integers[m] > integers[high]) {
            swap(integers, high, m); // 保证中间比右边小
        }

        if (integers[m] > integers[low]) {
            swap(integers, low, m);// 保证中间比左边大
        }

        // 此时integers[low]已经为左中右的中间值
        int privotKey = integers[low];

        return privotKey;
    }


    private static void swap(Integer[] integers, int low, int high) {
        int k = integers[low];
        integers[low] = integers[high];
        integers[high] = k;
    }
}
