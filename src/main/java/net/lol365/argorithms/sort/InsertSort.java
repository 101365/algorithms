package net.lol365.argorithms.sort;

import net.lol365.argorithms.util.RandomUtil;

/**
 * 插入排序
 * 1.从第一个元素开始，该元素可以认为已经被排序
 * 2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 * 3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 * 4.重复步骤 3，直到找到已排序的元素小于或者等于新元素的位置
 * 5.将新元素插入到该位置后
 * 6.重复步骤 2~5
 */
public class InsertSort {

    public void sort(int[] array) {
        // 外循环是待排序元素
        for(int i=1; i<array.length; i++) {
            int value = array[i];
            // 内循环是已排序元素
            for(int j=0; j<i; j++) {
                if (value < array[j]) {
                    // 所有元素后移，外围元素插入到当前位置
                    for(int k=i; k>j; k--) {
                        swapElement(array, k, k-1);
                    }
                    array[j] = value;
                    break;
                }
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
        InsertSort sort = new InsertSort();
        sort.sort(array);
        RandomUtil.displayIntArray(array);
    }

}
