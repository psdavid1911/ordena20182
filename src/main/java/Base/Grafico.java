package Base;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafico<TIPOX extends Comparable,TIPOY extends Number>{

    public Grafico(Lista<Par<TIPOX,TIPOY>> dados,String NomeDaSerie,String rotuloX,String rotuloY,String titulo,int altura,int largura){
        try{
            DefaultCategoryDataset conjuntoDeDados=new DefaultCategoryDataset();
            File arquivo=new File(titulo+".jpeg");
            for(Par<TIPOX,TIPOY> par:dados) conjuntoDeDados.addValue(par.getY(),NomeDaSerie,par.getX());
            JFreeChart lineChartObject=ChartFactory.createLineChart(titulo,rotuloX,rotuloY,conjuntoDeDados,PlotOrientation.VERTICAL,true,true,false);
            ChartUtilities.saveChartAsJPEG(arquivo,lineChartObject,largura,altura);
        }catch(IOException ex){
            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
