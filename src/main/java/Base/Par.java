package Base;

public class Par<X, Y>{

    X x;
    Y y;

    public Par(X x, Y y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString(){
        return "("+"x="+x+", y="+y+')';
    }
}
