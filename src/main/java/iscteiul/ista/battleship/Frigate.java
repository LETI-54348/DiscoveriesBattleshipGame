package iscteiul.ista.battleship;

/**
 * Classe que representa uma embarcação do tipo Fragata no jogo Batalha Naval.
 * A Fragata é um navio militar linear de tamanho 4, preenchendo as suas coordenadas
 * de forma sequencial na horizontal ou vertical consoante a orientação indicada.
 *
 * @author Grupo Ninjas (Juliana Prado, Luís Prado, Simão Sousa)
 * @version 1.0
 * @see Ship
 */
public class Frigate extends Ship {

    /** O tamanho padrão (número de secções ocupadas) da Fragata. */
    private static final Integer SIZE = 4;

    /** O identificador nominal da embarcação. */
    private static final String NAME = "Fragata";

    /**
     * Construtor da classe Frigate. Cria o navio mapeando as 4 posições sequenciais
     * em linha reta no tabuleiro de acordo com a direção geográfica selecionada.
     *
     * @param bearing                  A orientação espacial (Norte, Sul, Este, Oeste).
     * @param pos                      A coordenada inicial a partir da qual o navio se estende.
     * @throws IllegalArgumentException Se a orientação indicada for inválida ou nula.
     */
    public Frigate(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Frigate.NAME, bearing, pos);
        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(new Position(pos.getRow() + r, pos.getColumn()));
                break;
            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(new Position(pos.getRow(), pos.getColumn() + c));
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for thr frigate");
        }
    }

    /**
     * Devolve o tamanho absoluto da Fragata.
     *
     * @return O número de posições ocupadas pela embarcação.
     */
    public Integer getSize() {
        return Frigate.SIZE;
    }
}
