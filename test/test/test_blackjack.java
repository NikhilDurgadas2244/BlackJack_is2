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
    
        player1.addCard(new Jack().getValor());
        player1.addCard(new Ace().getValor());
        
        player2.addCard(new PipCard(10).getValor());
        player2.addCard(new PipCard(5).getValor());
        player2.addCard(new PipCard(6).getValor());
        
        player3.addCard(new PipCard(3).getValor());
        player3.addCard(new PipCard(6).getValor());
        player3.addCard(new Ace().getValor());
        player3.addCard(new PipCard(3).getValor());
        player3.addCard(new Ace().getValor());
        player3.addCard(new King().getValor());
        
        croupier.addCard(new PipCard(5).getValor());
        croupier.addCard(new PipCard(10).getValor());
        
        deck.addCard(new Ace().getValor());
        deck.addCard(new PipCard(3).getValor());
        deck.addCard(new King().getValor());
        deck.addCard(new PipCard(2).getValor());
        
        BlackJack blackjack = new BlackJack(player1,player2,player3,croupier);
        List<Player> winners = blackjack.getWinners();
        List<Player> test = new ArrayList<>();
        test.add(player1);
        assert(winners.equals(test));
    }
}
