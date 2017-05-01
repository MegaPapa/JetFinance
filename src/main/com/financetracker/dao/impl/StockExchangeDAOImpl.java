package com.financetracker.dao.impl;

import com.financetracker.bean.StockPricePredictions;
import com.financetracker.bean.StockTickers;
import com.financetracker.dao.StockExchangeDAO;
import com.financetracker.dao.exception.DAOException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by User on 08.04.2017.
 */
@Repository
@Transactional
public class StockExchangeDAOImpl implements StockExchangeDAO {

    private static final String QUERY_GET_PREDICTION_BY_TICKER =
            "from StockTickers.stockTickers where StockTickers.ticker = ";

    @Autowired
    private SessionFactory sessionFactory;

    public void addPrediction(StockPricePredictions prediction, int tickerId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            StockTickers ticker = session.load(StockTickers.class, tickerId);
            if (ticker.getStockTickers() != null) {
                ticker.getStockTickers().add(prediction);
                session.saveOrUpdate(ticker);
            }
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public void addTicker(StockTickers ticker) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            session.save(ticker);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public StockPricePredictions getPredictionsByTicker(StockTickers ticker, Timestamp timestamp) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<StockPricePredictions> predictions = session.createQuery(
                    QUERY_GET_PREDICTION_BY_TICKER + ticker.getTicker()
            ).list();
            for (StockPricePredictions pricePrediction : predictions) {
                if (pricePrediction.getPredictionDate() == timestamp) {
                    return pricePrediction;
                }
            }
            return null;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public StockPricePredictions getLastPredictionByTicker(StockTickers ticker) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            List<StockPricePredictions> predictions = session.createQuery(
                    QUERY_GET_PREDICTION_BY_TICKER + ticker.getTicker()
            ).list();
            if (predictions.size() > 0) {
                StockPricePredictions lastPrediction = predictions.get(predictions.size());
                return lastPrediction;
            }
            return null;
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public void updatePrediction(StockPricePredictions newPrediction, int oldPredictionId) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            StockPricePredictions pricePredictions = session.get(StockPricePredictions.class, oldPredictionId);
            if (pricePredictions == null) {
                throw new DAOException("Can't find prediction with id = " + oldPredictionId);
            }
            pricePredictions = newPrediction;
            session.merge(pricePredictions);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }

    public void deletePrediction(int id) throws DAOException {
        try {
            Session session = sessionFactory.getCurrentSession();
            StockPricePredictions pricePredictions = session.get(StockPricePredictions.class, id);
            if (pricePredictions == null) {
                throw new DAOException("Can't find prediction with id = " + id);
            }
            session.delete(pricePredictions);
        }
        catch (SessionException exception) {
            throw new DAOException("Can't open session.");
        }
    }
}
