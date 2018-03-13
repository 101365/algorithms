package net.lol365.argorithms.work;

import net.lol365.argorithms.util.RandomUtil;

import java.util.Arrays;
import java.util.Random;

/**
 * 移位数组查找指定值所在的位置
 */
public class OffsetArray {

    private static int searchTarget(int[] array, int target) {
        return search(array, target, 0, array.length - 1);
    }

    private static int search(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[left] <= array[mid]) {
            // 左侧是完全递增序列
            boolean exist = exist(array, target, left, mid);
            if (exist) {
                // 二分查找
                return binarySearchA(array, target, left, mid);
            } else {
                // 查找右侧
                return search(array, target, mid + 1, right);
            }
        } else {
            // 右侧是完全递增序列
            boolean exist = exist(array, target, mid + 1, right);
            if (exist) {
                // 二分查找
                return binarySearchA(array, target, mid + 1, right);
            } else {
                // 查找左侧
                return search(array, target, left, mid);
            }
        }
    }

    private static int binarySearchA(int[] array, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] > target) {
            return binarySearchA(array, target, left, mid);
        } else {
            return binarySearchA(array, target, mid + 1, right);
        }

    }

    private static boolean exist(int[] array, int target, int start, int end) {
        return target >= array[start] && target <= array[end];
    }


    /**
     * 准备工作 => 生成移位数组
     * @param array
     */
    private static int[] offset(int[] array) {
        Random rand = new Random();
        int cutLine = rand.nextInt(array.length);
        int[] result = new int[array.length];
        for(int i=cutLine; i<array.length; i++) {
            result[i - cutLine] = array[i];
        }
        for(int i=0; i<cutLine; i++) {
            result[array.length - cutLine + i] = array[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        // 先生成一个长度为20，数字500以内的随机数组
        int[] raw = RandomUtil.randomIntArray(20, 500);
        int target = raw[random.nextInt(raw.length)];
        System.out.println("查找数字 => " + target);
        // 打印原始数据
        RandomUtil.displayIntArray(raw);
        // 排序
        Arrays.sort(raw);
        // 打印排序后数组
        RandomUtil.displayIntArray(raw);
        // 生成移位数组
        int[] array = offset(raw);
        // 打印移位数组
        RandomUtil.displayIntArray(array);

        int index = searchTarget(array, target);
        System.out.println(index);
        assert index >= 0;

    }



}
