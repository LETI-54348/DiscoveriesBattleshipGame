/**
 * Representa um navio do tipo Nau no jogo Batalha Naval.
 * <p>
 * Uma Nau ocupa três posições consecutivas no tabuleiro, de acordo
 * com a direção indicada pelo seu rumo.
 *
 * @author Luis Prado (nº 98898)
 * @version 1.0
 */
package iscteiul.ista.battleship;

/**
 * Representa uma Nau da frota.
 */
public class Carrack extends Ship {

    /**
     * Tamanho da Nau.
     */
    private static final Integer SIZE = 3;

    /**
     * Nome da categoria da Nau.
     */
    private static final String NAME = "Nau";

    /**
     * Cria uma nova Nau com a direção e posição inicial indicadas.
     * <p>
     * A Nau ocupa três posições consecutivas na direção indicada.
     *
     * @param bearing direção em que a Nau está orientada
     * @param pos posição inicial da Nau
     * @throws IllegalArgumentException se a direção indicada não for válida
     */
    public Carrack(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Carrack.NAME, bearing, pos);

        switch (bearing) {
            case NORTH:
            case SOUTH:
                for (int r = 0; r < SIZE; r++)
                    getPositions().add(
                        new Position(pos.getRow() + r, pos.getColumn())
                    );
                break;

            case EAST:
            case WEST:
                for (int c = 0; c < SIZE; c++)
                    getPositions().add(
                        new Position(pos.getRow(), pos.getColumn() + c)
                    );
                break;

            default:
                throw new IllegalArgumentException(
                    "ERROR! invalid bearing for the carrack"
                );
        }
    }

    /**
     * Obtém o tamanho da Nau.
     *
     * @return número de posições ocupadas pela Nau
     */
    @Override
    public Integer getSize() {
        return Carrack.SIZE;
    }
}
