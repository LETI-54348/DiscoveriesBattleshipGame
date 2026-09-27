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

## Regras do Jogo

O Discoveries Battleship Game é jogado por dois jogadores, cada um com uma grelha de 10x10.

### Preparação

1. Cada jogador possui uma frota constituída por:
   - 1 Galeão, com 5 posições;
   - 1 Fragata, com 4 posições;
   - 2 Naus, com 3 posições cada;
   - 3 Caravelas, com 2 posições cada;
   - 4 Barcas, com 1 posição cada.

2. Antes do início do jogo, cada jogador posiciona todos os seus navios na sua grelha.

3. Os navios podem ser colocados na horizontal ou na vertical.

4. Os navios não se podem sobrepor nem tocar entre si.

5. Os navios podem ficar encostados aos limites da grelha.

6. A posição da frota de cada jogador permanece escondida do adversário.

### Desenvolvimento do jogo

1. Os jogadores jogam alternadamente.

2. Em cada turno, o jogador realiza uma rajada de três tiros, indicando três coordenadas da grelha adversária.

3. Depois da rajada, o adversário informa o resultado de cada tiro, indicando se:
   - o tiro acertou num navio;
   - o tiro atingiu a água;
   - um navio foi afundado.

4. Quando existe um acerto, deve ser identificado o tipo de navio atingido.

5. Cada jogador regista na grelha do adversário os resultados dos tiros realizados.

6. Os navios adversários completamente atingidos são identificados como afundados.

### Objetivo

O objetivo do jogo é localizar e afundar toda a frota adversária.

Vence o primeiro jogador que conseguir atingir todos os navios do adversário.
