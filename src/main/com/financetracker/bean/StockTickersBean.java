package com.financetracker.bean;

import javax.persistence.*;

/**
 * Created by User on 13.03.2017.
 */
@Entity
@Table(name = "stock_tickers", schema = "financetrackerdb", catalog = "")
public class StockTickersBean {
    private int id;
    private String companyName;
    private String ticker;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "company_name", nullable = false, length = 80)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "ticker", nullable = false, length = 20)
    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockTickersBean that = (StockTickersBean) o;

        if (id != that.id) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null) return false;
        if (ticker != null ? !ticker.equals(that.ticker) : that.ticker != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (ticker != null ? ticker.hashCode() : 0);
        return result;
    }
}
