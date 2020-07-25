package com.example.resttest;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private boolean isUserExists(User user) {
        return userRepository.findByEmail(user.getEmail()).isPresent();
    }

    public User createUser(User user) {

        if (isUserExists(user)) throw new RuntimeException("Record already exists");

        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

    }

    public User getUserById(long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(long id, User user) {
        User userDb = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userDb.setFirstName(user.getFirstName());
        userDb.setLastName(user.getLastName());
        return userRepository.save(userDb);

    }

    public void deleteUser(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userRepository.delete(user);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }
}
