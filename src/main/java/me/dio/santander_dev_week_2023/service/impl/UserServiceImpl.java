package me.dio.santander_dev_week_2023.service.impl;

import me.dio.santander_dev_week_2023.model.User;
import me.dio.santander_dev_week_2023.model.repository.UserRepository;
import me.dio.santander_dev_week_2023.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
       return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsById(userToCreate.getId()) && userToCreate.getId() != null){
            throw new IllegalArgumentException("This user Id already exists;");
        }
        return userRepository.save(userToCreate);
    }
}
