package leetcode.medium.sortingAlgorithm;

/**
 * @author qingtong
 * @since 2023-05-04 08:46
 **/
public class CountingSort {
    /* 计数排序 */
    // 完整实现，可排序对象，并且是稳定排序
    void countingSort(int[] nums) {
        int m = 0;
        // 1. 统计数组最大元素m
        for (int num : nums) {
            m = Integer.max(m, num);
        }

        // 2. 统计各数字出现的次数
        int[] counter = new int[m + 1];
        for (int num : nums) {
            counter[num]++;
        }

        // 3. 求counter的前缀和，讲"出现次数"转为"尾索引"
        // 即counter[num] - 1 是num在res中最后一次出现的索引
        for (int i = 0; i < m; i++) {
            // 累加前缀
            counter[i + 1] += counter[i];
        }

        // 4. 倒序遍历nums，将各元素填入结果数组res
        // 初始化数组res用于记录结果
        int n = nums.length;
        int[] res = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            // 将num放置到对应的索引处(索引是从0开始的，所以这里要-1)
            res[counter[num] - 1] = num;

            // 令前缀和自减1，得到下次放置num的索引
            counter[num]--;
        }

        // 将结果数组res覆盖原数组nums
        for (int i = 0; i < n; i++) {
            nums[i] = res[i];
        }
    }

}
