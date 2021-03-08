package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "CoTime", schema = "WikiDatebase")
public class CoTimeEntity {
    private int infoId;
    private String courseTerm;
    private int cotoclNum;
    private String courseYear;
    private String courseWeek;
    private String courseWeekTime;
    private Timestamp courseDate;

    @Id
    @Column(name = "info_id")
    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    @Basic
    @Column(name = "course_year")
    public String getCourseYear() {
        return courseTerm;
    }

    public void setCourseYear(String courseTerm) {
        this.courseTerm = courseTerm;
    }

    @Basic
    @Column(name = "course_term")
    public String getCourseTerm() {
        return courseTerm;
    }

    public void setCourseTerm(String courseTerm) {
        this.courseTerm = courseTerm;
    }

    @Basic
    @Column(name = "cotocl_num")
    public int getCotoclNum() {
        return cotoclNum;
    }

    public void setCotoclNum(int cotoclNum) {
        this.cotoclNum = cotoclNum;
    }

    @Basic
    @Column(name = "course_week")
    public String getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(String courseWeek) {
        this.courseWeek = courseWeek;
    }

    @Basic
    @Column(name = "course_week_time")
    public String getCourseWeekTime() {
        return courseWeekTime;
    }

    public void setCourseWeekTime(String courseWeekTime) {
        this.courseWeekTime = courseWeekTime;
    }

    @Basic
    @Column(name = "course_date")
    public Timestamp getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Timestamp courseDate) {
        this.courseDate = courseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoTimeEntity that = (CoTimeEntity) o;

        if (infoId != that.infoId) return false;
        if (cotoclNum != that.cotoclNum) return false;
        if (courseTerm != null ? !courseTerm.equals(that.courseTerm) : that.courseTerm != null) return false;
        if (courseWeek != null ? !courseWeek.equals(that.courseWeek) : that.courseWeek != null) return false;
        if (courseWeekTime != null ? !courseWeekTime.equals(that.courseWeekTime) : that.courseWeekTime != null)
            return false;
        if (courseDate != null ? !courseDate.equals(that.courseDate) : that.courseDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = infoId;
        result = 31 * result + (courseTerm != null ? courseTerm.hashCode() : 0);
        result = 31 * result + cotoclNum;
        result = 31 * result + (courseWeek != null ? courseWeek.hashCode() : 0);
        result = 31 * result + (courseWeekTime != null ? courseWeekTime.hashCode() : 0);
        result = 31 * result + (courseDate != null ? courseDate.hashCode() : 0);
        return result;
    }
}
