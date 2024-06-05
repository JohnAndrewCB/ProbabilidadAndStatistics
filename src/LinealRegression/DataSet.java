package LinealRegression;
public class DataSet {
    // static double sumaPublicidad = 0;
    // static double publicidad[] = new double[9]; //Arreglo independiente

    private double[] publicidad; // variable independiente x
    private double[] ventas; // Variable dependiente y

    //Inicializar los arreglos de "Sales" y de "Advertasing"
    public DataSet(){
        publicidad = new double[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ventas = new double[]{3, 6, 9, 12, 15, 18, 21, 24, 27}; //desde 1544
    }

    double[] xDesconocido = {44, 54, 60, 38, 59};//Datos predecidos 64, 73, 79, 83, 86

    public double[] getX(){
        return this.publicidad;
    }
    public double[] getY(){
        return this.ventas;
    }
    public double[] getxDesconocido(){
        return this.xDesconocido;
    }
}
