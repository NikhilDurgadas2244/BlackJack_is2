package blackjack.jugadores;

import blackjack.cartas.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {

    private final List<Card> bet = new ArrayList<Card>();

    
    public void addCard(Card card){
        bet.add(card);
        
    }

    public List<Card> getCards() {
        return bet;
    }
    
}
