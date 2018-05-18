package SeleniumTeaWebsite;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.Assert.assertEquals;

public class TeaSteps {

    private static WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;



    @Given ("^the correct web address$")
    public void the_correct_web_address(){
        driver = new ChromeDriver();
        driver.get("http://www.practiceselenium.com/welcome.html");

    }
    @When ("^I navigate to the 'Menu' page$")
    public void I_navigate_to_the_menu_page(){
        driver.get("http://www.practiceselenium.com/menu.html");
    }
    @When ("^I click the checkout button$")
    public void I_click_the_checkout_buttons() {
        driver.get("http://www.practiceselenium.com/menu.html");
        driver.findElement(By.xpath("//a[@id='wsb-button-00000000-0000-0000-0000-000451955160']/span")).click();
    }
    @When ("^I navigate to the \"let's talk\" page$")
    public void I_navigate_to_the_lets_talk_page(){
        driver.get("http://www.practiceselenium.com/let-s-talk-tea.html");
    }

    @Then ("^I can browse a list of the available products.$")
    public void I_can_browse_a_list_of_the_available_products()  {
        driver.get("http://www.practiceselenium.com/menu.html");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
   }
    @Then ("^I am taken to the checkout page$")
    public void I_am_taken_to_the_checkout_page(){
        assertEquals("http://www.practiceselenium.com/check-out.html" , driver.getCurrentUrl() );
    }

    @Then ("^I am taken to the \"let's talk page$")
    public void I_am_taken_to_lets_talk_page(){
        assertEquals("http://www.practiceselenium.com/let-s-talk-tea.html" , driver.getCurrentUrl() );
    }

    @Then ("^I am Happy$")
    public void I_am_Happy(){
        driver.quit();
    }


}
