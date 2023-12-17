package com.bsuir.matsiushenko.shop.web.commands.commandImpl;

import com.bsuir.matsiushenko.shop.model.service.CartService;
import com.bsuir.matsiushenko.shop.model.service.impl.HttpSessionCartService;
import com.bsuir.matsiushenko.shop.web.JspPageName;
import com.bsuir.matsiushenko.shop.web.commands.ICommand;
import com.bsuir.matsiushenko.shop.web.exceptions.CommandException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author nekit
 * @version 1.0
 * Command to get cart jsp
 */
public class CartGetCommand implements ICommand {
    private static final String CART_ATTRIBUTE = "cart";
    private final CartService cartService = HttpSessionCartService.getInstance();

    /**
     * Get cart jsp
     *
     * @param request http request
     * @return cart jsp path
     * @throws CommandException throws when there is some errors during command execution
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.getSession().setAttribute(CART_ATTRIBUTE, cartService.getCart(request.getSession()));
        return JspPageName.CART_JSP;
    }
}
