package com.financetracker.bean;

import javax.persistence.*;

/**
 * Created by User on 13.03.2017.
 */
@Entity
@Table(name = "role", schema = "financetrackerdb", catalog = "")
public class RoleBean {
    private int id;
    private String roleName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name", nullable = false, length = 30)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleBean roleBean = (RoleBean) o;

        if (id != roleBean.id) return false;
        if (roleName != null ? !roleName.equals(roleBean.roleName) : roleBean.roleName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        return result;
    }
}
