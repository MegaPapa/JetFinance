package com.financetracker.dao;

import com.financetracker.bean.StockPricePredictions;
import com.financetracker.bean.StockTickers;
import com.financetracker.dao.exception.DAOException;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by User on 08.04.2017.
 */
public interface StockExchangeDAO {
    /* CRUD OPERATION */

    // CREATE
    void addPrediction(StockPricePredictions prediction, int tickerId) throws DAOException;
    void addTicker(StockTickers ticker) throws DAOException;

    // READ
    StockPricePredictions getPredictionsByTicker(StockTickers ticker, Timestamp timestamp) throws DAOException;
    StockPricePredictions getLastPredictionByTicker(StockTickers ticker) throws DAOException;

    // UPDATE
    void updatePrediction(StockPricePredictions newPrediction, int oldPredictionId) throws DAOException;

    // DELETE
    void deletePrediction(int id) throws DAOException;
}
