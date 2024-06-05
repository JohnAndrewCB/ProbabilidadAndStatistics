package Probabilidades;

public class PMarginal {

    // P(evento) = Probabilidad de que ocurra tal "evento" (evento Marginal)
    public double ProbabilidadMarginal(String[] evento, String[] poblacion){
        double probabilidad = 0;
        double e = evento.length;
        double n = poblacion.length;

        probabilidad = e / n;

        return probabilidad;
    }


}
