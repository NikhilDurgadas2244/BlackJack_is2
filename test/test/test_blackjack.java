package test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import blackjack.cartas.*;
import blackjack.jugadores.*;
import blackjack.blackjack.*;




public class test_blackjack {
    
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    Player croupier = new Player();
    Player deck = new Player();
    
    @Test
    public void prueba_caso_1(){
    
        player1.addCard(new Jack());
        player1.addCard(new Ace());
        
        System.out.println(BlackJack.calculatePoints(player1.getCards()));
        //System.out.print(assert(BlackJack.calculatePoints(player1.getCards())));
        
        player2.addCard(new PipCard(10));
        player2.addCard(new PipCard(5));
        player2.addCard(new PipCard(6));
        System.out.println(BlackJack.calculatePoints(player2.getCards()));
        
        
        player3.addCard(new PipCard(3));
        player3.addCard(new PipCard(6));
        player3.addCard(new Ace());
        player3.addCard(new PipCard(3));
        player3.addCard(new Ace());
        player3.addCard(new King());
        System.out.println(BlackJack.calculatePoints(player3.getCards()));
        
        
        croupier.addCard(new PipCard(5));
        croupier.addCard(new PipCard(10));
        
        deck.addCard(new Ace());
        deck.addCard(new PipCard(3));
        deck.addCard(new King());
        deck.addCard(new PipCard(2));
        
        BlackJack blackjack = new BlackJack(player1,player2,player3,croupier,deck);
        List<Player> winners = blackjack.getWinners(player1,player2,player3,croupier,deck);
        for(Player p : winners){
            System.out.println(p.getCards());
        }
        List<Player> test = new ArrayList<>();
        test.add(player1);
        assert(winners.equals(test));
    }
    
    
    @Test
    public void prueba_caso_2(){
        player1.addCard(new PipCard(10));
        player1.addCard(new King());
        
        player2.addCard(new PipCard(10));
        player2.addCard(new PipCard(2));
        player2.addCard(new PipCard(6));
        
        player3.addCard(new PipCard(8));
        player3.addCard(new PipCard(8));
        player3.addCard(new PipCard(5));
        
        croupier.addCard(new PipCard(5));
        croupier.addCard(new PipCard(10));
        
        deck.addCard(new Ace());
        deck.addCard(new PipCard(3));
        deck.addCard(new King());
        deck.addCard(new PipCard(2));
        
         BlackJack blackjack = new BlackJack(player1,player2,player3,croupier, deck);
        List<Player> winners = blackjack.getWinners(player1,player2,player3,croupier,deck);
        List<Player> test = new ArrayList<>();
        test.add(player1);
        test.add(player3);
        assert(winners.equals(test));
        
        
        
    
    }
    
    
    
    
    
}
