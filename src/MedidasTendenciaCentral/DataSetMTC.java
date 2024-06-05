package MedidasTendenciaCentral;

public class DataSetMTC { //MTC = Medidas de Tendencia Central

    double data[];

    public DataSetMTC(){
        data = new double[]{78, 56, 45, 51, 46, 52, 54, 33, 43, 49, 47, 61, 36, 55, 66, 48, 74, 25, 58, 56, 53, 35, 69, 27, 64, 32, 75, 40, 47, 68, 57};
    }
    public double[] getData(){
        return this.data;
    }

}
