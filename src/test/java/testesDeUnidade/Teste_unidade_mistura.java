package testesDeUnidade;

import Base.Aleatorio;
import Base.Lista;
import Ordenacao.Mistura;
import org.junit.Test;

public class Teste_unidade_mistura{

    @Test public void mistura(){
        Lista<Integer> l=Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Mistura.ordena(l);
        l.imprime();
    }
}
