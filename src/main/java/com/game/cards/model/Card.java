package com.game.cards.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.game.cards.enums.CardType;
import com.game.cards.enums.Color;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.logging.log4j.util.Strings;

import java.beans.Transient;
import java.util.Optional;


@Getter
@EqualsAndHashCode
public class Card {

    private  Color color;
    private  String value;

    public Card(final int value, final Color color) {
        this.value = CardType.nameOfCard(value);
        this.color = color;
    }

    @JsonIgnore
    public Optional<CardType> getCardType(){
        return Optional.of(CardType.valueOf(this.value));
    }

    public String valueName(){
        return getCardType()
                .map(CardType::getName)
                .filter(Strings::isNotBlank)
                .orElse(String.valueOf(this.value));
    }

    public String fullName(){
        return String.format("%s de %s", valueName(), color.getName());
    }

    @Override
    public String toString() {
        return fullName();
    }
}
