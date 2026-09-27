package iscteiul.ista.battleship;

import java.util.List;

/**
 * Interface que define o contrato principal para o motor do jogo Batalha Naval.
 * Fornece métodos para controlo de disparos, estatísticas da partida e visualização da frota.
 *
 * @author Juliana Prado
 * @version 1.0
 */
public interface IGame {

    /**
     * Executa um disparo numa coordenada específica do tabuleiro.
     *
     * @param pos A posição geométrica alvo do disparo (contendo linha e coluna).
     * @return    O objeto IShip que foi atingido ou null se o tiro foi na água.
     */
    IShip fire(IPosition pos);

    /**
     * Obtém o histórico de todas as posições onde já foram efetuados disparos.
     *
     * @return Uma lista contendo todas as coordenadas de tiros disparados na partida.
     */
    List<IPosition> getShots();

    /**
     * Contabiliza o número total de tiros repetidos (disparados em coordenadas já atacadas).
     *
     * @return O total de jogadas duplicadas efetuadas pelo jogador.
     */
    int getRepeatedShots();

    /**
     * Contabiliza o número total de tiros que foram disparados fora dos limites do tabuleiro.
     *
     * @return O total de jogadas inválidas registadas no sistema.
     */
    int getInvalidShots();

    /**
     * Obtém o número total de tiros certeiros que atingiram alguma embarcação.
     *
     * @return O número de impactos de sucesso acumulados.
     */
    int getHits();

    /**
     * Obtém o número total de navios da frota adversária que já foram completamente destruídos.
     *
     * @return O total de embarcações afundadas até ao momento.
     */
    int getSunkShips();

    /**
     * Obtém a quantidade de navios que ainda se encontram operacionais na frota.
     *
     * @return O número de navios restantes que ainda não foram afundados.
     */
    int getRemainingShips();

    /**
     * Imprime na consola a listagem formatada de todos os disparos válidos efetuados na partida.
     */
    void printValidShots();

    /**
     * Imprime no ecrã a representação visual atualizada de todo o tabuleiro da frota e estados dos navios.
     */
    void printFleet();
}
