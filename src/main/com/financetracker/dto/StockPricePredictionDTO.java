package com.financetracker.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by User on 01.05.2017.
 */
public class StockPricePredictionDTO {

    private int id;
    private Timestamp predictionDate;
    private BigDecimal stockPrice;
    private String stockState;

    public Timestamp getPredictionDate() {
        return predictionDate;
    }

    public void setPredictionDate(Timestamp predictionDate) {
        this.predictionDate = predictionDate;
    }

    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    public String getStockState() {
        return stockState;
    }

    public void setStockState(String stockState) {
        this.stockState = stockState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
