package com.financetracker.bean;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by User on 13.03.2017.
 */
@Entity
@Table(name = "stock_price_predictions", schema = "financetrackerdb", catalog = "")
public class StockPricePredictionsBean {
    private int id;
    private Timestamp predictionDate;
    private int stockPrice;
    private String stockState;

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
    public int getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(int stockPrice) {
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

        StockPricePredictionsBean that = (StockPricePredictionsBean) o;

        if (id != that.id) return false;
        if (stockPrice != that.stockPrice) return false;
        if (predictionDate != null ? !predictionDate.equals(that.predictionDate) : that.predictionDate != null)
            return false;
        if (stockState != null ? !stockState.equals(that.stockState) : that.stockState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (predictionDate != null ? predictionDate.hashCode() : 0);
        result = 31 * result + stockPrice;
        result = 31 * result + (stockState != null ? stockState.hashCode() : 0);
        return result;
    }
}
