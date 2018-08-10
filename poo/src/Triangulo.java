
import java.awt.Polygon;
/**
 * Um triangulo que pode ser manipulado e desenha a si proprio numa janela
 * grafica.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Triangulo{

    private int altura;
    private int largura;
    private int posicaoX;
    private int posicaoY;
    private String cor;
    private boolean estaVisivel;

    public Triangulo(int altura,int largura,int posicaoX,int posicaoY,String cor,boolean estaVisivel){
        this.altura=altura;
        this.largura=largura;
        this.posicaoX=posicaoX;
        this.posicaoY=posicaoY;
        this.cor=cor;
        this.estaVisivel=estaVisivel;
    }
    
    

    /**
     * Cria um novo triangulo na posicao e cor padrao.
     */
    public Triangulo(){
        altura=30;
        largura=40;
        posicaoX=50;
        posicaoY=15;
        cor="verde";
        estaVisivel=false;
    }

    /**
     * Método de acesso ao campo altura
     *
     * @return A altura do triângulo
     */
    public int getAltura(){
        return altura;
    }

    /**
     * Método de acesso ao campo altura
     *
     * @return A largura do triângulo
     */
    public int getLargura(){
        return largura;
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
     * Torna esse triangulo visivel. Se ele ja estiver visivel nao faz nada.
     */
    public void tornaVisivel(){
        estaVisivel=true;
        draw();
    }

    /**
     * Torna esse triangulo invisivel. Se ele ja estiver invisivel nao faz nada.
     */
    public void tornaInvisivel(){
        erase();
        estaVisivel=false;
    }

    /**
     * Move o triangulo 20 pixels para a direita.
     */
    public void direita(){
        moveHorizontal(20);
    }

    /**
     * Move o triangulo 20 pixels para a esquerda.
     */
    public void esquerda(){
        moveHorizontal(-20);
    }

    /**
     * Move o triangulo 20 pixels para cima.
     */
    public void sobe(){
        moveVertical(-20);
    }

    /**
     * Move o triangulo 20 pixels para baixo.
     */
    public void desce(){
        moveVertical(20);
    }

    /**
     * Move o triangulo na horizontal por 'distancia' pixels.
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
     * Move o triangulo na vertical por 'distancia' pixels.
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
     * Move lentamente o triangulo na horizontal por 'distancia' pixels.
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
     * Move lentamente o triangulo na vertical por 'distancia' pixels.
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
     * Muda a altura e largura do triangulo(em pixels). Altura e largura devem
     * ser >= 0.
     *
     * @param novaAltura Nova altura do triangulo. Deve ser maior que zero.
     * @param novaLargura Nova largura do triangulo. Deve ser maior que zero.
     */
    public void setTamanho(int novaAltura,int novaLargura){
        erase();
        altura=novaAltura;
        largura=novaLargura;
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
     * Desenha o triangulo com as especificacoes atuais na janela grafica.
     */
    private void draw(){
        if(estaVisivel){
            TelaGrafica canvas=TelaGrafica.obtenhaTelaGrafica();
            int[] xpoints={posicaoX,posicaoX+(largura/2),posicaoX-(largura/2)};
            int[] ypoints={posicaoY,posicaoY+altura,posicaoY+altura};
            canvas.draw(this,cor,new Polygon(xpoints,ypoints,3));
            canvas.wait(10);
        }
    }

    /**
     * Apaga o triangulo da janela grafica.
     */
    private void erase(){
        if(estaVisivel){
            TelaGrafica canvas=TelaGrafica.obtenhaTelaGrafica();
            canvas.erase(this);
        }
    }
}
