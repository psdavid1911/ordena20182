package grupo.ordena20182;

public class Par<X extends Comparable,Y> implements Comparable<Par<X,Y>>{

    private X x;
    private Y y;

    public Par(X x,Y y){
        this.x=x;
        this.y=y;
    }

    public X getX(){
        return x;
    }

    public void setX(X x){
        this.x=x;
    }

    public Y getY(){
        return y;
    }

    public void setY(Y y){
        this.y=y;
    }

    @Override
    public int compareTo(Par<X,Y> outro){
        return this.x.compareTo(outro.x);
    }

    @Override
    public String toString(){
        return "("+"x="+x+", y="+y+')';
    }
}
