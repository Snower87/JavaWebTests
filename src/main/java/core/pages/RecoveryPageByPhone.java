package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryPageByPhone extends BasePage {
    private SelenideElement numberTelephone = $(By.id("field_phone"));
    private SelenideElement checkBoxCountryOrRegion = $(By.id("country"));
    private SelenideElement getSMSCodeButton = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице восстановления пароля")
    private void verifyPageElements() {
        numberTelephone.shouldBe(visible);
        checkBoxCountryOrRegion.shouldBe (visible);
        getSMSCodeButton.shouldBe(visible);
    }

    @Step("Вводим текст в поле: телефон {phone}")
    public void writePhoneNumber(String phone) {
        numberTelephone.shouldBe(visible).click();
        numberTelephone.shouldBe(visible).setValue(phone);
    }

    @Step("Нажимаем на кнопку получить код на телефон")
    public void clickGetSMSCodeButton() {
        getSMSCodeButton.shouldBe(visible).click();
    }
}
