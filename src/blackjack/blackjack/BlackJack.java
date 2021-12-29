package blackjack.blackjack;

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
    
    public List<Player> getWinners(){
        
        ArrayList<Player> winners = new ArrayList<>();
        
        
        
        return winners;
    }
    
}
