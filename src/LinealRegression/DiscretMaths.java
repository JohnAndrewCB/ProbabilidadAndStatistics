/*
Clase que opera con los valores de Ventas y Publicidad
para calcular sumatorias, restas, divisiones.
 */
package LinealRegression;
public class DiscretMaths {

    public DiscretMaths(){

    }
    //Numero de datos
    double n = 9;
    //Métodos de operaciones matematicas diversas
    public double Suma(double[] data){
        double totalX = 0;

        for(int i = 0; i < data.length; i++)
            totalX += data[i];

        return totalX;
    }

    public double Media(double suma){
        double media;
        media = suma / n;

        return media;
    }

    public double[] Multiplicacion(double[] data){
        double[] multiplicacionesX = new double[data.length];

        for(int i = 0; i < data.length; i++)
            multiplicacionesX[i] = data[i] * data[i];

        return multiplicacionesX;
    }

    public double[] VentasPorPubli(double[] dataX, double[] dataY){
        int filas = dataX.length;
        double [] xpory = new double[filas];

        for(int i = 0; i < filas; i++){
            xpory[i] = dataX[i] * dataY[i];
        }
        return xpory;
    }

}
