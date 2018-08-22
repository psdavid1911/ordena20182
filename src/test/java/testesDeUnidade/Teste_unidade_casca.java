package testesDeUnidade;

import Base.Aleatorio;
import Base.Lista;
import Ordenacao.Bolha;
import Ordenacao.Casca;
import org.junit.Test;

public class Teste_unidade_casca {

    @Test
    public void casca() {
        Lista<Integer> l = Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Casca.ordena(l);
        l.imprime();
    }
}
