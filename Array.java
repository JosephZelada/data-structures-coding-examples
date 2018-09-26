import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
        int[] reversedArray = new int[a.length];
        for(int i = a.length - 1; i >= 0; i--) {
            reversedArray[a.length - i - 1] = a[i];
        }
        return reversedArray;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount;
        try {
            arrCount = scanner.nextInt();
        } catch (NoSuchElementException e) {
            System.out.println("Unable to parse array length, please check input and try again");
            bufferedWriter.close();
            return;
        }
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        if (arrItems.length != arrCount) {
            System.out.println("Invalid input, provided length doesn't match integers");
            bufferedWriter.close();
            return;
        }
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arrCount; i++) {
            int arrItem;
            try {
                arrItem = Integer.parseInt(arrItems[i]);
            } catch(NumberFormatException e){
                System.out.println("Unable to parse element " + arrItems[i] + " to integer. Please check input and try again");
                bufferedWriter.close();
                return;
            }
            arr[i] = arrItem;
        }

        int[] res = reverseArray(arr);

        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

