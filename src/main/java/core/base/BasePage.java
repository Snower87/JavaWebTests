package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    protected SelenideElement acceptCookieButton = $(".cb_accept");
    protected SelenideElement acceptPrivacyButton = $(".cmptxt_btn_yes");

    @Step("Выполняем поиск по сайту с запросом: {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step("Открываем VK Service")
    public void openVKServices() {
        vkServices.shouldBe(visible).click();
    }

    @Step("Кликаем на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    @Step("Принимаем куки")
    public void acceptCookie() {
        acceptCookieButton.shouldBe(visible).click();
    }

    @Step("Принимаем политику конфиденциальности")
    public void acceptPrivacyButton() {
        acceptPrivacyButton.shouldBe(visible).click();
    }
}
