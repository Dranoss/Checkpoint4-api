package com.mysecretgarden.api.webServices.controllers;

import com.mysecretgarden.api.webServices.entities.CardType;
import com.mysecretgarden.api.webServices.services.CardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/card-types")
public class CardTypeController {

    @Autowired
    private CardTypeService cardTypeService;

    @GetMapping
    public List<CardType> getCards(){
        return cardTypeService.getAll();
    }

    @GetMapping(value = "/{id}")
    public CardType getCardById(@PathVariable Long id){
        return cardTypeService.getCardTypeById(id);
    }

    @PostMapping
    public CardType postCard(@RequestBody CardType cardType){
        return cardTypeService.save(cardType);
    }

    @PutMapping(value = "/{id}")
    public CardType putCard(@RequestBody CardType cardType, @PathVariable Long id){
        return cardTypeService.update(cardType, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCard(@PathVariable Long id){
        cardTypeService.deleteCardType(id);
    }
}
