package com.financetracker.bean;

import javax.persistence.*;

/**
 * Created by User on 13.03.2017.
 */
@Entity
@Table(name = "banned_users", schema = "financetrackerdb", catalog = "")
@IdClass(BannedUsersBeanPK.class)
public class BannedUsersBean {
    private int systemAdministratorId;
    private int userId;
    private String description;

    @Id
    @Column(name = "system_administrator_id", nullable = false)
    public int getSystemAdministratorId() {
        return systemAdministratorId;
    }

    public void setSystemAdministratorId(int systemAdministratorId) {
        this.systemAdministratorId = systemAdministratorId;
    }

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "description", nullable = false, length = -1)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BannedUsersBean that = (BannedUsersBean) o;

        if (systemAdministratorId != that.systemAdministratorId) return false;
        if (userId != that.userId) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemAdministratorId;
        result = 31 * result + userId;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
