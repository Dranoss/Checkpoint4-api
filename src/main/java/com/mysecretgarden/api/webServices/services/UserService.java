package com.mysecretgarden.api.webServices.services;

import com.mysecretgarden.api.webServices.entities.Guardian;
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

    public List<Guardian> getAll(){
        return userRepository.findAll();
    }

    public Guardian findUserById(Long id){
        Optional<Guardian> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    public Guardian saveUser(Guardian guardian){
        guardian.setPassword(bCryptPasswordEncoder.encode(guardian.getPassword()));
        return userRepository.save(guardian);
    }

    public Guardian updateUser(Guardian guardian, Long id){
        if(id == guardian.getId()) {
            Guardian updatedGuardian = userRepository.findById(id).get();
            updatedGuardian.setFirstName(guardian.getFirstName());
            updatedGuardian.setLastName(guardian.getLastName());
            updatedGuardian.setRole(guardian.getRole());
            updatedGuardian.setUsername(guardian.getUsername());
            updatedGuardian.setProfilePicture(guardian.getProfilePicture());
            return userRepository.save(updatedGuardian);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
