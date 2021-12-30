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
    private final Player deck;

    public BlackJack(Player p1, Player p2, Player p3, Player c, Player d) {
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
        if(totalValue > 21 && aceCounter >= 1){
            totalValue -= 10;
        }
        return totalValue;
    }
    
    public static List<Card> croupierTakeCards(List<Card> croupierCards, List<Card> deckCards){
        
         while (calculatePoints(croupierCards) < 17){
             for (Card card : deckCards){
                 croupierCards.add(card);
            }
         }
         return croupierCards;
    }
    
    public List<Player> getWinners(){
        ArrayList<Player> winners = new ArrayList<>();
        List<Card> p1Cards = new ArrayList<>(player1.getCards());
        List<Card> p2Cards = new ArrayList<>(player2.getCards());
        List<Card> p3Cards = new ArrayList<>(player3.getCards());
        List<Card> croupierCards = new ArrayList<>(croupierTakeCards(croupier.getCards(), deck.getCards()));
        
        int p1Points = calculatePoints(p1Cards);
        int p2Points = calculatePoints(p2Cards);
        int p3Points = calculatePoints(p3Cards);
        int croupierPoints = calculatePoints(croupierCards);
      
        if(croupierPoints > 21){
            winners.add(player1);
            winners.add(player2);
            winners.add(player3);
            return winners;
        }
        
        if(isBlackJack(croupierCards)){
            winners.add(croupier);
            return winners;
        }
       
        if(croupierPoints > p1Points && croupierPoints > p2Points && croupierPoints > p3Points && croupierPoints < 21){
            winners.add(croupier);
            return winners;
        }
        
        if(isBlackJack(p1Cards)){
            winners.add(player1);
        }
        
        if(isBlackJack(p2Cards)){
            winners.add(player2);
        }
        
        if(isBlackJack(p3Cards)){
            winners.add(player3);
        }
        
        /*
        else if(isBlackJack(p1Cards) || (calculatePoints(player1.getCards()) > calculatePoints(croupierCards))){
            winners.add(player1);
        }
        
        if(winners.isEmpty()){
            winners.add(croupier);
        }
        */
        

        /*
        if(isBlackJack(player1.getCards())){
            winners.add(player1);
        }
        
        else if(calculatePoints(player1.getCards()) > calculatePoints(croupierTakeCards(croupier.getCards(), deck.getCards()))){
            winners.add(player1);
        }
        
        if(isBlackJack(player2.getCards())){
            winners.add(player2);
        }
        
        if(isBlackJack(player3.getCards())){
            winners.add(player3);
        }
        
        if(isBlackJack(croupierTakeCards(croupier.getCards(), deck.getCards()))){
            winners.add(croupier);
        }
        */
        return winners;
    }
    
}
