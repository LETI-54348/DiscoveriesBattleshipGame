/**
 * Define as operações disponíveis para uma frota de navios
 * no jogo Batalha Naval.
 * <p>
 * Esta interface estabelece as operações para consultar e gerir
 * os navios de uma frota.
 *
 * @author Luis Prado (nº 98898)
 * @version 1.0
 */
package iscteiul.ista.battleship;

import java.util.List;

/**
 * Define as operações disponíveis para uma frota de navios.
 */
public interface IFleet {

    /**
     * Tamanho do tabuleiro do jogo.
     */
    Integer BOARD_SIZE = 10;

    /**
     * Número máximo de navios que uma frota pode conter.
     */
    Integer FLEET_SIZE = 10;

    /**
     * Obtém a lista de navios da frota.
     *
     * @return lista de navios pertencentes à frota
     */
    List<IShip> getShips();

    /**
     * Adiciona um navio à frota.
     *
     * @param s navio a adicionar
     * @return {@code true} se o navio for adicionado;
     *         {@code false} caso contrário
     */
    boolean addShip(IShip s);

    /**
     * Obtém os navios pertencentes a uma determinada categoria.
     *
     * @param category categoria dos navios a procurar
     * @return lista de navios pertencentes à categoria indicada
     */
    List<IShip> getShipsLike(String category);

    /**
     * Obtém os navios da frota que ainda estão a flutuar.
     *
     * @return lista dos navios que ainda não foram afundados
     */
    List<IShip> getFloatingShips();

    /**
     * Procura o navio que ocupa uma determinada posição.
     *
     * @param pos posição do tabuleiro a verificar
     * @return o navio que ocupa a posição indicada ou {@code null}
     *         caso não exista nenhum navio nessa posição
     */
    IShip shipAt(IPosition pos);

    /**
     * Apresenta o estado atual da frota.
     */
    void printStatus();
}
