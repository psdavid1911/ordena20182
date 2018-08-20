package Base;

import java.io.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Grafico{

    public static <X extends Number, Y extends Number> void criaGrafico(Serie<X, Y> serie, String nomeDoGrafico, String nomeX, String nomeY, String nomeArquivo, int largura, int altura){
        JFreeChart grafico=ChartFactory.createXYLineChart(nomeDoGrafico, nomeX, nomeY, criaColecaoDeSerie(serie), PlotOrientation.VERTICAL, true, true, true);
        grafico.getXYPlot().setRenderer(new XYSplineRenderer(1000)); // Suaviza as linhas
        try{
            ChartUtilities.saveChartAsJPEG(new File(nomeArquivo+".jpeg"), grafico, largura, altura);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static <X extends Number, Y extends Number> void criaGrafico(Series<X, Y> series, String nomeDoGrafico, String nomeX, String nomeY, String nomeArquivo, int largura, int altura){
        JFreeChart grafico=ChartFactory.createXYLineChart(nomeDoGrafico, nomeX, nomeY, criaColecaoDeSeries(series), PlotOrientation.VERTICAL, true, true, true);
        grafico.getXYPlot().setRenderer(new XYSplineRenderer(1000)); // Suaviza as linhas
        try{
            ChartUtilities.saveChartAsJPEG(new File(nomeArquivo+".jpeg"), grafico, largura, altura);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static <X extends Number, Y extends Number> XYSeriesCollection criaColecaoDeSerie(Serie<X, Y> s){
        XYSeries serie=new XYSeries(s.nomeDaColecao);
        for(Par<X, Y> p:s.pares)
            serie.add(p.x, p.y);
        return new XYSeriesCollection(serie);
    }

    private static <X extends Number, Y extends Number> XYSeriesCollection criaColecaoDeSeries(Series<X, Y> series){
        XYSeriesCollection colecaoDeSeries=new XYSeriesCollection();
        for(Serie<X, Y> serie:series.colecao){
            XYSeries serieAuxiliar=new XYSeries(serie.getNome());
            for(Par<X, Y> par:serie.pares)
                serieAuxiliar.add(par.x, par.y);
            colecaoDeSeries.addSeries(serieAuxiliar);
        }
        return colecaoDeSeries;
    }
}
