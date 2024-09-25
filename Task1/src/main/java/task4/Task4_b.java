package task4;

import java.lang.reflect.Method;

public class Task4_b {
    public void showMethods() {
        try {
            CustomClass obj = new CustomClass();
            Method[] methods = obj.getClass().getDeclaredMethods();
            for (Method method : methods) {
                System.out.println("Метод: " + method.getName());
            }

            Method greetMethod = obj.getClass().getDeclaredMethod("greet");
            greetMethod.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class CustomClass {
        public void greet() {
            System.out.println("Привіт, Світ!");
        }
    }

    public static void main(String[] args) {
        Task4_b task4_b = new Task4_b();
        task4_b.showMethods();
    }
}
