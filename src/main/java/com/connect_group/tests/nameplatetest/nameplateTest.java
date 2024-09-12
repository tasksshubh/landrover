package com.connect_group.tests.nameplatetest;

import com.connect_group.pages.financecalculator.FilterByPage;
import com.connect_group.pages.financecalculator.ModelSelectPage;
import com.connect_group.pages.financecalculator.PersonalisedQuotePage;
import com.connect_group.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class nameplateTest extends BaseTest {
    protected Logger log = Logger.getLogger(nameplateTest.class.getName());

    private ModelSelectPage modelSelectPage;
    private FilterByPage filterByPage;
    private PersonalisedQuotePage personalisedQuotePage;

    @BeforeEach
    void setupAndNavigateToUrl() {
        modelSelectPage = new ModelSelectPage(driver);
        filterByPage = new FilterByPage(driver);
        personalisedQuotePage = new PersonalisedQuotePage(driver);

        open("https://www.landrover.co.uk/offers-and-finance/finance-calculator.html");
    }
    //Task 1
    @Test
    public void verifyingNumberOfNamePLate() throws InterruptedException {
        modelSelectPage.passingAlertsAndCookies();
        modelSelectPage.scrolldownPage();
        List<WebElement> numberofnameplates= modelSelectPage.getAllNameplates();
        int receivedsize=numberofnameplates.size();
        int expectedsize=7;
        assertEquals(expectedsize,receivedsize);
        log.info("number of nameplate test has been passed Task 1 succed");

    }

}
