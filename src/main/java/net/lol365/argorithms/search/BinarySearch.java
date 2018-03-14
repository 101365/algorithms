package net.lol365.argorithms.search;

import net.lol365.argorithms.util.RandomUtil;

import java.util.Arrays;

/**
 * 二分查找
 * 1.前提是有序列表
 * 2.每次计算指定范围内的中间值，进行比较。
 */
public class BinarySearch {

    public static int search(int[] arr, int target) {

        int low = 0;
        int high = arr.length;
        int mid = (low + high) / 2;

        while (low <= high) {
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] raw = RandomUtil.randomIntArray(20, 20);
        System.out.println("raw => ");
        RandomUtil.displayIntArray(raw);
        System.out.println();
        Arrays.sort(raw);
        System.out.println("sorted => ");
        RandomUtil.displayIntArray(raw);
        System.out.println();

        int target = 15;
        System.out.println("target => " + target);
        int index = search(raw, target);
        System.out.println(index);

    }
}
