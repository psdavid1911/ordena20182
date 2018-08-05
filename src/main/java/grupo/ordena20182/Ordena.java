package grupo.ordena20182;

public class Ordena{

    public static Lista<Integer> bubbleSort(Lista<Integer> elementos){
        for(Integer e:elementos)
            for(int j=0;j<elementos.size()-1;j++)
                if(elementos.get(j)>elementos.get(j+1))
                    elementos.trocaElementos(j,j+1);
        return elementos;
    }

    public static Lista<Integer> selectionSort(Lista<Integer> elementos){
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
