package net.lol365.argorithms.util;

import java.util.Random;

/**
 * 生成随机数列的工具类
 */
public class RandomUtil {

    /**
     * 生成随机
     * @param size
     * @param range
     * @return
     */
    public static int[] randomIntArray(int size, int range) {
        Random rand = new Random();
        int[] array = new int[size];
        for(int i=0; i<size; i++) {
            array[i] = rand.nextInt(range);
        }
        return array;
    }

    public static void displayIntArray(int[] array) {
        for (int obj : array) {
            System.out.print(obj + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = randomIntArray(20, 1000);
        displayIntArray(array);
    }

}
