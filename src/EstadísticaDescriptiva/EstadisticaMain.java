package EstadísticaDescriptiva;

public class EstadisticaMain {

    public static void main(String[] args){
        DataSetEstadistica myData = new DataSetEstadistica();
        DiscretMathsEstad myDM = new DiscretMathsEstad();

        double[] dataSet = myDM.OrdenDataSet(myData.getData()); //Ordenado ascendentemente

        int rango = myDM.Rango(dataSet); // r = rango

        int nClases = myDM.NumeroClases(dataSet);     // k = Numero de clases

        int amplitud = myDM.AmplitudClase(rango, nClases); // c = aplitud de cada invervalo

        double[][] tabla = myDM.TablaEstadistica(rango, nClases, amplitud, dataSet);

        int[][] limitesDeClases = myDM.LimitesDeClase(nClases, amplitud, dataSet);

        myDM.imprimirTabla(tabla, limitesDeClases); //Imprime resultados (tabla estadística)

    }// Main
}//Clase EstadisticaMain
