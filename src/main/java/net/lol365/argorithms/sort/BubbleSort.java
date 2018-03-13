package net.lol365.argorithms.sort;

import net.lol365.argorithms.util.RandomUtil;

/**
 * 冒泡排序
 *  平均复杂度和最差复杂度都是n^2
 */
public class BubbleSort {

    public void sort(int[] array) {
        for(int i=0; i<array.length; i++) {
            for(int j=i+1; j<array.length; j++) {
                if (array[i]>array[j]) {
                    swapElement(array, i, j);
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
        BubbleSort sort = new BubbleSort();
        sort.sort(array);
        RandomUtil.displayIntArray(array);
    }

}
