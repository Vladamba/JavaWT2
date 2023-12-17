package com.bsuir.matsiushenko.shop.web.commands.commandImpl;

import com.bsuir.matsiushenko.shop.web.JspPageName;
import com.bsuir.matsiushenko.shop.web.commands.ICommand;
import com.bsuir.matsiushenko.shop.web.exceptions.CommandException;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author nekit
 * @version 1.0
 * Command to unknown name
 */
public class UnknownCommand implements ICommand {
    /**
     * Return error page
     *
     * @param request http request
     * @return return error page jsp path
     * @throws CommandException throws when there is some errors during command execution
     */
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        return JspPageName.ERROR_PAGE;
    }
}
