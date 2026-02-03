package com.yatish.collection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yatish.util.HibernateUtil;

public class SetDemo {
    public static void main(String[] args) {

        SessionFactory sessionFactory = HibernateUtil.getFactory();
        Session session = sessionFactory.openSession();
        Transaction ts = session.beginTransaction();

        Employee emp = new Employee();
        emp.setId(1);
        emp.setName("Yatish");
        emp.setSalary(50000);

        emp.getCertificates().add(new Certificate(101, "Java", emp));
        emp.getCertificates().add(new Certificate(102, "Hibernate", emp));
        emp.getCertificates().add(new Certificate(103, "Spring", emp));

        session.persist(emp);
        ts.commit();
        session.close();
    }
}
