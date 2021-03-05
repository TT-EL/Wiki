package xyz.dgel.Model.EF;

import javax.persistence.*;

@Entity
@Table(name = "employee", schema = "WikiDatebase")
public class EmployeeEntity {
    private String eid;
    private String ename;

    @Id
    @Column(name = "eid")
    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    @Basic
    @Column(name = "ename")
    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EmployeeEntity that = (EmployeeEntity) o;

        if (eid != null ? !eid.equals(that.eid) : that.eid != null) return false;
        if (ename != null ? !ename.equals(that.ename) : that.ename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eid != null ? eid.hashCode() : 0;
        result = 31 * result + (ename != null ? ename.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "id=" +eid+",name="+ename;
    }
}
