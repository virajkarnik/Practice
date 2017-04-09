/**
 * Created by viraj on 4/1/2017.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5,2,4,6,7,2,6,3};
        MergeSort ms = new MergeSort();
        int[] sorted_arr = ms.sort(arr, 0, arr.length-1, (arr.length-1)/2);
        System.out.println("sorted array");
        for (int i = 0; i < sorted_arr.length; i++) {
            System.out.print(" "+ sorted_arr[i]);
        }
    }

    int[] sort(int[] arr, int first, int last, int mid) {
        if (first == last) return arr;
        int[] arr_left = sort(arr, first, mid, (first+mid)/2);
        int[] arr_right = sort(arr, mid+1, last, (mid+last+1)/2);
        int[] helper = new int[arr.length];
        int[] arr_sorted = merge(arr_left, helper, first, mid, last);
        return arr_sorted;
    }

    int[] merge(int[] arr, int[] helper, int first, int mid, int last) {
        System.out.println("into merge: " + first + " " + mid + " " + last);
        for (int n = first; n < last; n++) {
            helper[n] = arr[n];
        }
        //int[] arr_sorted = new int[arr_left.length+arr_right.length];
        int i = first, j = mid+1, ctr = 0;
        while (i <= mid && j <= last) {
            System.out.println(ctr+ "th comparison " + i + " " + j);
            if (helper[i] <= helper[j]) {
                arr[ctr] = arr[i]; i++;
            }
            else {
                arr[ctr] = arr[j]; j++;
            }
            ctr++;
        }
/*
        if (i > mid) {
            while (j <= last) {
                arr_sorted[ctr] = arr_right[j]; j++; ctr++;
            }
        }
*/
        if (j > last) {
            while (i <= mid) {
                arr[ctr] = arr[i]; i++; ctr++;
            }
        }
        return arr;
    }
}
