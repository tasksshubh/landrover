package com.connect_group.tests.financecalculator;

import com.connect_group.pages.financecalculator.FilterByPage;
import com.connect_group.pages.financecalculator.ModelSelectPage;
import com.connect_group.pages.financecalculator.PersonalisedQuotePage;
import com.connect_group.tests.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class FinanceCalculatorTest extends BaseTest {
  protected Logger log = Logger.getLogger(FinanceCalculatorTest.class.getName());

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
  public void Task2() throws InterruptedException {
    modelSelectPage.passingAlertsAndCookies();
    modelSelectPage.clickonMonthlyPaymentTab();
    filterByPage.sliderValueSetter();
    filterByPage.depositeTab("20000");
    filterByPage.acceptValueAndCalculateButton();
    String actual=filterByPage.FirstCarPerMonthValueAfterFiltering();
    String filterednumber=actual.replaceAll("[^\\d.]","");
    Double value=Double.parseDouble(filterednumber);
    if(value<750){
      log.info("filteration succed");
    }
    Thread.sleep(5000);                  //As a precaution as page sometime take time to load
    modelSelectPage.scrolldownPage();
    int receivedresults=filterByPage.loadedResultsAfterFinancing();
    int expectedresult=7;
    assertEquals(expectedresult,receivedresults);
    log.info("Task 2 succed");
    Thread.sleep(5000);
  }

}