
import java.awt.Rectangle;

/**
 * Um quadrado que pode ser manipulado e desenha a si proprio numa janela
 * grafica.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */

public class Quadrado{

    private int tamanho;
    private int posicaoX;
    private int posicaoY;
    private String cor;
    private boolean estaVisivel;

    public Quadrado(int tamanho,int posicaoX,int posicaoY,String cor,boolean estaVisivel){
        this.tamanho=tamanho;
        this.posicaoX=posicaoX;
        this.posicaoY=posicaoY;
        this.cor=cor;
        this.estaVisivel=estaVisivel;
    }

    /**
     * Cria um novo quadrado na posicao e cor padrao.
     */
    public Quadrado(){
        tamanho=30;
        posicaoX=60;
        posicaoY=50;
        cor="vermelho";
        estaVisivel=false;
    }

    /**
     * Método de acesso ao campo tamanho
     *
     * @return O tamanho do lado do quadrado
     */
    public int getTamanho(){
        return tamanho;
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
     * Torna esse quadrado visivel. Se ele ja estiver visivel nao faz nada.
     */
    public void tornaVisivel(){
        estaVisivel=true;
        draw();
    }

    /**
     * Torna esse quadrado invisivel. Se ele ja estiver invisivel nao faz nada.
     */
    public void tornaInvisivel(){
        erase();
        estaVisivel=false;
    }

    /**
     * Move o quadrado 20 pixels para a direita.
     */
    public void direita(){
        moveHorizontal(20);
    }

    /**
     * Move o quadrado 20 pixels para a esquerda.
     */
    public void esquerda(){
        moveHorizontal(-20);
    }

    /**
     * Move o quadrado 20 pixels para cima.
     */
    public void sobe(){
        moveVertical(-20);
    }

    /**
     * Move o quadrado 20 pixels para baixo.
     *
     * @param distancia Distancia que o objeto sera movido para baixo se
     * positivo ou para cima se negativo
     */
    public void desce(){
        moveVertical(20);
    }

    /**
     * Move o quadrado na horizontal por 'distancia' pixels.
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
     * Move o quadrado na vertical por 'distancia' pixels.
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
     * Move lentamente o quadrado na horizontal por 'distancia' pixels.
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
     * Move lentamente o quadrado na vertical por 'distancia' pixels.
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
     * Muda o tamanho do lado do quadrado(em pixels). Tamanho deve ser >= 0.
     *
     * @param novoTamanho Novo tamanho do lado do quadrado. Deve ser maior que
     * zero.
     */
    public void setTamanho(int novoTamanho){
        erase();
        tamanho=novoTamanho;
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
     * Desenha o quadrado com as especificacoes atuais na janela grafica.
     */
    private void draw(){
        if(estaVisivel){
            TelaGrafica canvas=TelaGrafica.obtenhaTelaGrafica();
            canvas.draw(this,cor,
                    new Rectangle(posicaoX,posicaoY,tamanho,tamanho));
            canvas.wait(10);
        }
    }

    /**
     * Apaga o quadrado da janela grafica.
     */
    private void erase(){
        if(estaVisivel){
            TelaGrafica canvas=TelaGrafica.obtenhaTelaGrafica();
            canvas.erase(this);
        }
    }
}
