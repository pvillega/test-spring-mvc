package com.perevillega.eia;

import com.perevillega.eia.dao.UserDAO;
import com.perevillega.eia.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class HelloController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private Validator userFormValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model, Locale locale) {
        log.debug("Set message");
        String msg = messageSource.getMessage("home.title", null, locale);
        model.addAttribute("message", msg);

        log.debug("Get all users");
        model.addAttribute("users", userDAO.getAllUsers());

        log.debug("bind new user for form");
        model.addAttribute("user", new User());

        return "hello";
    }

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String create(@ModelAttribute("user") User user, BindingResult result, SessionStatus status) {
        userFormValidator.validate(user, result);
        if (result.hasErrors()) {
            return "hello";
        }
        userDAO.save(user);
        status.setComplete();
        return "redirect:/";
    }

}