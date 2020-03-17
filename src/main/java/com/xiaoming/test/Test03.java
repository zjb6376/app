package com.xiaoming.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * @Author:zjb
 * @Date:2020/2/5
 * @Version 1.0
 */
public class Test03 {


    public static void main(String[] args) {
        Test03 t3 = new Test03();
        // t3.bubbleSort();
        // t3.chooseSort1();
        // t3.chooseSort2();
        // t3.insertSort();
        // t3.xierSort2();
        int[] array = {35, 15, 78, 22, 8, 32, 2, 22};
        t3.quickSort(array, 0, array.length - 1);
    }


    public void bubbleSort() {
        // int[] array = {35, 15, 78, 22, 8, 32, 2};
        boolean flag = false;
        int[] array = new int[80000];
        Random random = new Random();

        for (int i = 0; i < 80000; i++) {
            array[i] = random.nextInt(80000);
        }

        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + startTime);
        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            if (!flag) {
                break;
            } else {
                flag = false;
            }
        }
        long overTime = System.currentTimeMillis();
        System.out.println("结束时间：" + overTime);
        System.out.println("耗时：" + (overTime - startTime));
    }


    public void chooseSort1() {
        // int[] array = {35, 15, 78, 22, 8, 32, 2};
        int[] array = new int[80000];
        Random random = new Random();

        for (int i = 0; i < 80000; i++) {
            array[i] = random.nextInt(80000);
        }
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + startTime);

        int temp = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        long overTime = System.currentTimeMillis();
        System.out.println("结束时间：" + overTime);
        System.out.println("耗时：" + (overTime - startTime));
    }

    public void chooseSort2() {
        // int[] array = {35, 15, 78, 22, 8, 32, 2};
        int[] array = new int[80000];
        Random random = new Random();

        for (int i = 0; i < 80000; i++) {
            array[i] = random.nextInt(80000);
        }
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + startTime);

        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
        long overTime = System.currentTimeMillis();
        System.out.println("结束时间：" + overTime);
        System.out.println("耗时：" + (overTime - startTime));
    }

    public void insertSort() {
        int[] array = {35, 15, 78, 22, 8, 32, 2};

        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < array.length; i++) {
            insertVal = array[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex + 1] = insertVal;
        }
        System.out.println(Arrays.toString(array));
    }

    public void xierSort1() {
        int[] array = {35, 15, 78, 22, 8, 32, 2};
        int temp = 0;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] > array[j + gap]) {
                        temp = array[j];
                        array[j] = array[j + gap];
                        array[j + gap] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public void xierSort2() {
        // int[] array = {35, 15, 78, 22, 8, 32, 2};
        int[] array = new int[80000];
        Random random = new Random();

        for (int i = 0; i < 80000; i++) {
            array[i] = random.nextInt(80000);
        }
        long startTime = System.currentTimeMillis();
        System.out.println("开始时间：" + startTime);

        int temp = 0;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                temp = array[j];
                while (j - gap >= 0 && temp < array[j - gap]) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
        }
        long overTime = System.currentTimeMillis();
        System.out.println("结束时间：" + overTime);
        System.out.println("耗时：" + (overTime - startTime));
    }

    public void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;

        int pivot = array[(left + right) / 2];
        int temp = 0;

        while (l < r) {
            while (array[l] < pivot) {
                l += 1;
            }
            while (array[r] > pivot) {
                r -= 1;
            }
            if (l >= r) {
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            if (array[l] == pivot) {
                r -= 1;
            }
            if (array[r] == pivot) {
                l += 1;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r) {
            quickSort(array, left, r);
        }
        if (right > l) {
            quickSort(array, l, right);
        }

        System.out.println(Arrays.toString(array));
    }

    public void guibingSort2(int[] array, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            guibingSort2(array, left, mid, temp);
            guibingSort2(array, mid + 1, right, temp);
            guibingSort1(array, left, mid, right, temp);
        }
    }

    public void guibingSort1(int[] array, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid + 1;
        int t = 0;

        while(i<mid && j<=right){
            if(array[i] <= array[j]){
                temp[t] = array[i];
                t += 1;
                i += 1;
            } else{
                temp[t] = array[j];
                t += 1;
                j += 1;
            }
        }

        while(i < mid){
            temp[t] = array[i];
            t += 1;
            i += 1;
        }

        while(j <= right){
            temp[t] = array[j];
            t += 1;
            j += 1;
        }

        t = 0;
        int tempLeft = left;
        while(tempLeft <= right){
            array[tempLeft] = temp[t];
            t += 1;
            tempLeft += 1;
        }
    }
}
