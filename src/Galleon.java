/**
 * Representa a embarcação do tipo Galeão no jogo.
 * O Galeão é um navio de grande porte com elevada resistência na frota dos Descobrimentos.
 *
 * @author Simão Sousa
 * @version 1.0
 */
public class Galleon {

    private int tamanho = 4;
    private int resistencia = 4;

    /**
     * Obtém o tamanho em quadrados (comprimento) ocupado pelo Galeão no tabuleiro.
     *
     * @return O número de posições horizontais ou verticais que o navio ocupa.
     */
    public int getTamanho() {
        return this.tamanho;
    }

    /**
     * Regista um dano sofrido pelo Galeão quando é atingido por um tiro certeiro.
     */
    public void registarDano() {
        if (this.resistencia > 0) {
            this.resistencia--;
        }
    }
}
