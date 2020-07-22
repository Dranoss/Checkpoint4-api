package com.mysecretgarden.api.webServices.repositories;

import com.mysecretgarden.api.webServices.entities.CardType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Long> {
}
