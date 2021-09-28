package com.game.cards.service;

import com.game.cards.model.Game;
import com.game.cards.model.Hand;
import com.game.cards.utils.CardUtils;
import com.game.cards.utils.Constants;
import org.springframework.stereotype.Service;
import java.util.Collections;
import java.util.stream.Collectors;


@Service
public class GameServiceImpl implements GameService{

    public Hand serveHand() {
        var game = new Game();
        return serveHandWithinGame(game);
    }

    private Hand serveHandWithinGame(final Game game) {
        var deck = CardUtils.generateAllCards();
        Collections.shuffle(deck);
        var shuffledCards = deck.stream().limit(Constants.HAND_SIZE).collect(Collectors.toList());
        return new Hand(shuffledCards, game.sortCards(shuffledCards));
    }

}
