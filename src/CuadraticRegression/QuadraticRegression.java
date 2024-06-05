package CuadraticRegression;

public class QuadraticRegression {

    //Calculo de la Determinante del Sistema
    public double Ds(double n,double sumax, double cuadradox, double cubox, double cuartax){
        double total = 0;

        total = (n * cuadradox * cuartax) + (sumax * cubox * cuadradox) + (cuadradox * sumax * cubox)
                - (Math.pow(cuadradox, 3) - (Math.pow(cubox, 2) * n) - (Math.pow(sumax, 2) * cuartax));

        return total;
    }

    //Calculo de Determinante de B0 (convexa o concava hacia a bajo)
    public double Db0(double sumax, double sumay, double cuadradox, double cubox, double cuartax, double equisy, double equiscuay){
        double total = 0;

        total = (sumay * cuadradox * cuartax) + (sumax * cubox * equiscuay) + (cuadradox * equisy * cubox)
                - (Math.pow(cuadradox,2) * equiscuay) - (Math.pow(cubox, 2) * sumay) - (cuartax * equisy * sumax);

        return total;
    }

    //Calculo de Determinante de B1 (amplitud de curva)
    public double Db1(double n, double sumax, double sumay, double cuadradox, double cubox, double cuartax, double equisy, double equiscuay){
        double total = 0;

        total = (n * equisy * cuartax) + (sumay * cubox * cuadradox) + (cuadradox * sumax * equiscuay)
                - (cuadradox *  equisy * cuadradox) - (equiscuay * cubox * n) - (cuartax * sumax * sumay);

        return total;
    }

    //Calculo de Determinante de B2 (intersepción con eje y)
    public double Db2(double n, double sumax, double sumay, double cuadradox, double cubox, double equisy, double equiscuay){
        double total = 0;

        total = (n * cuadradox * equiscuay) + (sumax * equisy * cuadradox) + (sumay * sumax *  cubox)
                - (Math.pow(cuadradox, 2) * sumay) - (cubox * equisy * n) - (Math.pow(sumax, 2) * equiscuay);

        return total;
    }

    //Calculo de las B... 0,1,2
    public double Betas(double db, double ds){
        double total = 0;

        total = db / ds;

        return total;
    }

    //Margen de ERROR
    /*public double MargenError(){

    } */

    //Ecuacion de regresion cuadratica

    public double[] CuadradoX(double[] data){
        double[] total = new double[data.length];

        for(int i = 0; i < data.length; i++){
            total[i] += Math.pow(data[i], 2);
        }
        return total;
    }

    public double[] DataPredecido(double b0, double b1, double b2, double[] x, double[] cuadradox){
        double[] y = new double[x.length];

        for(int i = 0; i < x.length; i++){
            y[i] = (b2 * cuadradox[i] + (b1 * x[i]) + b0); // + e
        }
        return  y;
    }
}
