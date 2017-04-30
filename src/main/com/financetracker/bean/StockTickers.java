package com.financetracker.bean;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 19.03.2017.
 */
@Entity
@Table(name = "stock_tickers", schema = "financetrackerdb", catalog = "")
public class StockTickers {
    private int id;
    private String companyName;
    private String ticker;
    private Set<User> userStockTickers;
    private List<StockPricePredictions> stockTickers;

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

        StockTickers that = (StockTickers) o;

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

    @ManyToMany(mappedBy = "tickers")
    public Set<User> getUserStockTickers() {
        return userStockTickers;
    }

    public void setUserStockTickers(Set<User> userStockTickers) {
        this.userStockTickers = userStockTickers;
    }

    @ManyToMany
    @JoinTable(name = "stock_price_predictions_has_stock_tickers", catalog = "", schema = "financetrackerdb", joinColumns = @JoinColumn(name = "stock_tickers_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "stock_price_predictions_id", referencedColumnName = "id", nullable = false))
    public List<StockPricePredictions> getStockTickers() {
        return stockTickers;
    }

    public void setStockTickers(List<StockPricePredictions> stockTickers) {
        this.stockTickers = stockTickers;
    }
}
