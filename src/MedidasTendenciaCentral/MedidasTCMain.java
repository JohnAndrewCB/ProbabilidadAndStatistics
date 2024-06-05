package MedidasTendenciaCentral;
import EstadísticaDescriptiva.DiscretMathsEstad;

import java.util.*;
public class MedidasTCMain {

    public static void main(String[] args){
        DataSetMTC dataSetMTC = new DataSetMTC();
        MetodosVarios metodosVarios = new MetodosVarios();
        NoAgrupados noAgrupados = new NoAgrupados();
        Agrupados dataAgrupada = new Agrupados();

        double media = 0, mediana = 0;
        List<Double> listModa = new ArrayList<>(); //Multi modal,

        //Determinar que tipo de conjunto de datos se evalúa
        boolean agrupados = metodosVarios.Agrupados(dataSetMTC.getData());
        System.out.println(agrupados); //true agrupados / false no agrupados

        //Ordenar datos
        double[] dataOrdenada = metodosVarios.OrdenDataSet(dataSetMTC.getData());

        if(agrupados == false){ // Si el data set No esta Agrupado
            media = noAgrupados.Media(dataOrdenada);
            mediana = noAgrupados.Mediana(dataOrdenada);
            listModa = noAgrupados.Moda(dataOrdenada);
        }else { //  Si el data set Sí esta Agrupado
            //LLamado de métodos de class "Agrupados" para: agrupar el data set
            DiscretMathsEstad agruparDatos = new DiscretMathsEstad();
            int rango = agruparDatos.Rango(dataOrdenada); //Cantidad de datos por intervalo.
            int numeroDeclases = agruparDatos.NumeroClases(dataOrdenada); //Número de clases o intervalos necesarios para agrupar. (k)
            int amplitudClase = agruparDatos.AmplitudClase(rango, numeroDeclases); //Cuantos elementos caben por intervalo. (c)

            int[][] limitesDeClase = agruparDatos.LimitesDeClase(numeroDeclases, amplitudClase, dataOrdenada);

            // método propio de "Agrupados" para construir la tabla:
            double[][] tabla = dataAgrupada.Tabla(rango, numeroDeclases, amplitudClase, dataOrdenada);

            //Imprimir tabla para no perderse en los calculos de las medidas de tendencia central
            dataAgrupada.imprimirTabla(tabla, limitesDeClase);


            //LLamado de métodos de class "Agrupados" para: Determinar MEDIDAS de tendencia central

            media = dataAgrupada.Media(tabla, dataOrdenada);
            mediana = dataAgrupada.Mediana(tabla, limitesDeClase, dataOrdenada);
            listModa = dataAgrupada.Moda(tabla, limitesDeClase);

            //              ..........
        }


        //imprimir Medidas de tendencia central para DATOS NO AGRUPADOS
        metodosVarios.Imprimir(agrupados, media, mediana, listModa);





    }
}
