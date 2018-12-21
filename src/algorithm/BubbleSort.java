package algorithm;

/**
 * @Author: wujiapeng
 * @Description: 冒泡排序
 * @Date: created in 20:29 2018/12/17
 */
public class BubbleSort {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 5, 1, 7, 8, 4, 3};
        for (int i = 0; i < integers.length; i++) {
            for (int j = integers.length - 1; j > i; j--) {
                if (integers[j] < integers[j - 1]) {
                    int k = integers[j];
                    integers[j] = integers[j - 1];
                    integers[j - 1] = k;
                }
            }
        }
        System.out.println(integers);
    }

}
