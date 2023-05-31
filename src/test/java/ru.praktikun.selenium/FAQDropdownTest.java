package ru.praktikun.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.praktikum.selenium.config.AppConfig;

public class FAQDropdownTest extends BaseTest{

    @Test
    public void testFAQDropdown() {

        try {

            webDriver.get(AppConfig.APP_URL);

            WebElement faqDropdown = webDriver.findElement(By.className("FAQDropdown_faq__dropdown"));

            faqDropdown.click();

            Thread.sleep(2000);

            for (int i = 1; i <= 8; i++) {

                WebElement question = webDriver.findElement(By.xpath("//div[@class='FAQDropdown_faq__item'][" + i + "]//div[@class='FAQDropdown_faq__question']"));
                question.click();
                Thread.sleep(1000);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}