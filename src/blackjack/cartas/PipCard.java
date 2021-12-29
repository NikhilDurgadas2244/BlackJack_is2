package blackjack.cartas;

public class PipCard extends Card{
    
    private int valor = 0;

    public PipCard(int value) {
        this.valor = value;
    }

    @Override
    public int getValor() {
        return valor;
    }
    
    
    
    
}
