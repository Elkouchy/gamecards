package com.game.cards.Controller;

import com.game.cards.model.Hand;
import com.game.cards.service.GameService;
import com.game.cards.utils.Routes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class GameRestController {
    private final GameService gameService;

    /**
     * to expose shuffledCards and sortedCards
     *
     * @return Hand
     */
    @GetMapping(value = Routes.SERVE_HAND)
    public Hand serveHand() {
        return gameService.serveHand();
    }


}
