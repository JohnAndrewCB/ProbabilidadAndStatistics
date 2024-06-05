package PolynomialRegression;

import java.text.DecimalFormat;

public class DiscretMathsPolynomial {

    //Operaciones con matrices
    //Calculo de las Betas "B"


    // "x" como arreglo bidimensional de variables independiente de n orden (uno como primer elemento por fila)
    public double[][] DeNOrden(double[] data) {
        int columnas = 4; //Valor completamente cambiable (depende de que tipo de modelo n orden quieres construir) !No: columnas < 2!!
        //26 elementos en arreglo x
        double norden[][] = new double[data.length][columnas];

        for (int i = 0; i < data.length; i++) {
            for (int k = 0; k < columnas; k++) {
                if(k == 0){
                    norden[i][k] = 1;
                } else if(k == 1){
                    norden[i][k] = data[i];
                }else{
                    norden[i][k] = Math.pow(data[i], k);
                }
            }
        }
        return norden;
    }

    //Formar la trasnpuesta de la matriz de los valores independientes
    public double[][] TranspuestaX(double[][] deNorden){ //Recibir matriz "normal" (deNorden) como parámetro
        int columna = deNorden[0].length;
        double[][] transpuesta = new double[columna][deNorden.length];

        for(int i = 0; i < deNorden.length; i++){
            for(int k = 0; k < columna; k++){
                transpuesta[k][i] = deNorden[i][k];
            }
        }
        return transpuesta;
    }


    //Multiplicacion de la transpuesta POR el arreglo "x" n_orden, de las variables independientes.
    public double[][] MultiplicacionMatricial(double[][] transpuesta, double[][] deNorden){
        double[][] transpuestaPorNormal = new double[deNorden[0].length][transpuesta.length];

        for(int i = 0; i < transpuesta.length; i++){ //Recorrer el arreglo resultante
            for(int k = 0; k < deNorden[0].length; k++){ //Recorrer matriz resultante
                for(int j = 0; j < transpuesta[0].length; j++){ //Recorrer matrices que son parámetros
                    //Multiplicar toda la fila de transpuesta x tola la columna de deNorden o "matriz normal" de independientes
                    transpuestaPorNormal[i][k] += transpuesta[i][j] * deNorden[j][k];
                }//j
            }//k
        }//i
        return transpuestaPorNormal; //Resultante de la multiplicación de matrices
    }


    //          Calculo de la inversa de la matriz resultante (transpuesta por matriz_Normal)
    public double[][] MatrizInversa(double[][] matriz){
        int n = matriz.length;
        double[][] inversa = new double[n][n];

        double[][] identidad = Identidad(n); //Método "Identidad()"
        double[][] aumentarMatriz = Aumentar(matriz, identidad); // Combinar matrices método "Aumentar()"

        for (int i = 0; i < n; i++) {
            // Convertir la diagonal de mi matriz aumentada a 1
            double divisor = aumentarMatriz[i][i];
            for (int j = 0; j < 2 * n; j++) {
                aumentarMatriz[i][j] /= divisor;
            }

            // Hacer 0 en todas las demás celdas de valores de la columna del elemento diagonal actual
            for (int k = 0; k < n; k++) {
                if (k != i) { //Ser diferente a la posición de mi diagonal
                    double factor = aumentarMatriz[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        aumentarMatriz[k][j] -= factor * aumentarMatriz[i][j]; //Volver a 0
                    }
                }
            }
        }
        // Extraer la matriz inversa que antes era la identidad, de la parte derecha de la matriz aumentada
        for (int i = 0; i < n; i++) {
            System.arraycopy(aumentarMatriz[i], n, inversa[i], 0, n);
        }
        return inversa;
    }

    //Función para la matriz identidad
    private double[][] Identidad(int size){
        double[][] identidad = new double[size][size];

        for(int i = 0; i < size; i++){
            identidad[i][i] = 1;
        }
        return identidad;
    }

