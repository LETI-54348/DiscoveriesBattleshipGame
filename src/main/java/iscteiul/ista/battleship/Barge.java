/**
 * Representa um navio do tipo Barca no jogo Batalha Naval.
 * <p>
 * Uma Barca ocupa apenas uma posição no tabuleiro.
 *
 * @author Luis Prado (nº 98898)
 * @version 1.0
 */
package iscteiul.ista.battleship;

/**
 * Representa uma Barca da frota.
 */
public class Barge extends Ship {

    /**
     * Tamanho da Barca.
     */
    private static final Integer SIZE = 1;

    /**
     * Nome da categoria da Barca.
     */
    private static final String NAME = "Barca";

    /**
     * Cria uma nova Barca na posição indicada.
     *
     * @param bearing direção da Barca
     * @param pos posição da Barca no tabuleiro
     */
    public Barge(Compass bearing, IPosition pos) {
        super(Barge.NAME, bearing, pos);
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
    }

    /**
     * Obtém o tamanho da Barca.
     *
     * @return número de posições ocupadas pela Barca
     */
    @Override
    public Integer getSize() {
        return SIZE;
    }
}
