/**
 * Representa uma frota de navios no jogo Batalha Naval.
 * <p>
 * Esta classe é responsável por gerir os navios pertencentes à frota,
 * permitindo adicionar, consultar, filtrar e apresentar os navios.
 *
 * @author Luis Prado (nº 98898)
 * @version 1.0
 */
public class Fleet implements IFleet {

    /**
     * Imprime todos os navios existentes na lista fornecida.
     *
     * @param ships lista de navios a imprimir
     */
    static void printShips(List<IShip> ships) {
        for (IShip ship : ships)
            System.out.println(ship);
    }

    /**
     * Lista de navios pertencentes à frota.
     */
    private List<IShip> ships;

    /**
     * Cria uma nova frota vazia.
     */
    public Fleet() {
        ships = new ArrayList<>();
    }

    /**
     * Obtém a lista de navios pertencentes à frota.
     *
     * @return lista de navios da frota
     */
    @Override
    public List<IShip> getShips() {
        return ships;
    }

    /**
     * Adiciona um navio à frota.
     *
     * @param s navio a adicionar
     * @return {@code true} se o navio for adicionado;
     *         {@code false} caso contrário
     */
    @Override
    public boolean addShip(IShip s) {
        boolean result = false;
        if ((ships.size() <= FLEET_SIZE) && (isInsideBoard(s)) && (!colisionRisk(s))) {
            ships.add(s);
            result = true;
        }
        return result;
    }

    /**
     * Obtém os navios pertencentes a uma determinada categoria.
     *
     * @param category categoria dos navios a procurar
     * @return lista de navios da categoria indicada
     */
    @Override
    public List<IShip> getShipsLike(String category) {
        List<IShip> shipsLike = new ArrayList<>();
        for (IShip s : ships)
            if (s.getCategory().equals(category))
                shipsLike.add(s);

        return shipsLike;
    }

    /**
     * Obtém todos os navios que ainda estão a flutuar.
     *
     * @return lista dos navios que ainda não foram afundados
     */
    @Override
    public List<IShip> getFloatingShips() {
        List<IShip> floatingShips = new ArrayList<>();
        for (IShip s : ships)
            if (s.stillFloating())
                floatingShips.add(s);

        return floatingShips;
    }

    /**
     * Procura o navio que ocupa uma determinada posição.
     *
     * @param pos posição a verificar
     * @return o navio que ocupa a posição ou {@code null} caso não exista
     */
    @Override
    public IShip shipAt(IPosition pos) {
        for (int i = 0; i < ships.size(); i++)
            if (ships.get(i).occupies(pos))
                return ships.get(i);
        return null;
    }

    /**
     * Verifica se um navio está completamente dentro do tabuleiro.
     *
     * @param s navio cuja posição será verificada
     * @return {@code true} se o navio estiver dentro do tabuleiro;
     *         {@code false} caso contrário
     */
    private boolean isInsideBoard(IShip s) {
        return (s.getLeftMostPos() >= 0
                && s.getRightMostPos() <= BOARD_SIZE - 1
                && s.getTopMostPos() >= 0
                && s.getBottomMostPos() <= BOARD_SIZE - 1);
    }

    /**
     * Verifica se existe risco de colisão com outro navio da frota.
     *
     * @param s navio cuja posição será verificada
     * @return {@code true} se existir risco de colisão;
     *         {@code false} caso contrário
     */
    private boolean colisionRisk(IShip s) {
        for (int i = 0; i < ships.size(); i++) {
            if (ships.get(i).tooCloseTo(s))
                return true;
        }
        return false;
    }

    /**
     * Apresenta o estado atual da frota.
     */
    public void printStatus() {
        printAllShips();
        printFloatingShips();
        printShipsByCategory("Galeao");
        printShipsByCategory("Fragata");
        printShipsByCategory("Nau");
        printShipsByCategory("Caravela");
        printShipsByCategory("Barca");
    }

    /**
     * Imprime todos os navios pertencentes a uma determinada categoria.
     *
     * @param category categoria dos navios a imprimir
     */
    public void printShipsByCategory(String category) {
        assert category != null;

        printShips(getShipsLike(category));
    }

    /**
     * Imprime todos os navios que ainda estão a flutuar.
     */
    public void printFloatingShips() {
        printShips(getFloatingShips());
    }

    /**
     * Imprime todos os navios da frota.
     */
    void printAllShips() {
        printShips(ships);
    }
}
