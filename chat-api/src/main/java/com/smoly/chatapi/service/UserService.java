package com.smoly.chatapi.service;

import com.smoly.chatapi.entity.User;
import com.smoly.chatapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public boolean existsById(long id) {
        return userRepository.existsById(id);
    }

    public User saveWithExistsCheck(User user) {
        if (!existsById(user.getId())) {
            return userRepository.save(user);
        }
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
