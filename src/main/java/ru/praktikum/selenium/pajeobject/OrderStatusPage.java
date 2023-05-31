package ru.praktikum.selenium.pajeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.assertTrue;

public class OrderStatusPage {
    WebDriver webDriver;

    public OrderStatusPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private By containerSuccess = By.xpath(".//div[@class='<div class=Track_Content__St6Kn']");

    public void chekContainerSuccess() {
        boolean isDisplayed = webDriver.findElement(containerSuccess).isDisplayed();
        assertTrue(isDisplayed);
    }
}
