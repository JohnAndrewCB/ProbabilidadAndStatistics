package Probabilidades;

import java.io.*;
import java.util.List;

public class GuardarDatos {

    public void GuardarEnArchivo(File fpermutaciones, List<String> resultados){
        try{
            FileWriter fw = new FileWriter(fpermutaciones, false); //False para sobreescribir lo que escriba a continuación
            PrintWriter pw = new PrintWriter(fw);
            for(String permuta : resultados){
                pw.println(permuta);
            }
            fw.close(); // cerramos flujo de escritura
        }catch (IOException e){
            System.out.println("Error de entrada y/o salida: " + e.getMessage());
        }
    }

    public void LecturaDeArchivo(File archivo){
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            while (linea != null){
                System.out.println(linea);
                linea = br.readLine();
            }
            fr.close();
        }catch(IOException e){
            System.out.println("Error al tratar de leer el documento");
        }
    }

}//clase
