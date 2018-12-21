package algorithm;

/**
 * @Author: wujiapeng
 * @Description: 冒泡排序优化-提前退出
 * @Date: created in 20:33 2018/12/17
 */
public class BubbleSort2 {

    public static void main(String[] args) {
        Integer[] integers = new Integer[]{2, 1, 7, 8, 9, 10};

        boolean flag = true;

        for (int i = 0; i < integers.length && flag; i++) {
            flag = false;
            for (int j = integers.length - 1; j > i; j--) {
                if (integers[j] < integers[j - 1]) {
                    int k = integers[j];
                    integers[j] = integers[j - 1];
                    integers[j - 1] = k;
                    flag = true;
                }
            }
        }
        System.out.println(integers);
    }

}
