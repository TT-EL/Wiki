package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Interaction", schema = "WikiDatebase")
public class InteractionEntity {
    private String iId;
    private Integer iClassify;
    private String tId;
    private String userId;
    private Timestamp iTime;

    @Id
    @Column(name = "i_id")
    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    @Basic
    @Column(name = "i_classify")
    public Integer getiClassify() {
        return iClassify;
    }

    public void setiClassify(Integer iClassify) {
        this.iClassify = iClassify;
    }

    @Basic
    @Column(name = "t_id")
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
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
    @Column(name = "i_time")
    public Timestamp getiTime() {
        return iTime;
    }

    public void setiTime(Timestamp iTime) {
        this.iTime = iTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InteractionEntity that = (InteractionEntity) o;

        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;
        if (iClassify != null ? !iClassify.equals(that.iClassify) : that.iClassify != null) return false;
        if (tId != null ? !tId.equals(that.tId) : that.tId != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (iTime != null ? !iTime.equals(that.iTime) : that.iTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + (iClassify != null ? iClassify.hashCode() : 0);
        result = 31 * result + (tId != null ? tId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (iTime != null ? iTime.hashCode() : 0);
        return result;
    }
}
