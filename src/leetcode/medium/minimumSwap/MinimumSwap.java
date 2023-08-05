package leetcode.medium.minimumSwap;

/**
 * 1247. 交换字符使得字符串相同
 * https://leetcode.cn/problems/minimum-swaps-to-make-strings-equal/
 *
 * @author qingtong
 * @since 2023-02-25 21:10
 **/
public class MinimumSwap {
    public static void main(String[] args) {
        System.out.println(minimumSwap("xx", "xy"));
    }

    public static int minimumSwap(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        if (arr1.length != arr2.length) {
            return -1;
        }

        if (arr1.length < 1 || arr1.length > 1000) {
            return -1;
        }

        boolean flag;
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            flag = true;
            if (arr1[i] != arr2[i]) {
                for (int j = i + 1; j < arr2.length; j++) {
                    if (arr2[i] == arr2[j] && arr1[i] == arr1[j]) {
                        char swap = arr2[j];
                        arr2[j] = arr1[i];
                        arr1[i] = swap;
                        count++;
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    for (int j = i + 1; j < arr2.length; j++) {
                        if (arr1[j] != arr2[j] && arr1[i] == arr2[j]) {
                            char swap = arr1[j];
                            arr1[j] = arr2[j];
                            arr2[j] = swap;
                            count++;

                            test(arr1, arr2, i, j);
                            count++;
                            break;
                        }
                    }
                }
            }
        }

        if (!String.valueOf(arr1).equals(String.valueOf(arr2))) {
            return -1;
        }

        return count;
    }

    private static void test(char[] arr1, char[] arr2, int i, int j) {
        if (arr1[j] == arr1[i]) {
            char swap = arr2[j];
            arr2[j] = arr1[i];
            arr1[i] = swap;
        }
    }
}
