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
        // Create
        Person person = new Person();
        person.setAge(42);
        person.setName("Harry");
        Long id = (Long) session.save(person);

        // Read
        Person readPerson = session.get(Person.class, id);
        System.out.println(readPerson);

        // Update
        session.beginTransaction();
        person.setAge(12);
        session.update(person);
        session.getTransaction().commit();

        // Delete
        session.delete(readPerson);
        readPerson = session.get(Person.class, id);
        System.out.println(readPerson);

        HybernateManager.shutdown();

    }
}
