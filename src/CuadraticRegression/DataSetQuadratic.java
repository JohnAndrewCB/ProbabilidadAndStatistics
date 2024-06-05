package CuadraticRegression;

public class DataSetQuadratic {
    // static double sumaPublicidad = 0;
    // static double publicidad[] = new double[9]; //Arreglo independiente

    private double[] publicidad; // variable independiente x
    private double[] ventas; // Variable dependiente y

    //Inicializar los arreglos de "Sales" y de "Advertasing"
    public DataSetQuadratic(){
        publicidad = new double[]{10, 15, 20, 24, 30, 34, 40, 45, 48, 50, 58, 60, 64};  //Horas trabajadas
        ventas = new double[]{115.6, 157.2, 189.2, 220.8, 253.8, 269.2, 284.8, 285, 277.4, 269.2, 244.2, 231.4, 180.4}; // Felicidad
    }

    double[] desco = {4, 5, 6, 9, 11};//Arreglo de datos independientes para dependientes desconocidos

    public double[] getX(){
        return this.publicidad;
    }
    public double[] getY(){
        return this.ventas;
    }
    public double[] getDesco(){
        return this.desco;
    }
}
