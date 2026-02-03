package com.yatish.training.dao;

import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.yatish.training.models.EmployeeEntity;
import com.yatish.training.models.CurrentUser;
import com.yatish.training.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

    private final static SessionFactory sessionFactory = HibernateUtil.getFactory();

    @Override
    public Optional<EmployeeEntity> addEmployee(EmployeeEntity emp) {
        try (Session session = sessionFactory.openSession()) {
            // Set the creator information
            emp.setCreatedByUserId(CurrentUser.getInstance().getCurrentUserId());
            emp.setCreatedByUsername(CurrentUser.getInstance().getCurrentUsername());

            Transaction ts = session.beginTransaction();
            session.save(emp);
            ts.commit();
            session.close();
            return Optional.of(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void deleteEmployeeById(int id) {
        Transaction ts = null;

        try (Session session = sessionFactory.openSession()) {
            ts = session.beginTransaction();
            EmployeeEntity emp = session.get(EmployeeEntity.class, id);

            if (emp == null) {
                System.out.println("Employee not found");
                return;
            }

            if (!canChange(emp)) {
                System.out.println("Permission Denied! You can only delete employees you created.");
                return;
            }

            
            session.delete(emp);
            ts.commit();

            System.out.println("Employee with id " + id + " deleted successfully.");

        } catch (Exception e) {
            if (ts != null) {
                ts.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public boolean updateEmployee(EmployeeEntity emp) {
        Scanner sc = new Scanner(System.in);
        try (Session session = sessionFactory.openSession()) {
            Transaction ts = session.beginTransaction();
            if (CurrentUser.getInstance().isAdmin()) {
                return true;
            }
            if (!canChange(emp)) {
                System.out.println("Permission Denied! You can only update employees you created.");
                ts.rollback();
                session.close();
                return false;
            }

            System.out.println("Before: " + emp);
            System.out.print("Enter new Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            emp.setName(name);
            System.out.print("Enter new City: ");
            String city = sc.nextLine();
            emp.setCity(city);
            System.out.print("Enter new State: ");
            String state = sc.nextLine();
            emp.setState(state);
            session.update(emp);
            ts.commit();
            session.close();
            System.out.println("After: " + emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean canChange(EmployeeEntity emp) {
        if (CurrentUser.getInstance().isAdmin()) {
            return true;
        }
        return emp.getCreatedByUserId()
                == CurrentUser.getInstance().getCurrentUserId();
    }

    @Override
    public Optional<List<EmployeeEntity>> getAllEmployees() {
        try (Session session = sessionFactory.openSession()) {
            List<EmployeeEntity> employees = session.createQuery("from EmployeeEntity", EmployeeEntity.class).list();
            return Optional.of(employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<EmployeeEntity> getEmployeeById(int id) {
        try (Session session = sessionFactory.openSession()) {
            EmployeeEntity emp = session.get(EmployeeEntity.class, id);
            return Optional.ofNullable(emp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<EmployeeEntity>> getEmployeeByState(String state) {
        try (Session session = sessionFactory.openSession()) {
            List<EmployeeEntity> employees = session.createQuery("from EmployeeEntity where state = :state", EmployeeEntity.class)
                    .setParameter("state", state)
                    .list();
            return Optional.of(employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public Optional<List<EmployeeEntity>> getEmployeeByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            List<EmployeeEntity> employees = session.createQuery("from EmployeeEntity where name = :name", EmployeeEntity.class)
                    .setParameter("name", name)
                    .list();
            return Optional.of(employees);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public void updateEmployeeById() {
        try (Scanner sc = new Scanner(System.in);
             Session session = sessionFactory.openSession()) {

            System.out.print("Enter Employee ID to update: ");
            int id = sc.nextInt();
            sc.nextLine(); 

            EmployeeEntity emp = session.get(EmployeeEntity.class, id);
            if (emp == null) {
                System.out.println("Employee not found");
                return;
            }

            System.out.println("Before: " + emp);
            System.out.print("Enter new Name: ");
            String name = sc.nextLine();
            emp.setName(name);
            System.out.print("Enter new City: ");
            String city = sc.nextLine();
            emp.setCity(city);
            System.out.print("Enter new State: ");
            String state = sc.nextLine();
            emp.setState(state);

            Transaction ts = session.beginTransaction();
            session.update(emp);
            ts.commit();
            session.close();
            System.out.println("After: " + emp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean canUpdateEmployee(EmployeeEntity emp) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
