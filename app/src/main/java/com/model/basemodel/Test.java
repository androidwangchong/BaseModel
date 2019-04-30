package com.model.basemodel;

import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;

public class Test {

    static int[] arr = {1, 45, 678, 5, 2, 8, 9, 111, 7, 456, 97341, 1, 1, 34, 4256, 3, 456,};

    //冒泡排序
    public static int[] sort(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int p = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = p;
                }
            }
        }
        return arr;
    }

    //冒泡排序 传入有序数组时，直接跳出循环
    public static int[] sort2(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return arr;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            boolean flags = true;//新加代码
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int p = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = p;
                    flags = false;//新加代码
                }
            }
            if (flags) {//新加代码
                return arr;//新加代码
            }//新加代码
        }
        return arr;
    }


    static int[] arr2 = {1, 45, 678, 5, 2, 8, 9, 111, 97366, 456, 97341, 97342, 97343, 97344, 97345, 97346, 97347, 97348, 97349};

    public static int[] sort3(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return arr;
        }
        int position = 0;//新增代码
        int length = arr.length - 1;//新增代码
        boolean isfirst = true; //新增代码
        for (int i = 0; i < length; i++) {
            boolean flags = true;
            for (int j = 0; j < length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int p = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = p;
                    flags = false;
                    position = position > j ? position : j;//新增代码
                }
            }
            /*新增代码*/
            if (isfirst) {
                isfirst = false;
                length = position;
                System.out.println(position + "");
            }
            if (flags) {
                return arr;
            }
        }
        return arr;
    }


    //快排
    private static void quickSort(int[] arr, int low, int high) {
        if (arr.length == 0 || arr.length == 1) {
            return;
        }
        if (low > high) {
            return;
        }
        int i = low;
        int j = high;
        int key = arr[low];

        while (i < j) {
            while (i < j && arr[j] > key) {
                j--;
            }
            while (i < j && arr[i] <= key) {
                i++;
            }

            if (i < j) {
                int p = arr[i];
                arr[i] = arr[j];
                arr[j] = p;
            }
        }
        int p = arr[i];
        arr[i] = arr[low];
        arr[low] = p;
//5, 对key左边的数快排
        quickSort(arr, low, i - 1);
        //6, 对key右边的数快排
        quickSort(arr, i + 1, high);

    }

    public static void s(int[] a, int l, int h) {
        if (l > h) {
            return;
        }

        int i = l;
        int j = h;

        int k = a[i];

        while (i < j) {
            while (i < j && a[j] > k) {
                j--;
            }
            while (i < j && a[i] <= k) {
                i++;
            }
            if (i < j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        int p = a[i];
        a[i] = a[l];
        a[l] = p;
        s(a, l, i - 1);
        s(a, i + 1, h);
    }

    //二分查找
    public static int myBinarySearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (value == arr[mid]) {
                return mid;
            }
            if (value > arr[mid]) {
                low = mid + 1;
            }
            if (value < arr[mid]) {
                high = mid - 1;
            }

        }
        return -1;//没有找到返回-1
    }


    public static void main(String[] args) {
//        sort();
        s(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
        int i = myBinarySearch(arr, 456);
        System.out.println(i + "");

    }


}
