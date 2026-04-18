package page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Search_product extends basePage{

	public Search_product(WebDriver driver) {
		super(driver);
	}
	@FindBy (id="twotabsearchtextbox")
	WebElement searchfield;
	@FindBy(id="nav-search-submit-button")
	WebElement searchbutton;
	@FindBy(xpath="//h2//span")
	List<WebElement> Alllaptop;
	@FindBy(id="productTitle")
	WebElement productTitle;
	@FindBy(xpath="//span[@class='a-price-whole']")
	WebElement productPrice;
	@FindBy(id="add-to-cart-button")
	WebElement addToCart;
	public void inputfield(String item) {
		searchfield.sendKeys(item);
	}
	public void clicksearch() {
		searchbutton.click();
	}
	public void selectLaptop(String expectedname) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
	            By.xpath("//h2//span")));


		for(WebElement laptop:Alllaptop) {
		   String text=	laptop.getText();
		   //System.out.println(text);

        if (text.toLowerCase().contains(expectedname.toLowerCase())) {
        	//System.out.println("CLICKING: " + text);
        	
        	js.executeScript("arguments[0].scrollIntoView({block:'center'});", laptop);            wait.until(ExpectedConditions.elementToBeClickable(laptop));
            js.executeScript("arguments[0].click();", laptop);
            break;
        }
			
		}	
	}
	public void validateProductPage() {
	    // Title validation
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(productTitle));
	    String title = productTitle.getText();
	    System.out.println("Title: " + title);
	    Assert.assertTrue(title.length() > 0, "Title is empty");

	    // Price validation
	    String price = productPrice.getText();
	    System.out.println("Price: " + price);
	    Assert.assertTrue(price.length() > 0, "Price not visible");

	    // Add to Cart validation
	    Assert.assertTrue(addToCart.isDisplayed(), "Add to Cart button not visible");
	}

}
