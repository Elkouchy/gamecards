package com.game.cards.Controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.game.cards.enums.Color;
import com.game.cards.model.Card;
import com.game.cards.model.Hand;
import com.game.cards.service.GameService;
import com.game.cards.utils.Routes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.context.ApplicationContext;
import org.springframework.test.web.servlet.MockMvc;

@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GameRestControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

   /* private WebTestClient webTestClient;
    @Autowired
    private ApplicationContext applicationContext;
    */

    @MockBean
    private GameService gameService;

    /*@Test
    void shouldGetHand() {
        Hand expectedHand =new Hand();
        expectedHand.setShuffledCards(List.of(new Card(2, Color.CLUBS),new Card(5, Color.DIAMONDS),new Card(5, Color.HEARTS)));
        expectedHand.setSortedCards(List.of(new Card(2, Color.CLUBS),new Card(5, Color.HEARTS),new Card(5, Color.DIAMONDS)));
        given(gameService.serveHand()).willReturn(expectedHand);
        final Hand resultat = webTestClient.get()
                .uri(Routes.SERVE_HAND)
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody(Hand.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertNotNull(resultat);
        Assertions.assertEquals(resultat.getShuffledCards().size(), resultat.getSortedCards().size());
        //verify(gameService, times(1)).serveHand();
        //verifyNoMoreInteractions(gameService);
    }

     */

    @Test
    void shouldGetHand() throws Exception {
        mockMvc.perform(get(Routes.SERVE_HAND)).andExpect(status().isOk())
                .andExpect(content -> {
                    var hand = objectMapper.readValue(content.getResponse().getContentAsString(), Hand.class);
                    assertThat(hand).isNotNull();
                    assertThat(hand.getSortedCards()).isNotEmpty();
                    assertThat(hand.getShuffledCards()).isNotEmpty();
                });
    }
}
