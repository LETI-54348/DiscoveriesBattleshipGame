# Experiências com Git
 
## Git Stash
Foi utilizada a funcionalidade Git Stash através do IntelliJ IDEA
para guardar temporariamente alterações locais ainda não submetidas.
 
### Procedimento realizado
 
1. Foi realizada uma alteração local num ficheiro do projeto, sem efetuar commit.
2. Foi utilizada a opção **Stash Changes** do IntelliJ IDEA.
3. O stash foi criado com a mensagem `Experiência Git Stash - Ficha Laboratorial 1`.
4. Foi verificado que as alterações ficaram temporariamente guardadas no stash.
5. Foi utilizada a operação **Pop** para recuperar as alterações.
6. Após o Pop, foi confirmado que os ficheiros modificados voltaram à lista de alterações locais.
 
Esta experiência permitiu verificar que o Git Stash permite guardar
   temporariamente trabalho ainda não submetido e recuperá-lo posteriormente.

## Git Rebase
Durante o envio das alterações para o repositório remoto, o Push foi
rejeitado porque a branch remota `origin/54348` continha alterações que
ainda não estavam integradas na branch local.
 
Foi utilizada a opção **Rebase** do IntelliJ IDEA para atualizar a branch
local, reaplicando os commits locais sobre o estado mais recente da branch
remota.
 
Após a conclusão do rebase, o Push foi realizado com sucesso para
`origin/54348`.
 
Esta experiência permitiu observar, na prática, a utilização de rebase
para integrar alterações remotas antes de efetuar um Push.
## Merge Conflict

Foi realizada uma experiência de conflito de merge através de duas
branches criadas a partir da mesma versão do projeto.

As branches `54348-conflict` e `54348-conflict-b` alteraram de forma
diferente a mesma linha do ficheiro `merge-conflict-demo.txt`.

Na branch `54348-conflict`, a estratégia foi definida como "aleatória",
enquanto na branch `54348-conflict-b` foi definida como "orientada".

Ao realizar o merge da branch `54348-conflict` na branch
`54348-conflict-b`, o Git identificou um conflito que não podia ser
resolvido automaticamente.

O conflito foi resolvido manualmente através da ferramenta gráfica de
resolução de conflitos do IntelliJ IDEA, analisando ambas as alterações
e definindo como resultado final:

`Estratégia de disparo: aleatória ou orientada`

Após a resolução, o merge foi concluído com sucesso.