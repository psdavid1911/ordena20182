package testesEficiencia;
import Base.Aleatorio;
import Base.Grafico;
import Base.Lista;
import Base.Par;
import Base.Serie;
import Ordenacao.Bolha;
import Ordenacao.Insercao;
import java.util.ArrayList;
import org.junit.Test;

public class Teste_eficiencia_insercao_pior{

    @Test public void teste_eficiencia_insercao(){
        Lista<Integer> tamanhos=new Lista<>(1,10,100,1000,10000,20000,30000,60000);
        Lista<Lista<Integer>> listas=new Lista<>();
        ArrayList<Par<Integer,Long>> pares=new ArrayList<>();
        for(Integer t:tamanhos) listas.add(Aleatorio.novaListaPiorCaso(t,10));
        for(int i=0;i<listas.size();i++) {
            Long temp=System.currentTimeMillis();
            listas.set(i,Insercao.ordena(listas.get(i)));
            pares.add(new Par(tamanhos.get(i),System.currentTimeMillis()-temp));
        }
        new Grafico<>(
                new Serie("Tempos(ms)",pares),
                "Grafico Metodo Insercao Pior Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "insercao_p_caso",
                800,
                600
        );
    }
}
