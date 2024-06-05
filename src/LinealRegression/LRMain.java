package LinealRegression;

public class LRMain {
    /*
    Program: Este programa calcula la mejor curva para un conjunto de datos, formula universal (Caso Benetton)
    Author: Juan André Chávez Baltazar
     */

    public static void main(String[] args){
        DataSet myDS = new DataSet();
        DiscretMaths myDM = new DiscretMaths();
        RegresionLineal myLR = new RegresionLineal();

        //Media de la suma de los cunjuntos de datos
        double sumaX = myDM.Suma(myDS.getX());
        double mediaX = myDM.Media(sumaX);

        double sumaY = myDM.Suma(myDS.getY());
        double mediaY = myDM.Media(sumaY);

        //Multiplicacion y suma de los datos (conjunto x)
        double[] multiX = myDM.Multiplicacion(myDS.getX());
        myDM.Suma(multiX);

        //Ventas por publicidad
        double[] multixy = myDM.VentasPorPubli(myDS.getX(), myDS.getY());
        myDM.Suma(multixy);

        //El numero de datos por la suma de multixy
        double nueveveces = myDS.getX().length * myDM.Suma(multixy);

        //Producto de sumas de el conjunto de datos de "x" y "y"
        double productoSXY = sumaX * sumaY;

        //9*mutixy menos el producto de los cunjuntos de datos
        double resta = nueveveces - productoSXY;

        //Nueve veces la suma de x*x (conjunto x)
        double nuvecesxporx = multiX.length * myDM.Suma(multiX);

        //Suma de x*x al cuadrado
        double cuadradox2 = myDM.Suma(multiX) * myDM.Suma(multiX);

        //Suma de x al cuadrado
        double cuadradoSx = sumaX * sumaX;

        //Betas del modelo de regresion gracias al data set original
        double b0 = myLR.BetaCero(nueveveces, productoSXY, nuvecesxporx, cuadradoSx);
        double b1 = myLR.BetaUno(mediaY, b0, mediaX);

        //Datos predecidos (data set independiente al data set original)
        double[] equisDesconocido = myDS.getxDesconocido();
        double[] y = myLR.EcuacionRegresion(b0, b1, equisDesconocido);

        System.out.println("        Regresion Lineal (caso Benetton)\n");

        System.out.println("B0: " + b0);
        System.out.println("B1: " + b1);

        System.out.println("Euacion de regresion y = B0 + B1x / " + b0 +" + "+ b1+" * x\n");

        System.out.println("Datos predecidos: \n");
        for(int i = 0; i < y.length; i++){
                System.out.println(" " + y[i]);
        }

    }
}
