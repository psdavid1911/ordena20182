package Ordenacao;

import Base.Lista;

public class Pilha{

    public static void ordena(Lista<Integer> vetor){
        int tamanhoDoVetor=vetor.size();
        for(int i=tamanhoDoVetor/2-1; i>=0; i--)
            organizador(vetor, tamanhoDoVetor, i);
        for(int i=tamanhoDoVetor-1; i>=0; i--){
            vetor.trocaElementos(0, i);
            organizador(vetor, i, 0);
        }
    }

    public static void organizador(Lista<Integer> vetor, int n, int i){
        int maior=i;
        int esquerda=2*i+1;
        int direita=2*i+2;
        if(esquerda<n&&vetor.get(esquerda)>vetor.get(maior))
            maior=esquerda;
        if(direita<n&&vetor.get(direita)>vetor.get(maior))
            maior=direita;
        if(maior!=i){
            vetor.trocaElementos(i, maior);
            organizador(vetor, n, maior);
        }
    }
}
