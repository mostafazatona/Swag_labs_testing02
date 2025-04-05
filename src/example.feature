import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

Feature: عملية جمع بسيطة
  Scenario: جمع رقمين
    Given لدي الرقم 5
    When أضيف الرقم 3
    Then النتيجة يجب أن تكون 8