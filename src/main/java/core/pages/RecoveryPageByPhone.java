package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class RecoveryPageByPhone extends BasePage {
    private SelenideElement numberTelephone = $(By.id("field_phone"));
    private SelenideElement checkBoxCountryOrRegion = $(By.id("country"));
    private SelenideElement getSMSCodeButton = $("[data-l='t,submit']");
    private SelenideElement errorMessage = $x(".//div[@class='input-e js-ph-vl-hint']");

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

    @Step("Выбираю код страны по названию")
    public String selectCountryByName(String countryName) {
        checkBoxCountryOrRegion.click(); //Открываем список стран
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName)); //Находим страну по названию
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text(); //Прокручиваем к стране и выбираем
        countryItem.click();
        return countryCode;
    }

    @Step("Проверяю сообщение с ошибкой")
    public String getErrorMessage() {
        errorMessage.shouldBe(visible);
        return errorMessage.getText();
    }
}
