package Base;
import java.util.Random;

public class Aleatorio{

    /**
     * Função que gera um número aleatório partindo de 0 até o valor máximo
     * indormado.
     *
     * @param valorMinimo - Limite inferior do numero aleatório
     * @param valorMaximo - Limite superior do numero aleatório
     * @return - O número gerado
     */
    public static int novoNumero(int valorMinimo,int valorMaximo){
        return new Random().nextInt((valorMaximo-valorMinimo)+1)+valorMinimo;
    }

    /**
     * Cria uma lista preenchida com números aleatórios
     *
     * @param tamanhoDaLista - Quantidade de elementos que a lista deve conter
     * @param valorMinimo - Limite inferior do numero aleatório
     * @param valorMaximo - Limite superior do numero aleatório
     * @return - Uma lista com tamanho informado, preenchida com numeros
     * aleatórios de 0 até o número informado
     */
    public static Lista<Integer> novaLista(int tamanhoDaLista,int valorMinimo,int valorMaximo){
        Lista<Integer> lista=new Lista<Integer>();
        for(int i=0;i<tamanhoDaLista;i++) lista.add(novoNumero(valorMinimo,valorMaximo));
        return lista;
    }

    public static Lista<Integer> novaListaPiorCaso(int tamanhoDaLista,int valorMaximo){
        Lista<Integer> lista=new Lista<Integer>();
        for(int i=0;i<tamanhoDaLista;i++) lista.add(--valorMaximo);
        return lista;
    }
}
