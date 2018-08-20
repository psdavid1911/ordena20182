package Ordenacao;

import Base.Lista;

public class Selecao{

    public static <T extends Comparable<T>> void ordena(Lista<T> elementos){
        for(int fixo=0; fixo<elementos.size()-1; fixo++){
            int menor=fixo;
            for(int i=menor+1; i<elementos.size(); i++)
                if(elementos.get(i).compareTo(elementos.get(menor))<0)menor=i;
            if(menor!=fixo)elementos.trocaElementos(fixo, menor);
        }
    }
}
