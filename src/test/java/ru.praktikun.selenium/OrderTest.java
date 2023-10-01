package ru.praktikun.selenium;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.praktikum.selenium.pajeobject.MainPage;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    MainPage mainPage;
    private final String orderButtonVariable;
    private final String name;
    private final String lastName;
    private final String address;
    private final String station;
    private final String phoneNumber;
    private final String dateRental;
    private final String periodRental;
    private final String comment;

    public OrderTest(String orderButtonVariable, String name, String lastName, String address, String station,
                     String phoneNumber, String dateRental, String periodRental, String comment) {
        this.orderButtonVariable = orderButtonVariable;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.station = station;
        this.phoneNumber = phoneNumber;
        this.dateRental = dateRental;
        this.periodRental = periodRental;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"orderButtonHeader", "Кристина", "Владимирова", "г. Москва", "Бульвар Рокоссовского", "79998885522", "29.09.23", "сутки", "захватите тонну мороженого"},
                {"orderButtonFooter", "Алексей", "Иванов", "г. Москва", "Бульвар Рокоссовского", "79998885522", "29.09.23", "сутки", "проверка комментария"}
        });
    }

    @Test
    public void scooterRentalOrder() {
        int questionIndex = 0;
        mainPage = new MainPage(webDriver, questionIndex);

        By orderButtonLocator = mainPage.getOrderButtonLocator(orderButtonVariable);

        mainPage.clickOrderButton(orderButtonLocator);
        mainPage.writeInputFieldName(name)
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
    }
}