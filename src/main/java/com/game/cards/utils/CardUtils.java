package com.game.cards.utils;

import com.game.cards.enums.Color;
import com.game.cards.model.Card;
import lombok.experimental.UtilityClass;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class CardUtils {

    public static List<Card> generateAllCards() {
        return IntStream.range(1, 14)
                .mapToObj(value -> List.of(
                        new Card(value, Color.CLUBS),
                        new Card(value, Color.HEARTS),
                        new Card(value, Color.DIAMONDS),
                        new Card(value, Color.SPADES)
                ))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    ;
}
