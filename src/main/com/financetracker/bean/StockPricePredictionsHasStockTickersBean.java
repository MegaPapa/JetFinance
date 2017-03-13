package com.financetracker.bean;

import javax.persistence.*;

/**
 * Created by User on 13.03.2017.
 */
@Entity
@Table(name = "stock_price_predictions_has_stock_tickers", schema = "financetrackerdb", catalog = "")
@IdClass(StockPricePredictionsHasStockTickersBeanPK.class)
public class StockPricePredictionsHasStockTickersBean {
    private int stockPricePredictionsId;
    private int stockTickersId;
    private StockPricePredictionsBean stockPricePredictionsByStockPricePredictionsId;

    @Id
    @Column(name = "stock_price_predictions_id", nullable = false)
    public int getStockPricePredictionsId() {
        return stockPricePredictionsId;
    }

    public void setStockPricePredictionsId(int stockPricePredictionsId) {
        this.stockPricePredictionsId = stockPricePredictionsId;
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

        StockPricePredictionsHasStockTickersBean that = (StockPricePredictionsHasStockTickersBean) o;

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

    @ManyToOne
    @JoinColumn(name = "stock_price_predictions_id", referencedColumnName = "id", nullable = false)
    public StockPricePredictionsBean getStockPricePredictionsByStockPricePredictionsId() {
        return stockPricePredictionsByStockPricePredictionsId;
    }

    public void setStockPricePredictionsByStockPricePredictionsId(StockPricePredictionsBean stockPricePredictionsByStockPricePredictionsId) {
        this.stockPricePredictionsByStockPricePredictionsId = stockPricePredictionsByStockPricePredictionsId;
    }
}
