/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemploCurso;

/**
 *
 * @author admin
 */
public class CourseStudent {
    
    private Student student;
    
    private Double mark;
    
    public CourseStudent(Student _student,Double _mark){
        student = _student;
        mark = _mark;                
    }

    @Override
    public String toString() {
        String msg = "NOT_APPROVED";
        if(isApproved())
            msg = "APPROVED";
        return student.fullName() + " -> " + mark + " - " + msg;
    }
    
    public boolean isApproved() {        
        return mark >= 65D;
    }

    public void reduceMark(double otherMark) {
        if(mark > otherMark)
            mark = mark - otherMark;
        else
            mark = 0D;        
    }
    public void adicionarNota(double nota){
        mark=mark+nota;
    }

    public Student getStudent() {
        return student;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
}
