package xyz.dgel.Model.EF;

import javax.persistence.*;

@Entity
@Table(name = "Course", schema = "WikiDatebase")
public class CourseEntity {
    private String courseId;
    private String courseName;
    private String courseDesc;
    private String courseImage;

    @Id
    @Column(name = "course_id")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Basic
    @Column(name = "course_name")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "course_desc")
    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    @Basic
    @Column(name = "course_image")
    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseEntity that = (CourseEntity) o;

        if (courseId != null ? !courseId.equals(that.courseId) : that.courseId != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (courseDesc != null ? !courseDesc.equals(that.courseDesc) : that.courseDesc != null) return false;
        if (courseImage != null ? !courseImage.equals(that.courseImage) : that.courseImage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = courseId != null ? courseId.hashCode() : 0;
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (courseDesc != null ? courseDesc.hashCode() : 0);
        result = 31 * result + (courseImage != null ? courseImage.hashCode() : 0);
        return result;
    }
}
