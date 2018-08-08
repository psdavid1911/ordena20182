package Ordenacao;
import Base.Lista;

public class Selecao{

    public static Lista<Integer> ordena(Lista<Integer> elementos){
        for(int fixo=0;fixo<elementos.size()-1;fixo++) {
            int menor=fixo;
            for(int i=menor+1;i<elementos.size();i++)
                if(elementos.get(i)<elementos.get(menor))
                    menor=i;
            if(menor!=fixo)
                elementos.trocaElementos(fixo,menor);
        }
        return elementos;
    }
}
