package com.yatish.dao;

import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.*;
import com.yatish.entity.EmployeeEntity;
import com.yatish.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {
    private SessionFactory sessionFactory = HibernateUtil.getFactory();

    @Override
    public Optional<EmployeeEntity> addEmployee(EmployeeEntity e) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(e);
            transaction.commit();
            return Optional.of(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(int id) {
        try (Session session = sessionFactory.openSession()) {
            // EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
            EmployeeEntity employeeEntity = session.find(EmployeeEntity.class, id);
            session.close();
            return Optional.of(employeeEntity);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<EmployeeEntity>> getAllEmployees() {
        try (Session session = sessionFactory.openSession()) {

            List<EmployeeEntity> list = session.createQuery("from EmployeeEntity", EmployeeEntity.class)
                    .list();

            return Optional.of(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<EmployeeEntity>> getByCity(String city){
        try(Session session = sessionFactory.openSession()){
            String hql = "from EmployeeEntity where city = :cityName";
            Query<EmployeeEntity> query = session.createQuery(hql, EmployeeEntity.class);
            query.setParameter("cityName", city);
            List<EmployeeEntity> list = query.list();
            return Optional.of(list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Optional.empty();
    } 

    @Override
    public void deleteEmployeeById(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            EmployeeEntity employeeEntity = session.get(EmployeeEntity.class, id);
            if (employeeEntity != null) {
                session.remove(employeeEntity);
            }
            transaction.commit();
            System.out.println("Employee deleted successfully with id: " + id);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
