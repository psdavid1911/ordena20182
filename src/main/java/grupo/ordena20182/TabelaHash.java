package grupo.ordena20182;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 *
 * @author david
 * @param <CHAVE>
 * @param <VALOR>
 */
public class TabelaHash<CHAVE,VALOR> extends HashMap<CHAVE,VALOR>{

    public boolean contemValor(VALOR valor){
        return containsValue(valor);
    }

    public boolean contemChave(CHAVE chave){
        return containsKey(chave);
    }

    public boolean vazio(){
        return isEmpty();
    }

    public Set<Entry<CHAVE,VALOR>> conjunto(){
        return entrySet();
    }

    public int tamanho(){
        return size();
    }

    /**
     * Substitui o valor antigo ou retorna nulo se não hover valor antigo.
     *
     * @param chave
     * @param valor
     *
     * @return
     */
    public VALOR adiciona(CHAVE chave,VALOR valor){
        return put(chave,valor);
    }

    public void limpa(){
        clear();
    }

    /**
     * Retorna nulo se nenhum valor for encontrado
     *
     * @param chave
     *
     * @return
     */
    public VALOR pega(CHAVE chave){
        return get(chave);
    }

    public Collection<VALOR> valores(){
        return values();
    }

    public HashMap<CHAVE,VALOR> original(){
        return this;
    }

    public void paraCada(BiConsumer<? super CHAVE,? super VALOR> expressaoLambda){
        forEach(expressaoLambda);
    }

    // Acrescentar para Strings
    // Adicionar para enviar erro;
    /**
     * Cuidado ao executar, verifique se os dados foram REALMENTE inseridos
     *
     * @param chave
     * @param valor
     */
    public void adicionaSomando(CHAVE chave,VALOR valor){
        if(valor instanceof Number){
            // SE FOR INTEIRO
            if(valor.getClass().getName().equals(Double.class.getName())){
                Double valorAnterior=(Double)adiciona(chave,valor);
                if(valorAnterior!=null){
                    Double novoValor=((Number)valor).doubleValue()+valorAnterior;
                    adiciona(chave,(VALOR)novoValor);
                }
            }
            // SE FOR DOUBLE
            if(valor.getClass().getName().equals(Integer.class.getName())){
                Integer valorAnterior=(Integer)adiciona(chave,valor);
                if(valorAnterior!=null){
                    Integer novoValor=((Number)valor).intValue()+valorAnterior;
                    adiciona(chave,(VALOR)novoValor);
                }
            }
        }else
            adiciona(chave,valor);
    }
}
