package com.perevillega.eia;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.net.URI;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/mvc-dispatcher-servlet.xml")
public abstract class AbstractIT {

    @Autowired
    private URI siteBase;

    @Autowired
    private WebDriver drv;

    public URI getSiteBase() {
        return siteBase;
    }

    public WebDriver getDrv() {
        return drv;
    }
}
