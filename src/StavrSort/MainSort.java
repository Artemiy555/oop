package StavrSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.apache.commons.math3.util.ArithmeticUtils.pow;

public class MainSort {

    public static void main(String[] args) {
        long start;
        long finish;
        long timeConsumedMillis;

        int a = 0; // Начальное значение диапазона - "от"
        long b = 2147483647; // Конечное значение диапазона - "до" для 30тс
        long c = 100000-1; // Конечное значение диапазона - "до" для 100тс
        long d = pow(2,15); // Конечное значение диапазона - "до" для 300тс
        long g = 2147483647; // Конечное значение диапазона - "до" для 1мл



        int[] thiT  = new int[30_000];
        for (int i = 0; i < thiT.length; i++) {
            thiT[i] = a + (int) (Math.random() * b);
        }
        int[] tenTT  = new int[100_000];
        for (int i = 0; i < tenTT.length; i++) {
            tenTT[i] = a + (int) (Math.random() * c);
        }
        int[] thiTT  = new int[300_000];
        for (int i = 0; i < thiTT.length; i++) {
            thiTT[i] = a + (int) (Math.random() * d);
        }
        int[] oneM  = new int[1_000_000];
        for (int i = 0; i < oneM.length; i++) {
            oneM[i] = a + (int) (Math.random() * g);
        }


        System.out.println("stable-sort");
        start = System.currentTimeMillis();
        mergeSort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("//////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        mergeSort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("/////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        mergeSort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("/////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        mergeSort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);



        System.out.println("Radix sort Java implementation");
        start = System.currentTimeMillis();
        radixsort(thiT, thiT.length);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("///////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        radixsort(tenTT, tenTT.length);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        radixsort(thiTT, thiTT.length);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        radixsort(oneM, oneM.length);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("//////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);


        System.out.println("LSD radix sort");
        start = System.currentTimeMillis();
        radixSort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("///////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        radixSort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        radixSort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        radixSort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("//////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);




        System.out.println("Multi-pivot Quicksort by Yaroslavskiy");
        start = System.currentTimeMillis();
        quicksort3PivotBasic(thiT, 0, thiT.length - 1);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("///////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        quicksort3PivotBasic(tenTT, 0, tenTT.length - 1);
        radixSort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        quicksort3PivotBasic(thiTT, 0, thiTT.length - 1);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        quicksort3PivotBasic(oneM, 0, oneM.length - 1);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("//////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);


        System.out.println("IntroSort");
        SortingClass sortingClass = new SortingClass();
        sortingClass.introSort(thiT);

        start = System.currentTimeMillis();
        sortingClass.introSort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("///////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        sortingClass.introSort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        sortingClass.introSort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        start = System.currentTimeMillis();
        sortingClass.introSort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("//////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);

        System.out.println("Arrays.sort ()");

        start = System.currentTimeMillis();
        Arrays.sort(thiT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("///////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);
        start = System.currentTimeMillis();
        Arrays.sort(tenTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("///////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);
        Arrays.sort(thiTT);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);
        Arrays.sort(oneM);
        finish = System.currentTimeMillis();
        timeConsumedMillis = finish - start;
        System.out.println("//////////////////////////////////////////////////////////////////////\n"+timeConsumedMillis);


//        for(int i=0; i<thiT.length; i++)
//            System.out.print(thiT[i]+" ");
//
    }








    //Merge sort with Insert sort of short subarray
    static void print(ArrayList<Integer> a, int n) {
        for (int i = 0; i <= n; i++)
            System.out.print(a.get(i) + " ");
        System.out.println();
    }
    static void sortMerge(ArrayList<Integer> a, int n) {
        for (int i = n;
             i >= 0; i--)
            for (int j = n;
                 j > n - i; j--)
                if (a.get(j) > a.get(j - 1))
                {
                    int tempswap = a.get(j);
                    a.remove(j);
                    a.add(j, a.get(j - 1));
                    a.remove(j - 1);
                    a.add(j - 1, tempswap);
                }
       // print(a, n);
    }
    //Merge sort with Insert sort of short subarray

    //Iterative Merge Sort
    public static void mergeSort(int[] array)
    {
        if(array == null)
        {
            return;
        }

        if(array.length > 1)
        {
            int mid = array.length / 2;

            // Split left part
            int[] left = new int[mid];
            for(int i = 0; i < mid; i++)
            {
                left[i] = array[i];
            }

            // Split right part
            int[] right = new int[array.length - mid];
            for(int i = mid; i < array.length; i++)
            {
                right[i - mid] = array[i];
            }
            mergeSort(left);
            mergeSort(right);

            int i = 0;
            int j = 0;
            int k = 0;

            // Merge left and right arrays
            while(i < left.length && j < right.length)
            {
                if(left[i] < right[j])
                {
                    array[k] = left[i];
                    i++;
                }
                else
                {
                    array[k] = right[j];
                    j++;
                }
                k++;
            }
            // Collect remaining elements
            while(i < left.length)
            {
                array[k] = left[i];
                i++;
                k++;
            }
            while(j < right.length)
            {
                array[k] = right[j];
                j++;
                k++;
            }
        }
    }
    //Iterative Merge Sort


    // Radix sort Java implementation
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }


        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }


    static void radixsort(int arr[], int n)
    {
        int m = getMax(arr, n);

        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    static void print(int arr[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
    // Radix sort Java implementation

    //LSD radix sort
    public static void radixSort(int[] arr)
    {
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++)
            buckets[i] = new LinkedList<Integer>();

        boolean sorted = false;
        int expo = 1;

        while ( ! sorted) {
            sorted = true;

            for (int item : arr) {
                int bucket = (item / expo) % 10;
                if (bucket > 0) sorted = false;
                //boolean add = buckets[bucket].add(item);
            }

            expo *= 10;
            int index = 0;

            for (Queue<Integer> bucket : buckets)
                while ( ! bucket.isEmpty())
                    arr[index++] = bucket.remove();
        }

        assert isSorted(arr);
    }
    private static boolean isSorted(int[] arr)
    {
        for (int i = 1; i < arr.length; i++)
            if (arr[i - 1] > arr[i])
                return false;

        return true;
    }
    //LSD radix sort





    //Multi-pivot Quicksort by Yaroslavskiy
    private static final int INSERTION_SORT_THRESHOLD = 55;

    private static void insertionsort(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            for (int j = i; j > lo && a[j] < a[j - 1]; j--) {
                swap(a, j, j - 1);
            }
        }
    }

    // for reference
    public static void quicksort1Pivot(int[] A, int lo, int hi) {
        int length = hi - lo + 1;
        if (length < INSERTION_SORT_THRESHOLD) {
            if (length > 1)
                insertionsort(A, lo, hi);
            return;
        }
        int midpoint = (lo + hi) >>> 1;
        swap(A, lo, midpoint);

        int p = A[lo];
        int i = lo+1;
        int j = hi;
        while (i <= j) {
            while (A[i] < p && i <= j) i++;
            while (A[j] > p && i <= j) j--;
            if (i <= j) {
                swap(A, i, j);
                i++; j--;
            }
        }
        i--; j++;
        swap(A, i, lo);

        quicksort1Pivot(A, lo, i-1);
        quicksort1Pivot(A, i+1, hi);
    }


    public static void quicksort3PivotBasic(int[] A, int lo, int hi) {
        int length = hi - lo + 1;
        if (length < INSERTION_SORT_THRESHOLD) {
            if (length > 1)
                insertionsort(A, lo, hi);
            return;
        }

        int midpoint = (lo + hi) >>> 1;
        // insertion sort lo,mid,hi elements
        if (A[midpoint] < A[lo]) { int t = A[midpoint]; A[midpoint] = A[lo]; A[lo] = t; }
        if (A[hi] < A[midpoint]) { int t = A[hi]; A[hi] = A[midpoint]; A[midpoint] = t;
            if (t < A[lo]) { A[midpoint] = A[lo]; A[lo] = t; }
        }

        int p = A[lo];
        int q = A[midpoint];
        int r = A[hi];
        // p,q & r are now sorted, place them at a[lo], a[lo+1] & a[hi]
        swap(A, lo+1, midpoint);

        // Pointers a and b initially point to the first element of the array while c
        // and d initially point to the last element of the array.
        int a = lo + 2;
        int b = lo + 2;
        int c = hi - 1;
        int d = hi - 1;

        while (b <= c) {
            while (A[b] < q && b <= c) {
                if (A[b] < p) {
                    swap(A, a, b);
                    a++;
                }
                b++;
            }
            while (A[c] > q && b <= c) {
                if (A[c] > r) {
                    swap(A, c, d);
                    d--;
                }
                c--;
            }
            if (b <= c) {
                if (A[b] > r) {
                    if (A[c] < p) {
                        swap(A, b, a); swap(A, a, c);
                        a++;
                    } else {
                        swap(A, b, c);
                    }
                    swap(A, c, d);
                    b++; c--; d--;
                } else {
                    if (A[c] < p) {
                        swap(A, b, a); swap(A, a, c);
                        a++;
                    } else {
                        swap(A, b, c);
                    }
                    b++; c--;
                }
            }
        }
        // swap the pivots to their correct positions
        a--; b--; c++; d++;
        swap(A, lo + 1, a); swap(A, a, b);
        a--;
        swap(A, lo, a);
        swap(A, hi, d);

        quicksort3PivotBasic(A, lo, a-1);
        quicksort3PivotBasic(A, a+1, b-1);
        quicksort3PivotBasic(A, b+1, d-1);
        quicksort3PivotBasic(A, d+1, hi);
    }


    public static void quicksort3Pivot(int[] A, int lo, int hi) {
        int length = hi - lo + 1;
        if (length < INSERTION_SORT_THRESHOLD) {
            if (length > 1)
                insertionsort(A, lo, hi);
            return;
        }

        // approximation of length / 7
        int seventh = (length >> 3) + (length >> 6) + 1;

        int e4 = (lo + hi) >>> 1; // The midpoint
        int e3 = e4 - seventh;
        int e2 = e3 - seventh;
        int e1 = lo;
        int e5 = e4 + seventh;
        int e6 = e5 + seventh;
        int e7 = hi;

        // Sort using insertion sort
        if (A[e2] < A[e1]) { int t = A[e2]; A[e2] = A[e1]; A[e1] = t; }

        if (A[e3] < A[e2]) { int t = A[e3]; A[e3] = A[e2]; A[e2] = t;
            if (t < A[e1]) { A[e2] = A[e1]; A[e1] = t; }
        }
        if (A[e4] < A[e3]) { int t = A[e4]; A[e4] = A[e3]; A[e3] = t;
            if (t < A[e2]) { A[e3] = A[e2]; A[e2] = t;
                if (t < A[e1]) { A[e2] = A[e1]; A[e1] = t; }
            }
        }
        if (A[e5] < A[e4]) { int t = A[e5]; A[e5] = A[e4]; A[e4] = t;
            if (t < A[e3]) { A[e4] = A[e3]; A[e3] = t;
                if (t < A[e2]) { A[e3] = A[e2]; A[e2] = t;
                    if (t < A[e1]) { A[e2] = A[e1]; A[e1] = t; }
                }
            }
        }
        if (A[e6] < A[e5]) { int t = A[e6]; A[e6] = A[e5]; A[e5] = t;
            if (t < A[e4]) { A[e5] = A[e4]; A[e4] = t;
                if (t < A[e3]) { A[e4] = A[e3]; A[e3] = t;
                    if (t < A[e2]) { A[e3] = A[e2]; A[e2] = t;
                        if (t < A[e1]) { A[e2] = A[e1]; A[e1] = t; }
                    }
                }
            }
        }
        if (A[e7] < A[e6]) { int t = A[e7]; A[e7] = A[e6]; A[e6] = t;
            if (t < A[e5]) { A[e6] = A[e5]; A[e5] = t;
                if (t < A[e4]) { A[e5] = A[e4]; A[e4] = t;
                    if (t < A[e3]) { A[e4] = A[e3]; A[e3] = t;
                        if (t < A[e2]) { A[e3] = A[e2]; A[e2] = t;
                            if (t < A[e1]) { A[e2] = A[e1]; A[e1] = t; }
                        }
                    }
                }
            }
        }

        int p = A[e2];
        int q = A[e4];
        int r = A[e6];
        swap(A, lo, e2);
        swap(A, lo+1, e4);
        swap(A, hi, e6);
        // Pointers a and b initially point to the first element of the array while c
        // and d initially point to the last element of the array.
        int a = lo + 2;
        int b = lo + 2;
        int c = hi - 1;
        int d = hi - 1;

        while (b <= c) {
            while (A[b] < q && b <= c) {
                if (A[b] < p) {
                    swap(A, a, b);
                    a++;
                }
                b++;
            }
            while (A[c] > q && b <= c) {
                if (A[c] > r) {
                    swap(A, c, d);
                    d--;
                }
                c--;
            }
            if (b <= c) {
                if (A[b] > r) {
                    if (A[c] < p) {
                        swap(A, b, a); swap(A, a, c);
                        a++;
                    } else {
                        swap(A, b, c);
                    }
                    swap(A, c, d);
                    b++; c--; d--;
                } else {
                    if (A[c] < p) {
                        swap(A, b, a); swap(A, a, c);
                        a++;
                    } else {
                        swap(A, b, c);
                    }
                    b++; c--;
                }
            }
        }
        // swap the pivots to their correct positions
        a--; b--; c++; d++;
        swap(A, lo + 1, a); swap(A, a, b);
        a--;
        swap(A, lo, a);
        swap(A, hi, d);

        quicksort3Pivot(A, lo, a-1);
        quicksort3Pivot(A, a+1, b-1);
        quicksort3Pivot(A, b+1, d-1);
        quicksort3Pivot(A, d+1, hi);
    }

    private static final void swap(int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    private static boolean isSorted(int[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++) {
            if (a[i] < a[i - 1]) {
                return false;
            }
        }
        return true;
    }
    //Multi-pivot Quicksort by Yaroslavskiy


}
