package CuadraticRegression;

public class QRMain {
    /*
    Program: Prediccion de datos, a partir del Data Set "Varsity Tutors"
    Author: Chávez Baltazar Juan André
    */

    public static void main(String[] args) {
        //Objetos creados para el uso de metodos y obtencion de atributos (get())
        DataSetQuadratic myDSQ = new DataSetQuadratic();
        DiscretMathsQuadratic myDMQ = new DiscretMathsQuadratic();
        QuadraticRegression myQR = new QuadraticRegression();

        double N = 7; //Elementos o pares ordenados (x,y)

        //                          Operaciones con variables dependientes
        //Variables X y Y de primer orden
        double sumaX = myDMQ.Suma(myDSQ.getX());
        double sumalY = myDMQ.Suma(myDSQ.getY());

        double equisY = myDMQ.Equisy(myDSQ.getX(), myDSQ.getY());
        double equiscuaY = myDMQ.EquisCuadradaY(myDSQ.getX(), myDSQ.getY());

        //                          Operaciones con variables independientes
        //Variable X de segundo orden
        double cuadradox = myDMQ.Cuadrado(myDSQ.getX());
        //Variable... tercer orden
        double cubox = myDMQ.Cubo(myDSQ.getX());
        //Variable... cuarto orden
        double cuartax = myDMQ.Cuarta(myDSQ.getX());


        //                          Determinantes
        //Determinante del Sistema = ds
        double ds = myQR.Ds(N, sumaX, cuadradox, cubox, cuartax);

        //Determinante de B0 = db0
        double db0 = myQR.Db0(sumaX, sumalY, cuadradox, cubox, cuartax, equisY, equiscuaY);

        //Determinante de B1 = db1
        double db1 = myQR.Db1(N, sumaX, sumalY, cuadradox, cubox, cuartax, equisY, equiscuaY);

        //Determinante de B2 = db2
        double db2 = myQR.Db2(N, sumaX, sumalY, cuadradox, cubox, equisY, equiscuaY);

        //                       B0, B1, B2 (Determinante S / Determi... de B...0,1,2)
        // Varsity Tutors: B0 = c B2 = a B1 = b
        double b0 = myQR.Betas(db0, ds);
        double b1 = myQR.Betas(db1, ds);
        double b2 = myQR.Betas(db2, ds);

        //Valores para y de jat (datos predecidos)
        //Ecuacion para cualquier parábola
        double[] cuadradoX = myQR.CuadradoX(myDSQ.getX());


        System.out.println("        Quadratic Regression \n");
        System.out.println("B2: " + b2);
        System.out.println("B1: " + b1);
        System.out.println("B0: " + b0);

        System.out.println("y = "+b2+"*x^2"+" + "+b1+"*x"+"+"+b0);

        System.out.println("Datos predecidos: \n");
        double[] equisDesconocido = myDSQ.getDesco();
        double[] equisDescoCuadrado = myQR.CuadradoX(equisDesconocido);
        double[] y = myQR.DataPredecido(b0, b1, b2, equisDesconocido, equisDescoCuadrado);

        for (int i = 0; i < y.length; i++) {
            System.out.println("y = " + y[i]);
        }

    }
}
