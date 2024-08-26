/// V 1: Basic Arithmetic Operations
//Objective: To understand and perform basic arithmetic operations in Java using primitive types.
//Instructions:
//Declare two int variables.
//Assign values to the variables and perform basic arithmetic operations (e.g., addition, subtraction, multiplication, division).
//Print the results of each operation to the console.

package task1;

public class task1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        int sum = num1 + num2;
        int subs = num1 - num2;
        int multi = num1 * num2;
        int divide = num1 / num2;

        System.out.println("Addition: " + num1 + " + " + num2 + " = " + sum);
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + subs);
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + multi);
        System.out.println("Division: " + num1 + " / " + num2 + " = " + divide);
    }
}
