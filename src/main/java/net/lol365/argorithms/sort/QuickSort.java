package net.lol365.argorithms.sort;

import net.lol365.argorithms.util.RandomUtil;

/**
 * 快速排序
 */
public class QuickSort {

    public void sort(int[] array) {
        if (array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1);
    }

    public void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 分区处理
            int pivotIndex = partition(array, low, high);
            // 左区间递归排序
            quickSort(array, low, pivotIndex - 1);
            // 右区间递归排序
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                high--;
            }
            if (low < high) {
                array[low++] = array[high];
            }
            while (low < high && array[low] <= pivot) {
                low++;
            }
            if (low < high) {
                array[high--] = array[low];
            }
        }
        array[low] = pivot;
        return low;
    }

    public static void main(String[] args) {
        int[] array = RandomUtil.randomIntArray(20, 200);
        RandomUtil.displayIntArray(array);
        QuickSort sort = new QuickSort();
        sort.sort(array);
        RandomUtil.displayIntArray(array);
    }
}
