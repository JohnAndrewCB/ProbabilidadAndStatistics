package MedidasTendenciaCentral;

import EstadísticaDescriptiva.DiscretMathsEstad;
import java.util.*;

public class NoAgrupados {

    //      Media
    public double Media(double[] data){
        double media = 0, total = 0;
        for(int i = 0; i < data.length; i++){
            total += data[i];
        }
        return media = total/data.length;
    }
    //      Mediana
    public double Mediana(double[] data){
        double mediana = 0;
        double posicion = 0;
        //Se necesitan ordenar los datos (ascendente o descendente) pero, ya obtenemos como parámetro el data set ya ordenado
        //Encontrar la Mediana Si el numero de datos es impar o par.
        if(data.length % 2 != 0){// impar
            posicion = (data.length + 1)/2;    //Fórmula para encontrar la posicion de mi elemento que será la Mediana
            posicion = posicion - 1; //Restar siempre una unidad de posicion ya que en los arreglos el conteo de elementos empieza en 0.
            return mediana = data[(int) posicion]; //Asignando el valor de dicha "posicion" en el arreglo
        }else {//   par
            int posicion2 = 0;
            posicion = (data.length + 1)/2;
            posicion = (posicion - posicion % 2);
            posicion2 = (int)(posicion + 1) ; //Como simpre será entre dos elementos, el límite simpre será el siguiente elemento.
            mediana = (data[(int) posicion] + data[posicion2])/2;
            return mediana;
        }
    }
    //      Moda   (replantear calculo de la moda)
    public List<Double> Moda(double[] data){
        //Para la primera fila de la tabla: Datos que participan en el data set (sin tomar en cuenta cuantas veces se repiten)
        List<Double> datosUnicos = new ArrayList<>();
        //Para llenar la segunda fila de la tabla: Lista para almacenar frecuencias de cada dato
        List<Integer> frecuencias = new ArrayList<>();

        // Calculando las frecuencias de cada dato
        double actual = data[0];
        int contador = 1;
        for (int i = 1; i < data.length; i++) {
            if (data[i] == actual) {
                contador++;
            } else {
                datosUnicos.add(actual);
                frecuencias.add(contador);
                actual = data[i];
                contador = 1;
            }
        }
        // Añadir el último elemento
        datosUnicos.add(actual);
        frecuencias.add(contador);

        //tabla
        int columnas = datosUnicos.size();
        double[][] tabla = new double[2][columnas]; //Tabla para contener los datos

        //LLenando de la tabla, con los datos unicos del data set y sus respectivas frecuencias
        for(int i = 0; i < columnas; i++){
            tabla[0][i] = datosUnicos.get(i);
            tabla[1][i] = frecuencias.get(i);
        }

        // Encontrar la/s moda/s
        List<Double> modas = new ArrayList<>();
        double maxFrecuencia = 0;
        for (int i = 0; i < columnas; i++) {
            if (tabla[1][i] > maxFrecuencia) {
                maxFrecuencia = tabla[1][i];
                modas.clear();
                modas.add(tabla[0][i]);
            } else if (tabla[1][i] == maxFrecuencia) {
                modas.add(tabla[0][i]);
            }
        }

        //Verificar si todas las frecuencias son 1: NO HAY MODA
        if (maxFrecuencia == 1) {
            return new ArrayList<>(); // Retornar lista vacía si no hay moda
        }

        return modas;
    }


}
