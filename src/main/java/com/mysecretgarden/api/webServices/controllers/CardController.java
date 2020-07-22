package com.mysecretgarden.api.webServices.controllers;

import com.mysecretgarden.api.webServices.entities.Card;
import com.mysecretgarden.api.webServices.services.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public List<Card> getCards(){
        return cardService.getAll();
    }

    @GetMapping(value = "/{id}")
    public Card getCardById(@PathVariable Long id){
        return cardService.getCardById(id);
    }

    @PostMapping
    public Card postCard(@RequestBody Card card){
        return cardService.saveCard(card);
    }

    @PutMapping(value = "/{id}")
    public Card putCard(@RequestBody Card card, @PathVariable Long id){
        return cardService.updateCard(card, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCard(@PathVariable Long id){
        cardService.deleteCard(id);
    }
}
