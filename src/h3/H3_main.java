package h3;

import java.util.Arrays;

public class H3_main {
    public static void main(String[] args) {
        int[] array = {5, 3, 8, 4, 2};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(mergeSort(array)));

    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] linkeHaelfte = new int[mid];
        int[] rechteHaelfte = new int[array.length - mid];

        for (int i = 0; i < mid; i++) {
            linkeHaelfte[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            rechteHaelfte[i - mid] = array[i];
        }

        return merge(mergeSort(linkeHaelfte), mergeSort(rechteHaelfte));
    }

    public static int[] merge(int[] array1, int[] array2) {
        int [] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] > array2[j]) {
                result[k++] = array2[j++];
            } else {
                result[k++] = array1[i++];
            }
        }

        while (i < array1.length) {
            result[k++] = array1[i++];
        }
        while (j < array2.length) {
            result[k++] = array2[j++];
        }

        return result;
    }
}
