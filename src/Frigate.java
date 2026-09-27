/**
 * Representa a embarcação do tipo Fragata no jogo.
 * A Fragata é um navio de escolta rápido e de médio porte na frota dos Descobrimentos.
 *
 * @author Simão Sousa
 * @version 1.0
 */
public class Frigate {

    private int resistencia = 2;

    /**
     * Verifica se a Fragata ainda se encontra operacional ou se já foi totalmente afundada.
     *
     * @return true se o navio recebeu danos em todas as suas secções, false caso contrário.
     */
    public boolean estaAfundado() {
        return this.resistencia == 0;
    }
}

