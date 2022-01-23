package blackjack.cartas;

public class PipCard extends Card{
    
    private int valor = 0;

    public PipCard(int value) {
        this.valor = value;
        if (this.valor < 2){this.valor = 2;}
        if (this.valor > 10){this.valor = 10;}
    }

    @Override
    public int getValor() {
        return valor;
    }
    
    
    
    
}
