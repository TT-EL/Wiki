package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "User", schema = "WikiDatebase")
public class UserEntity {
    private String userId;
    private String wxId;
    private String wxUsername;
    private String wxImage;
    private Byte wxStatus;
    private String name;
    private Byte power;
    private Timestamp regTime;

    @Id
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "wx_id")
    public String getWxId() {
        return wxId;
    }

    public void setWxId(String wxId) {
        this.wxId = wxId;
    }

    @Basic
    @Column(name = "wx_username")
    public String getWxUsername() {
        return wxUsername;
    }

    public void setWxUsername(String wxUsername) {
        this.wxUsername = wxUsername;
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
    @Column(name = "wx_status")
    public Byte getWxStatus() {
        return wxStatus;
    }

    public void setWxStatus(Byte wxStatus) {
        this.wxStatus = wxStatus;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "power")
    public Byte getPower() {
        return power;
    }

    public void setPower(Byte power) {
        this.power = power;
    }

    @Basic
    @Column(name = "reg_time")
    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (wxId != null ? !wxId.equals(that.wxId) : that.wxId != null) return false;
        if (wxUsername != null ? !wxUsername.equals(that.wxUsername) : that.wxUsername != null) return false;
        if (wxImage != null ? !wxImage.equals(that.wxImage) : that.wxImage != null) return false;
        if (wxStatus != null ? !wxStatus.equals(that.wxStatus) : that.wxStatus != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (power != null ? !power.equals(that.power) : that.power != null) return false;
        if (regTime != null ? !regTime.equals(that.regTime) : that.regTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (wxId != null ? wxId.hashCode() : 0);
        result = 31 * result + (wxUsername != null ? wxUsername.hashCode() : 0);
        result = 31 * result + (wxImage != null ? wxImage.hashCode() : 0);
        result = 31 * result + (wxStatus != null ? wxStatus.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (power != null ? power.hashCode() : 0);
        result = 31 * result + (regTime != null ? regTime.hashCode() : 0);
        return result;
    }
}
