package task4;

import java.util.concurrent.Semaphore;

public class Task4_a {
    private Semaphore semaphore;

    public Task4_a(int permits) {
        this.semaphore = new Semaphore(permits);
    }



    public void access(String threadName) {
        try {
            semaphore.acquire();
            System.out.println(threadName + " отримав доступ.");
            Thread.sleep(500);
            System.out.println(threadName + " завершив роботу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        Task4_a task4_a = new Task4_a(2);

        for (int i = 1; i <= 3; i++) {
            final String threadName = "Потік " + i;
            new Thread(() -> task4_a.access(threadName)).start();
        }
    }
}
