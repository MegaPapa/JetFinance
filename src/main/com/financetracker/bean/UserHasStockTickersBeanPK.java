package com.financetracker.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by User on 13.03.2017.
 */
public class UserHasStockTickersBeanPK implements Serializable {
    private int userId;
    private int stockTickersId;

    @Column(name = "user_id", nullable = false)
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "stock_tickers_id", nullable = false)
    @Id
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

        UserHasStockTickersBeanPK that = (UserHasStockTickersBeanPK) o;

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
}
