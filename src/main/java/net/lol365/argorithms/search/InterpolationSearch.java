package net.lol365.argorithms.search;

import net.lol365.argorithms.util.RandomUtil;

import java.util.Arrays;

/**
 * 插值查找
 *  相当于是二分查找的改进版本
 */
public class InterpolationSearch {

    public static int search(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high && arr[low] <= target && arr[high] >= target) {
            // 计算区间比例，这样更容易确定要找的值靠近哪个边界
            float fx = 1.0f * (target - arr[low]) / (arr[high] - arr[low]);
            // 0<fx<1.0
            int mid = (int) (low + fx * (high - low));
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] raw = RandomUtil.randomIntArray(20, 20);
        System.out.println("raw => ");
        RandomUtil.displayIntArray(raw);
        Arrays.sort(raw);
        System.out.println();
        System.out.println("sorted => ");
        RandomUtil.displayIntArray(raw);
        System.out.println();

        int target = 15;
        System.out.println("target => " + target);
        int index = search(raw, target);
        System.out.println(index);

    }

}
