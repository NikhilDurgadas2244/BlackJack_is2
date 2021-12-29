package blackjack.blackjack;

import blackjack.cartas.Ace;
import blackjack.cartas.Card;
import blackjack.jugadores.Player;
import java.util.ArrayList;
import java.util.List;
public class BlackJack {
    
    private final Player player1;
    private final Player player2;
    private final Player player3;
    private final Player croupier;

    public BlackJack(Player p1, Player p2, Player p3, Player c) {
        this.player1 = p1;
        this.player2 = p2;
        this.player3 = p3;
        this.croupier = c;
    }
    
    public static boolean isBlackJack(List<Card> bet){
        return calculatePoints(bet) == 21 && bet.size() == 2;
        
    }
    
    public static int calculatePoints(List<Card> bet){
        int totalValue = 0;
        int aceCounter = 0;
        for (Card card : bet){
            if(card instanceof Ace){
                aceCounter++;
            }
            totalValue += card.getValor();
        }
        if(totalValue > 21 && aceCounter >= 1){
            totalValue -= 10;
        }
        return totalValue;
    }
    
    public List<Player> getWinners(){
        
        ArrayList<Player> winners = new ArrayList<>();
        
        if(isBlackJack(player1.getCards())){
        
            winners.add(player1);
        }
        
        if(isBlackJack(player2.getCards())){
        
            winners.add(player2);
        }
        
        if(isBlackJack(player3.getCards())){
        
            winners.add(player3);
        }
        
        return winners;
    }
    
}
