package com.yatish.ems.repository;

import com.yatish.ems.models.Employee;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeRepository implements Serializable {

    private Map<Integer, Employee> map = new HashMap<>();

    public Map<Integer, Employee> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Employee> map) {
        this.map = map;
    }

    public void save(Employee e) {
        map.put(e.getId(), e);
    }

    public Employee findById(int id) {
        return map.get(id);
    }

    public Collection<Employee> findAll() {
        return map.values();
    }

    public void delete(int id) {
        map.remove(id);
    }
}
