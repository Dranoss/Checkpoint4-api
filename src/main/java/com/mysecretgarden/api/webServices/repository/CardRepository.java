package com.mysecretgarden.api.webServices.repository;

import com.mysecretgarden.api.webServices.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
