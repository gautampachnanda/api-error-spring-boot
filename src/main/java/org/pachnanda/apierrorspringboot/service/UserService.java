package org.pachnanda.apierrorspringboot.service;

import org.pachnanda.apierrorspringboot.entities.User;
import org.pachnanda.apierrorspringboot.model.EntityNotFoundException;
import org.pachnanda.apierrorspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUserNoException(Long userId) {
        return userRepository.findById(userId);
    }

    public User getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (!user.isPresent()) {
            throw new EntityNotFoundException(User.class, "id", userId.toString());
        }
        return user.get();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUserCollection(UserCollection userCollection) {
        List<User> users = new ArrayList<>();

        for (Long userId : userCollection.getUsersIds()) {
            Optional<User> user = userRepository.findById(userId);
            if (!user.isPresent()) {
                throw new EntityNotFoundException(User.class, "id", userId.toString());
            }
            users.add(user.get());
        }
        return users;
    }
}
