package net.lol365.argorithms.lintcode;

/**
 * 给出两个整数a和b, 求他们的和, 但不能使用 + 等数学运算符。
 */
public class No1 {

    /**
     *  使用未运算
     *  第1步（忽略进位）：0＋0＝0，0＋1＝1，1＋0＝0，1＋1＝0，典型的异或运算。
        第2步：很明显，只有1＋1会向前产生进位1，相对于这一数位的进位值为10，而10＝(1&1)<<1。
        第3步：将第1步和第2步得到的结果相加，其实又是在重复上述2步，直到不再产生进位为止。
     * @param a
     * @param b
     * @return
     */
    public static int aplusb(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        int sum, i;
        i = a ^ b;
        sum = (a & b) << 1;
        return aplusb(sum, i);
    }

    public static void main(String[] args) {
        System.out.println(aplusb(2, 20));
    }

}
