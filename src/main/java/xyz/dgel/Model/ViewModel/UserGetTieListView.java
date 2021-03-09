package xyz.dgel.Model.ViewModel;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

public class UserGetTieListView {

    private String tId;
    private String tUrlVideo;
    private String tUrlImage;
    private String tIntroduction;
    private Integer tWatch;
    private Timestamp tEditTime;
    private String wxImage;
    private String name;

    @Id
    @Column(name = "t_id")
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }


    @Basic
    @Column(name = "t_url_video")
    public String gettUrlVideo() {
        return tUrlVideo;
    }

    public void settUrlVideo(String tUrlVideo) {
        this.tUrlVideo = tUrlVideo;
    }

    @Basic
    @Column(name = "t_url_image")
    public String gettUrlImage() {
        return tUrlImage;
    }

    public void settUrlImage(String tUrlImage) {
        this.tUrlImage = tUrlImage;
    }

    @Basic
    @Column(name = "t_introduction")
    public String gettIntroduction() {
        return tIntroduction;
    }

    public void settIntroduction(String tIntroduction) {
        this.tIntroduction = tIntroduction;
    }


    @Basic
    @Column(name = "t_watch")
    public Integer gettWatch() {
        return tWatch;
    }

    public void settWatch(Integer tWatch) {
        this.tWatch = tWatch;
    }

    @Basic
    @Column(name = "t_edit_time")
    public Timestamp gettEditTime() {
        return tEditTime;
    }

    public void settEditTime(Timestamp tEditTime) {
        this.tEditTime = tEditTime;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
