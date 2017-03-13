package com.financetracker.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by User on 13.03.2017.
 */
public class BannedUsersBeanPK implements Serializable {
    private int systemAdministratorId;
    private int userId;

    @Column(name = "system_administrator_id", nullable = false)
    @Id
    public int getSystemAdministratorId() {
        return systemAdministratorId;
    }

    public void setSystemAdministratorId(int systemAdministratorId) {
        this.systemAdministratorId = systemAdministratorId;
    }

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BannedUsersBeanPK that = (BannedUsersBeanPK) o;

        if (systemAdministratorId != that.systemAdministratorId) return false;
        if (userId != that.userId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = systemAdministratorId;
        result = 31 * result + userId;
        return result;
    }
}
