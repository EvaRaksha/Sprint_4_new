package ru.praktikum.selenium.pajeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static ru.praktikum.selenium.config.AppConfig.APP_URL;

public class MainPage {
    WebDriver webDriver;

    public MainPage(WebDriver webDriver, int questionIndex) {
        this.webDriver = webDriver;
        this.questionIndex = questionIndex;
        questionLocator = By.xpath("//div[@id='accordion__heading-" + questionIndex + "']");
        answerLocator = By.xpath("//div[@id='accordion__panel-" + questionIndex + "']");

        webDriver.get(APP_URL);
    }
    private By inputFieldName = By.xpath(".//input[@placeholder='* Имя']");
    private By inputFieldLastName  = By.xpath(".//input[@placeholder='* Фамилия']");
    private By inputFieldAddress  = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    private By expandListMetroStation  = By.xpath(".//input[@class='select-search__input']");
    private By chooseMetroStation  = By.xpath(".//div[contains(text(), 'Бульвар Рокоссовского')]");
    private By inputFieldPhoneNumber   = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    private By buttonNextFillOutTheForm   = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM");
    private By inputFieldRentalStartDate  = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private By openDropdownListRentalPeriod  = By.cssSelector("span.Dropdown-arrow");
    private By chooseRentalPeriod  = By.xpath("//div[@class='Dropdown-option' and text()='сутки']");
    private By chooseScooterColorGrey  = By.cssSelector("input#grey.Checkbox_Input__14A2w[type='checkbox']");
    private By inputFieldComment = By.cssSelector("input.Input_Input__1iN_Z.Input_Responsible__1jDKN[placeholder='Комментарий для курьера']");
    private By buttonOrderFinal = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    private By yesButtonCheckout = By.cssSelector("button.Button_Button__ra12g.Button_Middle__1CSJM[text='Да']");

    private By modalWindowOrderSuccess = By.xpath("//div[@class='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");

    private By buttonViewStatus = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");
    public int questionIndex;
    private By questionLocator = By.xpath("//div[@id='accordion__heading-" + questionIndex + "']");
    private By answerLocator = By.xpath("//div[@id='accordion__panel-" + questionIndex + "']");


    public void clickOrderButton(By orderButtonLocator) {
        webDriver.findElement(orderButtonLocator).click();
    }

    public By getOrderButtonLocator(String orderButtonVariable) {

        if (orderButtonVariable.equals("orderButtonHeader")) {
            return By.cssSelector(".Button_Button__ra12g");
        } else if (orderButtonVariable.equals("orderButtonFooter")) {
            return By.cssSelector(".Button_Button__ra12g.Button_UltraBig__UU3Lp");
        }
        return null;
    }

    public MainPage writeInputFieldName(String name){
        webDriver.findElement(inputFieldName).sendKeys(name);
        return this;
    }

    public MainPage writeInputFieldLastName(String lastName){
        webDriver.findElement(inputFieldLastName).sendKeys(lastName);
        return this;
    }

    public MainPage writeInputFieldAddress(String address){
        webDriver.findElement(inputFieldAddress).sendKeys(address);
        return this;
    }

    public MainPage expandListMetroStation() {
        webDriver.findElement(expandListMetroStation).click();
        return this;
    }

    public MainPage chooseMetroStation(String station) {
        webDriver.findElement(chooseMetroStation).click();
        return this;
    }

    public MainPage setInputFieldPhoneNumber(String phoneNumber) {
        webDriver.findElement(inputFieldPhoneNumber).sendKeys(phoneNumber);
        return this;
    }

    public MainPage clickButtonNextFillOutTheForm() {
        webDriver.findElement(buttonNextFillOutTheForm).click();
        return this;
    }

    public MainPage setInputFieldRentalStartDate(String startDate) {
        webDriver.findElement(inputFieldRentalStartDate).sendKeys(startDate);
        return this;
    }

    public MainPage openDropdownListRentalPeriod() {
        webDriver.findElement(openDropdownListRentalPeriod).click();
        return this;
    }

    public MainPage chooseRentalPeriod(String period) {
        webDriver.findElement(chooseRentalPeriod).click();
        return this;
    }

    public MainPage chooseScooterColorGrey() {
        webDriver.findElement(chooseScooterColorGrey).click();
        return this;
    }

    public MainPage setInputFieldComment(String comment) {
        webDriver.findElement(inputFieldComment).sendKeys(comment);
        return this;
    }

    public MainPage clickButtonOrderFinal() {
        webDriver.findElement(buttonOrderFinal).click();
        return this;
    }

    public MainPage clickYesButtonCheckout() {
        webDriver.findElement(yesButtonCheckout).click();
        return this;
    }

    public MainPage modalWindowOrderSuccess() {
        webDriver.findElement(modalWindowOrderSuccess).click();
        return this;
    }

    public OrderStatusPage clickButtonViewStatus() {
        webDriver.findElement(buttonViewStatus).click();
        return new OrderStatusPage(webDriver);
    }

    public String findQuestionText() {
        WebElement questionElement = questionLocator.findElement(webDriver);
        return questionElement.getText();
    }

    public void clickQuestionAndExpandAnswer() {
        WebElement questionElement = webDriver.findElement(questionLocator);
        questionElement.click();
    }

    public String findAnswerText() {
        WebElement answerElement = answerLocator.findElement(webDriver);
        return answerElement.getText();
    }

    public void scrollToFaqBlock() {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        WebElement faqBlock = webDriver.findElement(By.className("Home_FAQ__3uVm4"));
        js.executeScript("arguments[0].scrollIntoView();", faqBlock);
    }
    public By getQuestionLocator() {
        return questionLocator;
    }

    public By getAnswerLocator() {
        return answerLocator;
    }

}