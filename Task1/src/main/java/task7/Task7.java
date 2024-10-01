package task7;

import org.hibernate.Session;
import task6.Person;
import task6.Address;
import task6.HybernateManager;

public class Task7 {
    public static void main(String[] args) {
        Session session = HybernateManager.getSessionFactory().openSession();

        session.beginTransaction();

        Address address = new Address();
        address.setCity("Los Angeles");
        address.setState("CA");
        session.save(address);

        // Person with OneToOne Passport
        Person person = new Person();
        person.setName("John Doe");
        person.setAge(30);

        Passport passport = new Passport();
        passport.setPassportNumber("A1234567");
        session.save(passport);

        person.setPassport(passport);
        person.setAddress(address);
        session.save(person);

        // Residents for OneToMany with Address
        Resident resident1 = new Resident();
        resident1.setName("Resident 1");
        resident1.setAddress(address);
        session.save(resident1);

        Resident resident2 = new Resident();
        resident2.setName("Resident 2");
        resident2.setAddress(address);
        session.save(resident2);

        // Project for ManyToMany
        Project project = new Project();
        project.setProjectName("Project A");
        session.save(project);

        person.getProjects().add(project);
        session.save(person);

        session.getTransaction().commit();

        Person readPerson = session.get(Person.class, person.getId());
        System.out.println(readPerson);

        session.close();
        HybernateManager.shutdown();
    }
}
