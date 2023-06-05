package ru.praktikun.selenium;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.praktikum.selenium.config.AppConfig;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FAQDropdownTest extends BaseTest {
    private int questionIndex;

    public FAQDropdownTest(int questionIndex) {
        this.questionIndex = questionIndex;
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
        });
    }

    @Test
    public void testFAQDropdown() {
        try {
            webDriver.get(AppConfig.APP_URL);

            String questionLocator = "//*[@id='accordion__heading-" + questionIndex + "']";
            String answerLocator = "//*[@id='accordion__panel-" + questionIndex + "']";

            WebElement question = webDriver.findElement(By.xpath(questionLocator));
            WebElement answer = webDriver.findElement(By.xpath(answerLocator));

            question.click();
            Thread.sleep(1000);

            assert answer.isDisplayed() : "Ответ не открыт для вопроса: " + question.getText();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}