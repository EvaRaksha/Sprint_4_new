package ru.praktikum.selenium.pajeobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static ru.praktikum.selenium.config.AppConfig.APP_URL;

public class MainPage {
    WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get(APP_URL);
    }

    private By orderButtonHeader = By.className("Button_Button__ra12g");
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

    private By yesButtonCheckout = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='* Да']");

    private By modalWindowOrderSuccess  = By.xpath("//div[@class=Order_ModalHeader__3FDaJ') and text()='Заказ оформлен']");

    private By buttonViewStatus = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    public MainPage clickOrderButtonHeader(){
        webDriver.findElement(orderButtonHeader).click();
        return this;
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
}
