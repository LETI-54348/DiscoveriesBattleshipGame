# Battleship

Basic academic version of Battleship game to build upon.

### Grupo: `Ninjas`

| Curso | Número | Nome |
|---|---:|---|
| LETI | **54348** | Juliana Prado |
| LETI | **98898** | Luís Prado |
| DSA | **130768** | Simão Sousa |

# Projeto: Batalha Naval dos Descobrimentos

## 📝 Introdução

Este repositório aloja o projeto desenvolvido no âmbito da unidade curricular. O objetivo é implementar um jogo baseado nas dinâmicas de Batalha Naval, contextualizado com a época dos Descobrimentos Portugueses.

Todos os membros da equipa colaboram ativamente na evolução do projeto através da utilização de Git, GitHub, branches, commits, Pull Requests e revisão colaborativa.

---

## 🖼️ Imagem do Projeto

https://upload.wikimedia.org/wikipedia/commons/0/08/Isla_Terceira.jpg

---

## 🎯 Regras do Jogo

O Discoveries Battleship Game é jogado por dois jogadores. Cada jogador dispõe de duas grelhas de 10x10 posições:

- **O seu mar**, onde posiciona a sua frota;
- **O mar do adversário**, onde regista os tiros efetuados e a informação conhecida sobre a frota adversária.

### Preparação

1. Cada jogador possui uma frota constituída por:
   - 1 Galeão, com 5 posições;
   - 1 Fragata, com 4 posições;
   - 2 Naus, com 3 posições cada;
   - 3 Caravelas, com 2 posições cada;
   - 4 Barcas, com 1 posição cada.

2. Antes do início do jogo, cada jogador posiciona todos os navios na sua grelha.

3. Os navios podem ser colocados na horizontal ou na vertical.

4. Os navios não se podem sobrepor nem tocar entre si.

5. Os navios podem ficar encostados aos limites da grelha.

6. A posição da frota de cada jogador permanece escondida do adversário.

### Desenvolvimento do Jogo

1. Os jogadores jogam alternadamente.

2. Em cada turno, o jogador realiza uma rajada de três tiros, indicando três coordenadas `(linha, coluna)` da grelha adversária.

3. Depois da rajada, o adversário informa o resultado de cada tiro, que pode ser:
   - **Água**: o tiro não atingiu qualquer embarcação;
   - **Tiro certeiro**: o tiro atingiu um navio, sendo indicado o tipo de navio atingido;
   - **Afundado**: todas as posições do navio foram atingidas.

4. Cada jogador regista na grelha do adversário os resultados dos tiros realizados.

5. Os navios adversários completamente atingidos são identificados como afundados.

### Objetivo

O objetivo do jogo é localizar e afundar toda a frota adversária.

Vence o primeiro jogador que conseguir atingir todos os navios da frota adversária.

---

## 🚢 Frota dos Descobrimentos

| Batalha Naval | Descobrimentos | English | Dimensão | # Navios |
|---|---|---|---:|---:|
| Porta-aviões | Galeão | Galleon | 5 | 1 |
| Navio de 4 canhões | Fragata | Frigate | 4 | 1 |
| Navio de 3 canhões | Nau | Carrack | 3 | 2 |
| Navio de 2 canhões | Caravela | Caravel | 2 | 3 |
| Submarino | Barca | Barge | 1 | 4 |

---

## 📜 Contexto Histórico: A Era dos Descobrimentos

O projeto transporta o clássico jogo de Batalha Naval para o período da expansão marítima portuguesa e dos confrontos navais no Atlântico, como a Batalha de Vila Franca do Campo, travada nos Açores em 1582.

As embarcações utilizadas no jogo refletem navios associados a este contexto histórico:

- https://en.wikipedia.org/wiki/Galleon: embarcação de grande porte utilizada, entre outras funções, em operações de defesa e transporte;
- https://en.wikipedia.org/wiki/Frigate: embarcação de guerra caracterizada pela sua utilização em missões de combate e patrulha;
- https://en.wikipedia.org/wiki/Carrack: embarcação de grande porte utilizada nas viagens oceânicas;
- https://en.wikipedia.org/wiki/Caravel: embarcação particularmente associada à exploração marítima portuguesa;
- https://en.wikipedia.org/wiki/Barge: embarcação de menores dimensões utilizada para transporte e apoio.

Mais informação:
https://en.wikipedia.org/wiki/Battle_of_Vila_Franca_do_Campo

