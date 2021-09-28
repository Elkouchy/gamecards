package com.game.cards.model;

import com.game.cards.enums.Color;
import lombok.Getter;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Game {
    @Getter
    private final String id = UUID.randomUUID().toString();
    private final Order order = new Order();

    public List<Color> colorOrder() {
        return order.getColorOrder();
    }

    public List<Integer> valuesOrder() {
        return order.getValuesOrder();
    }

    public List<Card> sortCards(Collection<Card> shuffledCards) {
        return shuffledCards.stream().sorted(comparator()).collect(Collectors.toList());
    }

    private Comparator<Card> comparator() {
        Comparator<Card> colorComparator = Comparator.comparingInt(card -> colorOrder().indexOf(card.getColor()));
        Comparator<Card> valuesComparator = Comparator.comparingInt(card -> valuesOrder().indexOf(card.getValue()));
        return colorComparator.thenComparing(valuesComparator);
    }

}