    //Función aparte para aumentar la matriz: mitad matriz/ mitad parte identidad
    private double[][] Aumentar(double[][] matriz, double[][] identidad){
        int n = matriz.length;
        double[][] aumento = new double[n][n * 2];
        for(int i = 0; i < n; i++){
            System.arraycopy(matriz[i], 0, aumento[i], 0, n); //Copiar desde fila 0 : Pegar desde indice 0 : pegar n cantidad de elementos
            System.arraycopy(identidad[i], 0, aumento[i], n, n); //Copiar desde fila 0 : Pegar desde indice n
        }
        return aumento;
    }
// Fin "Calculo de la inversa de una matriz"


    //Matriz Normal de valores dependientes "y"
    public double[][] NormalDeY(double[] y){
        int columnas = 1;
        double[][] normalDeY = new double[y.length][columnas];

        for(int i = 0; i < y.length; i++){
            for(int k = 0; k < columnas; k++){
                normalDeY[i][k] = y[i];
            }
        }
        return normalDeY;
    }

    //TranspuestaX por matriz normal de valores dependientes "y"
    public double[][] TranspuestaPorY(double[][] transpuestax, double[][] normaly){
        double[][] transPorY = new double[transpuestax.length][normaly[0].length];
        for(int i = 0; i < transpuestax.length; i++){//size 3 filas
            for(int k = 0; k < transpuestax[0].length; k++){ //size 26 columnas
                for(int j = 0; j < normaly[0].length; j++){ //size 1 columna (y)
                    transPorY[i][j] += transpuestax[i][k] * normaly[k][j];
                }
            }
        }
        return transPorY;
    }

    //              Calculo de los coeficientes de correlacion y de determinación  (r y r^2)
    public double Correlacion(double[] observadosY, double[] observadosX){
            int n = observadosY.length; //Numero de datos observados
            //Suma de los valores observados
            double totalY = Suma(observadosY);
            double totalX = Suma(observadosX);
            //Medias
            double mediaY = totalY/n;
            double mediaX = totalX/n;
            //Sumatorias
            double Numerador = Numerador(observadosX, observadosY, mediaX, mediaY);
            double Denominador = DenominadorX(observadosX, mediaX) * DenominadorY(observadosY, mediaY);
            //Correlacion
            double correlacion = Numerador/ Math.sqrt(Denominador); //Math.sqrt() = Raiz cuadrada

        return correlacion; //retorno
    }

    public double Determinacion(double[] observadosY){
        double ssRegression = 0, ssTotal = 0;
        double total = Suma(observadosY);
        double mediaY = total/ observadosY.length;
        ssTotal = DenominadorY(observadosY, mediaY);
        for(int i = 0; i < observadosY.length; i++){
            ssRegression += Math.pow(mediaY - observadosY[i], 2);
        }

        double determinacion = ssRegression/ssTotal;
        return determinacion;
    }

    private double Suma(double[] data){
        double total = 0;
        for(int i = 0; i < data.length; i++){
            total += data[i];
        }
        return total;
    }

    private double Numerador(double[] dataX, double[] dataY, double mediaX, double mediaY){
        double total = 0;
        for(int a = 0; a < dataY.length; a++){
            total += (dataX[a] - mediaX) * (dataY[a] - mediaY);
        }
        return total;
    }

    private double DenominadorX(double[] dataX, double mediaX){
        double total = 0;
        for(int b = 0; b < dataX.length; b++){
            total += Math.pow(dataX[b]-mediaX, 2);
        }
        return total;
    }
    private double DenominadorY(double[] dataY, double mediaY){
        double total = 0;
        for(int c = 0; c < dataY.length; c++){
            total += Math.pow(dataY[c]-mediaY, 2);
        }
        return total;
    }

    //Fin de calculos para r y r^2


    public void ImprimirBetas(double[][] data){

        for (int i = 0; i < data.length; i++){
            DecimalFormat df = new DecimalFormat("#.######"); // Importar clase, para dar formato con número de decimales esperados (precisión en calculos)
            for(int k = 0; k < data[0].length; k++){
                System.out.println("B"+i+": "+df.format(data[i][k]));
            }
        }
    }

    public void ImprimirPredicciones(double[] y){
        DecimalFormat df = new DecimalFormat("#.###");
        //¿Cual será la eficiencia de la maquina con un Batch Size de x?
        for(int i = 0; i < y.length; i++){
            System.out.println("Y: "+df.format(y[i]));
        }
    }



}
