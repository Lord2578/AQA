package task7;

import org.hibernate.Session;
import task6.Person;
import task6.Address;
import task6.HybernateManager;


public class Task7 {
    public static void main(String[] args) {
        Session session = HybernateManager.getSessionFactory().openSession();
        session.beginTransaction();

        // Create new Address
        Address address = new Address();
        address.setCity("Los Angeles");
        address.setState("CA");
        session.save(address);

        // Create new Passport and Person
        Passport passport = new Passport();
        passport.setPassportNumber("A1234567");
        session.save(passport);

        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);
        person.setPassport(passport);
        person.setAddress(address);
        session.save(person);

        // Create Residents for OneToMany relationship
        Resident resident1 = new Resident();
        resident1.setName("Resident 1");
        resident1.setAddress(address);
        session.save(resident1);

        Resident resident2 = new Resident();
        resident2.setName("Resident 2");
        resident2.setAddress(address);
        session.save(resident2);

        // Create Project for ManyToMany relationship
        Project project = new Project();
        project.setProjectName("Project A");
        session.save(project);

        person.getProjects().add(project);
        session.save(person);

        session.getTransaction().commit();

        // Read: Retrieve person from database
        Person readPerson = session.get(Person.class, person.getId());
        System.out.println("Read Person: " + readPerson);

        // Update: Modify the person's name and save changes
        session.beginTransaction();
        readPerson.setName("John Smith");
        session.update(readPerson);
        session.getTransaction().commit();
        System.out.println("Updated Person: " + readPerson);

        // Delete: Delete a resident
        session.beginTransaction();
        session.delete(resident1);
        session.getTransaction().commit();
        System.out.println("Resident 1 deleted");

        session.close();
        HybernateManager.shutdown();
    }
}
