package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Tie", schema = "WikiDatebase")
public class TieEntity {
    private String tId;
    private int cotoclNum;
    private String userId;
    private String tUrlVideo;
    private String tUrlImage;
    private String tIntroduction;
    private String tText;
    private Integer tWatch;
    private Timestamp tEditTime;

    @Id
    @Column(name = "t_id")
    public String gettId() {
        return tId;
    }

    public void settId(String tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "cotocl_num")
    public int getCourseId() {
        return cotoclNum;
    }

    public void setCourseId(int cotoclNum) {
        this.cotoclNum = cotoclNum;
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
    @Column(name = "t_text")
    public String gettText() {
        return tText;
    }

    public void settText(String tText) {
        this.tText = tText;
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

}
