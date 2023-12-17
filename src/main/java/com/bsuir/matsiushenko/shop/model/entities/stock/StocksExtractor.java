package com.bsuir.matsiushenko.shop.model.entities.stock;

import com.bsuir.matsiushenko.shop.model.dao.PhoneDao;
import com.bsuir.matsiushenko.shop.model.dao.impl.JdbcPhoneDao;
import com.bsuir.matsiushenko.shop.model.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StocksExtractor {
    private PhoneDao phoneDao = JdbcPhoneDao.getInstance();

    public List<Stock> extractData(ResultSet resultSet) throws SQLException, DaoException {
        List<Stock> stocks = new ArrayList<>();
        while (resultSet.next()) {
            Stock stock = new Stock();
            stock.setPhone(phoneDao.get(resultSet.getLong("PHONEID")).orElse(null));
            stock.setStock(resultSet.getInt("STOCK"));
            stock.setReserved(resultSet.getInt("RESERVED"));
            stocks.add(stock);
        }
        return stocks;
    }
}
