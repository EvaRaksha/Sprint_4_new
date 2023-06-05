package ru.praktikun.selenium;

import org.junit.Test;
import org.openqa.selenium.By;
import ru.praktikum.selenium.pajeobject.MainPage;

public class OrderTest extends BaseTest {
    MainPage mainPage;
    String name = "Кристина";
    String lastName = "Владимирова";
    String address = "г. Москва";
    String station = "Бульвар Рокоссовского";
    String phoneNumber = "79998885522";
    String dateRental = "29.09.23";
    String periodRental = "сутки";
    String comment = "захватите тонну мороженого";

    @Test
    public void scooterRentalOrder() {
        mainPage = new MainPage(webDriver);
        By orderButtonHeader = mainPage.getOrderButtonHeader();
        By orderButtonFooter = mainPage.getOrderButtonFooter();
        mainPage.clickOrderButton(orderButtonHeader)
                .writeInputFieldName(name)
                .writeInputFieldLastName(lastName)
                .writeInputFieldAddress(address)
                .expandListMetroStation()
                .chooseMetroStation(station)
                .setInputFieldPhoneNumber(phoneNumber)
                .clickButtonNextFillOutTheForm()
                .setInputFieldRentalStartDate(dateRental)
                .openDropdownListRentalPeriod()
                .chooseRentalPeriod(periodRental)
                .chooseScooterColorGrey()
                .setInputFieldComment(comment)
                .clickButtonOrderFinal()
                .clickYesButtonCheckout()
                .modalWindowOrderSuccess()
                .clickButtonViewStatus()
                .checkContainerSuccess();

        mainPage.clickOrderButton(orderButtonFooter)
                .writeInputFieldName(name)
                .writeInputFieldLastName(lastName)
                .writeInputFieldAddress(address)
                .expandListMetroStation()
                .chooseMetroStation(station)
                .setInputFieldPhoneNumber(phoneNumber)
                .clickButtonNextFillOutTheForm()
                .setInputFieldRentalStartDate(dateRental)
                .openDropdownListRentalPeriod()
                .chooseRentalPeriod(periodRental)
                .chooseScooterColorGrey()
                .setInputFieldComment(comment)
                .clickButtonOrderFinal()
                .clickYesButtonCheckout()
                .modalWindowOrderSuccess()
                .clickButtonViewStatus()
                .cheсkContainerSuccess();
    }
}