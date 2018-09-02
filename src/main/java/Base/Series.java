package Base;

import java.util.ArrayList;

public class Series<X extends Comparable<X>, Y>{

    public ArrayList<Serie<X, Y>> colecao;

    public Series(ArrayList<Serie<X, Y>> colecao){
        this.colecao=colecao;
    }
}
