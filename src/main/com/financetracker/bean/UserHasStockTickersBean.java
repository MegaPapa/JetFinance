package com.financetracker.bean;

import javax.persistence.*;

/**
 * Created by User on 13.03.2017.
 */
@Entity
@Table(name = "user_has_stock_tickers", schema = "financetrackerdb", catalog = "")
@IdClass(UserHasStockTickersBeanPK.class)
public class UserHasStockTickersBean {
    private int userId;
    private int stockTickersId;
    private UserBean userByUserId;
    private StockTickersBean stockTickersByStockTickersId;

    @Id
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "stock_tickers_id", nullable = false)
    public int getStockTickersId() {
        return stockTickersId;
    }

    public void setStockTickersId(int stockTickersId) {
        this.stockTickersId = stockTickersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserHasStockTickersBean that = (UserHasStockTickersBean) o;

        if (userId != that.userId) return false;
        if (stockTickersId != that.stockTickersId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + stockTickersId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    public UserBean getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserBean userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "stock_tickers_id", referencedColumnName = "id", nullable = false)
    public StockTickersBean getStockTickersByStockTickersId() {
        return stockTickersByStockTickersId;
    }

    public void setStockTickersByStockTickersId(StockTickersBean stockTickersByStockTickersId) {
        this.stockTickersByStockTickersId = stockTickersByStockTickersId;
    }
}
