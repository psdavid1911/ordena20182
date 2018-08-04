package grupo.ordena20182;
import java.io.*;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficoDeLinha<TIPOX extends Comparable,TIPOY extends Number>{

    DefaultCategoryDataset conjuntoDeDados=new DefaultCategoryDataset();

    public void adicionaConjuntoDeDados(TabelaHash<TIPOX,TIPOY> dados,String NomeDaSerie){
        for(Entry<TIPOX,TIPOY> entrada:dados.conjunto())
            conjuntoDeDados.addValue(entrada.getValue(),NomeDaSerie,entrada.getKey());
    }

    public void adicionaConjuntoDeDados(Lista<Par<TIPOX,TIPOY>> dados,String NomeDaSerie){
        for(Par<TIPOX,TIPOY> par:dados)
            conjuntoDeDados.addValue(par.getY(),NomeDaSerie,par.getX());
    }

    public void criaGrafico(TabelaHash<TIPOX,TIPOY> dados,String NomeDaSerie,String rotuloX,String rotuloY,String titulo,int largura,int altura){
        adicionaConjuntoDeDados(dados,NomeDaSerie);
        JFreeChart lineChartObject=ChartFactory.createLineChart(titulo,
                rotuloX,
                rotuloY,
                conjuntoDeDados,
                PlotOrientation.VERTICAL,
                true,true,false
        );

        File arquivo=new File(titulo+".jpeg");
        try{
            ChartUtilities.saveChartAsJPEG(arquivo,lineChartObject,largura,altura);
        }catch(IOException ex){
            Logger.getLogger(GraficoDeLinha.class.getName()).log(Level.SEVERE,null,ex);
        }
    }

    public void criaGrafico(String rotuloX,String rotuloY,String titulo){
        JFreeChart lineChartObject=ChartFactory.createLineChart(titulo,
                rotuloX,
                rotuloY,
                conjuntoDeDados,
                PlotOrientation.VERTICAL,
                true,true,false
        );
        int largura=800;
        /*
         * Width of the image
         */
        int altura=600;
        /*
         * Height of the image
         */
        File arquivo=new File(titulo+".jpeg");
        try{
            ChartUtilities.saveChartAsJPEG(arquivo,lineChartObject,largura,altura);
        }catch(IOException ex){
            Logger.getLogger(GraficoDeLinha.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
