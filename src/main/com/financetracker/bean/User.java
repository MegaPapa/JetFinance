package com.financetracker.bean;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

/**
 * Created by User on 19.03.2017.
 */
@Entity
public class User {
    private int id;
    private String nickname;
    private String password;
    private boolean isActive;
    private boolean isPremium;
    private Timestamp premiumEndDate;
    private String email;
    private Role roleByRoleId;
    private Set<StockTickers> tickers;
    private int roleId;

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
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    @Basic
    @Column(name = "is_premium", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    public boolean getIsPremium() {
        return isPremium;
    }

    public void setIsPremium(boolean isPremium) {
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

        User user = (User) o;

        if (id != user.id) return false;
        if (isActive != user.isActive) return false;
        if (isPremium != user.isPremium) return false;
        if (nickname != null ? !nickname.equals(user.nickname) : user.nickname != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (premiumEndDate != null ? !premiumEndDate.equals(user.premiumEndDate) : user.premiumEndDate != null)
            return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (premiumEndDate != null ? premiumEndDate.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @ManyToMany
    @JoinTable(name = "user_has_stock_tickers", schema = "financetrackerdb", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "stock_tickers_id", referencedColumnName = "id", nullable = false))
    public Set<StockTickers> getTickers() {
        return tickers;
    }

    public void setTickers(Set<StockTickers> users) {
        this.tickers = users;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
