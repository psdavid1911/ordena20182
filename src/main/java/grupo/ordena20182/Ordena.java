/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo.ordena20182;

/**
 *
 * @author psdav
 */
public class Ordena{

    public static Lista<Integer> bubbleSort(Lista<Integer> vetor){
        for(int i=0;i<vetor.size();i++)
            for(int j=0;j<vetor.size()-1;j++)
                if(vetor.get(j)>vetor.get(j+1)){
                    int aux=vetor.get(j);
                    vetor.set(j,vetor.get(j+1));
                    vetor.set(j+1,aux);
                }
        return vetor;
    }

    public static Lista<Integer> selectionSort(Lista<Integer> lista){
        for(int fixo=0;fixo<lista.size()-1;fixo++) {
            int menor=fixo;

            for(int i=menor+1;i<lista.size();i++)
                if(lista.get(i)<lista.get(menor))
                    menor=i;
            if(menor!=fixo){
                int t=lista.get(fixo);
                lista.set(fixo,lista.get(menor));
                lista.set(menor,t);
            }
        }
        return lista;
    }
}
