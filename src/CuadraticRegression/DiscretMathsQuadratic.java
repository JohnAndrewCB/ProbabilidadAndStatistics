package CuadraticRegression;
import java.lang.Math;
public class DiscretMathsQuadratic {

    //Operaciones matematicas diversas
    //Suma de todos los datos independientes y dependientes
    public double Suma(double[] data){
        double total = 0;
        for(int i = 0; i < data.length; i++){
            total += data[i];
        }
        return total;
    }

    // variables independientes al cuadrado
    public double Cuadrado(double[] data){
        double total = 0;

        for(int i = 0; i < data.length; i++){
            total += Math.pow(data[i], 2);
        }
        return total;
    }
    // variables independientes al cubo
    public double Cubo(double[] data){
        double total = 0;

        for(int i = 0; i < data.length; i++){
            total += Math.pow(data[i],3);
        }
        return total;
    }
    // variables independientes a la cuarta
    public double Cuarta(double[] data){
        double total = 0;
        for(int i = 0; i < data.length; i++){
            total += Math.pow(data[i], 4);
        }
        return total;
    }


    //Operaciones con variables dependientes (xy, (x^2)y)
    //xy
    public double Equisy(double[] x, double[] y){
        double total = 0;
        for(int i = 0; i < x.length; i++){
            total += x[i] * y[i];
        }
        return total;
    }
    //x^2 * y
    public double EquisCuadradaY(double[] x, double[] y){
        double total = 0;
        for(int i = 0; i < x.length; i++){
            total += (x[i] * x[i]) * y[i];
        }
        return total;
    }

}
