package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Student", schema = "WikiDatebase")
public class StudentEntity extends UserEntity{

    private String studentId;

    private String classId;

    private Integer enrolTime;


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public Integer getEnrolTime() {
        return enrolTime;
    }

    public void setEnrolTime(Integer enrolTime) {
        this.enrolTime = enrolTime;
    }
}
