public class SortingThread1 extends Thread{
    @Override
    public void run(){
        // sorting start...
        QuickSort.quickSort(Main.arr, 0, Main.arr.length/2 - 1);
        //QuickSort.printArr(Main.arr, Main.arr.length/2 - 1);
    }
}
