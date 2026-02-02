package com.yatish.dao;

import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yatish.entity.EmployeeEntity;
import com.yatish.util.HibernateUtil;



public class EmployeeDAOImpl implements EmployeeDAO {
    private SessionFactory factory;

    {
        factory=HibernateUtil.getFactory();
    }

    @Override
    public Optional<EmployeeEntity> addEmployee(EmployeeEntity ee){
        Transaction ts=null;
        try(Session session=factory.openSession()) {
            ts=session.beginTransaction();
            session.save(ee);
            ts.commit();
            return Optional.of(ee);
        } catch (Exception e) {
            ts.rollback();
        }
        return Optional.empty();
    }
    @Override
    public Optional<EmployeeEntity> getEmployeeById(Integer empId){
        try (Session session=factory.openSession()){
            EmployeeEntity et=session.get(EmployeeEntity.class,empId);
            return Optional.of(et);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
