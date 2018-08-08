package testesEficiencia;
import Base.Aleatorio;
import Base.Grafico;
import Base.Lista;
import Base.Par;
import Ordenacao.Bolha;
import org.junit.Test;

public class Teste_eficiencia_bolha{

    @Test public void teste_eficiencia_bolha(){
        Lista<Integer> tamanhos=new Lista<>(1,10,100,1000,10000,20000,30000);
        Lista<Lista<Integer>> listas=new Lista<>();
        Lista<Par<Integer,Long>> pares=new Lista<>();
        for(Integer t:tamanhos) listas.add(Aleatorio.novaLista(t,-10,10));
        for(int i=0;i<listas.size();i++) {
            Long temp=System.currentTimeMillis();
            listas.set(i,Bolha.ordena(listas.get(i)));
            pares.adiciona(new Par(tamanhos.get(i),System.currentTimeMillis()-temp));
        }
        new Grafico<>(pares,"Tempos de construção em milissegundos","Tamanho das listas","Tempos(ms)","Grafico Metodo Bolha",800,600);
    }
}
