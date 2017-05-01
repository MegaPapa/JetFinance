package com.financetracker.service;

import com.financetracker.bean.StockPricePredictions;
import com.financetracker.bean.StockTickers;
import com.financetracker.dto.CompanyDTO;
import com.financetracker.dto.StockPricePredictionDTO;
import com.financetracker.service.exception.ServiceException;

import java.sql.Timestamp;

/**
 * Created by User on 01.05.2017.
 */
public interface StockExchangeService {

    void addPrediction(StockPricePredictionDTO prediction, int tickerId) throws ServiceException;
    void addTicker(CompanyDTO ticker) throws ServiceException;

    StockPricePredictions getPredictionsByTicker(CompanyDTO ticker, Timestamp timestamp) throws ServiceException;
    StockPricePredictions getLastPredictionByTicker(CompanyDTO ticker) throws ServiceException;

    void updatePrediction(StockPricePredictionDTO newPrediction, int oldPredictionId) throws ServiceException;

    void deletePrediction(int id) throws ServiceException;
}
