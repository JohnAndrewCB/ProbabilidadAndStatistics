package MedidasTendenciaCentral;
import java.text.DecimalFormat;
import java.util.*;
public class MetodosVarios {

    //Método para determinar Si se trata de datos agrupados o no
    public boolean Agrupados(double[] data){
        boolean desicion = false;
        if(data.length > 29){ //Si es Mayor a 30 datos se considera agruparlos
            desicion = true;
        }
        return desicion;
    }

    //Método para ordenar de manera ascenden un data set
    public double[] OrdenDataSet(double[] data){
        double[] ordenado = data.clone(); // Clonar la matriz de entrada
        double x; //Variable de uso temporal

        //Voy guardando los valores en orden ascendente (ordenación de burbuja)
        for (int i = 0; i < ordenado.length - 1; i++) {
            for (int j = 0; j < ordenado.length - 1 - i; j++) { //optimización de analisis (-i) para evitar analizar posiciones...
                if (ordenado[j] > ordenado[j + 1]) {            //...de elementos que ya se encuentran al final de la lista o sea, ya ordenados.
                    // Intercambiar los elementos si están en el orden incorrecto
                    x = ordenado[j];
                    ordenado[j] = ordenado[j + 1];
                    ordenado[j + 1] = x;
                }
            }
        }
        return ordenado;
    }

    public void Imprimir(boolean agrupados, double media, double mediana, List<Double> moda) {
        DecimalFormat df = new DecimalFormat("#.##");
        if (agrupados) { //true
            System.out.println("Conjunto de datos Agrupados \n");

            System.out.println("Media: " + df.format(media));
            System.out.println("Mediana: " + mediana);
            System.out.println("Moda: " + moda);
        } else {
            System.out.println("Conjunto de datos No Agrupados \n");

            System.out.println("Media: " + media);
            System.out.println("Mediana: " + mediana);
            System.out.println("Moda: " + moda);
        }
    }


}
