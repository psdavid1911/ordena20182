package Base;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico<X extends Comparable,Y extends Number>{

    public Grafico(Series<X,Y> minhasSeries,String nomeDoGrafico,String nomeDoEixoX,String nomeDoEixoY,String nomeDoArquivo,int largura,int altura){
        try{
            DefaultCategoryDataset dados=new DefaultCategoryDataset();
            for(Serie<X,Y> s:minhasSeries.colecao) for(Par<X,Y> p:s.pares) dados.addValue(p.y,s.nomeDaColecao,p.x);
            File arquivo=new File(nomeDoArquivo+".jpeg");
            JFreeChart grafico=ChartFactory.createLineChart(nomeDoGrafico,nomeDoEixoX,nomeDoEixoY,dados,PlotOrientation.VERTICAL,true,true,false);
            ChartUtilities.saveChartAsJPEG(arquivo,grafico,largura,altura);
        }catch(IOException ex){
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public Grafico(Serie<X,Y> serie,String nomeDoGrafico,String nomeDoEixoX,String nomeDoEixoY,String nomeDoArquivo,int largura,int altura){
        try{
            DefaultCategoryDataset dados=new DefaultCategoryDataset();
            for(Par<X,Y> p:serie.pares) dados.addValue(p.y,serie.nomeDaColecao,p.x);
            File arquivo=new File(nomeDoArquivo+".jpeg");
            JFreeChart grafico=ChartFactory.createLineChart(nomeDoGrafico,nomeDoEixoX,nomeDoEixoY,dados,PlotOrientation.VERTICAL,true,true,false);
            ChartUtilities.saveChartAsJPEG(arquivo,grafico,largura,altura);
        }catch(IOException ex){
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
