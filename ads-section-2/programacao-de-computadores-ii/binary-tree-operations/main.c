#include <stdio.h>
#include <stdlib.h>

#include "main.h"

#include "inserir-direita.h"
#include "inserir-esquera.h"
#include "inserir.h"
#include "inserir-recursive.h"
#include "imprimir.h"
#include "buscar.h"
#include "remover.h"
#include "tamanho.h"

int main() {
    int op, valor;
    ArvB arv;
    arv.raiz = NULL;

    No *raiz = NULL;

    do {
        printf("\n0 - sair\n1 - inserir\n2 - imprimir\n3 - Buscar\n4 - Remover\n");
        scanf("%d", &op);

        switch(op) {
        case 0:
            printf("\nSaindo...\n");
            break;
        case 1:
            printf("Digite um valor: ");
            scanf("%d", &valor);
            raiz = inserirNovaVersao(raiz, valor);// não precisa da estrutura ArvB
            //inserir(&arv, valor);// para utilizar esta inserção, comente a anterior
            break;
        case 2:
            printf("\nImpressao da arvore binaria:\n");
            imprimir(raiz);
            printf("\n");
            printf("Tamanho: %d\n", tamanho(raiz));
            break;
        case 3:
            printf("Qual valor deseja buscar? ");
            scanf("%d", &valor);
            printf("Resultado da busca: %d\n", buscar(raiz, valor));
            break;
        case 4:
            printf("Digite um valor a ser removido: ");
            scanf("%d", &valor);
            raiz = remover(raiz, valor);
            break;
        default:
            printf("\nOpcao invalida...\n");
        }
    } while(op != 0);
}