package Probabilidades;

public class DataSets {

    String abecedario[];
    String pruebaPequeña[];

    String dias[]; //poblacion
    String nublado[]; // evento A
    String noNublado[]; // evento a
    String llueve[]; // evento B
    String noLlueve[]; // evento b

    //Conjuntos interseptados
    String llueveAndNublado[]; // Dias en que: evento B y A ocurren simultáneamente
    String noNubladoAndNollueve[]; // Dias en que: evento b y a ocurren simultáneamente
    String noNubladoAndllueve[]; // Dias en que: evento a y B ocurren simultáneamente
    String nollueveAndNublado[]; // Dias en que: evento A y b ocurren simultáneamente
    //Abecedario
    public DataSets(){
        //Abecedario - Parte 1 Hands on
        abecedario =  new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "w", "X", "Y", "Z"};
        pruebaPequeña = new String[]{"A", "B", "C", "D", "E"}; //Max k - 12g ram

        //  Pronóstico del clima - Parte 2 Hands on
        dias = new String[]{"Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7", "Dia 8", "Dia 9",
                "Dia 10", "Dia 11", "Dia 12", "Dia 13", "Dia 14", "Dia 15", "Dia 16", "Dia 17", "Dia 18"};
        nublado = new String[]{"Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7", "Dia 8", "Dia 9"};
        noNublado = new String[]{"Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7", "Dia 8", "Dia 9"};
        llueve = new String[]{"Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7", "Dia 8", "Dia 9", "Dia 10"};
        noLlueve = new String[]{"Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7", "Dia 8"};
        //intersecciones
        llueveAndNublado = new String[]{"Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6", "Dia 7"};
        noNubladoAndNollueve = new String[]{"Dia 1", "Dia 2", "Dia 3", "Dia 4", "Dia 5", "Dia 6"};
        noNubladoAndllueve = new String[]{"Dia 1", "Dia 2", "Dia 3"};
        nollueveAndNublado = new String[]{"Dia 1", "Dia 2"};
    }

}//clase
