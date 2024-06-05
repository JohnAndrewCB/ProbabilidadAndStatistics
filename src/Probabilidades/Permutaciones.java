package Probabilidades;

import java.math.BigInteger; //Importar clase de math para almacenar el valor maximo del fact(N.elementosArreglo)
import java.util.ArrayList;
import java.util.List;

public class Permutaciones {

    //Número de Elementos a considerar para cada permutacion posible.
    public int r = 3;
    //Lista de almacenaje para todas permutacones posibles
    List<String> resultados = new ArrayList<>();


    public void PermutacionesGeneradas(String[] abecedario, int r, int n, String permuta,List<String> resultados) throws OutOfMemoryError{
        //Hablamos de: permutacion/LINEAL/elementos sin repetir

        //En el caso de que se haya construido una PERMUTACION COMPLETA
        if(r == 0){ //
            resultados.add(permuta);
            return;
        }

        for(int i = 0; i < n; i++){ // Tomar elementos de la población
            if(!permuta.contains(abecedario[i])){
                PermutacionesGeneradas(abecedario, r - 1, n,permuta + abecedario[i], resultados); //Método recursivo
            }
        }

        /*
        El punto de la recursividad, es que por cada vuelta de ejecucion de este mismo método
        me estará generando letra por letra la cadena de texto de una permutación (Cuando r=0, el for continuara
        generando la siguiente permutacion con la letra que siga "i" permitiendo 0 repeticiones de permutas), la condicion juega
        un papel imortante lógico, ya que mientras no se hayan agregado todos los elementos, seguira
        construyendo esa misma permutacion.
         */
    }
    /*
    private static void generatePermutations(String[] abecedario, String prefix, int n, int r, List<String> result) {

        for (int i = 0; i < n; i++) {
            if (!prefix.contains(abecedario[i])) {  // Evitar repetición de elementos
                generatePermutations(abecedario, prefix + abecedario[i], n, r - 1, result);
            }
        }
   }
     */


    public BigInteger Npermutaciones(String[] abecedario, int r){
        int n = abecedario.length;
        BigInteger factorialN = BigInteger.ONE; //inicializar a 1
        BigInteger permutaciones;
        for(int i = 1; i <= n; i++){ //Factorial del número de elementos
            factorialN = factorialN.multiply(BigInteger.valueOf(i)); //Multiplica por i, cada resultado actual
        }

        int denominador = n - r;

        BigInteger factorialdenominador = BigInteger.ONE; //inicializar a 1
        for(int i = 1; i <= denominador; i++){
            factorialdenominador = factorialdenominador.multiply(BigInteger.valueOf(i));
        }

        permutaciones = factorialN.divide(factorialdenominador);

        return permutaciones;
    }


}//clase
