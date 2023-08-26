package leetcode.DynamicProgramming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * leetCode第139题：单词拆分I
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * @author qingtong
 * @since 2023-08-27 00:15
 **/
public class WordBreak_139 {

    // 用哈希集合方便判断是否存在
    HashSet<String> wordDict;
    // 备忘录,-1:未创建,0:无法拼出,1:可以拼出
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = new HashSet<>(wordDict);
        memo = new int[s.length()];
        // 初始化
        Arrays.fill(memo, -1);
        return dp(s, 0);
    }

    public boolean dp(String s, int i) {
        if (i == s.length()) {
            return true;
        }
        if (memo[i] != -1) {
            return memo[i] != 0;
        }
        for (int len = 1; i + len <= s.length(); len++) {
            String prefix = s.substring(i, i + len);
            if (wordDict.contains(prefix)) {
                boolean subProblem = dp(s, i + len);
                if (subProblem) {
                    memo[i] = 1;
                    return true;
                }
            }
        }

        memo[i] = 0;
        return false;
    }
}
