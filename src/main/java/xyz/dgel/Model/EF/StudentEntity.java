package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Student", schema = "WikiDatebase")
public class StudentEntity extends UserEntity{
    private String studentId;
    private String classId;
    private Timestamp enrolTime;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Basic
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    public Timestamp getEnrolTime() {
        return enrolTime;
    }

    public void setEnrolTime(Timestamp enrolTime) {
        this.enrolTime = enrolTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentEntity that = (StudentEntity) o;

        if (studentId != null ? !studentId.equals(that.studentId) : that.studentId != null) return false;
        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;
        if (enrolTime != null ? !enrolTime.equals(that.enrolTime) : that.enrolTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = studentId != null ? studentId.hashCode() : 0;
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        result = 31 * result + (enrolTime != null ? enrolTime.hashCode() : 0);
        return result;
    }
}
