import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lxp19_000 on 2015-03-01.
 */
public class Solution {

    public void heapSort(int[] A) {
        for (int i = 0; i < A.length; i++) {
            buildHeap(A, A.length - i);
            int temp = A[0];
            A[0] = A[A.length - 1 - i];
            A[A.length - 1 - i] = temp;
            System.out.println(Arrays.toString(A));
        }
    }

    public void Heapify(int[] A, int current, int size) {
        int left = getLeftChild(current);
        int right = getRightChild(current);
        int largest;

        //find the largest among three nodes
        if ((left <= size) && (A[left - 1] > A[current - 1]))
            largest = left;
        else largest = current;
        if ((right <= size) &&(A[right - 1] > A[largest - 1]))
            largest = right;

        //if the root is not the maximal, then swap
        if (current != largest && largest <= size) {
            int temp = A[current - 1];
            A[current - 1] = A[largest - 1];
            A[largest - 1] = temp;
        //When swapped, it may not be the right heap.
            Heapify(A, largest, size);
        }
    }

    public void buildHeap(int[] A, int size) {
        for (int i = size / 2; i >= 1; i--)
            Heapify(A, i, size);

    }

    public int getSize(int[] A) {
        return A.length;
    }
    public int getParent(int current) {
        return current / 2;
    }
    public int getLeftChild(int current) {
        return 2 * current;
    }

    public int getRightChild(int current) {
        return 2 * current + 1;
    }
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        list.add("保护环境");     //向列表中添加数据
        list.add("爱护地球");     //向列表中添加数据
        list.add("从我做起");        //向列表中添加数据
        list.add(1,"从我做起");     //在第1+1个元素的位置添加数据
        //通过循环输出列表中的内容
        for(int i=0;i<list.size();i++){
            System.out.println(i+":"+list.get(i));
        }
    }
}