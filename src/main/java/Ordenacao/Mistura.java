package Ordenacao;

import Base.Lista;

public class Mistura{

    public static <T extends Comparable<T>> void ordena(Lista<T> lista){
        if(lista.size()>1){
            int meio=lista.size()/2;
            Lista<T> listaDaEsquerda=lista.subLista(0, meio);
            Lista<T> listaDaDireita=lista.subLista(meio, lista.size());
            ordena(listaDaEsquerda);
            ordena(listaDaDireita);
            int i=0, j=0, k=0;
            while(i<listaDaEsquerda.size()&&j<listaDaDireita.size()){
                if(listaDaEsquerda.get(i).compareTo(listaDaDireita.get(j))<0)
                    lista.set(k, listaDaEsquerda.get(i++));
                else
                    lista.set(k, listaDaDireita.get(j++));
                k+=1;
            }
            while(i<listaDaEsquerda.size())
                lista.set(k++, listaDaEsquerda.get(i++));
            while(j<listaDaDireita.size())
                lista.set(k++, listaDaDireita.get(j++));
        }
    }
}
