package com.example.cruddemo.service;



import com.example.cruddemo.model.User;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private final Map<Long, User> userMap = new HashMap<>();
    private long idCounter = 1;

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User getUserById(Long id) {
        return userMap.get(id);
    }

    public User createUser(User user) {
        user.setId(idCounter++);
        userMap.put(user.getId(), user);
        return user;
    }

    public User updateUser(Long id, User updatedUser) {
        if (!userMap.containsKey(id)) return null;
        updatedUser.setId(id);
        userMap.put(id, updatedUser);
        return updatedUser;
    }

    public boolean deleteUser(Long id) {
        return userMap.remove(id) != null;
    }
}
