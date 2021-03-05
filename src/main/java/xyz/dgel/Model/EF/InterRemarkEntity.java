package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "InterRemark", schema = "WikiDatebase")
public class InterRemarkEntity {
    private String iId;
    private String remarkText;
    private Timestamp remarkTime;

    @Id
    @Column(name = "i_id")
    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    @Basic
    @Column(name = "remark_text")
    public String getRemarkText() {
        return remarkText;
    }

    public void setRemarkText(String remarkText) {
        this.remarkText = remarkText;
    }

    @Basic
    @Column(name = "remark_time")
    public Timestamp getRemarkTime() {
        return remarkTime;
    }

    public void setRemarkTime(Timestamp remarkTime) {
        this.remarkTime = remarkTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterRemarkEntity that = (InterRemarkEntity) o;

        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;
        if (remarkText != null ? !remarkText.equals(that.remarkText) : that.remarkText != null) return false;
        if (remarkTime != null ? !remarkTime.equals(that.remarkTime) : that.remarkTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + (remarkText != null ? remarkText.hashCode() : 0);
        result = 31 * result + (remarkTime != null ? remarkTime.hashCode() : 0);
        return result;
    }
}
