package com.yatish.training.repository;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.yatish.training.models.EmployeeEntity;

public class EmployeeRepository implements Serializable {

    private Map<Integer, EmployeeEntity> map = new HashMap<>();

    public Map<Integer, EmployeeEntity> getMap() {
        return map;
    }

    public void setMap(Map<Integer, EmployeeEntity> map) {
        this.map = map;
    }

    public void save(EmployeeEntity e) {
        map.put(e.getId(), e);
    }

    public EmployeeEntity findById(int id) {
        return map.get(id);
    }

    public Collection<EmployeeEntity> findAll() {
        return map.values();
    }

    public void delete(int id) {
        map.remove(id);
    }
}
