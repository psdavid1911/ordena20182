package Base;

import java.util.ArrayList;

public class Serie<X extends Comparable<X>, Y>{

    private String nomeDaColecao;
    private ArrayList<Par<X, Y>> pares;

    public Serie(String nomeDaColecao){
        this.nomeDaColecao=nomeDaColecao;
        pares=new ArrayList<>();
    }

    public Serie(String nomeDaColecao, ArrayList<Par<X, Y>> pares){
        this.nomeDaColecao=nomeDaColecao;
        this.pares=pares;
    }

    public void adiciona(X x, Y y){
        getPares().add(new Par<X, Y>(x, y));
    }

    public String getNome(){
        return getNomeDaColecao();
    }

    public String getNomeDaColecao(){
        return nomeDaColecao;
    }

    public void setNomeDaColecao(String nomeDaColecao){
        this.nomeDaColecao=nomeDaColecao;
    }

    public ArrayList<Par<X, Y>> getPares(){
        return pares;
    }

    public void setPares(ArrayList<Par<X, Y>> pares){
        this.pares=pares;
    }
}
