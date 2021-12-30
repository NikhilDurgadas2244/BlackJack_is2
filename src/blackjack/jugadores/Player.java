package blackjack.jugadores;

import blackjack.cartas.Card;
import java.util.ArrayList;
import java.util.List;
import blackjack.blackjack.*;

public class Player {

    private final List<Card> bet = new ArrayList<Card>();

    
    public void addCard(Card card){
        bet.add(card);
    }

    public List<Card> getCards() {
        return bet;
    }
    
    public boolean isWinner(Player croupier){
        System.out.println(BlackJack.calculatePoints(croupier.getCards()));
        BlackJack.croupierTakeCards(croupier);
        int sumBetCroupier = BlackJack.calculatePoints(croupier.getCards());
        int sumBetPlayer = BlackJack.calculatePoints(this.bet);
        System.out.println(sumBetPlayer + " " + sumBetCroupier);
        //System.out.println(BlackJack.calculatePoints(croupier.getCards()));
        if(sumBetPlayer > 21) {return false;}
        
        if(BlackJack.isBlackJack(croupier.getCards())){return false;}
        
        if(sumBetCroupier > 21) {return true;}
        
        if(BlackJack.isBlackJack(this.bet)){return true;}
        
        
        return sumBetPlayer > sumBetCroupier;
    }
    
}
