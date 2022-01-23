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
    private static List<Card> deck;

    public BlackJack(Player p1, Player p2, Player p3, Player c, List<Card> d) {
        this.player1 = p1;
        this.player2 = p2;
        this.player3 = p3;
        this.croupier = c;
        this.deck = d;
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
        while(totalValue > 21 && aceCounter > 0){
            totalValue -= 10;
            aceCounter--;
        }
        return totalValue;
    }
    
    public static void croupierTakeCards(Player croupier){
        List<Card> deckCards = new ArrayList<>(deck);
        int i = 0;
         while (calculatePoints(croupier.getCards()) < 17){
            croupier.addCard(deckCards.get(i));
            i++;
         }
    }
    
    public List<Player> getWinners(Player player1, Player player2, Player player3, Player croupier, List<Card> deck){
        ArrayList<Player> winners = new ArrayList<>();
        
        if(player1.isWinner(croupier)){winners.add(player1);}
        
        if(player2.isWinner(croupier)){winners.add(player2);}
        
        if(player3.isWinner(croupier)){winners.add(player3);}
        
        
        return winners;
    }
    
}
