package task3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Task3 {

    /// Array Reverse: Write a Java program that takes an array of integers and reverses its elements. Your program should prompt the user to enter the array size and the elements of the array, and then output the reversed array.
    // Make HashSet of doubles from the result array and perform the following operations: a) Add an element to the end of the list; b)Remove an element from the list; c)Replace an element in the list; d)Sort the list in alphabetical order; e)Print the elements of the list;
    //Make up the situation for ArrayIndexOutOfBoundsException. Catch it and display the explanation for your custom case.

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

        /// Створюємо хешсет з елементами масиву
        HashSet<Double> hashSet = new HashSet<>();
        for (int num : reversedArray) {
            hashSet.add((double) num);
        }

        System.out.println("HashSet " + hashSet);

        // a) Add an element to the end of the list;

        hashSet.add(99.99);
        System.out.println("Після додавання елемента 99.99: " + hashSet);

    }

    private static int[] reverseArray(int[] array) {
        int [] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++){
            reversedArray[i] = array[array.length - 1 - i];
        }
        return reversedArray;
    }

}
