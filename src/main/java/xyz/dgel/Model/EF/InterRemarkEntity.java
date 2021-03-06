package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "InterRemark", schema = "WikiDatebase")
public class InterRemarkEntity {
    private String iId;
    private String remarkText;
    private Timestamp remarkTime;
    public Integer remarkUpNum;

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

    @Basic
    @Column(name = "remark_up_num")
    public Integer getRemarkUpNum() {
        return remarkUpNum;
    }

    public void setRemarkUpNum(Integer remarkUpNum) {
        this.remarkUpNum = remarkUpNum;
    }

}
