package iscteiul.ista.battleship;

/**
 * Classe que representa uma embarcação do tipo Galeão no jogo Batalha Naval.
 * O Galeão é um navio de grande porte que ocupa 5 posições no tabuleiro, possuindo
 * uma geometria de posicionamento específica baseada na sua orientação (cruz ou formato T).
 *
 * @author Grupo Ninjas (Juliana Prado, Luís Prado, Simão Sousa)
 * @version 1.0
 * @see Ship
 */
public class Galleon extends Ship {

    /** O tamanho padrão (número de secções ocupadas) do Galeão. */
    private static final Integer SIZE = 5;

    /** O identificador nominal da embarcação. */
    private static final String NAME = "Galeao";

    /**
     * Construtor da classe Galleon. Instancia o navio atribuindo o nome padrão,
     * a orientação espacial e calcula dinamicamente a sua frota de posições na grelha.
     *
     * @param bearing                  A orientação ou direção geométrica (Norte, Sul, Este, Oeste).
     * @param pos                      A coordenada inicial/âncora para o posicionamento.
     * @throws IllegalArgumentException Se a orientação fornecida for inválida ou nula.
     */
    public Galleon(Compass bearing, IPosition pos) throws IllegalArgumentException {
        super(Galleon.NAME, bearing, pos);

        if (bearing == null)
            throw new NullPointerException("ERROR! invalid bearing for the galleon");

        switch (bearing) {
            case NORTH:
                fillNorth(pos);
                break;
            case EAST:
                fillEast(pos);
                break;
            case SOUTH:
                fillSouth(pos);
                break;
            case WEST:
                fillWest(pos);
                break;
            default:
                throw new IllegalArgumentException("ERROR! invalid bearing for the galleon");
        }
    }

    /**
     * Devolve o tamanho absoluto do Galeão.
     *
     * @return O número de posições ocupadas pela embarcação.
     */
    public Integer getSize() {
        return Galleon.SIZE;
    }

    /**
     * Preenche as coordenadas do navio quando orientado para o Norte.
     *
     * @param pos Posição âncora inicial.
     */
    private void fillNorth(IPosition pos) {
        for (int i = 0; i < 3; i++) {
            getPositions().add(new Position(pos.getRow(), pos.getColumn() + i));
        }
        getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + 1));
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + 1));
    }

    /**
     * Preenche as coordenadas do navio quando orientado para o Sul.
     *
     * @param pos Posição âncora inicial.
     */
    private void fillSouth(IPosition pos) {
        for (int i = 0; i < 2; i++) {
            getPositions().add(new Position(pos.getRow() + i, pos.getColumn()));
        }
        for (int j = 2; j < 5; j++) {
            getPositions().add(new Position(pos.getRow() + 2, pos.getColumn() + j - 3));
        }
    }

    /**
     * Preenche as coordenadas do navio quando orientado para o Este.
     *
     * @param pos Posição âncora inicial.
     */
    private void fillEast(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 3));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }

    /**
     * Preenche as coordenadas do navio quando orientado para o Oeste.
     *
     * @param pos Posição âncora inicial.
     */
    private void fillWest(IPosition pos) {
        getPositions().add(new Position(pos.getRow(), pos.getColumn()));
        for (int i = 1; i < 4; i++) {
            getPositions().add(new Position(pos.getRow() + 1, pos.getColumn() + i - 1));
        }
        getPositions().add(new Position(pos.getRow() + 2, pos.getColumn()));
    }
}
