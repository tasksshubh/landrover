package com.connect_group.pages.financecalculator;

import com.connect_group.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.logging.Logger;

public class ModelSelectPage extends BasePage {
  protected Logger log = Logger.getLogger(ModelSelectPage.class.getName());

  public ModelSelectPage(WebDriver driver) {
    super(driver);
  }

  private WebElement getModelSelectNameplateContainer() {
    return until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".fc-nameplates__nameplateContainer")));
  }

  public List<WebElement> getAllNameplates() {
    return until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("#model-select-render>div>div")));
  }

  private WebElement monthlyPaymentTab(){
    return getDriver().findElement(By.cssSelector("#switcher-button-fbmp"));
  }
  public void clickonMonthlyPaymentTab(){
    monthlyPaymentTab().click();
  }

  public void passingAlertsAndCookies(){
    driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
    try {
      WebDriverWait wait = new WebDriverWait(driver, 3);
      WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#psyma_close_button_link")));
      popup.click();
    }catch(Exception e){
      log.info("No pop up appear");
    }
  }
  public void scrolldownPage() throws InterruptedException {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    for (int i = 0; i < 1; i++) {
      js.executeScript("window.scrollBy(0, 500);"); // Scroll by 500 pixels
      Thread.sleep(1000); // Pause to allow content to load
    }
  }
  public String getpagetitle(){
    String s=driver.getTitle();
    return s;
  }
  private WebElement firstcarselection(){
    return getDriver().findElement(By.cssSelector("#model-select-render > div > div:nth-child(1) > div > a.fc-nameplate__nameplate__imageLink"));
  }

  public void selectfirstcar() throws InterruptedException {
    firstcarselection().click();
    Thread.sleep(5000);
    String s= driver.getTitle();
    log.info(s);
  }
  private WebElement car2(){
    return getDriver().findElement(By.xpath("//*[@id='model-select-render']/div/div[2]/div/a[1]"));

  }

  public void selectanothercar() throws InterruptedException {
    car2().click();
    Thread.sleep(200);
  }


}