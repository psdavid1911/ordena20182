
import java.awt.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * TelaGrafica is a class to allow for simple graphical drawing on a canvas.
 * This is a modification of the general purpose TelaGrafica, specially made for
 * the BlueJ "shapes" example.
 *
 * @author: Bruce Quig
 * @author: Michael Kolling (mik)
 *
 * @version 2008.03.30
 */
public class TelaGrafica{

    public void carregaElementos(){
        ArrayList<Circulo> listaDeCirculos=new ArrayList<>();
        listaDeCirculos.add(new Circulo(10,130,40,"vermelho",true));
        listaDeCirculos.add(new Circulo(10,115,85,"vermelho",true));
        listaDeCirculos.add(new Circulo(10,100,135,"vermelho",true));
        listaDeCirculos.add(new Circulo(10,85,190,"vermelho",true));
        listaDeCirculos.add(new Circulo(10,70,250,"vermelho",true));
        listaDeCirculos.add(new Circulo(10,160,40,"vermelho",true));
        listaDeCirculos.add(new Circulo(10,175,85,"vermelho",true));
        listaDeCirculos.add(new Circulo(10,190,135,"vermelho",true));
        listaDeCirculos.add(new Circulo(10,205,190,"vermelho",true));
        listaDeCirculos.add(new Circulo(10,220,250,"vermelho",true));
        ArrayList<Quadrado> listaDeQuadrados=new ArrayList<>();
        listaDeQuadrados.add(new Quadrado(30,135,270,"marrom",true));
        listaDeQuadrados.add(new Quadrado(30,135,255,"marrom",true));
        ArrayList<Triangulo> listaDeTriangulos=new ArrayList<>();
        listaDeTriangulos.add(new Triangulo(30,30,150,15,"verde",true));
        listaDeTriangulos.add(new Triangulo(60,60,150,30,"verde",true));
        listaDeTriangulos.add(new Triangulo(90,90,150,50,"verde",true));
        listaDeTriangulos.add(new Triangulo(120,120,150,75,"verde",true));
        listaDeTriangulos.add(new Triangulo(150,150,150,105,"verde",true));
    }
    // Note: The implementation of this class (specifically the handling of
    // shape identity and colors) is slightly more complex than necessary. This
    // is done on purpose to keep the interface and instance fields of the
    // shape objects in this project clean and simple for educational purposes.
    private static TelaGrafica canvasSingleton;

    /**
     * Factory method to get the canvas singleton object.
     */
    public static TelaGrafica obtenhaTelaGrafica(){
        if(canvasSingleton==null)
            canvasSingleton=new TelaGrafica("Janela Grafica",300,300,
                    Color.white);
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }
    //  ----- instance part -----
    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColor;
    private Image canvasImage;
    private ArrayList<Object> objects;
    private HashMap<Object,ShapeDescription> shapes;

    /**
     * Create a TelaGrafica.
     *
     * @param title title to appear in TelaGrafica Frame
     * @param width the desired width for the canvas
     * @param height the desired height for the canvas
     * @param bgColor the desired background color of the canvas
     */
    private TelaGrafica(String title,int width,int height,Color bgColor){
        frame=new JFrame();
        canvas=new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width,height));
        backgroundColor=bgColor;
        frame.pack();
        objects=new ArrayList<Object>();
        shapes=new HashMap<Object,ShapeDescription>();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of screen when
     * made visible. This method can also be used to bring an already visible
     * canvas to the front of other windows.
     *
     * @param visible boolean value representing the desired visibility of the
     * canvas (true or false)
     */
    public void setVisible(boolean visible){
        if(graphic==null){
            // first time: instantiate the offscreen image and fill it with
            // the background color
            Dimension size=canvas.getSize();
            canvasImage=canvas.createImage(size.width,size.height);
            graphic=(Graphics2D)canvasImage.getGraphics();
            graphic.setColor(backgroundColor);
            graphic.fillRect(0,0,size.width,size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Draw a given shape onto the canvas.
     *
     * @param referenceObject an object to define identity for this shape
     * @param color the color of the shape
     * @param shape the shape object to be drawn on the canvas
     */
    // Note: this is a slightly backwards way of maintaining the shape
    // objects. It is carefully designed to keep the visible shape interfaces
    // in this project clean and simple for educational purposes.
    public void draw(Object referenceObject,String color,Shape shape){
        objects.remove(referenceObject);   // just in case it was already there
        objects.add(referenceObject);      // add at the end
        shapes.put(referenceObject,new ShapeDescription(shape,color));
        redraw();
    }

    /**
     * Erase a given shape's from the screen.
     *
     * @param referenceObject the shape object to be erased
     */
    public void erase(Object referenceObject){
        objects.remove(referenceObject);   // just in case it was already there
        shapes.remove(referenceObject);
        redraw();
    }

    /**
     * Set the foreground color of the TelaGrafica.
     *
     * @param newColor the new color for the foreground of the TelaGrafica
     */
    public void setForegroundColor(String colorString){
        if(colorString.equals("vermelho"))
            graphic.setColor(Color.red);
        else if(colorString.equals("preto"))
            graphic.setColor(Color.black);
        else if(colorString.equals("azul"))
            graphic.setColor(Color.blue);
        else if(colorString.equals("amarelo"))
            graphic.setColor(Color.yellow);
        else if(colorString.equals("verde"))
            graphic.setColor(Color.green);
        else if(colorString.equals("laranja"))
            graphic.setColor(new Color(255,200,0));
        else if(colorString.equals("branco"))
            graphic.setColor(Color.white);
        else if(colorString.equals("marrom"))
            graphic.setColor(new Color(153,102, 0));
        else
            graphic.setColor(Color.black);
    }

    /**
     * Wait for a specified number of milliseconds before finishing. This
     * provides an easy way to specify a small delay which can be used when
     * producing animations.
     *
     * @param milliseconds the number
     */
    public void wait(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch(Exception e){
            // ignoring exception at the moment
        }
    }

    /**
     * Redraw ell shapes currently on the TelaGrafica.
     */
    private void redraw(){
        erase();
        for(Object shape:objects)
            shapes.get(shape).draw(graphic);
        canvas.repaint();
    }

    /**
     * Erase the whole canvas. (Does not repaint.)
     */
    private void erase(){
        Color original=graphic.getColor();
        graphic.setColor(backgroundColor);
        Dimension size=canvas.getSize();
        graphic.fill(new Rectangle(0,0,size.width,size.height));
        graphic.setColor(original);
    }

    /**
     * **********************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * TelaGrafica frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class CanvasPane extends JPanel{

        public void paint(Graphics g){
            g.drawImage(canvasImage,0,0,null);
        }
    }

    /**
     * **********************************************************************
     * Inner class CanvasPane - the actual canvas component contained in the
     * TelaGrafica frame. This is essentially a JPanel with added capability to
     * refresh the image drawn on it.
     */
    private class ShapeDescription{

        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape,String color){
            this.shape=shape;
            colorString=color;
        }

        public void draw(Graphics2D graphic){
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }
}
