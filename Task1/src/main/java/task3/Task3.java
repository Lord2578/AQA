package task3;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {

    // Array Reverse: Write a Java program that takes an array of integers and reverses its elements.
    // Your program should prompt the user to enter the array size and the elements of the array,
    // and then output the reversed array.

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Розмір масиву: ");
        int size = scanner.nextInt();

        int[] array = new int[size];
        System.out.print("Елементи масиву: ");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        int [] reversedArray = reverseArray(array);

        System.out.println("Реверсований масив: " + Arrays.toString(reversedArray));
    }

    private static int[] reverseArray(int[] array) {
        int [] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++){
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

}
