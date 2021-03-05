package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "AccumulatePoint", schema = "WikiDatebase")
public class AccumulatePointEntity {
    private int num;
    private String userId;
    private Integer grade;
    private Timestamp gainTime;

    @Id
    @Column(name = "num")
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Basic
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "grade")
    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Basic
    @Column(name = "gain_time")
    public Timestamp getGainTime() {
        return gainTime;
    }

    public void setGainTime(Timestamp gainTime) {
        this.gainTime = gainTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccumulatePointEntity that = (AccumulatePointEntity) o;

        if (num != that.num) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (grade != null ? !grade.equals(that.grade) : that.grade != null) return false;
        if (gainTime != null ? !gainTime.equals(that.gainTime) : that.gainTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (grade != null ? grade.hashCode() : 0);
        result = 31 * result + (gainTime != null ? gainTime.hashCode() : 0);
        return result;
    }
}
