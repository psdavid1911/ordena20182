package Base;
import java.util.ArrayList;

public class Serie<X,Y>{

    public String nomeDaColecao;
    public ArrayList<Par<X,Y>> pares;

    public Serie(String nomeDaColecao){
        this.nomeDaColecao=nomeDaColecao;
        pares=new ArrayList<>();
    }

    public Serie(String nomeDaColecao,ArrayList<Par<X,Y>> pares){
        this.nomeDaColecao=nomeDaColecao;
        this.pares=pares;
    }

    public void adiciona(X x,Y y){
        pares.add(new Par<X,Y>(x,y));
    }
}
