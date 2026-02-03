package com.yatish.training.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.yatish.training.models.EmployeeEntity;

public class HibernateUtil {
    private static SessionFactory factory;
    static{
        Configuration configuration=new Configuration();
        configuration.configure();

        configuration.addAnnotatedClass(EmployeeEntity.class);
        factory=configuration.buildSessionFactory();
    }
    public static SessionFactory getFactory(){
        return factory;
    }

}