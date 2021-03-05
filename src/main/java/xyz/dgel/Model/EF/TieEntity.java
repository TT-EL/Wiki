package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Tie", schema = "WikiDatebase", catalog = "")
public class TieEntity {
    private String tId;
    private String courseId;
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
    @Column(name = "course_id")
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TieEntity tieEntity = (TieEntity) o;

        if (tId != null ? !tId.equals(tieEntity.tId) : tieEntity.tId != null) return false;
        if (courseId != null ? !courseId.equals(tieEntity.courseId) : tieEntity.courseId != null) return false;
        if (userId != null ? !userId.equals(tieEntity.userId) : tieEntity.userId != null) return false;
        if (tUrlVideo != null ? !tUrlVideo.equals(tieEntity.tUrlVideo) : tieEntity.tUrlVideo != null) return false;
        if (tUrlImage != null ? !tUrlImage.equals(tieEntity.tUrlImage) : tieEntity.tUrlImage != null) return false;
        if (tIntroduction != null ? !tIntroduction.equals(tieEntity.tIntroduction) : tieEntity.tIntroduction != null)
            return false;
        if (tText != null ? !tText.equals(tieEntity.tText) : tieEntity.tText != null) return false;
        if (tWatch != null ? !tWatch.equals(tieEntity.tWatch) : tieEntity.tWatch != null) return false;
        if (tEditTime != null ? !tEditTime.equals(tieEntity.tEditTime) : tieEntity.tEditTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId != null ? tId.hashCode() : 0;
        result = 31 * result + (courseId != null ? courseId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (tUrlVideo != null ? tUrlVideo.hashCode() : 0);
        result = 31 * result + (tUrlImage != null ? tUrlImage.hashCode() : 0);
        result = 31 * result + (tIntroduction != null ? tIntroduction.hashCode() : 0);
        result = 31 * result + (tText != null ? tText.hashCode() : 0);
        result = 31 * result + (tWatch != null ? tWatch.hashCode() : 0);
        result = 31 * result + (tEditTime != null ? tEditTime.hashCode() : 0);
        return result;
    }
}
