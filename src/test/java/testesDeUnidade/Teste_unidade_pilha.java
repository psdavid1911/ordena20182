package testesDeUnidade;

import Base.Aleatorio;
import Base.Lista;
import Ordenacao.Pilha;
import org.junit.Test;

public class Teste_unidade_pilha{

    @Test public void pilha(){
        Lista<Integer> l=Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Pilha.ordena(l);
        l.imprime();
    }
}
