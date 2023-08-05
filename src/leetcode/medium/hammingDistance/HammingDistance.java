package leetcode.medium.hammingDistance;

/**
 * @author qingtong
 * @since 2023-04-22 11:33
 **/
public class HammingDistance {

    public static int hammingDistance(int x, int y) {

        return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(5,6));
    }

}
