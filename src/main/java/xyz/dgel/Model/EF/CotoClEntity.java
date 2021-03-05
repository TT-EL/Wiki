package xyz.dgel.Model.EF;

import javax.persistence.*;

@Entity
@Table(name = "CotoCl", schema = "WikiDatebase")
public class CotoClEntity {
    private int cotoclNum;
    private String classId;
    private String courseId;
    private String teacherId;

    @Id
    @Column(name = "cotocl_num")
    public int getCotoclNum() {
        return cotoclNum;
    }

    public void setCotoclNum(int cotoclNum) {
        this.cotoclNum = cotoclNum;
    }

    @Basic
    @Column(name = "class_id")
    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "course_id")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "teacher_id")
    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CotoClEntity that = (CotoClEntity) o;

        if (cotoclNum != that.cotoclNum) return false;
        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;
        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = cotoclNum;
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        return result;
    }
}
