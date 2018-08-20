package testesDeUnidade;

import Base.Aleatorio;
import Base.Lista;
import Ordenacao.Selecao;
import org.junit.Test;

public class Teste_unidade_selecao{

    @Test public void selecao(){
        Lista<Integer> l=Aleatorio.novaLista(50, -99, 99);
        l.imprime();
        Selecao.ordena(l);
        l.imprime();
    }
}
