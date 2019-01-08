package svndemo.test.sort;

import java.util.Arrays;

/**
 * Created by hongjian.chen on 2019/1/7.
 */
public class SelectSort {


    //    选择排序
    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int indexMin = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[indexMin]) {
                    indexMin = j;
                }
            }
            if (i != indexMin) {
                int temp = nums[i];
                nums[i] = nums[indexMin];
                nums[indexMin] = temp;
            }
        }
        System.out.println("Current sorting result:");
        System.out.println(nums.length + ":" + Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] a = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1};
        System.out.println("Before numsert Sorting:");
        System.out.println("a:" + Arrays.toString(a));
        selectSort(a);
    }
}
