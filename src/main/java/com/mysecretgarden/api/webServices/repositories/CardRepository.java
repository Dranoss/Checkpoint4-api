package com.mysecretgarden.api.webServices.repositories;

import com.mysecretgarden.api.webServices.entities.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
