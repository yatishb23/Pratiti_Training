package com.yatish.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.yatish.collection.Certificate;
import com.yatish.collection.Employee;
import com.yatish.model.EmployeeDTO;

public class HibernateUtil {
    private static SessionFactory factory;
    static{
        Configuration configuration=new Configuration();
        configuration.configure();

        configuration.addAnnotatedClass(EmployeeDTO.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Certificate.class);
        factory=configuration.buildSessionFactory();
    }
    public static SessionFactory getFactory(){
        return factory;
    }

}