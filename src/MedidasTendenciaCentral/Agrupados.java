package MedidasTendenciaCentral;

import java.util.ArrayList;
import java.util.List;

public class Agrupados {
    //Construccion de la tabla con el data set agrupado
    public double[][] Tabla(int rango, int k, int c, double[] dataSet){
        double[][] tabla = new double[k][4]; // Columnas: numero de clases, frecuencias, frecuencias acomuladas, puntpMedio "Xc"

        //Recorrer tabla de modo que después de terminar de llenar la columna, pase a otra.
        for(int j = 0; j < tabla[0].length; j++){
            for(int i = 0; i < tabla.length; i++){
                if(j == 0){ //Numerar cada intervalo por fila
                    tabla[i][0] = i + 1;
                }else if(j == 1){ //    Frecuencia
                    // Calculo de los límites de clase
                    int a = (int) dataSet[0]; // Obtener el valor mínimo del conjunto de datos
                    for (int s = 0; s < k; s++) {
                        int limiteInferior = a + (c * s);
                        int limiteSuperior = limiteInferior + c - 1;
                        int f = 0; // Inicializar la frecuencia para cada intervalo

                        // Contar la frecuencia de los datos que caen en el intervalo actual
                        for (double dato : dataSet) { //For mejorado
                            if (dato >= limiteInferior && dato <= limiteSuperior) {
                                f++;
                            }
                        }
                        // Asignar la frecuencia al intervalo correspondiente en la tabla
                        tabla[s][1] = f;
                    }
                }else if(j == 2){ //     Frecuencia Absoluta o acomulada
                    double fa = 0;
                    for(int s = 0; s < k; s++){
                        double frecuencia = tabla[s][1];
                        fa += frecuencia;
                        tabla[s][2] = fa;
                    }
                }else if(j == 3){ //        Punto medio   "Xc"
                    // Calculo de los límites de clase
                    double a = dataSet[0]; // Obtener el valor mínimo del conjunto de datos
                    for (int s = 0; s < k; s++) {
                        double limiteInferior = a + (c * s);
                        double limiteSuperior = limiteInferior + c - 1;
                        double xc = 0; //Inicializar el punto medio para cada intervalo

                        //Calculo del punto medio
                        xc = (limiteSuperior - limiteInferior)/2;
                        xc += limiteInferior;
                        tabla[s][3] = xc; // Puntos medios guardados en columna 3 pero columna 4 al mostrar en consola
                    }
                }
            }//for i
        }//for j
        return tabla;
    }//Método tabla

    public void imprimirTabla(double[][]tabla, int[][] limites){
        //Encabezado
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("| %-6s | %-5s | %-5s | %-5s | %-6s |\n", "Clases", "Limite de clases", "Frecuencia", "Fa", "Punto Medio");
        System.out.println("-------------------------------------------------------------------------------------------------");
        // Imprimir los datos de la tabla
        for (int i = 0; i < tabla.length; i++) {
            System.out.printf("| %-6s | %-16s | %-10s | %-11s | %-6s |\n", tabla[i][0], limites[i][0]+" - "+limites[i][1], tabla[i][1], tabla[i][2], tabla[i][3]);
        }
        // Imprimir línea de cierre de tabla
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

    //      MEDIA
    public double Media(double[][] tabla, double[] dataSet){
        double media = 0;

        for(int i = 0; i < tabla.length; i++){
            media += (tabla[i][1] * tabla[i][3]);
        }

        media = media / dataSet.length;

        return media;
    }
    //      MEDIANA
    public double Mediana(double[][] tabla, int[][] limitesDeClase, double[] dataset){
        double mediana = 0;
        //Localizar intervalo donde se encuentra la mediana
        int ubicacion = dataset.length / 2;
        /*if(dataset.length % 2 != 0){
            ubicacion += 1;
        }
         */

        //Buscar en la columna de frecuencias acomuladas el intervalo apartir de la "ubicacion"
        int filaMediana = 0;
        for(int i = 0; i < tabla.length; i++){
            if(tabla[i][2] >= ubicacion){
                filaMediana = i;
                break;
            }
        }

        // A partir de la fila, ubicamos los demás datos para la fórmula
        int limiteInferior = limitesDeClase[filaMediana][0]; // 43  en este caso  #
        double totalFrecuencias = (double) dataset.length / 2; // 31/2 = 15.5  ¿se redondea o no?
        double frecuenciaDeClase = tabla[filaMediana][1]; // 8
        double frecuenciaAcumuladaMenor = filaMediana > 0 ? tabla[filaMediana - 1][2] : 0; // 8
        double amplitudDeClase = limitesDeClase[filaMediana][1] - limiteInferior; // 8
        //Aplicamos fórmula:

        mediana = limiteInferior + ((totalFrecuencias-frecuenciaAcumuladaMenor)/frecuenciaDeClase) * amplitudDeClase; //



        return mediana;
    }
    //      MODA
    public List<Double> Moda(double[][] tabla, int[][] limitesDeClaase){
        List<Double> modas = new ArrayList<>();

        //A partir de la clase (fila tabla) con mayor número de frecuencias
        //Buscar clase/s:

        double valorMax = 1, valorActual = 0;
        for(int i = 0; i < tabla.length; i++){
            valorActual =  tabla[i][1];
            if(valorActual > valorMax){
                valorMax = valorActual;
                valorActual = 0;
            }
        }
        //Después de encontrar un valor Máximo, buscamos si hay clases con el mismo valor máximo de Frecuencias
        List<Integer> filasUbicacion = new ArrayList<>();
        for(int i = 0; i < tabla.length; i++){
            if(tabla[i][1] == valorMax){
                filasUbicacion.add(i);
            }
        }

        //Ya ubicadas, aplicar fórmula para cualquier clase que presente el mismo número de frecuencias
        for(int i = 0; i < filasUbicacion.size(); ++i){
            int fila = filasUbicacion.get(i);

            //inicializando variables participantes en la fórmula
            double limiteInferiorDeClase = limitesDeClaase[filasUbicacion.get(i)][0]; // Li
            double frecuenciaMayor = tabla[fila][1]; // fi
            double frecuenciaAnterior = (fila > 0)? tabla[fila - 1][1] : 0; //fi-1   ("if-else compacto" para evitar "-1" índice fuera de rango)
            double frecuenciaPosterior = (fila < tabla.length - 1) ? tabla[fila + 1][1] : 0; //fi+1 ("if-else compacto" para evitar "tabla.length+1" índice fuera de rango)
            double a = limitesDeClaase[0][1] - limitesDeClaase[0][0]; // A = Aplitud de clase

            double moda = limiteInferiorDeClase + ((frecuenciaMayor - frecuenciaAnterior) / ((frecuenciaMayor - frecuenciaAnterior) + (frecuenciaMayor - frecuenciaPosterior))) * a;

            modas.add(moda);
        }

        return modas;
    }
    




}
