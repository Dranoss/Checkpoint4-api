package com.mysecretgarden.api.webServices.repositories;

import com.mysecretgarden.api.webServices.entities.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Guardian, Long> {
    Guardian findByUsername(String username);
}
