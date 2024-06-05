package Probabilidades;

public class PConjunta {


    public double ProbabilidadConjunta(String[] eventosSimultaneos, String[] poblacion){
        //En donde se toma en cuenta los casos donde los eventos ocurrieron
        //...simultaneamente, entre el numero de elementos de la poblacion
        double probabilidad = 0;
        double eventoS = eventosSimultaneos.length;
        double n = poblacion.length;

        probabilidad = eventoS / n;

        return probabilidad;
    }

}
