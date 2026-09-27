# Battleship

Basic academic version of Battleship game to build upon.

### Grupo: `Ninjas`

| Curso | Número | Nome |
| LETI | **54348** | Juliana Prado |
| LETI | **98898** | Luís Prado |
| DSA | **130768** | Simão Sousa |

# Projeto: Batalha Naval dos Descobrimentos

## 📝 Introdução
Este repositório aloja o projeto desenvolvido no âmbito da unidade curricular. O objetivo é implementar um jogo baseado nas dinâmicas de batalha naval, contextualizado com a época dos Descobrimentos Portugueses. Todos os membros da equipa devem colaborar ativamente na evolução deste documento.

---

## 🖼️ Imagem do Projeto
![Ilha Terceira](https://upload.wikimedia.org/wikipedia/commons/0/08/Isla_Terceira.jpg)

---                                                                                                                                                                                                 

## 🎯 Regras do Jogo                                                                                                                                                                                                                                                                                                                                                                                                                            
O jogo decorre em dois tabuleiros de grelha quadriculada de 10x10 posições:  

* Cada jogador dispõe de duas grelhas: **"o seu mar"** (onde posiciona a sua frota) e **"o mar do adversário"** (onde regista os tiros disparados).                                                                                     
* **Posicionamento**: Os navios são colocados na horizontal ou vertical, sem que se toquem entre si (mesmo na diagonal), embora possam encostar às margens do tabuleiro.                                                                
* **Dinâmica de Disparo**: Em cada turno, cada jogador dispara uma **rajada de 3 tiros**, indicando as respetivas coordenadas `(linha, coluna)`.                                                                                        
* **Feedback do Adversário**: O oponente informa o resultado de cada um dos 3 disparos:                                                                                                                                                 
* **Água**: o tiro falhou qualquer embarcação;                                                                                                                                                                                        
* **Tiro Certeiro**: o tiro atingiu um navio (indicando o tipo de navio atingido);                                                                                                                                                    
* **Afundado**: quando todas as posições do navio foram atingidas.                                                                                                                                                                    
* **Condição de Vitória**: O jogo termina quando um dos jogadores conseguir atingir e afundar a totalidade dos navios da frota adversária.                                                                                              
  ---                                                                                                                                                                                                                                     
                                                                                                                                                                                                                                            
 ## 📜 Contexto Histórico: A Era dos Descobrimentos                                                                                                                                                                                      
O projeto transporta o clássico jogo de Batalha Naval para o período da expansão marítima portuguesa e os confrontos navais no Atlântico, como a célebre [Batalha de Vila Franca do Campo (1582)](https://en.wikipedia.org/wiki/Battle_of_Vila_Franca_do_Campo), travada nos Açores. As embarcações do jogo refletem os navios da época:                                                                                                                                                                              
* [Galeão](https://en.wikipedia.org/wiki/Galleon): Poderosa belonave artilhada de grande porte, usada para escolta e defesa das rotas ultramarinas.                                                                                     
* [Fragata](https://en.wikipedia.org/wiki/Frigate): Embarcação de guerra veloz, com capacidade de combate e patrulha costeira.
                                                                                                                                                                                  
* [Nau](https://en.wikipedia.org/wiki/Carrack): Embarcação de grande porte e casco robusto, pilar da Rota do Cabo para a Índia.                                                                                                         
* [Caravela](https://en.wikipedia.org/wiki/Caravel): Navio de exploração ágil com velas latinas, célebre pela capacidade de bolinar (navegar contra o vento).                                                                         
* [Barca](https://en.wikipedia.org/wiki/Barge): Pequena embarcação costeira utilizada em missões de reconhecimento e apoio logístico.                                                                                                   
