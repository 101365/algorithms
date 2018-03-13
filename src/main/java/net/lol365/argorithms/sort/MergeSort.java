package net.lol365.argorithms.sort;

import net.lol365.argorithms.util.RandomUtil;

/**
 * 归并排序
 */
public class MergeSort {

    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    public void mergeSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    /**
      (1）申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     （2）设定两个指针，最初位置分别为两个已经排序序列的起始位置
     （3）比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     （4）重复步骤3直到某一指针达到序列尾
     （5）将另一序列剩下的所有元素直接复制到合并序列尾
     * @param a
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] a, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        // 把较小的数先移到新数组中
        while (i <= mid && j <= right) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while (j <= right) {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for (int k2 = 0; k2 < temp.length; k2++) {
            a[k2 + left] = temp[k2];
        }

    }

    public static void main(String[] args) {
        int[] array = RandomUtil.randomIntArray(20, 1000);
        RandomUtil.displayIntArray(array);
        MergeSort sort = new MergeSort();
        sort.sort(array);
        RandomUtil.displayIntArray(array);
    }

}
