package Ordenacao;

import Base.Lista;

public class Contagem{

    public static void ordena(Lista<Integer> lista){
        int maior=lista.valorMaximo();
        Lista<Integer> c=new Lista<>();
        for(int i=0; i<maior; i++)c.add(0);
        for(int i=0; i<lista.size(); i++)
            c.set(lista.get(i)-1, c.get(lista.get(i)-1)+1);
        for(int i=1; i<maior; i++)
            c.set(i, c.get(i)+c.get(i-1));
        Lista<Integer> b=new Lista<>();
        for(Integer l:lista)b.add(0);
        for(int i=0; i<b.size(); i++){
            b.set(c.get(lista.get(i)-1)-1, lista.get(i));
            c.set(lista.get(i)-1, c.get(lista.get(i)-1)-1);
        }
        for(int i=0; i<b.size(); i++)
            lista.set(i, b.get(i));
    }
}
