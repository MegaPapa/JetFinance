package com.financetracker.bean;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by User on 13.03.2017.
 */
public class StockPricePredictionsHasStockTickersBeanPK implements Serializable {
    private int stockPricePredictionsId;
    private int stockTickersId;

    @Column(name = "stock_price_predictions_id", nullable = false)
    @Id
    public int getStockPricePredictionsId() {
        return stockPricePredictionsId;
    }

    public void setStockPricePredictionsId(int stockPricePredictionsId) {
        this.stockPricePredictionsId = stockPricePredictionsId;
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

        StockPricePredictionsHasStockTickersBeanPK that = (StockPricePredictionsHasStockTickersBeanPK) o;

        if (stockPricePredictionsId != that.stockPricePredictionsId) return false;
        if (stockTickersId != that.stockTickersId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = stockPricePredictionsId;
        result = 31 * result + stockTickersId;
        return result;
    }
}
