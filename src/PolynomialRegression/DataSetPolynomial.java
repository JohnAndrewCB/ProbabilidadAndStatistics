package PolynomialRegression;

public class DataSetPolynomial {

 private double[] x; //Batch size (Materia prima, tamaño del lote)
 private double[] y; //Machine Efficiency (eficiencia de la maquina)

 public DataSetPolynomial(){
     x = new double[]{108, 115, 106, 97, 95, 91, 97, 83, 83, 78, 54, 67, 56, 53,
                      61, 115, 81, 78, 30, 45, 99, 32, 25, 28, 90, 89};

     y = new double[]{95, 96, 95, 97, 93, 94, 95, 93, 92, 86, 73, 80, 65, 69, 77,
                      96, 87, 89, 60, 63, 95, 61, 55, 56, 94, 93};
 }

 public double[] getX(){
     return this.x;
 }

 public double[] getY() {
        return this.y;
 }

 public double[]batchSizeDesconocido = {110, 26, 112, 33, 100}; //Valores x, para "y" desconocidas.

 public double[] getDesco(){
     return this.batchSizeDesconocido;
 }
}