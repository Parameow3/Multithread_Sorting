import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        int[] arr = {7, 12, 19, 3, 18, 4, 2, 6, 15, 8};
        int n = arr.length;

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("QuickSort:");
        System.out.println("1. Single Thread Sorting");
        System.out.println("2. Multi Thread Sorting");
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

            }
            default -> System.out.println("Invalid Input...");
        }
    }
}