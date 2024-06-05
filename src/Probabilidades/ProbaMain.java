package Probabilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.List;

public class ProbaMain {
    /*
    Program: Hands on 8
    Author: Chávez Baltazar Juan André

    - Permutaciones posibles
    - Probabilidades (Conjunta, Marginal, Condicional)
    */
    public static void main(String[] args){
        Permutaciones permutacion = new Permutaciones();
        DataSets dataSets = new DataSets();
        GuardarDatos guardar = new GuardarDatos();

        //      PARTE 1 - PERMUTACIONES

        File fpermutaciones = new File("C://Users/Juani/Documents/2 semestre/Projects JAVA/Permutaciones/permutaciones.txt");

        String[] abecedario = dataSets.pruebaPequeña; //   Población a analizar
        int n = abecedario.length; //Numero de elementos de la Población
        int r = permutacion.r; //   Elementos por permutacion (muestra de la poblacion)

        //  Calcular número de permutaciones
        BigInteger permutaciones = permutacion.Npermutaciones(abecedario, r); //Número de combinaciones posibles

        //  Recopilacion de todos los resultados diferentes posibles (permutaciones)
        List<String> resultados = permutacion.resultados;

        //  Generar permutaciones
        String permuta = ""; //Para comparar, evaluar que no haya letras ya escritas, obtiene los elementos del abecedario
        try {
            permutacion.PermutacionesGeneradas(abecedario, r, n, permuta, resultados); //Método generador
        }catch (OutOfMemoryError e){
            System.out.println("Memoria insuficiente para el sustento del programa: " + e.getMessage());
        }


        for(int i = 0; i < resultados.size(); i++){
            System.out.println(resultados.get(i));
        }


        guardar.GuardarEnArchivo(fpermutaciones, resultados);


        System.out.println("Número de permutaciones: " + permutaciones);
        //System.out.println(resultados.size());
        System.out.println("\n \n");

        //      PARTE 2 - PROBABILIDADES (Marginal, Conjunta, Condicional)
        PMarginal marginal = new PMarginal();
        PConjunta conjunta = new PConjunta();
        PCondicional condicional = new PCondicional();
        String[] dias = dataSets.dias; // Población S = 18 días
        String[] nublado = dataSets.nublado; // Evento A = 9 días
        String[] noNublado = dataSets.noNublado; // Evento a = 9 días
        String[] llueve = dataSets.llueve; // Evento B = 10 días
        String[] noLlueve = dataSets.noLlueve; // Evento b = 8 días
        // Intersecciones
        String[] llueveAndNublado = dataSets.llueveAndNublado; // Dias en que: evento B y A ocurren simultáneamente
        String[] noNubladoAndNollueve = dataSets.noNubladoAndNollueve; // Dias en que: evento b y a ocurren simultáneamente
        String[] noNubladoAndllueve = dataSets.noNubladoAndllueve; // Dias en que: evento a y B ocurren simultáneamente
        String[] nollueveAndNublado = dataSets.nollueveAndNublado; // Dias en que: evento b y A ocurren simultáneamente
        // Probabilidad Marginal de que ocurra Dichos evetos P(A) P(a) P(B) P(b)
        double pA = marginal.ProbabilidadMarginal(nublado, dias);
        double pa = marginal.ProbabilidadMarginal(noNublado, dias);
        double pB = marginal.ProbabilidadMarginal(llueve, dias);
        double pb = marginal.ProbabilidadMarginal(noLlueve, dias);
        // Probabilidad Conjunta de que ocurran ambos eventos simultáneamente
        double pConjuntaAB = conjunta.ProbabilidadConjunta(llueveAndNublado, dias);
        double pCojuntaba = conjunta.ProbabilidadConjunta(noNubladoAndNollueve, dias);
        //  Probabilidad Condicional de que ocurra un evento según dado la ocurrensia de otro
        double pCondicionalBA = condicional.ProbabilidadCondicional(llueveAndNublado, nublado);
        double pCondicionalBa = condicional.ProbabilidadCondicional(noNubladoAndllueve, noNublado);
        double pCondicionalbA = condicional.ProbabilidadCondicional(nollueveAndNublado, nublado);
        double pCondicionalba = condicional.ProbabilidadCondicional(noNubladoAndNollueve, noNublado);
        double pCondicionalAB = condicional.ProbabilidadCondicional(llueveAndNublado, llueve);
        double pCondicionalAb = condicional.ProbabilidadCondicional(nollueveAndNublado, noLlueve);


        //Impresiones (Probabilidades)
        System.out.println("        PROBABILIDADES (Marginal, Conjunta, Condicional)");
        System.out.println("    P(Marginal)");
        System.out.println("P(A): " + pA + " probabilidad de que sea un día Nublado");
        System.out.println("P(a): " + pa + " probabilidad de que NO este Nublado");
        System.out.println("P(B): " + pB + " probabilidad de que llueva");
        System.out.println("P(b): " + pb + " probabilidad de que NO llueva");
        System.out.println("\n");
        System.out.println("    P(Conjunta)");
        System.out.println("P(A ∩ B): " + pConjuntaAB + " probabilidad de que llueva y este nublado");
        System.out.println("P(a ∩ b): "+ pCojuntaba + " probabilidad de que no llueva y no este nublado");

        System.out.println("\n");
        System.out.println("    P(Condicional)");
        System.out.println("P(B|A): "+ pCondicionalBA + " probabilidad de que llueva DADO QUE este nublado");
        System.out.println("P(B|a): "+ pCondicionalBa + " probabilidad de que llueva DADO QUE que no este nublado");
        System.out.println("P(b|A): "+ pCondicionalbA + " probabilidad de que no llueva DADO QUE este nublado");
        System.out.println("P(b|a): "+ pCondicionalba + " probabilidad de que no llueva DADO QUE no este nublado");
        System.out.println("P(A|B): "+ pCondicionalAB + " probabilidad de que este nublado DADO QUE llueva");
        System.out.println("P(A|b): "+ pCondicionalAb + " probabilidad de que este nublado DADO QUE no llueva");

    }//main
}//clase
