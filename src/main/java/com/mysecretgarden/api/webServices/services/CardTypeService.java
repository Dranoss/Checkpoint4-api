package com.mysecretgarden.api.webServices.services;

import com.mysecretgarden.api.webServices.entities.CardType;
import com.mysecretgarden.api.webServices.repositories.CardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CardTypeService {

    @Autowired
    private CardTypeRepository cardTypeRepository;

    public List<CardType> getAll(){
        return cardTypeRepository.findAll();
    }

    public CardType getCardTypeById(Long id) {
        Optional<CardType> optionalCardType = cardTypeRepository.findById(id);
        if (optionalCardType.isPresent()) {
            return optionalCardType.get();
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }

    public CardType save(CardType cardType){
        return cardTypeRepository.save(cardType);
    }

    public CardType update(CardType cardType, Long id){
        if(id == cardType.getId()){
            CardType updatedCardType = cardTypeRepository.findById(id).get();
            cardType.setColor(cardType.getColor());
            cardType.setName(cardType.getName());
            return cardTypeRepository.save(updatedCardType);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    public void deleteCardType(Long id){
        cardTypeRepository.deleteById(id);
    }
}
