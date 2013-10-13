package com.perevillega.eia;

import org.openqa.selenium.WebDriver;

import java.net.URI;

public class IndexPage {

    public static boolean isAtIndexPage(WebDriver drv, URI siteBase) {
        return drv.getCurrentUrl().equals(siteBase.toString());
    }

    private final WebDriver drv;
    private final URI siteBase;

    public IndexPage(WebDriver drv, URI siteBase) {
        if (!isAtIndexPage(drv, siteBase)) {
            throw new IllegalStateException();
        }
        this.drv = drv;
        this.siteBase = siteBase;
    }
}

