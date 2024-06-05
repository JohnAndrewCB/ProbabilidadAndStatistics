package EstadísticaDescriptiva;

public class DiscretMathsEstad {

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

    //Rango de los datos (dato que ayudará a calcular la cantidad de datos por intervalo)
    public int Rango(double[] data){
        //Obtenemos el elemento más grande del data set y el elemento más pequeño
        //y los restamos.
        double rango = data[data.length - 1] - data[0] ; //"data.length - 1"  hace referencia al último elemento del arrglo.
        return (int) rango; //Casting Doble a Entero
    }

    //Calculo del numero de clases que se emplearan para la agrupación (dependerá del número de datos proporcionado)
    public int NumeroClases(double[] dataSet){
        //Fórmula de "Sturges" para calcular el numero de clases o invervalos obtimos para agrupar mi Data Set
        double k = 1 + 3.322 * Math.log10(dataSet.length);
        if(k % 2 > 0.5){
            k += 1;
        }
        return (int) k; //Casting o cambio de conversion Doble a Entero.
    }

    //Determinar Amplitud para cada invervalo o clase
    public int AmplitudClase(int rango, int k){
        //Calculamos la amplitud que tendrá cada clase
        double c = rango/k;  //Amplitud = Rango/N. clases

        if(rango % k > 0.5){     //Evaluamos el residuo, para determinar si aplica "redondeo" o no
            c += 1;
        }

        return (int) c;
    }

    /*
    Dado que sabemos cuantos intervalos aplicarían, y el rango de ellos al Data Set...
    ...  Empezamos a ordenar nuestros datos y a calcular información relevante al conjunto de datos.
    */
    public double[][] TablaEstadistica(int rango, int k, int c, double[] dataSet){
        //Siempre serán 8 columnas: (clases, límite de clase, frecuencia, punto medio, Frecuencia absoluta,...
        //... frecuencia relativa, frecuencia relativa acomulada, porcentaje)
        double[][] tabla = new double[k][7]; //Quito una columna de las 8, para agregar después los limites de clase

            //Llenado de la tabla: --Columna por columna--
            for(int j = 0; j < 7; j++){ //Recorrer Tabla columnas
                for(int i = 0; i < k; i++){ //Recorrer Tabla filas
                if(j == 0){
                    tabla[i][0] = i + 1;
                } else if (j == 1) {                  //Frecuencia
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

                } else if (j == 2) {        //Punto Medio (Xc)
                    // Calculo de los límites de clase
                    int a = (int) dataSet[0]; // Obtener el valor mínimo del conjunto de datos
                    for (int s = 0; s < k; s++) {
                        int limiteInferior = a + (c * s);
                        int limiteSuperior = limiteInferior + c - 1;
                        int xc = 0; //Inicializar el punto medio para cada intervalo

                        //Calculo del punto medio
                        xc = (limiteSuperior - limiteInferior)/2;
                        if(xc % 2 == 0.5){
                            xc += 1; // siempre quedará como decimal, esto lo resolvemos con un "casting" a Entero.
                        }
                        xc = (int) xc + limiteInferior;
                        tabla[s][2] = xc; // Puntos medios guardados en columna 3 pero columna 4 al mostrar en consola
                    }
                } else if (j == 3) {       // Frecuencia Absoluta
                    double fa = 0;
                    for(int s = 0; s < k; s++){
                        double frecuencia = tabla[s][1];
                        fa += frecuencia;
                        tabla[s][3] = fa;
                    }
                } else if (j == 4) {       // Frecuencia Relativa
                    int totalValores = dataSet.length;

                    for(int s = 0; s < k; s++){
                        double frecuencia = tabla[s][1]; //obtengo la frecuencia de dicho intervalo
                        double fr = frecuencia/totalValores; //Frecuencia Relativa: Frecuencia/TotalDatos
                        tabla[s][4] = fr;
                        fr = 0;
                    }
                } else if (j == 5) { // Frecuencia Relativa Absoluta
                    //Incrementar cada vez más y más la frecuencia relativa por "cada más intervalos que se unan a la ecuación"
                    double fra = 0;
                    for(int s = 0; s < k; s++){
                        double freRelativa = tabla[s][4];
                        fra += freRelativa;
                        tabla[s][5] = fra;
                    }
                } else if (j == 6) { //Porcentaje de la cantidad de datos contenidos por intervalo
                    //Relacionado con la Frecuencia Relativa
                    for(int s = 0; s < k; s++){
                        double freRelativa = tabla[i][4];
                        double porcentaje = freRelativa * 100;
                        tabla[i][6] = porcentaje;
                        porcentaje = 0;
                    }
                } //else if ==> j==6
            }// for int i
        }//for int j
        return tabla;
    }

    //Tabla a parte para los limites de clase
    public int[][] LimitesDeClase(int k, int c, double[] dataSet){
        int[][] limitesClase = new int[k][2];
        int a = (int) dataSet[0];
        for(int i = 0; i < k; i++){
            int limiteInferior = a + (c * i);
            int limiteSup = limiteInferior + c - 1;

            limitesClase[i][0] = limiteInferior;
            limitesClase[i][1] = limiteSup;
        }
        //limitesClase[0][0] = a + " - " + (a + c - 1);
        return limitesClase;
    }

    public void imprimirTabla(double[][]tabla, int[][] limites){
        //Encabezado
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.printf("| %-6s | %-5s | %-5s | %-5s | %-6s | %-6s | %-6s | %-6s |\n", "Clases", "Limite de clases", "Frecuencia", "Punto Medio", "Fa", "fr", "fra", "Porcentaje%");
        System.out.println("-------------------------------------------------------------------------------------------------");
        // Imprimir los datos de la tabla
        for (int i = 0; i < tabla.length; i++) {
            System.out.printf("| %-6s | %-16s | %-10s | %-11s | %-6s | %-6s | %-6s | %-11s |\n", tabla[i][0], limites[i][0]+" - " +limites[i][1], tabla[i][1], tabla[i][2], tabla[i][3], tabla[i][4], tabla[i][5], tabla[i][6]);
        }
        // Imprimir línea de cierre de tabla
        System.out.println("-------------------------------------------------------------------------------------------------");
    }

}//Fin de Clase "DiscretMathsEstad"
