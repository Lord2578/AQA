package task6;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import task7.Passport;
import task7.Project;
import task7.Resident;

public class HybernateManager {

    private static SessionFactory sessionFactory;

    static {
        try {
            // Створюємо конфігурацію та додаємо всі сутності, які використовуються
            Configuration configuration = new Configuration().configure();

            // Додаємо сутності з пакету task6
            configuration.addAnnotatedClass(Person.class);
            configuration.addAnnotatedClass(Address.class);

            // Додаємо сутності з пакету task7
            configuration.addAnnotatedClass(Passport.class);
            configuration.addAnnotatedClass(Project.class);
            configuration.addAnnotatedClass(Resident.class);

            // Будуємо сесійну фабрику
            sessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }
}
