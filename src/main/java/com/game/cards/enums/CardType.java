package com.game.cards.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.util.Strings;

import java.util.Map;
import java.util.Objects;

@RequiredArgsConstructor
@Getter
public enum CardType {
    ACE("AS"), JACK("Valet"), QUEEN("Dame"), KING("Roi"), REGULAR(Strings.EMPTY);
    private final String name;
    private static final Map<Integer, CardType> values = Map.of(1, ACE, 11, JACK, 12, QUEEN, 13, KING);
    public static String nameOfCard(int value){
        return  Objects.nonNull(values.get(value))? values.get(value).name : String.valueOf(value);
    }
}
