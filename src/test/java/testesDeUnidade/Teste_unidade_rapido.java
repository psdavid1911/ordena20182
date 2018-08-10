package testesDeUnidade;
import Base.Aleatorio;
import Base.Lista;
import Ordenacao.Rapido;
import org.junit.Test;

public class Teste_unidade_rapido{

    @Test public void rapido(){
        Lista<Integer> l=Aleatorio.novaLista(50,-99,99);
        l.imprime();
        Rapido.ordena(l,0,l.tamanho()-1);
        l.imprime();
    }
}
