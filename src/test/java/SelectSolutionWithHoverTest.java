import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelectSolutionWithHoverTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void selectSolutionWithHoverTest() {
        //Открыть страницу GitHub
        open("https://github.com");
        //Перейти в Enterprise
        $("ul.d-lg-flex.list-style-none").$(byText("Solutions")).hover();
        $("[href='/enterprise']").click();
        //Убедиться, что перешли на верную страницу
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform."));
    }

}
