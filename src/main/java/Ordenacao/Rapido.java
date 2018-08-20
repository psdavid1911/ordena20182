package Ordenacao;

import Base.Lista;

public class Rapido{

    public static <T extends Comparable<T>> void ordena(Lista<T> vetor){
        rapido(vetor, 0, vetor.size()-1);
    }

    private static <T extends Comparable<T>> void rapido(Lista<T> vetor, int menor, int maior){
        if(vetor==null||vetor.isEmpty())return;
        if(menor>=maior)return;
        int meio=menor+(maior-menor)/2;
        T pivo=vetor.get(meio);
        int i=menor, j=maior;
        while(i<=j){
            while(vetor.get(i).compareTo(pivo)<0)i++;
            while(vetor.get(j).compareTo(pivo)>0)j--;
            if(i<=j)vetor.trocaElementos(i++, j--);
        }
        if(menor<j)rapido(vetor, menor, j);
        if(maior>i)rapido(vetor, i, maior);
    }
}
