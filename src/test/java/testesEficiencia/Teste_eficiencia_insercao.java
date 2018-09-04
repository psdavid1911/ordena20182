package testesEficiencia;

import Base.Aleatorio;
import Base.Grafico;
import Base.Lista;
import Base.Par;
import Base.Serie;
import Ordenacao.Insercao;
import java.util.ArrayList;
import org.junit.Test;

public class Teste_eficiencia_insercao{

    @Test public void testSelection(){
        Lista<Lista<Integer>> listas=new Lista<>(); // nunca sera usado
        Lista<Integer> tamanhos=new Lista<>(1000, 10000, 20000, 30000, 60000, 70000, 80000, 90000, 100000);
        ArrayList<Par<Integer, Long>> pares=new ArrayList<>();
        for(Integer t:tamanhos)
            listas.add(Aleatorio.novaLista(t, -10, 10));
        for(int i=0; i<listas.size(); i++){
            Long temp=System.currentTimeMillis();
            Insercao.ordena(listas.get(i));
            pares.add(new Par(tamanhos.get(i), System.currentTimeMillis()-temp));
        }
        Grafico.criaGrafico(
                new Serie("Tempos(ms)", pares),
                "Grafico Metodo Insercao Melhor Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "graficos/insercao_m_caso",
                800,
                600
        );
    }
}
