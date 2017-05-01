package com.financetracker.dto;

import com.financetracker.bean.StockPricePredictions;
import com.financetracker.bean.User;

import java.util.List;

/**
 * Created by User on 01.05.2017.
 */
public class CompanyDTO {
    private int id;
    private String companyName;
    private String ticker;
    private List<StockPricePredictionDTO> stockTickers;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public List<StockPricePredictionDTO> getStockTickers() {
        return stockTickers;
    }

    public void setStockTickers(List<StockPricePredictionDTO> stockTickers) {
        this.stockTickers = stockTickers;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
