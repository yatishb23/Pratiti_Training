package com.yatish.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.yatish.entity.EmployeeEntity;


public class HIbernateUtil1 {
  public static void main(String[] args) {
	  
     Configuration configuration=new org.hibernate.cfg.Configuration();
     configuration.addAnnotatedClass(EmployeeEntity.class);
     configuration.configure();
     SessionFactory factory=configuration.buildSessionFactory();
     
      try (Session session = factory.openSession()) {
          Transaction tx =session.beginTransaction();
          session.save(new EmployeeEntity("nikhil"));
          session.save(new EmployeeEntity("yatish"));
          tx.commit();
      }
     
  }
}
