package com.financetracker.service.exchanger;

import com.financetracker.bean.Role;
import com.financetracker.bean.StockPricePredictions;
import com.financetracker.bean.StockTickers;
import com.financetracker.bean.User;
import com.financetracker.dto.CompanyDTO;
import com.financetracker.dto.RoleDTO;
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
        user.setRoleByRoleId(DataExchanger.exchangeRoleDTOToRole(userDTO.getRoleDTO()));
        return user;
    }

    public static Role exchangeRoleDTOToRole(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setRoleName(role.getRoleName());
        return role;
    }

    public static RoleDTO exchangeRoleToRoleDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setRoleName(role.getRoleName());
        return roleDTO;
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

    public static StockPricePredictions exchangeStockPricePrediction(StockPricePredictionDTO dto) {
        StockPricePredictions pricePrediction = new StockPricePredictions();
        pricePrediction.setId(dto.getId());
        pricePrediction.setStockState(dto.getStockState());
        pricePrediction.setPredictionDate(dto.getPredictionDate());
        pricePrediction.setStockPrice(dto.getStockPrice());
        return pricePrediction;
    }

    public static StockPricePredictionDTO exchangeStockPricePrediction(StockPricePredictions prediction) {
        StockPricePredictionDTO dto = new StockPricePredictionDTO();
        dto.setId(prediction.getId());
        dto.setPredictionDate(prediction.getPredictionDate());
        dto.setStockPrice(prediction.getStockPrice());
        dto.setStockState(prediction.getStockState());
        return dto;
    }

    public static StockTickers exchangeStockTicker(CompanyDTO dto) {
        StockTickers ticker = new StockTickers();
        ticker.setId(dto.getId());
        ticker.setCompanyName(dto.getCompanyName());
        ticker.setTicker(dto.getTicker());
        List<StockPricePredictionDTO> dtoPredictions = dto.getStockTickers();
        List<StockPricePredictions> predictions = new ArrayList<StockPricePredictions>();
        for (StockPricePredictionDTO element : dtoPredictions) {
            predictions.add(DataExchanger.exchangeStockPricePrediction(element));
        }
        ticker.setStockTickers(predictions);
        return ticker;
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
