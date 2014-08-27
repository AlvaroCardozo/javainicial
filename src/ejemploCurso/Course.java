/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploCurso;

import java.util.Scanner;

/**
 *
 * @author admin
 */
public class Course {
    
    private int id;
    private String name;
    private int maxCapacity = 5;
    private CourseStudent[] courseStudents;
    
    public Course(int _id, String _name, int _capacity) {
        id = _id;
        name = _name;
        maxCapacity = _capacity;        
        courseStudents = new CourseStudent[maxCapacity];
    }
    
    public void register(Student student) {        
        int emptyCell = -1;
        for (int i = 0; i < maxCapacity && emptyCell == -1; i++) {
            if (courseStudents[i] == null) {
                emptyCell = i;
            }            
        }
        courseStudents[emptyCell] = new CourseStudent(student, 100D);
    }
    
    public int amountOfStudents() {
        int count = 0;
        for (int i = 0; i < maxCapacity; i++) {
            if (courseStudents[i] != null) {
                count++;
            }
        }
        return count;
    }
    
    private void reduceMark(double mark) {        
        for (int i = 0; i < maxCapacity; i++) {
            if (courseStudents[i] != null) {
                courseStudents[i].reduceMark(mark);
            }
        }
    }

    private void adicionarNota(double nota) {
        for (int i = 0; i < maxCapacity; i++) {
            if(courseStudents[i]!=null){
                courseStudents[i].adicionarNota(nota);
            }
        }        
    }
    
    private void printDetails() {
        String output = "Course: " + name + " id: " + id + "\n";
        output = output + "-----------------------\n";
        for (int i = 0; i < maxCapacity; i++) {
            if (courseStudents[i] != null) {
                output = output + courseStudents[i].toString() + "\n";
            }
        }
        System.out.println(output);
    }
    private Student obtenerEstudiante(String id){
        Student st=null;
        for (int i = 0; i < courseStudents.length; i++) {
            if (courseStudents[i] != null) {
                CourseStudent cs=courseStudents[i];
                Student estudiante=cs.getStudent();
                if(estudiante.id()==Integer.parseInt(id)){
                    st=estudiante;
                    break;
                }                        
            }
        }
        return st;
    }
    
    
    public CourseStudent obtenerNotaMaxima(){
        CourseStudent st=null;
        Double notaMaxima=0D;
        for (int i = 0; i < courseStudents.length; i++) {
            if (courseStudents[i] != null) {
                if(courseStudents[i].getMark()>notaMaxima){
                    notaMaxima=courseStudents[i].getMark();
                    st=courseStudents[i];
                }
            }
        }
        return st;
    }
     public CourseStudent obtenerCursoEstudiante(String id){
        CourseStudent st=null;
        for (int i = 0; i < courseStudents.length; i++) {
            if (courseStudents[i] != null) {
                CourseStudent cs=courseStudents[i];
                Student estudiante=cs.getStudent();
                if(estudiante.id()==Integer.parseInt(id)){
                    st=cs;
                    break;
                }                        
            }
        }
        return st;
    }
    private double promediar(){
        int cantEstudiantes=0;
        double total=0D;
        for (int i = 0; i < courseStudents.length; i++) {
            if (courseStudents[i] != null) {
                //cantEstudiantes=cantEstudiantes+1;
                cantEstudiantes++;
                //total=total+courseStudents[i].getMark();;
                total+=courseStudents[i].getMark();
            }
        }
        return total/cantEstudiantes;
    }
    
    public void imprimirClasificacion(){
        //for excelentes
        System.out.println("Alumnos Excelentes");
         for (int i = 0; i < courseStudents.length; i++) {
            if (courseStudents[i] != null) {
                if(courseStudents[i].getMark()>=85){
                    System.out.println(courseStudents[i].getStudent().fullName()+" "+courseStudents[i].getMark());
                }
            }
         }
         //for buenos
         System.out.println("Alumnos Buenos");
         for (int i = 0; i < courseStudents.length; i++) {
            if (courseStudents[i] != null) {
                if(courseStudents[i].getMark()>=70&&courseStudents[i].getMark()<85){
                    System.out.println(courseStudents[i].getStudent().fullName()+" "+courseStudents[i].getMark());
                }
            }
         }
         //for regulares
         System.out.println("alumnos regulares");
         for (int i = 0; i < courseStudents.length; i++) {
            if (courseStudents[i] != null) {
                if(courseStudents[i].getMark()>=51&&courseStudents[i].getMark()<70){
                    System.out.println(courseStudents[i].getStudent().fullName()+" "+courseStudents[i].getMark());
                }
            }
         }
         //for deficientes
         System.out.println("alumnos deficientes");
         for (int i = 0; i < courseStudents.length; i++) {
            if (courseStudents[i] != null) {
                if(courseStudents[i].getMark()<51){
                    System.out.println(courseStudents[i].getStudent().fullName()+" "+courseStudents[i].getMark());
                }
            }
         }
    }
    
    public static void main(String[] args) {
        Course course = new Course(1, "java_inicial", 4);        
        course.register(new Student(10, "Ariel", "Chimba", 21));
        course.register(new Student(20, "Oliver", "Pinto", 25));
//        System.out.println("registered students: " + course.amountOfStudents());        
//        course.printDetails();
//        course.reduceMark(35.1D);
//        course.printDetails(); 
//        course.adicionarNota(25D);
//        course.printDetails();
        /*Menu*/
        int opcionSeleccionada=0;
        Scanner scanner=new Scanner(System.in);
        while(opcionSeleccionada!=5){
            System.out.println("==========================");
            System.out.println("Menu");
            System.out.println("==========================");
            System.out.println("1.-Mostrar Alumno");
            System.out.println("2.-Promedio");
            System.out.println("3.-Imprimir detalle");
            System.out.println("4.-Registrar nota");
            System.out.println("5.-Salir");
            System.out.println("6.-Mejor Alumno");
            System.out.println("7.-clasificacion");
            String opcion=scanner.next();
            opcionSeleccionada=Integer.valueOf(opcion);
            if(opcionSeleccionada==3){
                course.printDetails();
                System.out.println("Escriba ok");
                scanner.next("ok");
            }else if(opcionSeleccionada==1){
                System.out.println("Ingrese el id del Alumno");
                String id=scanner.next();
                Student estudiante=course.obtenerEstudiante(id);
                if(estudiante!=null){
                    System.out.println(estudiante.fullName());
                }else{
                    System.out.println("Id invalido!");
                }
            }else if(opcionSeleccionada==2){
                System.out.println("El promedio del curso es: "+course.promediar());
            }else if(opcionSeleccionada==4){
                System.out.println("Ingrese el id del estudiante");
                String id=scanner.next();
                //Pedir el id del estudiante
                CourseStudent cs=course.obtenerCursoEstudiante(id);
                //obtener courseEstudiante
                //pedir la nota del estudiante
                System.out.println("Ingrese nota!");
                String nota=scanner.next();
                Double notad= Double.parseDouble(nota);
                
                //poner Nota courseEstudiante.setMark(50);
                cs.setMark(notad);
                course.printDetails();
            }else if(opcionSeleccionada==6){//Mejor Alumno
                CourseStudent cs= course.obtenerNotaMaxima();
                System.out.println(cs.getStudent().fullName()+" :"+cs.getMark());
            }else if(opcionSeleccionada==7){
                course.imprimirClasificacion();
            }
        }
        System.out.println("Chau!!!!");
        
    }
}
