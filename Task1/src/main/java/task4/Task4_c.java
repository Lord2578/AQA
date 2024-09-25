package task4;

public class Task4_c {

    interface Printable<T> {
        void print(T value);
    }

    public static class StringPrinter implements Printable<String> {
        public void print(String value) {
            System.out.println("Надруковано: " + value);
        }
    }

    public static void main(String[] args) {
        Printable<String> printer = new StringPrinter();
        printer.print("Привіт!");
    }
}
