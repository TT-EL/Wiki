package xyz.dgel.Model.ViewModel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

public class UserRemarkListView {

    private String iId;

    private String userName;

    private String wxImage;

    private String remarkText;



    private String remarkImage;

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
    @Column(name = "remark_image")
    public String getRemarkImage() {
        return remarkImage;
    }

    public void setRemarkImage(String remarkImage) {
        this.remarkImage = remarkImage;
    }
    @Basic
    @Column(name = "name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "wx_image")
    public String getWxImage() {
        return wxImage;
    }

    public void setWxImage(String wxImage) {
        this.wxImage = wxImage;
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
