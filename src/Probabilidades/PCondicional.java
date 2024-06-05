package Probabilidades;

public class PCondicional {


    public double ProbabilidadCondicional(String[] eve1AndEve2, String[] evento2){
        //Probabilidad de que ocurra evento1 dado que ocurrió evento2. (No habiendo independencia)
        double probabilidad = 0;
        double conjuncionEventos = (double) eve1AndEve2.length;
        double eventoCondicionado = (double) evento2.length;

        probabilidad = conjuncionEventos/eventoCondicionado;     // P(evento1 ∩ evento2) / P(evento condicionado)

        return probabilidad;
    }





}
