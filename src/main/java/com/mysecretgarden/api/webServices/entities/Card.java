package com.mysecretgarden.api.webServices.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "guardianCard")
    @JoinColumn(name = "guardian_id")
    private Guardian guardian;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonBackReference(value = "cardByType")
    @JoinColumn(name = "cardType_id")
    private CardType cardType;

    public Card() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
