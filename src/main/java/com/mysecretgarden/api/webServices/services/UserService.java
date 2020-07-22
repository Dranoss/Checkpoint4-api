package com.mysecretgarden.api.webServices.services;

import com.mysecretgarden.api.webServices.entities.User;
import com.mysecretgarden.api.webServices.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    public User saveUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(User user, Long id){
        if(id == user.getId()) {
            User updatedUser = userRepository.findById(id).get();
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setRole(user.getRole());
            updatedUser.setUsername(user.getUsername());
            updatedUser.setProfilePicture(user.getProfilePicture());
            return userRepository.save(updatedUser);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
