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

    public static <X extends Comparable<X>, Y extends Number> void criaGrafico(Serie<Double, Double> serie, String nomeDoGrafico, String nomeX, String nomeY, String nomeArquivo, int largura, int altura){
        JFreeChart grafico=ChartFactory.createXYLineChart(nomeDoGrafico, nomeX, nomeY, criaColecaoDeSerie(serie), PlotOrientation.VERTICAL, true, true, true);
        grafico.getXYPlot().setRenderer(new XYSplineRenderer(1000)); // Suaviza as linhas
        try{
            ChartUtilities.saveChartAsJPEG(new File(nomeArquivo+".jpeg"), grafico, largura, altura);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static <X extends Comparable<X>, Y extends Number> void criaGrafico(Series<Double, Double> series, String nomeDoGrafico, String nomeX, String nomeY, String nomeArquivo, int largura, int altura){
        JFreeChart grafico=ChartFactory.createXYLineChart(nomeDoGrafico, nomeX, nomeY, criaColecaoDeSeries(series), PlotOrientation.VERTICAL, true, true, true);
        grafico.getXYPlot().setRenderer(new XYSplineRenderer(1000)); // Suaviza as linhas
        try{
            ChartUtilities.saveChartAsJPEG(new File(nomeArquivo+".jpeg"), grafico, largura, altura);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static XYSeriesCollection criaColecaoDeSerie(Serie<Double, Double> s){
        XYSeries serie=new XYSeries(s.getNomeDaColecao());
        for(Par<Double, Double> p:s.getPares())
            serie.add(p.getX(), p.getY());
        return new XYSeriesCollection(serie);
    }

    private static XYSeriesCollection criaColecaoDeSeries(Series<Double, Double> series){
        XYSeriesCollection colecaoDeSeries=new XYSeriesCollection();
        for(Serie<Double, Double> serie:series.colecao){
            XYSeries serieAuxiliar=new XYSeries(serie.getNome());
            for(Par<Double, Double> par:serie.getPares())
                serieAuxiliar.add(par.getX(), par.getY());
            colecaoDeSeries.addSeries(serieAuxiliar);
        }
        return colecaoDeSeries;
    }
}
