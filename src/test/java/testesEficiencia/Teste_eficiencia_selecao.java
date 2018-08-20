package testesEficiencia;

import Base.Aleatorio;
import Base.Grafico;
import Base.Lista;
import Base.Par;
import Base.Serie;
import Ordenacao.Selecao;
import java.util.ArrayList;
import org.junit.Test;

public class Teste_eficiencia_selecao{

    @Test public void testSelection(){
        Lista<Lista<Integer>> listas=new Lista<>(); // nunca sera usado
        Lista<Integer> tamanhos=new Lista<>(1, 10, 100, 1000, 10000, 20000, 30000, 60000);
        ArrayList<Par<Integer, Long>> pares=new ArrayList<>();
        for(Integer t:tamanhos)
            listas.add(Aleatorio.novaLista(t, -10, 10));
        for(int i=0; i<listas.size(); i++){
            Long temp=System.currentTimeMillis();
            Selecao.ordena(listas.get(i));
            pares.add(new Par(tamanhos.get(i), System.currentTimeMillis()-temp));
        }
        Grafico.criaGrafico(
                new Serie("Tempos(ms)", pares),
                "Grafico Metodo Selecao Melhor Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "graficos/selecao_m_caso",
                800,
                600
        );
    }
}
