package com.yatish.training.dao;

import com.yatish.training.models.User;
import java.util.Optional;

public interface UserDAO {
    Optional<User> findByUsername(String username);
    Optional<User> addUser(User user);
    boolean userExists(String username);
    Optional<User> getUserById(int id);
}
