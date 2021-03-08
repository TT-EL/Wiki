package xyz.dgel.Model.ViewModel;

public class CourseInfoListView {

    public String course_id;

    public String course_name;

    public String year;

    public String teacher_name;

    public String class_name;

    public String course_desc;

    public Integer student_count;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getCourse_desc() {
        return course_desc;
    }

    public void setCourse_desc(String course_desc) {
        this.course_desc = course_desc;
    }

    public Integer getTudent_count() {
        return student_count;
    }

    public void setTudent_count(Integer student_count) {
        this.student_count = student_count;
    }
}
