import java.util.ArrayList;
import java.util.Arrays;

public class MyMain {
    // ********************
    // Code from homework
    // ********************

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length+arr2.length];
        int index1=0;
        int index2=0;
        int finalIndex=0;
        while (index1 < arr1.length|| index2 < arr2.length) {
            if (index1>arr1.length-1&&index2>arr2.length-1){
                break;
            }
            else if (index1>arr1.length-1){
                result[finalIndex]=arr2[index2];
                index2++;
            }
            else if (index2>arr2.length-1){
                result[finalIndex]=arr1[index1];
                index1++;
            }
            else if (arr1[index1] < arr2[index2]) {
                result[finalIndex] = arr1[index1];

                index1++;

            } else {
                result[finalIndex] = arr2[index2];

                index2++;

            }
            finalIndex++;
        }
        return result;
    }

    // **************************
    // In-class Practice Problems
    // **************************

    // Create a copy of part of an array
    // This should work similarly to substring in that we are
    // given two indexes, start and end, and we start with the
    // value at start and go up to but not including end

    // Examples:
    // subArray([5, 4, 3, 2, 1], 1, 3) => [4, 3]
    // subArray([1, 4, 3, 7], 0, 4) => [1, 4, 3, 7]
    // subArray([1, 4, 3, 7], 2, 4) => [3, 7]
    public static int[] subArray(int[] arr, int begin, int end) {
        int[] result = new int[end-begin];
        int index=0;
        for (int i=begin;i<end;i++){
            result[index]=arr[i];
            index++;
        }
        return result;
    }

    // Carries out merge sort!
    // The merge sort algorithm is divided into three main steps
    // Divide the array into two halves
    // Call merge sort (recursively) on the left half and the right half
    // Call merge to combine the two sorted halves into one sorted array
    //
    // We will keep recursing until the array is size 1, at which point we
    // just array the (sorted) array of size 1

    // You can assume that the array's length will be some power of 2

    // Examples:
    // mergeSort([6, 3, 4, 1, 5, 8, 7, 2]) => [1, 2, 3, 4, 5, 6, 7, 8]
    public static int[] mergeSort(int[] arr) {
        if(arr.length==0){
            return arr;
        }
        else if (arr.length==1) {
            return arr;
        }
        else{
            return merge(mergeSort(subArray(arr,0,arr.length/2)),mergeSort(subArray(arr,arr.length/2,arr.length)));
        }
    }



    // **************************
    // Homework Methods
    // **************************

    // For homework, we'll revisit a previous algorithm: insertion sort.
    // This will be the final recursive code that we'll write for a while.

    // First, write the insert method, which is given a sorted ArrayList
    // and a number x to insert into that ArrayList

    // Tail recursion will probably be helpful!

    // Hint: recall that we are going to insert x once we find the first
    // number in the ArrayList that is larger than x

    // Hint2: if we never find a number larger than x, x should be inserted
    // at the end of our ArrayList

    // Examples:
    // insert([1, 2, 4, 5], 3) => [1, 2, 3, 4, 5]
    // insert([1, 2, 4, 5], 0) => [0, 1, 2, 4, 5]
    // insert([1, 2, 4, 5, 7, 8], 10) => [1, 2, 4, 5, 7, 8, 10]

    // Wrapper method
    public static ArrayList<Integer> insert(ArrayList<Integer> list, int x) {
        return insertTR(list, x, 0);
    }

    // Tail recursive method
    public static ArrayList<Integer> insertTR(ArrayList<Integer> list, int x, int i) {
        if (list.size()<1){
            return list;
        }
        if (i==list.size()){
            list.add(x);
            return list;
        }
        else{
            if (list.get(i)<x){
                return insertTR(list,x,i+1);
            }
            else{
                list.add(i,x);
                return list;
            }
        }
    }

    // Next, write the insertion sort method, which is sorts a given
    // ArrayList using insertion sort

    // We can use the following recursive pseudocode:
    // Base case: if the list is size 1, it's sorted so just return the original list
    // Otherwise:
    // * Save the last element in the ArrayList
    // * Remove the last element of the ArrayList (making the list 1 shorter)
    // * Recursively sort the (now shorter) list
    // * Insert the saved value into the sorted, shorter list

    // No tail recursion necessary!

    // Hint: use the insert value from above

    // Examples:
    /// insertionSort([6, 3, 4, 1, 5, 8, 7, 2]) => [1, 2, 3, 4, 5, 6, 7, 8]
    public static ArrayList<Integer> insertionSort(ArrayList<Integer> list) {
        if(list.size() <= 1) {
            return list;
        }
        else{
            int n = list.get(list.size()-1);
            list.remove(list.size()-1);
            list = insertionSort(list);
            list = insert(list, n);
            return list;
        }
    }
}
