package net.lol365.argorithms.search;

import net.lol365.argorithms.util.RandomUtil;

/**
 * 顺序查找
 */
public class SeqSearch {

    /**
     * 从数组中查找，找到返回下标，找不到返回-1
     * @param arr
     * @param target
     * @return
     */
    public static int search(int[] arr, int target) {
        for(int i=0; i<arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = RandomUtil.randomIntArray(50, 50);
        int target = 10;
        RandomUtil.displayIntArray(arr);
        System.out.println(target);
        int index = search(arr, target);
        System.out.println(index);
    }

}
