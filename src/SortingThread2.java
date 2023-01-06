public class SortingThread2 extends Thread{
    @Override
    public void run(){
        // sorting start...
        QuickSort.quickSort(Main.arr, Main.arr.length/2 - 1, Main.arr.length - 1);
        //QuickSort.printArr(Main.arr, Main.arr.length - 1);
    }
}
