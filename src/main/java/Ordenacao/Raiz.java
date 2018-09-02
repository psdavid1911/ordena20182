package Ordenacao;

import Base.Lista;
import java.util.TreeMap;

public class Raiz{

    public static void ordena(Lista<Integer> entrada){
        for(Integer numero:entrada)
            if(numero<0)
                throw new Error("Lista contem elementos negativos");
        TreeMap<Integer, Lista<Integer>> balde=new TreeMap<>();
        for(int i=0; i<entrada.maiorLargura(); i++){
            for(Integer elemento:entrada){
                char[] digitos=elemento.toString().toCharArray();
                int indiceDoDigitoAtual=digitos.length-1-i;
                Integer categoriaDoElemento=indiceDoDigitoAtual<0?0:(int)digitos[indiceDoDigitoAtual]; // 1 = primeiro elemento da tabela unicode ?
                if(balde.containsKey(categoriaDoElemento)){
                    Lista<Integer> auxiliar=balde.get(categoriaDoElemento);
                    auxiliar.add(elemento);
                    balde.put(categoriaDoElemento, new Lista<Integer>(auxiliar));
                }else balde.put(categoriaDoElemento, new Lista<Integer>(elemento));
            }
            Lista<Integer> elementosOrdenados=new Lista<Integer>();
            for(Lista<Integer> elementosDaCategoria:balde.values())
                elementosOrdenados.addAll(elementosDaCategoria);
            entrada.clear();
            balde.clear();
            entrada.addAll(elementosOrdenados);
        }
    }
}
