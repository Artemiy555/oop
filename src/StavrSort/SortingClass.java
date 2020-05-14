package StavrSort;

public class SortingClass implements sortingAlgorithms{
    private HeapSort heap=new HeapSort();

    private IntroSort intro=new IntroSort();

    private MergeSort marge=new MergeSort();

    private Radix rad=new Radix();

    private LsdRadix lsd=new LsdRadix();

    private Quicksort quick=new Quicksort();

    @Override
    public void heapSort(int[] arr) {
        heap.sort(arr);

    }
    @Override
    public void introSort(int[] arr) {
        intro.sort(arr,0,arr.length-1);
    }
    @Override
    public void mergeSort( int[] arr) {
        marge.mergeSort(arr);
    }
    @Override
    public void radix( int[] arr) {
        rad.radixsort(arr);
    }
    @Override
    public void lsdRadix(int[] arr) {
        lsd.radixSortLSD(arr);
    }

    @Override
    public void quicksort(int[] A, int lo, int hi) {
        quick.quicksort3PivotBasic(A,lo, hi);
    }


}
