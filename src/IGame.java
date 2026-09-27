/**
 * Interface que define o contrato e os métodos obrigatórios para o motor
 * do jogo Batalha Naval dos Descobrimentos.
 *
 * @author Juliana Prado
 * @version 1.0
 */
public interface IGame {

    /**
     * Inicializa os tabuleiros e prepara o estado do jogo para o início da partida.
     */
    void iniciarJogo();

    /**
     * Processa o resultado de um disparo nas coordenadas especificadas.
     *
     * @param linha   A coordenada da linha alvo no tabuleiro (ex: 0 a 9).
     * @param coluna  A coordenada da coluna alvo no tabuleiro (ex: 0 a 9).
     * @return        Uma String indicando o resultado (ex: "Água", "Tiro no Galeão", "Afundado").
     */
    String processarDisparo(int linha, int coluna);

    /**
     * Verifica se todas as embarcações de uma frota foram totalmente destruídas.
     *
     * @return true se o jogo terminou com a derrota de uma das frotas, false caso contrário.
     */
    boolean verificarFimDeJogo();
}
