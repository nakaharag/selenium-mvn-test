package multibags;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginDefinitions {

    private final WebDriver driver = new ChromeDriver();


    @Given("que tenho acesso a página de login do multibags")
    public void paginaLogin() {
        driver.get("http://multibags.1dt.com.br/shop/customer/customLogon.html");

//        WebElement signin_userName = driver.findElement(By.id("signin_userName"));
//        WebElement signin_password = driver.findElement(By.id("signin_password"));
//        WebElement genericLogin_button = driver.findElement(By.id("genericLogin-button"));
//
//        signin_userName.sendKeys("wilson@email.com");
//        signin_password.sendKeys("111111");
//
//        genericLogin_button.submit();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        //driver.implicitly_wait(30);
//
//        driver.get("http://multibags.1dt.com.br/shop/customer/password.html");
    }

    @When("for inserido o usuario {string} e a senha {string}")
    public void testeLogin(String username, String senha) {
        driver.get("http://multibags.1dt.com.br/shop/customer/customLogon.html");

        WebElement signin_userName = driver.findElement(By.id("signin_userName"));
        WebElement signin_password = driver.findElement(By.id("signin_password"));

        signin_userName.sendKeys(username);
        signin_password.sendKeys(senha);
        signin_password.submit();
        WebElement genericLogin_button = driver.findElement(By.id("genericLogin-button"));

        genericLogin_button.click();
    }

    @Then("a mensagem {string} deve ser exibida")
    public void verificarMensagem(String message){

        new WebDriverWait(driver,10L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElement messageReturn = driver.findElement(By.id("loginError"));
                return messageReturn.getText().equals(message);
            }
        });
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
}
