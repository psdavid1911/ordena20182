package Base;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import static org.jfree.chart.JFreeChart.DEFAULT_TITLE_FONT;
import static org.jfree.ui.RectangleInsets.ZERO_INSETS;

public class Grafico<X extends Number, Y extends Number>{

    public Grafico(Serie<X, Y> s, String nomeDoGrafico, String nomeDoEixoX, String nomeDoEixoY, String nomeDoArquivo, int largura, int altura){
        XYSeries serie=new XYSeries(nomeDoEixoY);
        for(Par<X, Y> p:s.pares)serie.add(p.x, p.y);
        XYSeriesCollection colecao=new XYSeriesCollection(serie);
        //XYSplineRenderer renderizador=new XYSplineRenderer(1000);
        XYLineAndShapeRenderer renderizador=new XYLineAndShapeRenderer();
        NumberAxis x=new NumberAxis(nomeDoEixoX);
        x.setAutoRange(true);
        NumberAxis y=new NumberAxis(nomeDoEixoY);
        XYPlot tela=new XYPlot(colecao, x, y, renderizador);
        JFreeChart grafico=new JFreeChart(nomeDoGrafico, DEFAULT_TITLE_FONT, tela, true);
        grafico.setAntiAlias(true);
        grafico.setPadding(ZERO_INSETS); // quadrado no meio fica menor
        try{
            ChartUtilities.saveChartAsJPEG(new File(nomeDoArquivo+".jpeg"), grafico, largura, altura);
        }catch(IOException ex){
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
