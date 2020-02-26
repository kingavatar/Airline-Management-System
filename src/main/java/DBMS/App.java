package DBMS;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student std = new Student();
        std.setId(104);
        std.setName("abc");

        Configuration c = new Configuration().configure().addAnnotatedClass(Student.class);
        ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(c.getProperties()).build();
        SessionFactory sf = c.buildSessionFactory(sr);

        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();
        s.save(std);
        tx.commit();
    }
}
