package testesDeUnidade;

import Base.Aleatorio;
import Base.Lista;
import Ordenacao.Raiz;
import org.junit.Test;

public class Teste_unidade_raiz{

    @Test public void raiz(){
        Lista<Integer> l=Aleatorio.novaLista(50, 0, 99);
        l.imprime();
        Raiz.ordena(l);
        l.imprime();
    }
}
