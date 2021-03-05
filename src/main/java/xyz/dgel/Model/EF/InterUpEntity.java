package xyz.dgel.Model.EF;

import javax.persistence.*;

@Entity
@Table(name = "InterUp", schema = "WikiDatebase")
public class InterUpEntity {
    private String iId;
    private int value;

    @Id
    @Column(name = "i_id")
    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    @Basic
    @Column(name = "value")
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InterUpEntity that = (InterUpEntity) o;

        if (value != that.value) return false;
        if (iId != null ? !iId.equals(that.iId) : that.iId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iId != null ? iId.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }
}
