package net.lol365.argorithms.sort;

import net.lol365.argorithms.util.RandomUtil;

/**
 * 选择排序
 * 每次拿待排序数据中最(小)大的一个数据，放到当前位置。
 * 平均复杂度和最差复杂度都是 n^2
 */
public class SelectSort {

    public void sort(int[] array) {
        for(int i=0; i<array.length; i++) {
            int cursor = i;
            for(int j=i+1; j<array.length; j++) {
                if (array[cursor] > array[j]) {
                    cursor = j;
                }
            }
            if (cursor != i) {
                swapElement(array, i, cursor);
            }
        }
    }

    private void swapElement(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = RandomUtil.randomIntArray(20, 1000);
        RandomUtil.displayIntArray(array);
        SelectSort sort = new SelectSort();
        sort.sort(array);
        RandomUtil.displayIntArray(array);
    }

}
