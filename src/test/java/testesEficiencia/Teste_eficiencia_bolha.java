package testesEficiencia;
import Base.Aleatorio;
import Base.Grafico;
import Base.Lista;
import Base.Par;
import Base.Serie;
import Ordenacao.Bolha;
import java.util.ArrayList;
import org.junit.Test;

public class Teste_eficiencia_bolha{

    @Test public void teste_eficiencia_bolha(){
        Lista<Integer> tamanhos=new Lista<>(1,10,100,1000,10000,20000,30000);
        Lista<Lista<Integer>> listasDesordenadas=new Lista<>();
        ArrayList<Par<Integer,Long>> pares=new ArrayList<>();
        for(Integer t:tamanhos) listasDesordenadas.add(Aleatorio.novaLista(t,-10,10));
        for(int i=0;i<listasDesordenadas.size();i++) {
            Long temp=System.currentTimeMillis();
            listasDesordenadas.set(i,Bolha.ordena(listasDesordenadas.get(i)));
            pares.add(new Par(tamanhos.get(i),System.currentTimeMillis()-temp));
        }
        new Grafico<>(
                new Serie("Tempos(ms)",pares),
                "Grafico Metodo Bolha Melhor Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "Grafico Metodo Bolha Melhor Caso",
                800,
                600
        );
    }
}
