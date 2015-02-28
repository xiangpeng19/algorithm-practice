import com.sun.scenario.effect.Merge;

/**
 * Created by lxp19_000 on 2015-02-27.
 */
public class Solution {
    public void mergeSort(int[] A, int[] temp, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        mergeSort(A, temp, start, mid);
        mergeSort(A, temp, mid + 1, end);
        Merge(A, temp, start, mid, end);
    }

    public void Merge(int[] A,int[] temp, int start, int mid, int end) {
        //first have a back up of the origin array
        for (int i = start; i <= end; i++) temp[i] = A[i];
        int firstHalf = start, secondHalf = mid + 1;
        int index = start;
        while (firstHalf <= mid && secondHalf <= end) {
            if (temp[firstHalf] <= temp[secondHalf]) A[index++] = temp[firstHalf++];
            if (temp[firstHalf] > temp[secondHalf]) A[index++] = temp[secondHalf++];
        }
        while (firstHalf <= mid) A[index++] = temp[firstHalf++];
        while (secondHalf <= end) A[index++] = temp[secondHalf++];
    }
    public void quickSort(int[] A, int start, int end) {
        if (start > end) return;
        if (start < end) {
            int base = A[start];
            int i = start, j = end;
            while(i <= j) {
                while (i < end && A[i] < base) i++;
                while (j > start && A[j] > base) j--;
                if (i <= j) {
                    int temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    i++;
                    j--;
                }
            }
            if (start < j) quickSort(A, start, j);
            if (end > i) quickSort(A, i, end);

        }
    }

    public void insertSort(int[] A) {
        if (A.length == 0) return;
        for (int i = 1; i < A.length; i++)
            //we have to move A[j] before A[i]
            if (A[i] < A[i - 1]) {
                int temp = A[i];
                int j = i - 1;
                for (; j > 0 && A[j] > temp; j--) {
                    A[j + 1] = A[j];
                }
                A[j] = temp;
            }
    }

    //Every time we select the min and swap it to front
    public void selectSort(int[] A) {
        if (A.length == 0) return;
        for (int i = 0; i < A.length; i++)
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[i]) {
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                }
            }
    }
    public void bubbleSort(int[] A) {
        if (A.length == 0) return;
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[j - 1]) {
                    int temp = A[j];
                    A[j] = A[j - 1];
                    A[j - 1] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
 //       int A[] = {1};
        int[] A = {3,2,6,4,8,7,2222,222,9,1,6};
        int[] temp = new int[A.length];
        Solution s = new Solution();
//        s.bubbleSort(A);
//        s.selectSort(A);
//        s.insertSort(A);
//        s.quickSort(A, 0, A.length - 1);
        s.mergeSort(A, temp, 0, A.length - 1);
        for (int i : A)
            System.out.println(i);
    }
}
