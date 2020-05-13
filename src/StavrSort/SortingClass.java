package StavrSort;

public class SortingClass implements sortingAlgorithms{
    private HeapSort heap=new HeapSort();

    private IntroSort intro=new IntroSort();

    @Override
    public void heapSort(int[] arr) {
        heap.sort(arr);

    }
    @Override
    public void introSort(int[] arr) {
        intro.sort(arr,0,arr.length-1);
    }


}
