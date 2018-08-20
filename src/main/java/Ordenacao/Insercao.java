package Ordenacao;

import Base.Lista;

public class Insercao{

    public static <T extends Comparable<T>> void ordena(Lista<T> lista){
        for(int i=1, j; i<lista.size(); i++){
            T aux=lista.get(i);
            for(j=i; (j>0)&&(lista.get(j-1).compareTo(aux)>0); j--)
                lista.set(j, lista.get(j-1));
            lista.set(j, aux);
        }
    }
}
