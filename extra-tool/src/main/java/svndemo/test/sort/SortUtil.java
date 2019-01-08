package svndemo.test.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by hongjian.chen on 2019/1/8.
 */
public class SortUtil {

    public static int[] initArray() {
        int[] nums = new int[10];
        int index = 0;
        System.out.println("Please input test values you want to sort(Exit for zero/0):");
        Scanner sc = new Scanner(System.in);
        String st;
        do {
            st = sc.next();
            nums[index] = Integer.parseInt(st);
            index++;
            System.out.println("index=" + index + ":");
        } while (nums[index - 1] != 0);
        return nums;
    }

    public static void show(int[] nums) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0) {
                builder.append(" " + nums[i]);
            } else {
                builder.append(nums[i]);
            }
        }
        System.out.println(builder.toString());
    }

    /**
     * 基数排序
     * 1.取得数组中的最大数，并取得位数；
     * 2.arr为原始数组，从最低位开始取每个位组成radix数组；
     * 3.对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     */
    @Test
    public void sort() {
        int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        System.out.println("Before Sorting:" + Arrays.toString(arr));
        if (arr.length <= 1) return;
        //取得数组中的最大数，并取得位数
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        //申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;
        //从低位到高位，对每一位遍历，将所有元素分配到桶中
        for (int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];        //存储各个桶中存储元素的数量
            //分配：将所有元素分配到桶中
            for (int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }
            //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
            int k = 0;
            for (int b = 0; b < buckets.length; b++) {
                for (int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            base *= 10;
        }
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arras = SortUtil.initArray();
        System.out.println("Before numsert Sorting:");
        show(arras);
//        InsertSort.insertSort(arras);
//        InsertSort.myShellSort(arras);
//        BubbleSort.bubbleSort(arras);
//        SelectSort.selectSort(arras);
        HeapSort.heapSort(arras);
        System.out.println("After numsert Sorting:");
        show(arras);
    }
}
