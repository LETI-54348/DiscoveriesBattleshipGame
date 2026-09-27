package iscteiul.ista.battleship;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerir a lógica de execução e estado de uma partida de Batalha Naval.
 * Controla o histórico de disparos efetuados, validação de jogadas, contagem de acertos
 * e a renderização do tabuleiro em consola.
 *
 * @author Grupo Ninjas (Juliana Prado, Luís Prado, Simão Sousa)
 * @version 1.4
 */
public class Game implements iscteiul.ista.battleship.IGame {

    private IFleet fleet;
    private List<IPosition> shots;

    private Integer countInvalidShots;
    private Integer countRepeatedShots;
    private Integer countHits;
    private Integer countSinks;

    /**
     * Construtor da classe Game. Inicializa as estruturas de dados e os contadores
     * de estatísticas do jogo, associando a frota de embarcações fornecida.
     *
     * @param fleet A frota de navios que será posicionada e atacada no tabuleiro.
     */
    public Game(IFleet fleet) {
        this.shots = new ArrayList<IPosition>();
        this.countInvalidShots = 0;
        this.countRepeatedShots = 0;
        this.countHits = 0;
        this.countSinks = 0;
        this.fleet = fleet;
    }

    /**
     * Executa e processa a ação de um disparo numa determinada coordenada do tabuleiro.
     *
     * @param pos A posição geográfica alvo do disparo.
     * @return O objeto IShip atingido e afundado, ou null caso contrário.
     */
    public IShip fire(IPosition pos) {
        if (!validShot(pos)) {
            countInvalidShots++;
        } else { // valid shot!
            if (repeatedShot(pos)) {
                countRepeatedShots++;
            } else {
                shots.add(pos);
                IShip s = fleet.shipAt(pos);
                if (s != null) {
                    s.shoot(pos);
                    countHits++;
                    if (!s.stillFloating()) {
                        countSinks++;
                        return s;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Obtém o histórico de todas as posições alvejadas.
     *
     * @return Lista com as coordenadas dos disparos.
     */
    public List<IPosition> getShots() {
        return shots;
    }

    /**
     * Obtém o número total de tiros repetidos.
     *
     * @return Total de jogadas em posições repetidas.
     */
    public int getRepeatedShots() {
        return this.countRepeatedShots != null ? this.countRepeatedShots.intValue() : 0;
    }

    /**
     * Obtém o número total de tiros inválidos.
     *
     * @return Total de jogadas fora do tabuleiro.
     */
    public int getInvalidShots() {
        return this.countInvalidShots != null ? this.countInvalidShots.intValue() : 0;
    }

    /**
     * Obtém o número total de impactos bem-sucedidos.
     *
     * @return Total de acertos em navios.
     */
    public int getHits() {
        return this.countHits != null ? this.countHits.intValue() : 0;
    }

    /**
     * Obtém a quantidade de navios totalmente afundados.
     *
     * @return Total de embarcações destruídas.
     */
    public int getSunkShips() {
        return this.countSinks != null ? this.countSinks.intValue() : 0;
    }

    /**
     * Calcula quantos navios ainda flutuam.
     *
     * @return Quantidade de navios operacionais restantes.
     */
    public int getRemainingShips() {
        List<IShip> floatingShips = fleet.getFloatingShips();
        return floatingShips.size();
    }

    private boolean validShot(IPosition pos) {
        return (pos.getRow() >= 0 && pos.getRow() <= Fleet.BOARD_SIZE && pos.getColumn() >= 0
                && pos.getColumn() <= Fleet.BOARD_SIZE);
    }

    private boolean repeatedShot(IPosition pos) {
        for (int i = 0; i < shots.size(); i++) {
            if (shots.get(i).equals(pos)) {
                return true;
            }
        }
        return false;
    }

    public void printBoard(List<IPosition> positions, Character marker) {
        char[][] map = new char[Fleet.BOARD_SIZE][Fleet.BOARD_SIZE];

        for (int r = 0; r < Fleet.BOARD_SIZE; r++) {
            for (int c = 0; c < Fleet.BOARD_SIZE; c++) {
                map[r][c] = '.';
            }
        }

        for (IPosition pos : positions) {
            map[pos.getRow()][pos.getColumn()] = marker;
        }

        for (int row = 0; row < Fleet.BOARD_SIZE; row++) {
            for (int col = 0; col < Fleet.BOARD_SIZE; col++) {
                System.out.print(map[row][col]);
            }
            System.out.println();
        }
    }

    /**
     * Imprime na consola o tabuleiro identificando os tiros válidos com 'X'.
     */
    public void printValidShots() {
        printBoard(getShots(), 'X');
    }

    /**
     * Imprime na consola a grelha com a frota mapeada por '#'.
     */
    public void printFleet() {
        List<IPosition> shipPositions = new ArrayList<IPosition>();

        for (IShip s : fleet.getShips()) {
            shipPositions.addAll(s.getPositions());
        }

        printBoard(shipPositions, '#');
    }
}
