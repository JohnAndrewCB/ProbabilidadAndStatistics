package PolynomialRegression;

import java.text.DecimalFormat;

public class PolynomialRegression {

    public double[][] Betas(double[][] inversaXT, double[][] tY){//tY = Transpuesta de x por la matriz de las "ys"
        double[][] betas = new double[inversaXT.length][tY[0].length]; //3x1

        for(int i = 0; i < inversaXT.length; i++){ //Recorrer el arreglo resultante 3
            for(int k = 0; k < tY[0].length; k++){ //Recorrer matriz resultante 1
                for(int j = 0; j < inversaXT.length; j++){ //Recorrer matrices que son parámetros 3
                    betas[i][k] += inversaXT[i][j] * tY[j][k];
                }//j
            }//k
        }//i

        return betas;
    }

    public double[] Predicciones(double[] dataDesconocido, double[][]betas){
        double []y = new double[dataDesconocido.length];
        //¿Cual será la "eficiencia de la maquina" (y) con un "Batch Size" de x?

        //De lineal a cubico
        switch(betas.length){
            case 2:   //            Lineal
                for(int i = 0; i < dataDesconocido.length; i++){
                    y[i] = betas[0][0] + (betas[1][0] * dataDesconocido[i]);
                }
                break;
            case 3: //           Cuadratico
                for (int i = 0; i < dataDesconocido.length; i++){
                    y[i] = (betas[2][0] * Math.pow(dataDesconocido[i], 2) + (betas[1][0] * dataDesconocido[i]) + betas[0][0]);
                }
                break;
            case 4: //              Cubo
                for(int i = 0; i < dataDesconocido.length; i++){
                    y[i] = betas[0][0] - (betas[1][0] * dataDesconocido[i]) + (betas[2][0] * Math.pow(dataDesconocido[i], 2)) - (betas[3][0] * Math.pow(dataDesconocido[i], 3));
                }
                break;
        }

        return y;
    }

    public void ecuacionRegresssion(double[][] data, double[][] betas){
        int columnas = data[0].length;
        switch (columnas){
            case 2:
                System.out.println("y = "+betas[0][0]+" + "+betas[1][0]+"*x");
                break;
            case 3:
                System.out.println("y = "+betas[2][0]+"*x^2"+" + "+betas[1][0]+"*x"+" + "+betas[0][0]);
                break;
            case 4:
                System.out.println("y = "+betas[0][0]+" "+betas[1][0]+"*x"+" + "+betas[2][0]+"*x^2"+" "+betas[3][0]+"*x^3");

                break;
        }
    }





}
