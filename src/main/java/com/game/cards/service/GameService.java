package com.game.cards.service;

import com.game.cards.model.Hand;

public interface GameService {

    /**
     * return shuffled cards and sorted cards
     *
     * @return Hand
     */
    Hand serveHand();
}
