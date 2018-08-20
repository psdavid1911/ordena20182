package testesEficiencia;

import Base.Aleatorio;
import Base.Lista;
import Base.Par;
import Base.Serie;
import Ordenacao.Bolha;
import java.util.ArrayList;
import org.junit.Test;
import static Base.Grafico.criaGrafico;

public class Teste_eficiencia_selecao_pior{

    @Test @SuppressWarnings("unchecked")
    public void teste_eficiencia_selecao(){
        Lista<Integer> tamanhos=new Lista<>(1, 10, 100, 1000, 10000, 20000, 30000, 60000);
        Lista<Lista<Integer>> listas=new Lista<>();
        ArrayList<Par<Integer, Long>> pares=new ArrayList<>();
        for(Integer t:tamanhos)
            listas.add(Aleatorio.novaListaPiorCaso(t, 10));
        for(int i=0; i<listas.size(); i++){
            Long temp=System.currentTimeMillis();
            Bolha.ordena(listas.get(i));
            pares.add(new Par(tamanhos.get(i), System.currentTimeMillis()-temp));
        }
        criaGrafico(
                new Serie("Tempos(ms)", pares),
                "Grafico Selecao Selecao Pior Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "graficos/selecao_p_caso",
                800,
                600
        );
    }
}
