package multibags;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordDefinitions {

    private final WebDriver driver = new ChromeDriver();

    @Given("que o usuario esteja logado")
    public void login() {
        driver.get("http://multibags.1dt.com.br/shop/customer/customLogon.html");

        WebElement signin_userName = driver.findElement(By.id("signin_userName"));
        WebElement signin_password = driver.findElement(By.id("signin_password"));
        WebElement genericLogin_button = driver.findElement(By.id("genericLogin-button"));

        signin_userName.sendKeys("wilson@email.com");
        signin_password.sendKeys("111111");
        genericLogin_button.click();
    }

    @And("acesse a pagina de Change Password")
    public void paginaChangePassword(){

        new WebDriverWait(driver,5L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElement linkPassword = d.findElement(By.partialLinkText("password"));
                linkPassword.click();
                return true;
            }
        });
    }

    @When("o campo Current Password nao for preenchido com a senha atual")
    public void preencherSenhaNova() {
        WebElement currentPassword = driver.findElement(By.id("currentPassword"));
        currentPassword.sendKeys("222222");
    }

    @When("o campo New Password for preenchido com uma senha válida")
    public void newPasswordValido() {
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("A123456");
    }

    @When("o campo Repeat Password for preenchido com a mesma senha do campo anterior")
    public void repeatPassword() {
        WebElement checkPassword = driver.findElement(By.id("checkPassword"));
        checkPassword.sendKeys("A123456");

        WebElement submitChangePassword = driver.findElement(By.id("submitChangePassword"));
        submitChangePassword.click();
    }

    @Then("sera exibida uma mensagem de senha invalida")
    public void checkError() {
        new WebDriverWait(driver,5L).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                WebElement password_errors = d.findElement(By.id("password.errors"));
                String password_errorsExpected = "Invalid password";
                return password_errors.getText().equals(password_errorsExpected);
            }
        });
    }

    @After
    public void quitDriver(){
        driver.quit();
    }
}