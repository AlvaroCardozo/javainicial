/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploCurso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Archivo {

    public static void main(String[] args) {
        try {
            FileWriter fw = new FileWriter("D:\\prueba.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.write("Hola mundo!");
            pw.close();
            
            FileReader fr=new FileReader("D:\\prueba.txt");
            BufferedReader br=new BufferedReader(fr);
            String linea="";
            while((linea=br.readLine())!=null){
                System.out.println(linea);
            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
