//General:
//Install MySQL server (or any SQL like db)
//Make at least two tables (Entities from the previous task or any additional if needed)
//Make models for those Entities (from Task_5)
//Setup Hibernate for those Entities and local DB
//Check basic CRUD (create, read, update, and delete the BD records using Hibernate)
//Generate a few rows into all tables

package task6;

import org.hibernate.Session;

public class Task6 {
    public static void main(String[] args) {
        Session session = HybernateManager.getSessionFactory().openSession();
        session.beginTransaction();  // Початок транзакції для створення

        // Create
        Person person = new Person();
        person.setAge(42);
        person.setName("Harry");
        Long id = (Long) session.save(person);

        session.getTransaction().commit();  // Завершення транзакції після створення

        // Read
        session.beginTransaction();  // Початок транзакції для читання
        Person readPerson = session.get(Person.class, id);
        System.out.println("Read Person: " + readPerson);
        session.getTransaction().commit();  // Завершення транзакції після читання

        // Update
        session.beginTransaction();  // Початок транзакції для оновлення
        person.setAge(12);
        session.update(person);
        session.getTransaction().commit();  // Завершення транзакції після оновлення

        // Delete
        session.beginTransaction();  // Початок транзакції для видалення
        session.delete(readPerson);
        session.getTransaction().commit();  // Завершення транзакції після видалення

        // Перевірка чи об'єкт було видалено
        readPerson = session.get(Person.class, id);
        System.out.println("Read after delete: " + readPerson);  // Це повинно бути null, якщо видалено

        HybernateManager.shutdown();
    }
}

