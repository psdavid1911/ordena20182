package grupo.ordena20182;
import org.junit.Test;

public class AleatorioTest{

    @Test public void testTempos(){
        Lista<Lista<Integer>> listas=new Lista<>(); // nunca sera usado
        Lista<Integer> tamanhos=new Lista<>(1000,10000,20000,30000,40000,50000,60000,70000,80000,90000,100000);
        Lista<Par<Integer,Long>> pares=new Lista<>();
        for(Integer tamanho:tamanhos) {
            Long temp=System.nanoTime();
            listas.add(Aleatorio.novaLista(1000,-10,10));
            pares.adiciona(new Par(tamanho,System.nanoTime()-temp));
        }
        GraficoDeLinha<Integer,Long> grafico=new GraficoDeLinha<>();
        grafico.adicionaConjuntoDeDados(pares,"Tempos de construção em nanossegundos");
        grafico.criaGrafico("Tamanho das listas","Tempos(ns)","GraficoDeTempos");
    }

    @Test public void bubble(){
        Lista<Integer> l=Aleatorio.novaLista(50,-99,99);
        l.imprime();
        l=Ordena.bubbleSort(l);
        l.imprime();
    }

    @Test public void selection(){
        Lista<Integer> l=Aleatorio.novaLista(50,-99,99);
        l.imprime();
        l=Ordena.selectionSort(l);
        l.imprime();
    }

    @Test public void testBubble(){
        Lista<Lista<Integer>> listas=new Lista<>(); // nunca sera usado
        Lista<Integer> tamanhos=new Lista<>(1000,10000,20000,30000,40000,50000,60000,70000,80000,90000,100000);
        Lista<Par<Integer,Long>> pares=new Lista<>();
        for(Integer t:tamanhos)
            listas.add(Aleatorio.novaLista(1000,-10,10));
        for(int i=0;i<listas.size();i++) {
            Long temp=System.nanoTime();
            listas.set(i,Ordena.bubbleSort(listas.get(i)));
            pares.adiciona(new Par(tamanhos.get(i),System.nanoTime()-temp));
        }
        GraficoDeLinha<Integer,Long> grafico=new GraficoDeLinha<>();
        grafico.adicionaConjuntoDeDados(pares,"Tempos de construção em nanossegundos");
        grafico.criaGrafico("Tamanho das listas","Tempos(ns)","GraficoBubbleSort");
    }

    @Test public void testSelection(){
        Lista<Lista<Integer>> listas=new Lista<>(); // nunca sera usado
        Lista<Integer> tamanhos=new Lista<>(1000,10000,20000,30000,40000,50000,60000,70000,80000,90000,100000);
        Lista<Par<Integer,Long>> pares=new Lista<>();
        for(Integer t:tamanhos)
            listas.add(Aleatorio.novaLista(1000,-10,10));
        for(int i=0;i<listas.size();i++) {
            Long temp=System.nanoTime();
            listas.set(i,Ordena.selectionSort(listas.get(i)));
            pares.adiciona(new Par(tamanhos.get(i),System.nanoTime()-temp));
        }
        GraficoDeLinha<Integer,Long> grafico=new GraficoDeLinha<>();
        grafico.adicionaConjuntoDeDados(pares,"Tempos de construção em nanossegundos");
        grafico.criaGrafico("Tamanho das listas","Tempos(ns)","GraficoSelectionSort");
    }
}
