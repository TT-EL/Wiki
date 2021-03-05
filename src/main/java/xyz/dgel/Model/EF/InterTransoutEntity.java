package xyz.dgel.Model.EF;

import javax.persistence.*;

@Entity
@Table(name = "InterTransout", schema = "WikiDatebase")
public class InterTransoutEntity {
    private String iId;
    private String targetUserId;

    @Id
    @Column(name = "i_id")
    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    @Basic
    @Column(name = "target_user_id")
    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterTransoutEntity that = (InterTransoutEntity) o;

        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;
        if (targetUserId != null ? !targetUserId.equals(that.targetUserId) : that.targetUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + (targetUserId != null ? targetUserId.hashCode() : 0);
        return result;
    }
}
