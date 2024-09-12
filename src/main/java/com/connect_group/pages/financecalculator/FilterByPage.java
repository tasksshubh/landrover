package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.logging.Logger;

public class FilterByPage extends BasePage {
  protected Logger log = Logger.getLogger(FilterByPage.class.getName());

  public FilterByPage(WebDriver driver) {
    super(driver);
  }

  private WebElement getFilterByToggle() {
    return until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fc-toggle-switch__toggle-switch-icon")));
  }

  private WebElement minslider(){
    return getDriver().findElement(By.cssSelector("#handle_min"));
  }
  public WebElement slider;
  public void sliderValueSetter(){
    slider=driver.findElement(By.cssSelector("#handle_max"));
    Actions move = new Actions(driver);
    move.clickAndHold(slider).moveByOffset(-25, 0).release().perform();

  }
  private WebElement depositeTab(){
    return getDriver().findElement(By.cssSelector("#deposit"));
  }
  public void depositeTab(String depo){
    depositeTab().clear();
    depositeTab().sendKeys(depo);
  }
  private WebElement acceptValueAndCalculate(){
    return getDriver().findElement(By.xpath("//*[@id='fbmp-page-content']/div[1]/div/div[1]/button"));
  }
  public void acceptValueAndCalculateButton() throws InterruptedException {
    Thread.sleep(500);
    acceptValueAndCalculate().click();
    log.info("value from max "+slider.getAttribute("aria-valuenow"));
  }

  private List<WebElement> numberofcars(){
    return getDriver().findElements(By.cssSelector("#fbmp-page-content > div.fc-container__wrapper.fc-nameplates__nameplates>div"));
  }
  public int loadedResultsAfterFinancing(){
    int numbers=numberofcars().size();
    return numbers;

  }
  private WebElement firstcarafterfiltering(){
    return getDriver().findElement(By.xpath("//*[@id='fbmp-page-content']/div[2]/div[1]/div/div[2]/span[2]"));

  }
  public String FirstCarPerMonthValueAfterFiltering(){
    return firstcarafterfiltering().getText();
  }
}