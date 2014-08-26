/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploCurso;

/**
 *
 * @author admin
 */
public class Student {
    
    private int id;
    
    private String name;
    
    private String lastName;
    
    private int age;
    
    public Student(int _id, String _name, String _lastName, int _age){
        id = _id;
        name = _name;
        lastName = _lastName;
        age = _age;        
    }
    
    public int id(){
        return id;
    }
    
    public String fullName(){
        return name + " " + lastName;
    }
    
    public static void main(String[] args) {
        Student ariel = new Student(10, "Ariel", "Chimba", 21);
        System.out.println("full name: " + ariel.fullName());
    }
    @Override
    public String toString(){
        return name + " " + lastName;
    }
}
