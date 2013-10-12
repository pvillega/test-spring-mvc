package com.perevillega.eia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@RequestMapping("/")
public class HelloController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model, Locale locale) {
        String msg = messageSource.getMessage("home.title", null, locale);
        model.addAttribute("message", msg);
        log.debug("Sample logging entry to test it works");
        return "hello";
    }
}