package com.financetracker.service.impl;

import com.financetracker.bean.StockPricePredictions;
import com.financetracker.dao.StockExchangeDAO;
import com.financetracker.dao.exception.DAOException;
import com.financetracker.dto.CompanyDTO;
import com.financetracker.dto.StockPricePredictionDTO;
import com.financetracker.service.StockExchangeService;
import com.financetracker.service.exception.ServiceException;
import com.financetracker.service.exchanger.DataExchanger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by User on 01.05.2017.
 */

@Service
@Transactional
public class StockExchangeServiceImpl implements StockExchangeService {

    @Autowired
    private StockExchangeDAO stockExchangeDAO;

    public void addPrediction(StockPricePredictionDTO prediction, int tickerId) throws ServiceException {
        try {
            stockExchangeDAO.addPrediction(DataExchanger.exchangeStockPricePrediction(prediction), tickerId);
        }
        catch (DAOException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void addTicker(CompanyDTO ticker) throws ServiceException {
        try {
            stockExchangeDAO.addTicker(DataExchanger.exchangeStockTicker(ticker));
        }
        catch (DAOException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public StockPricePredictions getPredictionsByTicker(CompanyDTO ticker, Timestamp timestamp) throws ServiceException {
        try {
            return stockExchangeDAO.getPredictionsByTicker(DataExchanger.exchangeStockTicker(ticker), timestamp);
        }
        catch (DAOException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public StockPricePredictions getLastPredictionByTicker(CompanyDTO ticker) throws ServiceException {
        try {
            return stockExchangeDAO.getLastPredictionByTicker(DataExchanger.exchangeStockTicker(ticker));
        }
        catch (DAOException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void updatePrediction(StockPricePredictionDTO newPrediction, int oldPredictionId) throws ServiceException {
        try {
            stockExchangeDAO.updatePrediction(DataExchanger.exchangeStockPricePrediction(newPrediction), oldPredictionId);
        }
        catch (DAOException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }

    public void deletePrediction(int id) throws ServiceException {
        try {
            stockExchangeDAO.deletePrediction(id);
        }
        catch (DAOException exception) {
            throw new ServiceException(exception.getMessage());
        }
    }
}
