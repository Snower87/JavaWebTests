package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import core.pages.RecoveryPageByPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnonymRecoveryByPhoneTest extends BaseTest {

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryPageByPhone recoveryPageByPhone;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        // Принятие cookies и политики
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryTest() {
        // Попытка входа с некорректными данными
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.setPassword("1");
            loginPage.clickLogin();
        }

        // Прогружаем страницу с выбором восстановления: по телефону или email-у
        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();

        // Восстанавливаем доступ по номеру телефона
        anonymRecoveryPage.goToRecoveryByPhone();
        recoveryPageByPhone = new RecoveryPageByPhone();

        //Проверяем, что код выбранной страны совпадает
        String countryCode = recoveryPageByPhone.selectCountryByName("Гана");
        sleep(1000);
        assertEquals( "+233", countryCode, "Kод страны не совпадает с ожидаемым");
    }
}
