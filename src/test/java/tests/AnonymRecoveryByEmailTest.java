package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.LoginPage;
import core.pages.RecoveryPageByEmail;
import core.pages.RecoveryPageByPhone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRecoveryByEmailTest extends BaseTest{

    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryPageByEmail recoveryPageByEmail;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        // Принятие cookies и политики
        loginPage = new LoginPage();
        //LoginPage.acceptCookie();
        //LoginPage.acceptPrivacyButton();
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

        // Восстанавливаем доступ через email
        anonymRecoveryPage.goToRecoveryByEmail();
        recoveryPageByEmail = new RecoveryPageByEmail();
    }
}
