package xyz.dgel.Model.ViewModel;

import xyz.dgel.Model.EF.CotoClEntity;

public class ManagerAddCoursePlan extends CotoClEntity {

    private int infoId;
    private String courseYear;

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getCourseYear() {
        return courseYear;
    }

    public void setCourseYear(String courseYear) {
        this.courseYear = courseYear;
    }
}
