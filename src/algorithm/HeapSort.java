package algorithm;

/**
 * @Author: wujiapeng
 * @Description: 堆排序
 *
 * 是对简单排序的优化
 *
 * @Date: created in 20:11 2018/12/19
 */
public class HeapSort {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 1, 7, 8, 4, 3};
        int i;
        for (i = integers.length / 2; i > 0; i--) {
            heapAdjust(integers, i, integers.length -1);
        }

        for (i = integers.length -1; i > 1; i--) {
            swap(integers, 1, i);
            heapAdjust(integers, 1, i - 1);
        }

        System.out.println(integers);
    }

    public static void swap(Integer[] integers, int i, int j) {
        int k = integers[i];
        integers[i] = integers[j];
        integers[j] = k;
    }

    public static void heapAdjust(Integer[] integers, int s, int m) {
        int temp, j;
        temp = integers[s];
        for (j = 2 * s; j <= m; j *= 2) {
            if (j < m && integers[j] < integers[j + 1]) {
                ++j;
            }

            if (temp >= integers[j]) {
                break;
            }

            integers[s] = integers[j];
            s = j;
        }

        integers[s] = temp;
    }

}
