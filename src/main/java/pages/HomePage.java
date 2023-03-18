package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestComponents.BaseTest;

public class HomePage extends BaseTest {

	@FindBy(id = "twotabsearchtextbox")
	@CacheLookup
	private WebElement searchBox;

	@FindBy(className = "s-suggestion-container")
	@CacheLookup
	private List<WebElement> autoSug;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void enterTextIntoSearchBox(String text) {
		searchBox.sendKeys(text);
	}

	public void getAllSuggestions() {
		for (WebElement ele : autoSug) {
			System.out.println(ele.getText());
			if (ele.getText().equalsIgnoreCase("fastrack")) {
				ele.click();
				driver.getTitle();
				
				break;
			}

		}

		
	}

}
