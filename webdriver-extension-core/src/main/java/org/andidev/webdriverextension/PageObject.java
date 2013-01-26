package org.andidev.webdriverextension;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject implements Openable {

    private WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
        // Init page elements
        PageFactory.initElements(new DefaultHtmlTagFieldDecorator(driver), this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return null;
    }

    public boolean isOpen() {
        try {
            assertIsOpen();
            return true;
        } catch (Error e) {
            return false;
        }
    }
}