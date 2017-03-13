package com.financetracker.bean;

import javax.persistence.*;

/**
 * Created by User on 13.03.2017.
 */
@Entity
@Table(name = "system_administrator", schema = "financetrackerdb", catalog = "")
public class SystemAdministratorBean {
    private int id;
    private String nickname;
    private String email;
    private RoleBean roleByRoleId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nickname", nullable = false, length = 50)
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 70)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemAdministratorBean that = (SystemAdministratorBean) o;

        if (id != that.id) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    public RoleBean getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleBean roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }
}
