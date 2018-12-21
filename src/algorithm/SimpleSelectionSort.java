package algorithm;

/**
 * @Author: wujiapeng
 * @Description: 简单排序, 时间复杂度跟冒泡差不多，都是O(n^2)，但是要略优于冒泡
 *
 * 跟冒泡很像，但是每次是找出最小的，而不是两两比较冒泡上浮
 *
 * @Date: created in 20:37 2018/12/17
 */
public class SimpleSelectionSort {

    public static void main(String[] args) {
        Integer[] list = new Integer[]{2, 5, 1, 7, 8, 4, 3};
        for (int i = 0; i < list.length; i++) {
            int min = i;

            for (int j = i + 1; j < list.length; j++) {
                if (list[min] > list[j]) {
                    min = j;
                }
            }

            if (min != i) {
                int k = list[i];
                list[i] = list[min];
                list[min] = k;
            }
        }

        System.out.println(list);
    }

}
