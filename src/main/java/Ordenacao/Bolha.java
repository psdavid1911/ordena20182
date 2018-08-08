package Ordenacao;
import Base.Lista;

public class Bolha{

    public static Lista<Integer> ordena(Lista<Integer> elementos){
        for(Integer e:elementos)
            for(int j=0;j<elementos.size()-1;j++)
                if(elementos.get(j)>elementos.get(j+1))
                    elementos.trocaElementos(j,j+1);
        return elementos;
    }
}
