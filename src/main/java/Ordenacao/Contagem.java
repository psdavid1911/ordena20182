package Ordenacao;

import Base.Lista;

public class Contagem{

    public static void ordena(Lista<Integer> lista){
        int menor=lista.valorMinimo();
        int maior=lista.valorMaximo();
        int[] counts=new int[maior-menor+1];
        for(int x:lista)counts[x-menor]++;
        for(int i=0, current=0; i<counts.length; i++){
            lista.preecher(current, current+counts[i], i+menor);
            current+=counts[i];
        }
    }
}
