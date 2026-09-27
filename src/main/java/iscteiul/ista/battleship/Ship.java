package iscteiul.ista.battleship;                                                                                                                                                                                                       
                                                                                                                                                                                                                                            
    import java.util.ArrayList;                                                                                                                                                                                                             
    import java.util.Iterator;                                                                                                                                                                                                              
    import java.util.List;                                                                                                                                                                                                                  
                                                                                                                                                                                                                                            
    /**                                                                                                                                                                                                                                     
     * Classe abstrata base que implementa a interface {@link IShip}, fornecendo a lógica                                                                                                                                                   
     * comum para todos os tipos de embarcações do jogo dos Descobrimentos.                                                                                                                                                                 
     * Gere a posição de referência, a orientação cardeal, a lista de células ocupadas,                                                                                                                                                     
     * o cálculo dos limites geométricos e a receção de danos por disparos.                                                                                                                                                                 
     *                                                                                                                                                                                                                                      
     * @author Simão Sousa (nº 130768)                                                                                                                                                                                                      
     * @version 1.0                                                                                                                                                                                                                         
     */                                                                                                                                                                                                                                     
    public abstract class Ship implements IShip {                                                                                                                                                                                           
                                                                                                                                                                                                                                            
        private static final String GALEAO = "galeao";                                                                                                                                                                                      
        private static final String FRAGATA = "fragata";                                                                                                                                                                                    
        private static final String NAU = "nau";                                                                                                                                                                                            
        private static final String CARAVELA = "caravela";                                                                                                                                                                                  
        private static final String BARCA = "barca";                                                                                                                                                                                        
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Método fábrica (Factory Method) que instancia o navio adequado com base no tipo especificado.                                                                                                                                    
         *                                                                                                                                                                                                                                  
         * @param shipKind O nome do tipo de navio ("barca", "caravela", "nau", "fragata", "galeao").                                                                                                                                       
         * @param bearing A orientação cardeal da embarcação.                                                                                                                                                                               
         * @param pos A posição de referência inicial do navio.                                                                                                                                                                             
         * @return Uma nova instância da subclasse correspondente de {@link Ship}, ou {@code null} se o tipo for desconhecido.                                                                                                              
         */                                                                                                                                                                                                                                 
        static Ship buildShip(String shipKind, Compass bearing, Position pos) {                                                                                                                                                             
            Ship s;                                                                                                                                                                                                                         
            switch (shipKind) {                                                                                                                                                                                                             
                case BARCA:                                                                                                                                                                                                                 
                    s = new Barge(bearing, pos);                                                                                                                                                                                            
                    break;                                                                                                                                                                                                                  
                case CARAVELA:                                                                                                                                                                                                              
                    s = new Caravel(bearing, pos);                                                                                                                                                                                          
                    break;                                                                                                                                                                                                                  
                case NAU:                                                                                                                                                                                                                   
                    s = new Carrack(bearing, pos);                                                                                                                                                                                          
                    break;                                                                                                                                                                                                                  
                case FRAGATA:                                                                                                                                                                                                               
                    s = new Frigate(bearing, pos);                                                                                                                                                                                          
                    break;                                                                                                                                                                                                                  
                case GALEAO:                                                                                                                                                                                                                
                    s = new Galleon(bearing, pos);                                                                                                                                                                                          
                    break;                                                                                                                                                                                                                  
                default:                                                                                                                                                                                                                    
                    s = null;                                                                                                                                                                                                               
            }                                                                                                                                                                                                                               
            return s;                                                                                                                                                                                                                       
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        private String category;                                                                                                                                                                                                            
        private Compass bearing;                                                                                                                                                                                                            
        private IPosition pos;                                                                                                                                                                                                              
        protected List<IPosition> positions;                                                                                                                                                                                                
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Construtor da classe base que inicializa os atributos fundamentais do navio.                                                                                                                                                     
         *                                                                                                                                                                                                                                  
         * @param category O nome da categoria do navio (ex: "Caravela").                                                                                                                                                                   
         * @param bearing O rumo cardeal para onde o navio está orientado.                                                                                                                                                                  
         * @param pos A posição inicial de colocação na grelha.                                                                                                                                                                             
         */                                                                                                                                                                                                                                 
        public Ship(String category, Compass bearing, IPosition pos) {                                                                                                                                                                      
            assert bearing != null;                                                                                                                                                                                                         
            assert pos != null;                                                                                                                                                                                                             
                                                                                                                                                                                                                                            
            this.category = category;                                                                                                                                                                                                       
            this.bearing = bearing;                                                                                                                                                                                                         
            this.pos = pos;                                                                                                                                                                                                                 
            positions = new ArrayList<>();                                                                                                                                                                                                  
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Obtém a categoria do navio.                                                                                                                                                                                                      
         *                                                                                                                                                                                                                                  
         * @return O nome da categoria.                                                                                                                                                                                                     
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public String getCategory() {                                                                                                                                                                                                       
            return category;                                                                                                                                                                                                                
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Retorna a lista de todas as posições ocupadas pelo navio na grelha.                                                                                                                                                              
         *                                                                                                                                                                                                                                  
         * @return Lista com as instâncias de {@link IPosition}.                                                                                                                                                                            
         */                                                                                                                                                                                                                                 
        public List<IPosition> getPositions() {                                                                                                                                                                                             
            return positions;                                                                                                                                                                                                               
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Obtém a posição inicial de referência onde o navio começou a ser posicionado.                                                                                                                                                    
         *                                                                                                                                                                                                                                  
         * @return A coordenada inicial {@link IPosition}.                                                                                                                                                                                  
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public IPosition getPosition() {                                                                                                                                                                                                    
            return pos;                                                                                                                                                                                                                     
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Obtém o rumo/orientação cardeal do navio.                                                                                                                                                                                        
         *                                                                                                                                                                                                                                  
         * @return O rumo {@link Compass}.                                                                                                                                                                                                  
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public Compass getBearing() {                                                                                                                                                                                                       
            return bearing;                                                                                                                                                                                                                 
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Verifica se o navio ainda está a flutuar (ou seja, se resta pelo menos uma posição que não foi atingida).                                                                                                                        
         *                                                                                                                                                                                                                                  
         * @return {@code true} se ainda tiver partes intactas, {@code false} se estiver totalmente afundado.                                                                                                                               
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public boolean stillFloating() {                                                                                                                                                                                                    
            for (int i = 0; i < getSize(); i++)                                                                                                                                                                                             
                if (!getPositions().get(i).isHit())                                                                                                                                                                                         
                    return true;                                                                                                                                                                                                            
            return false;                                                                                                                                                                                                                   
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Obtém a coordenada da linha mais a norte (topo) ocupada pela embarcação.                                                                                                                                                         
         *                                                                                                                                                                                                                                  
         * @return O menor índice de linha.                                                                                                                                                                                                 
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public int getTopMostPos() {                                                                                                                                                                                                        
            int top = getPositions().get(0).getRow();                                                                                                                                                                                       
            for (int i = 1; i < getSize(); i++)                                                                                                                                                                                             
                if (getPositions().get(i).getRow() < top)                                                                                                                                                                                   
                    top = getPositions().get(i).getRow();                                                                                                                                                                                   
            return top;                                                                                                                                                                                                                     
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Obtém a coordenada da linha mais a sul (fundo) ocupada pela embarcação.                                                                                                                                                          
         *                                                                                                                                                                                                                                  
         * @return O maior índice de linha.                                                                                                                                                                                                 
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public int getBottomMostPos() {                                                                                                                                                                                                     
            int bottom = getPositions().get(0).getRow();                                                                                                                                                                                    
            for (int i = 1; i < getSize(); i++)                                                                                                                                                                                             
                if (getPositions().get(i).getRow() > bottom)                                                                                                                                                                                
                    bottom = getPositions().get(i).getRow();                                                                                                                                                                                
            return bottom;                                                                                                                                                                                                                  
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Obtém a coordenada da coluna mais a oeste (esquerda) ocupada pela embarcação.                                                                                                                                                    
         *                                                                                                                                                                                                                                  
         * @return O menor índice de coluna.                                                                                                                                                                                                
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public int getLeftMostPos() {                                                                                                                                                                                                       
            int left = getPositions().get(0).getColumn();                                                                                                                                                                                   
            for (int i = 1; i < getSize(); i++)                                                                                                                                                                                             
                if (getPositions().get(i).getColumn() < left)                                                                                                                                                                               
                    left = getPositions().get(i).getColumn();                                                                                                                                                                               
            return left;                                                                                                                                                                                                                    
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Obtém a coordenada da coluna mais a este (direita) ocupada pela embarcação.                                                                                                                                                      
         *                                                                                                                                                                                                                                  
         * @return O maior índice de coluna.                                                                                                                                                                                                
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public int getRightMostPos() {                                                                                                                                                                                                      
            int right = getPositions().get(0).getColumn();                                                                                                                                                                                  
            for (int i = 1; i < getSize(); i++)                                                                                                                                                                                             
                if (getPositions().get(i).getColumn() > right)                                                                                                                                                                              
                    right = getPositions().get(i).getColumn();                                                                                                                                                                              
            return right;                                                                                                                                                                                                                   
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Verifica se o navio ocupa uma dada posição da grelha.                                                                                                                                                                            
         *                                                                                                                                                                                                                                  
         * @param pos A coordenada a testar.                                                                                                                                                                                                
         * @return {@code true} se o navio ocupar essa posição, {@code false} caso contrário.                                                                                                                                               
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public boolean occupies(IPosition pos) {                                                                                                                                                                                            
            assert pos != null;                                                                                                                                                                                                             
                                                                                                                                                                                                                                            
            for (int i = 0; i < getSize(); i++)                                                                                                                                                                                             
                if (getPositions().get(i).equals(pos))                                                                                                                                                                                      
                    return true;                                                                                                                                                                                                            
            return false;                                                                                                                                                                                                                   
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Verifica se este navio está em contacto ou adjacente a outro navio.                                                                                                                                                              
         *                                                                                                                                                                                                                                  
         * @param other O outro navio a verificar.                                                                                                                                                                                          
         * @return {@code true} se houver contacto ou adjacência indevida, {@code false} caso contrário.                                                                                                                                    
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public boolean tooCloseTo(IShip other) {                                                                                                                                                                                            
            assert other != null;                                                                                                                                                                                                           
                                                                                                                                                                                                                                            
            Iterator<IPosition> otherPos = other.getPositions().iterator();                                                                                                                                                                 
            while (otherPos.hasNext())                                                                                                                                                                                                      
                if (tooCloseTo(otherPos.next()))                                                                                                                                                                                            
                    return true;                                                                                                                                                                                                            
                                                                                                                                                                                                                                            
            return false;                                                                                                                                                                                                                   
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Verifica se o navio está adjacente a uma determinada coordenada.                                                                                                                                                                 
         *                                                                                                                                                                                                                                  
         * @param pos A posição a testar.                                                                                                                                                                                                   
         * @return {@code true} se qualquer ponto do navio estiver colado a essa coordenada, {@code false} caso contrário.                                                                                                                  
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public boolean tooCloseTo(IPosition pos) {                                                                                                                                                                                          
            for (int i = 0; i < this.getSize(); i++)                                                                                                                                                                                        
                if (getPositions().get(i).isAdjacentTo(pos))                                                                                                                                                                                
                    return true;                                                                                                                                                                                                            
            return false;                                                                                                                                                                                                                   
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Regista um tiro sobre a posição informada, marcando-a como atingida se pertencer ao navio.                                                                                                                                       
         *                                                                                                                                                                                                                                  
         * @param pos A coordenada alvejada.                                                                                                                                                                                                
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public void shoot(IPosition pos) {                                                                                                                                                                                                  
            assert pos != null;                                                                                                                                                                                                             
                                                                                                                                                                                                                                            
            for (IPosition position : getPositions()) {                                                                                                                                                                                     
                if (position.equals(pos))                                                                                                                                                                                                   
                    position.shoot();                                                                                                                                                                                                       
            }                                                                                                                                                                                                                               
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Representação textual com resumo da categoria, rumo e posição do navio.                                                                                                                                                          
         *                                                                                                                                                                                                                                  
         * @return String formatada representativa da embarcação.                                                                                                                                                                           
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public String toString() {                                                                                                                                                                                                          
            return "[" + category + " " + bearing + " " + pos + "]";                                                                                                                                                                        
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
    }        assert pos != null;

        this.category = category;
        this.bearing = bearing;
        this.pos = pos;
        positions = new ArrayList<>();
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getCategory()
     */
    @Override
    public String getCategory() {
        return category;
    }

    /**
     * @return the positions
     */
    public List<IPosition> getPositions() {
        return positions;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getPosition()
     */
    @Override
    public IPosition getPosition() {
        return pos;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getBearing()
     */
    @Override
    public Compass getBearing() {
        return bearing;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#stillFloating()
     */
    @Override
    public boolean stillFloating() {
        for (int i = 0; i < getSize(); i++)
            if (!getPositions().get(i).isHit())
                return true;
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getTopMostPos()
     */
    @Override
    public int getTopMostPos() {
        int top = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() < top)
                top = getPositions().get(i).getRow();
        return top;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getBottomMostPos()
     */
    @Override
    public int getBottomMostPos() {
        int bottom = getPositions().get(0).getRow();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getRow() > bottom)
                bottom = getPositions().get(i).getRow();
        return bottom;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getLeftMostPos()
     */
    @Override
    public int getLeftMostPos() {
        int left = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() < left)
                left = getPositions().get(i).getColumn();
        return left;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#getRightMostPos()
     */
    @Override
    public int getRightMostPos() {
        int right = getPositions().get(0).getColumn();
        for (int i = 1; i < getSize(); i++)
            if (getPositions().get(i).getColumn() > right)
                right = getPositions().get(i).getColumn();
        return right;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#occupies(battleship.IPosition)
     */
    @Override
    public boolean occupies(IPosition pos) {
        assert pos != null;

        for (int i = 0; i < getSize(); i++)
            if (getPositions().get(i).equals(pos))
                return true;
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#tooCloseTo(battleship.IShip)
     */
    @Override
    public boolean tooCloseTo(IShip other) {
        assert other != null;

        Iterator<IPosition> otherPos = other.getPositions().iterator();
        while (otherPos.hasNext())
            if (tooCloseTo(otherPos.next()))
                return true;

        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#tooCloseTo(battleship.IPosition)
     */
    @Override
    public boolean tooCloseTo(IPosition pos) {
        for (int i = 0; i < this.getSize(); i++)
            if (getPositions().get(i).isAdjacentTo(pos))
                return true;
        return false;
    }


    /*
     * (non-Javadoc)
     *
     * @see battleship.IShip#shoot(battleship.IPosition)
     */
    @Override
    public void shoot(IPosition pos) {
        assert pos != null;

        for (IPosition position : getPositions()) {
            if (position.equals(pos))
                position.shoot();
        }
    }


    @Override
    public String toString() {
        return "[" + category + " " + bearing + " " + pos + "]";
    }

}
