package net.lol365.argorithms.sort;

import net.lol365.argorithms.util.RandomUtil;

/**
 * 希尔排序
 */
public class ShellSort {

    public void sort(int[] array) {
        // 初始步长
        for (int step = array.length / 2; step > 0; step /= 2) {
            for (int i = step; i < array.length; i++) {
                int j = i;
                while (j - step >= 0 && array[j] < array[j - step]) {
                    //插入排序采用交换法
                    swapElement(array, j, j - step);
                    j -= step;
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
        int[] array = RandomUtil.randomIntArray(20, 200);
        RandomUtil.displayIntArray(array);
        ShellSort sort = new ShellSort();
        sort.sort(array);
        RandomUtil.displayIntArray(array);
    }
}
