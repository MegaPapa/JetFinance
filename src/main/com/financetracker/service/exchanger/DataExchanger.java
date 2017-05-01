package com.financetracker.service.exchanger;

import com.financetracker.bean.StockPricePredictions;
import com.financetracker.bean.StockTickers;
import com.financetracker.bean.User;
import com.financetracker.dto.CompanyDTO;
import com.financetracker.dto.StockPricePredictionDTO;
import com.financetracker.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 01.05.2017.
 */
public class DataExchanger {

    public static User exchangeUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setEmail(userDTO.getEmail());
        user.setNickname(userDTO.getName());
        user.setTickers(userDTO.getTickers());
        user.setPassword(userDTO.getPassword());
        return user;
    }

    public static UserDTO exchangeUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setEmail(user.getEmail());
        userDTO.setTickers(user.getTickers());
        userDTO.setName(user.getNickname());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static StockPricePredictionDTO exchangeStockPricePrediction(StockPricePredictions prediction) {
        StockPricePredictionDTO dto = new StockPricePredictionDTO();
        dto.setId(prediction.getId());
        dto.setPredictionDate(prediction.getPredictionDate());
        dto.setStockPrice(prediction.getStockPrice());
        dto.setStockState(prediction.getStockState());
        return dto;
    }

    public static CompanyDTO exchangeStockTickerToDTO(StockTickers ticker) {
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setId(ticker.getId());
        companyDTO.setCompanyName(ticker.getCompanyName());
        companyDTO.setTicker(ticker.getTicker());
        List<StockPricePredictions> predictions = ticker.getStockTickers();
        List<StockPricePredictionDTO> dtoPredictions = new ArrayList<StockPricePredictionDTO>();
        for (StockPricePredictions prediction : predictions) {
            dtoPredictions.add(exchangeStockPricePrediction(prediction));
        }
        companyDTO.setStockTickers(dtoPredictions);
        return companyDTO;
    }
}
