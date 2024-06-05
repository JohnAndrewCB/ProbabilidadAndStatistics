package LinealRegression;
public class RegresionLineal {
    /*
    Program: Calculo de Lineal Regression (B0 y B1)
    Author: Juan André Chávez Baltazar
     */

        private  double b0;
        private  double b1;
        public RegresionLineal(){

        }

        public double getB0(){
                return this.b0;
        }

        public double getB1(){
                return this.b1;
        }



        //Calculo de B0 (intersección)
        public double BetaCero(double nueveveces, double productoSXY, double nuvecesxporx, double cuadradoSx){
                b0 = (nueveveces - productoSXY)/(nuvecesxporx - cuadradoSx);
                return b0;
        }
        //Calculo de B1 (pendiente)
        public double  BetaUno(double mediaY, double b0, double mediaX){
                b1 = mediaY - (b0 * mediaX);
                return b1;
        }

        //Ecuacion de regresion
        //double[] y = myDM.EcuacionRegresion(b0, b1, myDS.getX());

        //Prediccion de datos y = b0 + b1x
        public double[] EcuacionRegresion(double b0, double b1, double[] dataX){
                double[] y = new double[dataX.length];
                int B0 = (int) b0;
                int B1 = (int) b1;
                for(int i = 0; i < dataX.length; i++){
                        y[i] = B0 + (B1 * dataX[i]);
                }
                return y;
        }
}
