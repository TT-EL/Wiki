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
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
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


}
