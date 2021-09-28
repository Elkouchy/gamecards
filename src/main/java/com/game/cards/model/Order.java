package com.game.cards.model;

import com.game.cards.enums.Color;
import com.game.cards.utils.Constants;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Order {
    private static final Random RANDOM = new Random();
    private final List<Color> colorOrder = getshuffledColors();

     List<Color> getshuffledColors() {
        var colors = Arrays.asList(Color.values());
        Collections.shuffle(colors);
        return colors;
    }

    private final List<Integer> valuesOrder = getRandomValuesWithRepetition();

    private static List<Integer> getRandomValuesWithRepetition() {
        return IntStream.range(0, Constants.HAND_SIZE)
                .map(i -> RANDOM.nextInt(Constants.MAX_VALUE)) // RANDOM.nextInt(Constants.MAX_VALUE) + Constants.MIN_VALUE
                .boxed()
                .collect(Collectors.toList());
    }
}
