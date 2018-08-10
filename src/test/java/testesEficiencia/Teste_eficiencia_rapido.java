package testesEficiencia;
import Base.Aleatorio;
import Base.Grafico;
import Base.Lista;
import Base.Par;
import Base.Serie;
import Ordenacao.Bolha;
import Ordenacao.Rapido;
import java.util.ArrayList;
import org.junit.Test;

public class Teste_eficiencia_rapido{

    @Test public void teste_eficiencia_rapido(){
        Lista<Integer> tamanhos=new Lista<>(1,10,100,1000,10000,20000,30000);
        Lista<Lista<Integer>> listasDesordenadas=new Lista<>();
        ArrayList<Par<Integer,Long>> pares=new ArrayList<>();
        for(Integer t:tamanhos) listasDesordenadas.add(Aleatorio.novaLista(t,-10,10));
        for(int i=0;i<listasDesordenadas.size();i++) {
            Long temp=System.currentTimeMillis();
            listasDesordenadas.set(i,Rapido.ordena(listasDesordenadas.get(i),0,listasDesordenadas.get(i).tamanho()-1));
            pares.add(new Par(tamanhos.get(i),System.currentTimeMillis()-temp));
        }
        new Grafico<>(
                new Serie("Tempos(ms)",pares),
                "Grafico Metodo Rapido Melhor Caso",
                "Tamanho das listas",
                "Tempos de construção em milissegundos",
                "rapido_m_caso",
                800,
                600
        );
    }
}
