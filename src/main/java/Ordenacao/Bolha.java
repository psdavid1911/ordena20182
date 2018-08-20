package Ordenacao;

import Base.Lista;

public class Bolha{

    public static <T extends Comparable<T>> void ordena(Lista<T> elementos){
        for(T e:elementos)
            for(int j=0; j<elementos.size()-1; j++)
                if(elementos.get(j).compareTo(elementos.get(j+1))>0) // Uma forma de testar se o primeiro valor é maior que o segundo
                    elementos.trocaElementos(j, j+1);
    }
}
