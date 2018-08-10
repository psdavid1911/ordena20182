
import java.awt.geom.*;

/**
 * Um circulo que pode ser manipulado e desenha a si proprio numa janela
 * grafica.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Circulo{

    private int diametro;
    private int posicaoX;
    private int posicaoY;
    private String cor;
    private boolean estaVisivel;

    public Circulo(int diametro,int posicaoX,int posicaoY,String cor,boolean estaVisivel){
        this.diametro=diametro;
        this.posicaoX=posicaoX;
        this.posicaoY=posicaoY;
        this.cor=cor;
        this.estaVisivel=estaVisivel;
    }

    /**
     * Cria um novo circulo na posicao e cor padrao.
     */
    public Circulo(){
        diametro=30;
        posicaoX=20;
        posicaoY=60;
        cor="azul";
        estaVisivel=false;
    }

    /**
     * Método de acesso ao campo diametro
     *
     * @return O diâmetro do círculo
     */
    public int getDiametro(){
        return diametro;
    }

    /**
     * Método de acesso ao campo cor
     *
     * @return A cor do círculo
     */
    public String getCor(){
        return cor;
    }

    /**
     * Torna esse circulo visivel. Se ele ja estiver visivel nao faz nada.
     */
    public void tornaVisivel(){
        estaVisivel=true;
        draw();
    }

    /**
     * Torna esse circulo invisivel. Se ele ja estiver invisivel nao faz nada.
     */
    public void tornaInvisivel(){
        erase();
        estaVisivel=false;
    }

    /**
     * Move o circulo 20 pixels para a direita.
     */
    public void direita(){
        moveHorizontal(20);
    }

    /**
     * Move o circulo 20 pixels para a esquerda.
     */
    public void esquerda(){
        moveHorizontal(-20);
    }

    /**
     * Move o circulo 20 pixels para cima.
     */
    public void sobe(){
        moveVertical(-20);
    }

    /**
     * Move o circulo 20 pixels para baixo.
     */
    public void desce(){
        moveVertical(20);
    }

    /**
     * Move o circulo na horizontal por 'distancia' pixels.
     *
     * @param distancia Distancia que o objeto sera movido para direita se
     * positivo ou para esquerda se negativo
     */
    public void moveHorizontal(int distancia){
        erase();
        posicaoX+=distancia;
        draw();
    }

    /**
     * Move o circulo na vertical por 'distancia' pixels.
     *
     * @param distancia Distancia que o objeto sera movido para baixo se
     * positivo ou para cima se negativo
     */
    public void moveVertical(int distancia){
        erase();
        posicaoY+=distancia;
        draw();
    }

    /**
     * Move lentamente o circulo na horizontal por 'distancia' pixels.
     *
     * @param distancia Distancia que o objeto sera movido para direita se
     * positivo ou para esquerda se negativo
     */
    public void moveHorizontalLento(int distancia){
        int delta;
        if(distancia<0){
            delta=-1;
            distancia=-distancia;
        }else
            delta=1;
        for(int i=0;i<distancia;i++) {
            posicaoX+=delta;
            draw();
        }
    }

    /**
     * Move lentamente o circulo na vertical por 'distancia' pixels.
     *
     * @param distancia Distancia que o objeto sera movido para baixo se
     * positivo ou para cima se negativo
     */
    public void moveVerticalLento(int distancia){
        int delta;
        if(distancia<0){
            delta=-1;
            distancia=-distancia;
        }else
            delta=1;
        for(int i=0;i<distancia;i++) {
            posicaoY+=delta;
            draw();
        }
    }

    /**
     * Muda o tamanho do diametro do circulo(em pixels). Tamanho deve ser >= 0.
     *
     * @param novoDiametro Novo diametro do circulo. Deve ser maior que zero.
     */
    public void setDiametro(int novoDiametro){
        erase();
        diametro=novoDiametro;
        draw();
    }

    /**
     * Muda a cor do circulo. As cores validas sao "vermelho", "preto", "azul",
     * "amarelo", "verde", "laranja" e "branco".
     *
     * @param novaCor Nova cor do circulo
     */
    public void setCor(String novaCor){
        cor=novaCor;
        draw();
    }

    /**
     * Desenha o circulo com as especificaçoes atuais na janela grafica.
     */
    private void draw(){
        if(estaVisivel){
            TelaGrafica canvas=TelaGrafica.obtenhaTelaGrafica();
            canvas.draw(this,cor,new Ellipse2D.Double(posicaoX,posicaoY,
                    diametro,diametro));
            canvas.wait(10);
        }
    }

    /**
     * Apaga o circulo da janela grafica.
     */
    private void erase(){
        if(estaVisivel){
            TelaGrafica canvas=TelaGrafica.obtenhaTelaGrafica();
            canvas.erase(this);
        }
    }
}
