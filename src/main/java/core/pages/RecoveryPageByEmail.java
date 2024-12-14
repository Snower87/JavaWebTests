package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryPageByEmail extends BasePage {
    private SelenideElement emailField = $("[data-l='t,email']");
    private SelenideElement emailCodeButton = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления через email")
    private void verifyPageElements() {
        emailField.shouldBe (visible);
        emailCodeButton.shouldBe(visible);
    }

    @Step("Вводим текст в поле: почта {email}")
    public void writeEmail(String email) {
        emailField.shouldBe(visible).click();
        emailField.shouldBe(visible).setValue(email);
    }

    @Step("Нажимаем на кнопку получить код на email")
    public void clickSendCodeToEmail() {
        emailCodeButton.shouldBe(visible).click();
    }
}
