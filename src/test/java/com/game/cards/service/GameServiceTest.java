package com.game.cards.service;

import com.game.cards.model.Card;
import com.game.cards.model.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GameServiceTest {

    @Autowired
    private GameService gameService;

    @Test
    @DisplayName("Should serve a Hand with shuffled and sorted cards")
    void serveHandWithinGameTest() {

        var hand = gameService.serveHand();
        assertThat(hand).isNotNull();
        assertThat(hand.getShuffledCards()).hasSize(10);
        assertThat(hand.getSortedCards()).hasSize(10);
        assertThat(hand.getSortedCards()).containsAll(hand.getShuffledCards());
    }
}