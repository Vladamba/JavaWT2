package com.bsuir.matsiushenko.shop.model.entities.order;

import com.bsuir.matsiushenko.shop.model.dao.PhoneDao;
import com.bsuir.matsiushenko.shop.model.dao.impl.JdbcPhoneDao;
import com.bsuir.matsiushenko.shop.model.exceptions.DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderItemsExtractor {
    public List<OrderItem> extractData(ResultSet resultSet) throws SQLException, DaoException {
        List<OrderItem> orderItems = new ArrayList<>();
        PhoneDao phoneDao = JdbcPhoneDao.getInstance();
        while (resultSet.next()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setPhone(phoneDao.get(resultSet.getLong("phoneId")).orElse(null));
            orderItem.setQuantity(resultSet.getInt("quantity"));
            orderItems.add(orderItem);
        }
        return orderItems;
    }
}
