package iscteiul.ista.battleship;                                                                                                                                                                                                       
                                                                                                                                                                                                                                            
    import java.util.Objects;                                                                                                                                                                                                               
                                                                                                                                                                                                                                            
    /**                                                                                                                                                                                                                                     
     * Implementação da interface {@link IPosition} que representa uma célula concreta                                                                                                                                                      
     * na grelha da Batalha Naval dos Descobrimentos.                                                                                                                                                                                       
     * Mantém o registo das coordenadas (linha, coluna), o estado de ocupação por navio                                                                                                                                                     
     * e se a célula foi atingida por um disparo.                                                                                                                                                                                           
     *                                                                                                                                                                                                                                      
     * @author Simão Sousa (nº 130768)                                                                                                                                                                                                      
     * @version 1.0                                                                                                                                                                                                                         
     */                                                                                                                                                                                                                                     
    public class Position implements IPosition {                                                                                                                                                                                            
        private int row;                                                                                                                                                                                                                    
        private int column;                                                                                                                                                                                                                 
        private boolean isOccupied;                                                                                                                                                                                                         
        private boolean isHit;                                                                                                                                                                                                              
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Construtor que inicializa uma nova posição na grelha com a linha e coluna especificadas.                                                                                                                                         
         * Por omissão, a posição inicia desocupada e não atingida.                                                                                                                                                                         
         *                                                                                                                                                                                                                                  
         * @param row O número da linha (de 0 a 9).                                                                                                                                                                                         
         * @param column O número da coluna (de 0 a 9).                                                                                                                                                                                     
         */                                                                                                                                                                                                                                 
        public Position(int row, int column) {                                                                                                                                                                                              
            this.row = row;                                                                                                                                                                                                                 
            this.column = column;                                                                                                                                                                                                           
            this.isOccupied = false;                                                                                                                                                                                                        
            this.isHit = false;                                                                                                                                                                                                             
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Obtém o número da linha correspondente a esta posição na grelha.                                                                                                                                                                 
         *                                                                                                                                                                                                                                  
         * @return O índice da linha.                                                                                                                                                                                                       
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public int getRow() {                                                                                                                                                                                                               
            return row;                                                                                                                                                                                                                     
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Obtém o número da coluna correspondente a esta posição na grelha.                                                                                                                                                                
         *                                                                                                                                                                                                                                  
         * @return O índice da coluna.                                                                                                                                                                                                      
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public int getColumn() {                                                                                                                                                                                                            
            return column;                                                                                                                                                                                                                  
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Calcula o código hash para esta posição com base nas coordenadas e estados.                                                                                                                                                      
         *                                                                                                                                                                                                                                  
         * @return O valor do código hash.                                                                                                                                                                                                  
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public int hashCode() {                                                                                                                                                                                                             
            return Objects.hash(column, isHit, isOccupied, row);                                                                                                                                                                            
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Compara a igualdade desta posição com outro objeto.                                                                                                                                                                              
         * Duas posições são consideradas iguais se tiverem a mesma linha e a mesma coluna.                                                                                                                                                 
         *                                                                                                                                                                                                                                  
         * @param otherPosition O objeto a comparar.                                                                                                                                                                                        
         * @return {@code true} se tiverem a mesma linha e coluna, {@code false} caso contrário.                                                                                                                                            
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public boolean equals(Object otherPosition) {                                                                                                                                                                                       
            if (this == otherPosition)                                                                                                                                                                                                      
                return true;                                                                                                                                                                                                                
            if (otherPosition instanceof IPosition) {                                                                                                                                                                                       
                IPosition other = (IPosition) otherPosition;                                                                                                                                                                                
                return (this.getRow() == other.getRow() && this.getColumn() == other.getColumn());                                                                                                                                          
            } else {                                                                                                                                                                                                                        
                return false;                                                                                                                                                                                                               
            }                                                                                                                                                                                                                               
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Verifica se esta posição é adjacente a outra (distância máxima de 1 célula,                                                                                                                                                      
         * incluindo diagonais).                                                                                                                                                                                                            
         *                                                                                                                                                                                                                                  
         * @param other A outra posição a verificar.                                                                                                                                                                                        
         * @return {@code true} se as posições forem adjacentes, {@code false} caso contrário.                                                                                                                                              
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public boolean isAdjacentTo(IPosition other) {                                                                                                                                                                                      
            return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);                                                                                                                  
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Marca esta posição como ocupada por um navio.                                                                                                                                                                                    
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public void occupy() {                                                                                                                                                                                                              
            isOccupied = true;                                                                                                                                                                                                              
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Regista que esta posição foi alvo de um disparo.                                                                                                                                                                                 
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public void shoot() {                                                                                                                                                                                                               
            isHit = true;                                                                                                                                                                                                                   
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Indica se a posição se encontra ocupada por alguma embarcação.                                                                                                                                                                   
         *                                                                                                                                                                                                                                  
         * @return {@code true} se estiver ocupada, {@code false} caso contrário.                                                                                                                                                           
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public boolean isOccupied() {                                                                                                                                                                                                       
            return isOccupied;                                                                                                                                                                                                              
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Indica se a posição já foi alvejada por um disparo.                                                                                                                                                                              
         *                                                                                                                                                                                                                                  
         * @return {@code true} se foi atingida, {@code false} caso contrário.                                                                                                                                                              
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public boolean isHit() {                                                                                                                                                                                                            
            return isHit;                                                                                                                                                                                                                   
        }                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                            
        /**                                                                                                                                                                                                                                 
         * Retorna a representação textual formatada da posição.                                                                                                                                                                            
         *                                                                                                                                                                                                                                  
         * @return String no formato "Linha = X Coluna = Y".                                                                                                                                                                                
         */                                                                                                                                                                                                                                 
        @Override                                                                                                                                                                                                                           
        public String toString() {                                                                                                                                                                                                          
            return ("Linha = " + row + " Coluna = " + column);                                                                                                                                                                              
        }                                                                                                                                                                                                                                   
    }        } else {
            return false;
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#isAdjacentTo(battleship.IPosition)
     */
    @Override
    public boolean isAdjacentTo(IPosition other) {
        return (Math.abs(this.getRow() - other.getRow()) <= 1 && Math.abs(this.getColumn() - other.getColumn()) <= 1);
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#occupy()
     */
    @Override
    public void occupy() {
        isOccupied = true;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#shoot()
     */
    @Override
    public void shoot() {
        isHit = true;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#isOccupied()
     */
    @Override
    public boolean isOccupied() {
        return isOccupied;
    }

    /*
     * (non-Javadoc)
     *
     * @see battleship.IPosition#isHit()
     */
    @Override
    public boolean isHit() {
        return isHit;
    }

    @Override
    public String toString() {
        return ("Linha = " + row + " Coluna = " + column);
    }

}
