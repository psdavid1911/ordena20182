package Base;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.Arrays.asList;

/**
 * Cuidado, podem haver elementos duplicados em uma Dica, pode realizar
 * operações em sublistas, tais como remover todos os elementos do interior
 *
 * @author david
 * @param <T>
 */
public class Lista<T extends Comparable<T>> extends ArrayList<T> implements Iterable<T>, Comparable<Lista<T>>{

    public Lista(T... elementos){
        super(asList(elementos));
    }

    public Lista(List<T> lista){
        super(lista);
    }

    public Lista(){
        super();
    }

    public void adiciona(T elemento){
        add(elemento);
    }

    /**
     * Uma colecao se refere à todos aquelas classes e abstrações em java que
     * pertencem à Collections, ver hieraquia na documentação do java.
     *
     * @param colecao
     */
    public void adicionaTodos(Collection<T> colecao){
        addAll(colecao);
    }

    @Override
    public int compareTo(Lista<T> o){
        return this.toString().compareTo(o.toString());
    }

    public boolean contem(T elemento){
        return contains(elemento);
    }

    /**
     * Uma colecao se refere à todos aquelas classes e abstrações em java que
     * pertencem à Collections, ver hieraquia na documentação do java.
     *
     * @param colecao
     * @return
     */
    public boolean contemTodos(Collection<T> colecao){
        return containsAll(colecao);
    }

    /**
     * Exemplo de uso: listaQualquer.embaralha(new Random());
     *
     * @param valorAleatorio
     */
    public void embaralha(Random valorAleatorio){
        for(int i=size(); i>1; i--)
            trocaElementos(i-1, valorAleatorio.nextInt(i));
    }

    public Stream<T> filtro(Predicate<T> predicado){
        return stream().filter(predicado);
    }

    public Stream<T> fluxo(){
        return this.stream();
    }

    public void imprime(){
        System.out.println(toString());
    }

    public int indiceDaUltimaOcorrencia(T elemento){
        return lastIndexOf(elemento);
    }

    public int indiceDoElemento(T elemento){
        return indexOf(elemento);
    }

    public void inverte(){
    }

    public void limpa(){
        clear();
    }

    public void ordena(){
        sort(null);
    }

    public void ordena(Comparator comparador){
        Collections.sort(this, comparador);
    }

    public List original(){
        return this;
    }

    public void paraCada(Consumer<? super T> expressaoLambda){
        forEach(expressaoLambda);
    }

    public T pega(int posicao){
        return get(posicao);
    }

    /**
     * Criada por mim e pode ser melhorada.
     *
     * @param elemento
     *
     * @return
     */
    public T pega(T elemento){
        return get(indiceDoElemento(elemento));
    }

    public T pegaAleatorio(){
        return pega((new Random()).nextInt(tamanho()));
    }

    public void preenche(){
    }

    /**
     * Uma colecao se refere à todos aquelas classes e abstrações em java que
     * pertencem à Collections, ver hieraquia na documentação do java.
     *
     * @param colecao
     */
    public void removeTodos(Collection<T> colecao){
        removeAll(colecao);
    }

    public Lista<T> subLista(int posicaoInicial, int posicaoFinal){
        return new Lista<T>(subList(posicaoInicial, posicaoFinal));
    }

    public Lista<T> sublista(Predicate<T> expressaoLambda){
        return new Lista(filtro(expressaoLambda).collect(Collectors.toList()));
    }

    public T subtraiElemento(int indice){
        return remove(indice);
    }

    /**
     * Também chamado de cardinalidade.
     *
     * @return
     */
    public int tamanho(){
        return size();
    }

    /**
     * Muda elementos de posicao
     *
     * @param posicao1
     * @param posicao2
     */
    public void trocaElementos(int posicao1, int posicao2){
        T tmp=get(posicao1);
        set(posicao1, get(posicao2));
        set(posicao2, tmp);
    }

    /**
     * Muda elementos de posição. Cuidado ao usar esta opcao, lembre-se de que
     * os elementos de uma lista podem se repetir, nesse caso ele o usa a
     * primeira ocorrência como referência.
     *
     * @param elemento1
     * @param elemento2
     */
    public void trocaElementos(T elemento1, T elemento2){
        trocaElementos(indiceDoElemento(elemento1), indiceDoElemento(elemento2));
    }

    public boolean vazio(){
        return isEmpty();
    }
}
