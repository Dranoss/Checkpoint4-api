package com.mysecretgarden.api.webServices.services;

import com.mysecretgarden.api.webServices.entities.Card;
import com.mysecretgarden.api.webServices.repositories.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    @Autowired
    private CardRepository cardRepository;

    public List<Card> getAll(){
        return cardRepository.findAll();
    }

    public Card getCardById(Long id) {
        Optional<Card> optionalCard = cardRepository.findById(id);
        if (optionalCard.isPresent()) {
            return optionalCard.get();
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }

    public Card saveCard(Card card){
        return cardRepository.save(card);
    }

    public Card updateCard(Card card, Long id){
        if(id == card.getId()){
            Card cardUpdated = cardRepository.findById(id).get();
            cardUpdated.setName(card.getName());
            cardUpdated.setContent(card.getContent());
            //cardUpdated.setCardType(card.getCardType());
            return cardRepository.save(cardUpdated);
        }
        throw new ResponseStatusException(
                HttpStatus.PRECONDITION_FAILED);
    }

    public void deleteCard(Long id){
        cardRepository.deleteById(id);
    }
}
