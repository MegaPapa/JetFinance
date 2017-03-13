package com.financetracker.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by User on 13.03.2017.
 */
@Entity
@Table(name = "user", schema = "financetrackerdb", catalog = "")
public class UserBean {
    private int id;
    private String nickname;
    private String password;
    private byte isActive;
    private byte isPremium;
    private Timestamp premiumEndDate;
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
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "is_active", nullable = false)
    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "is_premium", nullable = false)
    public byte getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(byte isPremium) {
        this.isPremium = isPremium;
    }

    @Basic
    @Column(name = "premium_end_date", nullable = false)
    public Timestamp getPremiumEndDate() {
        return premiumEndDate;
    }

    public void setPremiumEndDate(Timestamp premiumEndDate) {
        this.premiumEndDate = premiumEndDate;
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

        UserBean userBean = (UserBean) o;

        if (id != userBean.id) return false;
        if (isActive != userBean.isActive) return false;
        if (isPremium != userBean.isPremium) return false;
        if (nickname != null ? !nickname.equals(userBean.nickname) : userBean.nickname != null) return false;
        if (password != null ? !password.equals(userBean.password) : userBean.password != null) return false;
        if (premiumEndDate != null ? !premiumEndDate.equals(userBean.premiumEndDate) : userBean.premiumEndDate != null)
            return false;
        if (email != null ? !email.equals(userBean.email) : userBean.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) isActive;
        result = 31 * result + (int) isPremium;
        result = 31 * result + (premiumEndDate != null ? premiumEndDate.hashCode() : 0);
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
