import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static int[] arr;

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Input size of arr: ");
            int n = scanner.nextInt();

            arr = new int[n];
            Random random = new Random();
            for (int i = 0; i < n; i++) {
                arr[i] = random.nextInt(10000);
            }

            QuickSort.printArr(arr, n);

            SortingThread1 sortingThread1 = new SortingThread1();
            SortingThread2 sortingThread2 = new SortingThread2();
            MergeThread mergeThread = new MergeThread();

            int choice;

            System.out.println("QuickSort:");
            System.out.println("1. Single Thread Sorting");
            System.out.println("2. Multi Thread Sorting");
            System.out.println("0. Exit");
            System.out.println("--------------------------");
            System.out.println("Please choose the choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("----------------------------------");
                    System.out.println("-------Single Thread Sorting------");
                    System.out.println("----------------------------------");

                    // start timer
                    Date start = new Date();

                    // sorting start...
                    QuickSort.quickSort(arr, 0, n - 1);

                    // end timer
                    Date end = new Date();
                    long timeTaken = end.getTime() - start.getTime();

                    System.out.println("Here is the sorted arr:");
                    QuickSort.printArr(arr, n);

                    System.out.println();
                    System.out.println("EXECUTION TIME--------------");
                    System.out.println(timeTaken + " ms");
                    System.out.printf("%02d min, %02d sec, %03d ms%n",
                            TimeUnit.MILLISECONDS.toMinutes(timeTaken),
                            TimeUnit.MILLISECONDS.toSeconds(timeTaken) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTaken)),
                            timeTaken % 1000);

                    System.out.println("--------------Program exited--------------");
                }
                case 2 -> {
                    System.out.println("---------------------------------");
                    System.out.println("-------Multi Thread Sorting------");
                    System.out.println("---------------------------------");

                    // start timer
                    Date start = new Date();

                    sortingThread1.start();
                    sortingThread2.start();
                    mergeThread.start();

                    sortingThread1.join();
                    sortingThread1.join();
                    mergeThread.join();

                    // end timer
                    Date end = new Date();
                    long timeTaken = end.getTime() - start.getTime();

                    System.out.println("Here is the sorted arr:");
                    QuickSort.printArr(arr, n);

                    System.out.println();
                    System.out.println("EXECUTION TIME--------------");
                    System.out.println(timeTaken + " ms");
                    System.out.printf("%02d min, %02d sec, %03d ms%n",
                            TimeUnit.MILLISECONDS.toMinutes(timeTaken),
                            TimeUnit.MILLISECONDS.toSeconds(timeTaken) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeTaken)),
                            timeTaken % 1000);

                    System.out.println("--------------Program exited--------------");
                }
                case 0 -> System.exit(0);
                default -> System.out.println("Invalid Input...");
            }
        }
    }
}