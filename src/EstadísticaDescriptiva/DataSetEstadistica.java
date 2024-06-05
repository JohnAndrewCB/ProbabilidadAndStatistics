package EstadísticaDescriptiva;

public class DataSetEstadistica {

    double[] data;

    public DataSetEstadistica(){
        data = new double[]{105, 106, 105, 107, 109, 111, 110, 110, 107, 107, 104,
                99, 103, 99, 103, 101, 100, 101, 100, 103, 98, 92, 97, 94, 95, 95,
                93, 95, 95, 95, 91, 82, 91, 85, 90, 86, 87, 89, 87, 89, 83, 106,
                103, 110, 93, 97, 88, 99, 99, 97, 96, 86, 84, 84, 91, 90, 96, 89,
                98, 88, 82, 111, 103, 81, 94, 92, 97, 85, 100, 105, 101, 107, 108,
                84, 84, 82, 91, 97, 91, 99, 102, 109, 110, 85, 83, 87, 99, 120,
                118, 113, 115, 113, 114, 96, 104, 114, 120, 119, 115, 116}; //Data Set del ejemplo de clase (modificado)
    }

    public double[] getData(){
        return this.data;
    }
}
