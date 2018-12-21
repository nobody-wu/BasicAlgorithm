package algorithm;

/**
 * @Author: wujiapeng
 * @Description: 希尔排序
 * <p>
 * 时间复杂度：O(n^(3/2)) < O(n^2)
 * <p>
 * 由于直接插入排序在原来数列基本有序(基本分布：小，中，大)的情况下，或者记录数较少的情况下使用是高效的。但是以上这两种情况较为严苛。
 * 所以希尔排序对直接插入排序进行的优化：
 * 分割待排序数列，以减少待排序数列的数量，达到上述记录数较少的情况
 * @Date: created in 19:28 2018/12/19
 */
public class ShellSort {

    public static void main(String[] args) {
        // 下标为0的是自己设置的哨兵
        Integer[] integers = new Integer[]{0, 2, 5, 1, 7, 8, 4, 3};
        int i, j;
        int increment = integers.length;
        do {
            // 增量序列
            increment = increment / 3 + 1;

            for (i = increment + 1; i < integers.length; i++) {
                if (integers[i] < integers[i - increment]) {
                    integers[0] = integers[i];
                    for (j = i - increment; j > 0 && integers[0] < integers[j]; j -= increment) {
                        // 记录后移，查找插入位置
                        integers[j + increment] = integers[j];
                    }

                    integers[j + increment] = integers[0];
                }
            }
        } while (increment > 1);

        System.out.println(integers);

    }

}
