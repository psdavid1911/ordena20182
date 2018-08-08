package testesDeUnidade;
import Base.Aleatorio;
import Base.Lista;
import Ordenacao.Bolha;
import org.junit.Test;

public class Teste_unidade_bolha{

    @Test public void bubble(){
        Lista<Integer> l=Aleatorio.novaLista(50,-99,99);
        l.imprime();
        l=Bolha.ordena(l);
        l.imprime();
    }
}
