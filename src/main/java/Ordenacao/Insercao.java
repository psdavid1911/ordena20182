package Ordenacao;
import Base.Lista;

public class Insercao{

    public static Lista<Integer> ordena(Lista<Integer> lista){
        for(int i=0;i<lista.size();i++) {
            int a=lista.get(i);
            for(int j=i-1;j>=0&&lista.get(j)>a;j--) {
                lista.set(j+1,lista.get(j));
                lista.set(j,a);
            }
        }
        return lista;
    }
}
