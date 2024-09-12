package com.connect_group.tests.modelselecttest;

import com.connect_group.pages.financecalculator.FilterByPage;
import com.connect_group.pages.financecalculator.ModelSelectPage;
import com.connect_group.pages.financecalculator.PersonalisedQuotePage;
import com.connect_group.tests.BaseTest;
import com.connect_group.tests.nameplatetest.nameplateTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;
import static org.junit.jupiter.api.Assertions.*;

public class modelTest extends BaseTest {
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

    @Test
    public void selectcarAndAssertPage() throws InterruptedException {
        modelSelectPage.passingAlertsAndCookies();
        modelSelectPage.selectfirstcar();
        String actualtext=personalisedQuotePage.verifyGetQuotePage();
        String expectedtext="Get a Quote";
        assertEquals(expectedtext,actualtext,"get quote assertion failed");
        log.info("Get quote assertion passed");
        personalisedQuotePage.clickonChangeVehicleButton();
       String actualtitle= modelSelectPage.getpagetitle();
       String expectedtitle="Payment Calculator | Vehicle Finance | Land Rover UK";
       assertEquals(expectedtitle,actualtitle,"Backto main page assertion failed");
       log.info("browser is back to main page");
       modelSelectPage.selectanothercar();
       personalisedQuotePage.verifyGetQuotePage();
    }
}
