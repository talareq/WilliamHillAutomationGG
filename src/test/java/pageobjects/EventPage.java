package pageobjects;




import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;


/**
 * Created by g on 2017-10-04.
 */
public class EventPage extends BaseClass {
    public EventPage(WebDriver driver) {super(driver);}


    @FindBy(xpath = "//*[@id='match-highlights-OB_SP9']/div//*[@class='btmarket__content']//li")
    private List<WebElement> matchList;

    @FindBy(xpath = "//*[@class='btmarket__wrapper -expanded']//div[@class='btmarket__selection']")
    private List<WebElement> oddList;

    @FindBy(xpath = "//div[@class='betslip-selection__content betslip-selection__content--single']//input[@type='text']")
    private WebElement stake;

    @FindBy(xpath = "//li[@class='betslip-bet-actions__list-item betslip-bet-actions__list-item--full-width']")
    private WebElement placeBetButton;


    @FindBy(xpath = "//span[@class='betslip-selection__estimated-returns-amount betslip-label--placeholder']")
    private WebElement toReturn;

    public EventPage selectOdd() {

        //select any odd for the preselected match
        Random rand = new Random();
        int randomodd = rand.nextInt(oddList.size());
        oddList.get(randomodd).click();
        String oddName = oddList.get(randomodd).getText();
        //compare if selected odd is the same one which required
        String selectedOdd = driver.findElement(By.xpath("//*[@class='betslip-selection__name betslip-selection__name--single']")).getText();
        assertThat(selectedOdd, containsString(oddName));
        return new EventPage(driver);
    }

    public EventPage placeABet(String bet) {

        //bet for 0.05 pounds
        stake.sendKeys(bet);
        return new EventPage(driver);
        }

    public EventPage checkBet(String bet) {

        //check if placed bet is correct
        String toReturn = driver.findElement(By.xpath("//span[@class='betslip-selection__estimated-returns-amount betslip-label--placeholder']")).getText();
        String toReturn1 = driver.findElement(By.xpath("//*[@id='total-to-return-price']")).getText();
        toReturn.equals(toReturn1);
        String totalStake = driver.findElement(By.xpath("//*[@id='total-stake-price']")).getText();
        bet.equals(totalStake);
        return new EventPage(driver);
        }



    }

