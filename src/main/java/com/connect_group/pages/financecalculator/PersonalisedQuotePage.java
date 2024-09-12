package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class PersonalisedQuotePage extends BasePage {
  protected Logger log = Logger.getLogger(PersonalisedQuotePage.class.getName());

  public PersonalisedQuotePage(WebDriver driver) {
    super(driver);
  }

  private WebElement getaQuoteTitle(){
    WebElement heading=driver.findElement(By.cssSelector("#container-5bb58fd64d > div > div > header > div > div > div"));
    WebElement getaQuotelink=heading.findElement(By.tagName("a"));
    return getaQuotelink;
  }
  private WebElement changeVehicleButton(){
    return getDriver().findElement(By.cssSelector("#fincalc-quickQuote > div > div > main > div > div > div.fc-quote-panel__panel.fc-quote-panel__panel--1 > div > div > div > div > div > div.fc-vehicle-change-block__change_vehicle_container > div:nth-child(3) > div > a > span"));

  }

  public String verifyGetQuotePage(){
    String s=getaQuoteTitle().getText();
    return s;

  }
  public void clickonChangeVehicleButton() throws InterruptedException {
    changeVehicleButton().click();
    Thread.sleep(200);
  }
}