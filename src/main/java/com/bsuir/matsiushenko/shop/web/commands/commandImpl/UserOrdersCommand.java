package com.bsuir.matsiushenko.shop.web.commands.commandImpl;

import com.bsuir.matsiushenko.shop.model.dao.OrderDao;
import com.bsuir.matsiushenko.shop.model.dao.impl.JdbcOrderDao;
import com.bsuir.matsiushenko.shop.model.exceptions.DaoException;
import com.bsuir.matsiushenko.shop.web.JspPageName;
import com.bsuir.matsiushenko.shop.web.commands.ICommand;
import com.bsuir.matsiushenko.shop.web.exceptions.CommandException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author nekit
 * @version 1.0
 * Command to get user orders page
 */
public class UserOrdersCommand implements ICommand {
    private OrderDao orderDao = JdbcOrderDao.getInstance();
    private static final String ORDERS_ATTRIBUTE = "orders";

    /**
     * Get user orders and show user orders page
     * @param request http request
     * @return user orders page jsp path
     * @throws CommandException throws when there is some errors during command execution
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        try {
            request.setAttribute(ORDERS_ATTRIBUTE, orderDao.findOrdersByLogin(request.getSession().getAttribute("login").toString()));
        } catch (DaoException e) {
            throw new CommandException(e.getMessage());
        }
        return JspPageName.USER_ORDERS_PAGE_JSP;
    }
}
