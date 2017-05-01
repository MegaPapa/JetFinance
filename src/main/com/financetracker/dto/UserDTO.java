package com.financetracker.dto;

import com.financetracker.bean.StockTickers;

import java.util.Set;

/**
 * Created by User on 01.05.2017.
 */
public class UserDTO {

    private int id;
    private String email;
    private String name;
    private String password;
    private Set<StockTickers> tickers;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<StockTickers> getTickers() {
        return tickers;
    }

    public void setTickers(Set<StockTickers> tickers) {
        this.tickers = tickers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
