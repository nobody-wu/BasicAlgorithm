package algorithm;

/**
 * @Author: wujiapeng
 * @Description: 直接插入排序
 * <p>
 * 时间复杂度也是O(n^2),但是比冒泡跟简单选择性能上要好一点
 * @Date: created in 11:57 2018/12/18
 */
public class StraightInsertionSort {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{0, 2, 5, 1, 7, 8, 4, 3};

        // 第一个数字自己设置，取第二个数字，然后之后的数字与当前数据做比较，是插在左边还是插在后边
        for (int i = 1; i < integers.length; i++) {
            if (integers[i] < integers[i - 1]) {
                integers[0] = integers[i];
                int j = i - 1;
                for (; integers[j] > integers[0]; j--) {
                    integers[j + 1] = integers[j];
                }
                integers[j + 1] = integers[0];
            }
        }

        System.out.println(integers);

    }

}
