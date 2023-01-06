public class MergeThread extends Thread{
    @Override
    public void run(){
        // sorting start...
        QuickSort.quickSort(Main.arr, 0, Main.arr.length - 1);
        //QuickSort.printArr(Main.arr, Main.arr.length - 1);
    }
}
