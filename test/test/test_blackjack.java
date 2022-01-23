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
    List<Card> deck = new ArrayList<>();
    
    @Test
    public void prueba_caso_blackjack(){
        player1.addCard(new Jack());
        player1.addCard(new Ace());
        
        assert(BlackJack.isBlackJack(player1.getCards()));
    }
    @Test
    public void prueba_caso_1(){
    
        player1.addCard(new Jack());
        player1.addCard(new Ace());
        
        
        player2.addCard(new PipCard(10));
        player2.addCard(new PipCard(5));
        player2.addCard(new PipCard(6));
        
        
        player3.addCard(new PipCard(3));
        player3.addCard(new PipCard(6));
        player3.addCard(new Ace());
        player3.addCard(new PipCard(3));
        player3.addCard(new Ace());
        player3.addCard(new King());
        
        
        croupier.addCard(new PipCard(9));
        croupier.addCard(new PipCard(7));
        
        deck.add(new PipCard(5));
        deck.add(new PipCard(4));
        deck.add(new King());
        deck.add(new PipCard(2));
        
        BlackJack blackjack = new BlackJack(player1,player2,player3,croupier,deck);
        List<Player> winners = blackjack.getWinners(player1,player2,player3,croupier,deck);
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
        
        
        deck.add(new Ace());
        deck.add(new PipCard(3));
        deck.add(new King());
        deck.add(new PipCard(2));
        
        BlackJack blackjack = new BlackJack(player1,player2,player3,croupier, deck);
        List<Player> winners = blackjack.getWinners(player1,player2,player3,croupier,deck);
        List<Player> test = new ArrayList<>();
        test.add(player1);
        test.add(player3);
        assert(winners.equals(test));
    
    }
    
    
    @Test
    public void ExtraTest1(){
        //ganan todos los jugadores porque croupier excede de 21 puntos
        player1.addCard(new PipCard(10));
        player1.addCard(new King());
        
        player2.addCard(new PipCard(10));
        player2.addCard(new Ace());
        player2.addCard(new PipCard(9));
        
        player3.addCard(new PipCard(8));
        player3.addCard(new PipCard(8));
        player3.addCard(new PipCard(5));
        
        croupier.addCard(new PipCard(5));
        croupier.addCard(new PipCard(10));
        
        deck.add(new King());
        deck.add(new PipCard(2));
        
        BlackJack blackjack = new BlackJack(player1,player2,player3,croupier, deck);
        List<Player> winners = blackjack.getWinners(player1,player2,player3,croupier,deck);
        List<Player> test = new ArrayList<>();
        test.add(player1);
        test.add(player2);
        test.add(player3);
        assert(winners.equals(test));
    }
    
    
    
    @Test
    public void ExtraTest2(){
        //gana croupier con blackjack
        player1.addCard(new PipCard(10));
        player1.addCard(new King());
        
        player2.addCard(new PipCard(10));
        player2.addCard(new PipCard(9));
        
        player3.addCard(new PipCard(5));
        player3.addCard(new PipCard(5));
        player3.addCard(new PipCard(7));
        
        croupier.addCard(new Ace());
        croupier.addCard(new PipCard(10));
        
        deck.add(new King());
        deck.add(new PipCard(2));
        
        BlackJack blackjack = new BlackJack(player1,player2,player3,croupier, deck);
        List<Player> winners = blackjack.getWinners(player1,player2,player3,croupier,deck);
        List<Player> test = new ArrayList<>();
        
        assert(winners.equals(test));
    }
    
    @Test
    public void ExtraTest3(){
        //no gana ningún jugador teniendo BlackJack porque el croupier tambien tiene BlackJack
        player1.addCard(new Ace());
        player1.addCard(new PipCard(10));
        
        player2.addCard(new Ace());
        player2.addCard(new PipCard(10));
        
        player3.addCard(new Ace());
        player3.addCard(new PipCard(10));
        
        croupier.addCard(new Ace());
        croupier.addCard(new PipCard(10));
        
        deck.add(new King());
        deck.add(new PipCard(2));
        
        BlackJack blackjack = new BlackJack(player1,player2,player3,croupier, deck);
        List<Player> winners = blackjack.getWinners(player1,player2,player3,croupier,deck);
        List<Player> test = new ArrayList<>();
        assert(winners.equals(test));
    }
    
    
    @Test
    public void ExtraTest4(){
        //ganan todos los jugadores porque croupier no llega a la puntuacion del jugador con menor puntuacion
        player1.addCard(new PipCard(10));
        player1.addCard(new King());

        
        player2.addCard(new PipCard(10));
        player2.addCard(new Ace());
        player2.addCard(new PipCard(9));

        
        player3.addCard(new PipCard(8));
        player3.addCard(new PipCard(8));
        player3.addCard(new PipCard(5));

        
        croupier.addCard(new PipCard(5));
        croupier.addCard(new PipCard(10));
        
        
        deck.add(new PipCard(2));
        deck.add(new PipCard(2));
        deck.add(new PipCard(2));
        
        BlackJack blackjack = new BlackJack(player1,player2,player3,croupier, deck);
        List<Player> winners = blackjack.getWinners(player1,player2,player3,croupier,deck);
        List<Player> test = new ArrayList<>();
        test.add(player1);
        test.add(player2);
        test.add(player3);
        assert(winners.equals(test));
    }
    
}
