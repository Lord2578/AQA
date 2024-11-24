package task2;

public class Task2 {

    // Метод для додавання
    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    // Метод для віднімання
    public int subs(int num1, int num2) {
        return num1 - num2;
    }

    // Метод для множення
    public int multi(int num1, int num2) {
        return num1 * num2;
    }

    // Метод для ділення
    public int divide(int num1, int num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Division by zero is not allowed!");
        }
        return num1 / num2;
    }

    public static void main(String[] args) {
        // Створюємо об'єкт Task2
        Task2 task = new Task2();

        int num1 = 10;
        int num2 = 5;

        // Викликаємо методи та виводимо результат
        System.out.println("Addition: " + num1 + " + " + num2 + " = " + task.sum(num1, num2));
        System.out.println("Subtraction: " + num1 + " - " + num2 + " = " + task.subs(num1, num2));
        System.out.println("Multiplication: " + num1 + " * " + num2 + " = " + task.multi(num1, num2));
        System.out.println("Division: " + num1 + " / " + num2 + " = " + task.divide(num1, num2));
    }
}
