package testesDeUnidade;

import Base.Aleatorio;
import Base.Lista;
import Ordenacao.Balde;
import org.junit.Test;

public class Teste_unidade_balde{

    @Test public void balde(){
        Lista<Integer> l=Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Balde.ordena(l);
        l.imprime();
    }
}
