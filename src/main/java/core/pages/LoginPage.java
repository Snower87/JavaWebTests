package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("[data-l='t,sign_in']");
    private SelenideElement forgotPasswordLink = $("[data-l='t,restore']");
    private SelenideElement registrationButton = $x("//div[@class='external-oauth-login-footer']/a[@data-l='t,register']");

    // Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $("[data-l='t,vkc']");
    private SelenideElement googleButton = $("[data-l='t,google']");
    private SelenideElement mailRuButton =  $("[data-l='t,mailru']");

    // Локатор для элемента с сообщением об ошибке входа
    private SelenideElement errorMessage = $(".input-e.login_error");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);

        //googleButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
    }

    @Step("Проверяем видимость всех элементов страницы")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Проверяем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {username} и паролем {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВКонтакте")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Вводим текст в поле: логин {username}")
    public void writeLogin(String username) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
    }

    @Step("Вводим текст в поле: пароль {password}")
    public void writePassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
    }

    @Step("Нажимаем на кнопку Войти в ОК")
    public void clickLoginButton() {
        loginButton.shouldBe(visible).click();
    }
}
