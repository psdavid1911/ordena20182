package Ordenacao;

import Base.Lista;
import java.util.TreeMap;

public class Balde{

    public static <T extends Comparable<T>> void ordena(Lista<T> entrada){
        int nivel =0;
        TreeMap<Integer, Lista<T>> balde= new TreeMap<>();
        for(T elemento:entrada){
            Integer valorDoChar = (int)(elemento.toString().charAt(nivel));
            if(balde.containsKey(valorDoChar)){
                Lista<T> auxiliar = balde.get(valorDoChar);
                auxiliar.add(elemento);
                balde.put(valorDoChar, new Lista<T>(auxiliar));
            }
            else balde.put(valorDoChar, new Lista<T>(elemento));
        }
        Lista<T> elementosOrdenados = new Lista<T>();
        for(Lista<T> elementosDaCategoria: balde.values()){
            elementosDaCategoria.ordena();
            elementosOrdenados.addAll(elementosDaCategoria);
        }
        entrada.clear();
        entrada.addAll(elementosOrdenados);
    }
}
