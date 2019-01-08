package svndemo.test.sort;


import java.util.Arrays;

/**
 * Created by hongjian.chen on 2019/1/7.
 */
public class BubbleSort {

    //    冒泡排序
    public static void bubbleSort(int[] a) {
        //外层循环控制比较的次数
        for (int i = 0; i < a.length - 1; i++) {
            //内层循环控制到达位置
            for (int j = 0; j < a.length - i - 1; j++) {
                //前面的元素比后面大就交换
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
        System.out.println("Current sorting result:");
        System.out.println("冒泡排序:" + Arrays.toString(a));
    }

    //快速排序
    public static int[] quickSort(int low, int high, int[] a) {
        //1,找到递归算法的出口
        if (low > high) {
            return null;
        }
        //2, 存
        int left = low;
        int right = high;
        //3,保存基准值
        int pivot = a[left];
        //4，完成一趟排序
        while (left < right) {
            //4.1 ，从右往左找到第一个小于pivot的数
            while (left < right && a[right] >= pivot) {
                right--;
            }
//            交换
//            a[left] = a[right];
//            4.2 从左往右找到第一个大于pivot的数
            while (left < right && a[left] <= pivot) {
                left++;
            }
//            a[right] = a[left];
//            4.3 交换
            int p = a[left];
            a[left] = a[right];
            a[right] = p;
        }
//        4.4，调整pivot的位置
        int p = a[left];
        a[left] = a[low];
        a[low] = p;
//        放置基准值，准备分治递归快排
//        a[left] = pivot;
//        5, 对pivot左边的数快排
        quickSort(low, left - 1, a);
//        6, 对pivot右边的数快排
        quickSort(right + 1, high, a);
        return a;
    }

    public static int[] quickSort2(int[] a, int low, int high) {
        //已经排完
        if (low >= high) {
            return null;
        }
        int left = low;
        int right = high;
        //保存基准值
        int pivot = a[left];
        while (left < right) {
            //从后向前找到比基准小的元素
            while (left < right && a[right] >= pivot)
                right--;
            a[left] = a[right];
            //从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot)
                left++;
            a[right] = a[left];
        }
        // 放置基准值，准备分治递归快排
        a[left] = pivot;
        quickSort2(a, low, left - 1);
        quickSort2(a, left + 1, high);
        return a;
    }

    public static void main(String[] args) {
        int[] a = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        System.out.println("Before numsert Sorting:");
        SortUtil.show(a);
//        bubbleSort(a);
        int[] nums = BubbleSort.quickSort(0, a.length - 1, a);
        int[] nums2 = BubbleSort.quickSort2(a, 0, a.length - 1);
        System.out.println("Current sorting result:");
        System.out.println("快速排序:" + Arrays.toString(nums));
        System.out.println("快速排序:" + Arrays.toString(nums2));
    }
}
