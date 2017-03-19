package com.financetracker.bean;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by User on 19.03.2017.
 */
@Entity
@Table(name = "stock_price_predictions", schema = "financetrackerdb", catalog = "")
public class StockPricePredictions {
    private int id;
    private Timestamp predictionDate;
    private BigDecimal stockPrice;
    private String stockState;
    private List<StockTickers> pricePredictions;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "prediction_date", nullable = false)
    public Timestamp getPredictionDate() {
        return predictionDate;
    }

    public void setPredictionDate(Timestamp predictionDate) {
        this.predictionDate = predictionDate;
    }

    @Basic
    @Column(name = "stock_price", nullable = false, precision = 6)
    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    @Basic
    @Column(name = "stock_state", nullable = false, length = 10)
    public String getStockState() {
        return stockState;
    }

    public void setStockState(String stockState) {
        this.stockState = stockState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StockPricePredictions that = (StockPricePredictions) o;

        if (id != that.id) return false;
        if (predictionDate != null ? !predictionDate.equals(that.predictionDate) : that.predictionDate != null)
            return false;
        if (stockPrice != null ? !stockPrice.equals(that.stockPrice) : that.stockPrice != null) return false;
        if (stockState != null ? !stockState.equals(that.stockState) : that.stockState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (predictionDate != null ? predictionDate.hashCode() : 0);
        result = 31 * result + (stockPrice != null ? stockPrice.hashCode() : 0);
        result = 31 * result + (stockState != null ? stockState.hashCode() : 0);
        return result;
    }

    @ManyToMany(mappedBy = "stockTickers")
    public List<StockTickers> getPricePredictions() {
        return pricePredictions;
    }

    public void setPricePredictions(List<StockTickers> pricePredictions) {
        this.pricePredictions = pricePredictions;
    }
}
