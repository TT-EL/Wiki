package xyz.dgel.Model.EF;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "InterCollection", schema = "WikiDatebase")
public class InterCollectionEntity {
    private String iId;
    private Timestamp collectionTime;

    @Id
    @Column(name = "i_id")
    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    @Basic
    @Column(name = "collection_time")
    public Timestamp getCollectionTime() {
        return collectionTime;
    }

    public void setCollectionTime(Timestamp collectionTime) {
        this.collectionTime = collectionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterCollectionEntity that = (InterCollectionEntity) o;

        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;
        if (collectionTime != null ? !collectionTime.equals(that.collectionTime) : that.collectionTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + (collectionTime != null ? collectionTime.hashCode() : 0);
        return result;
    }
}
