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
public class ArchivoEstudiante {
    public static void main(String[] args) {
        Student student=new Student(10, "Ariel", "Chimba", 20);
        Student student1=new Student(20, "Oliver", "Pinto", 20);
        Student student2=new Student(30, "Favio", "Carvallo", 20);
        Student student3=new Student(40, "Berman", "Cabrera", 20);
        
        Student[]estudiantes=new Student[4];
        estudiantes[0]=student;
        estudiantes[1]=student1;
        estudiantes[2]=student2;
        estudiantes[3]=student3;
        FileWriter fw;
        try {
            fw = new FileWriter("D:\\estudiantes.txt");
            PrintWriter pw = new PrintWriter(fw);
            for(int i=0;i<4;i++){
                pw.write(estudiantes[i].toString()+System.getProperty("line.separator"));
            }
            pw.close();
            
            
            FileReader fr=new FileReader("D:\\estudiantes.txt");
            BufferedReader br=new BufferedReader(fr);
            String linea="";
            while((linea=br.readLine())!=null){
                String[] token=linea.split(",");
                System.out.println(new Student(10, token[0], token[1],10).fullName());
            }
            br.close();
            
        } catch (IOException ex) {
            Logger.getLogger(ArchivoEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }
           
    }
}
