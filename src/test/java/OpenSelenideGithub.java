import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenSelenideGithub {
    @Test
    void searchSoftAssertionsSelenide(){
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("[name=query-builder-test]").setValue("Selenide").pressEnter();
        $$("h3.Box-sc-g0xbh4-0").first().$("a").click();
        $("#wiki-tab").click();
        $(byText("Soft assertions")).click();
        $$("ol li").shouldHave(texts("TestNG listener", "JUnit4 rule", "JUnit5 extension"));
    }
}
