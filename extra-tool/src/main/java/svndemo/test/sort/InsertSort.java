package svndemo.test.sort;

import java.util.Arrays;

/**
 * Created by hongjian.chen on 2019/1/7.
 */
public class InsertSort {
    //    插入排序
    public static void insertSort(int[] nums) {
        int insertNode;
        for (int i = 0; i < nums.length; i++) {
            insertNode = nums[i];
            int j = i - 1;
            while (j >= 0 && insertNode < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = insertNode;
        }
        System.out.println("Current sorting result:");
        System.out.println(nums.length + ":" + Arrays.toString(nums));
    }

    public static void myShellSort(int[] arr) {
        // i表示希尔排序中的第n/2+1个元素（或者n/4+1）
        // j表示希尔排序中从0到n/2的元素（n/4）
        // r表示希尔排序中n/2+1或者n/4+1的值
        int i, j, r, tmp;
        // 划组排序
        for (r = arr.length / 2; r >= 1; r = r / 2) {
            for (i = r; i < arr.length; i++) {
                tmp = arr[i];
                j = i - r;
                // 一轮排序
                while (j >= 0 && tmp < arr[j]) {
                    arr[j + r] = arr[j];
                    j -= r;
                }
                arr[j + r] = tmp;
            }
        }
        System.out.println("Current sorting result:");
        System.out.println(arr.length + ":" + Arrays.toString(arr));
    }

    //    希尔排序
    public static int[] shellSort(int[] nums) {
        int len = nums.length;
        int gap = nums.length / 2;
        while (gap > 0) {
            for (int j = gap; j < len; j++) {
                int i = j;
                while (i >= gap && nums[i - gap] > nums[i]) {
                    int temp = nums[i - gap] + nums[i];
                    nums[i - gap] = temp - nums[i - gap];
                    nums[i] = temp - nums[i - gap];
                    i -= gap;
                }
            }
            gap = gap / 2;
        }
        System.out.println("Current sorting result:");
        System.out.println(len + ":" + Arrays.toString(nums));
        return nums;
    }

    /**
     * 通过交换进行插入排序，借鉴冒泡排序
     *
     * @param a
     */
    public static int[] sort1(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        return a;
    }

    /**
     * 通过将较大的元素都向右移动而不总是交换两个元素
     *
     * @param a
     */
    public static int[] sort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int num = a[i];
            int j;
            for (j = i; j > 0 && num < a[j]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = num;
        }
        return a;
    }

    /**
     * 三向快速排序^e^看不懂
     * 在lt之前的(lo~lt-1)都小于中间值
     * 在gt之前的(gt+1~hi)都大于中间值
     * 在lt~i-1的都等于中间值
     * 在i~gt的都还不确定（最终i会大于gt，即不确定的将不复存在）
     */
    public static void sortThreeWay(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int v = a[lo], lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            if (a[i] < v) {
                swap(a, i++, lt++);
            } else if (a[i] > v) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        sortThreeWay(a, lo, lt - 1);
        sortThreeWay(a, gt + 1, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        System.out.println("Before numsert Sorting:");
        System.out.println("a:" + Arrays.toString(a));
        sortThreeWay(a, 0, a.length - 1);
        System.out.println("After numsert Sorting:");
        SortUtil.show(a);
//        insertSort(a);
        int[] nums1 = sort1(a);
        int[] nums2 = sort2(a);
        System.out.println("Current sorting result:");
        System.out.println("nums1" + Arrays.toString(nums1));
        System.out.println("nums2:" + Arrays.toString(nums2));
    }
}
