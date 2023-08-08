import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenSelenideGithub {
    @Test
    void searchSoftAssertionsSelenide() {
        open("https://github.com/");
        $("[placeholder='Search or jump to...']").click();
        $("[name=query-builder-test]").setValue("Selenide").pressEnter();
        $$("h3.Box-sc-g0xbh4-0").first().$("a").click();
        $("#wiki-tab").click();
        $(byText("Show 2 more pages…")).click();
        $(byText("SoftAssertions")).shouldBe(visible);
        $(byText("SoftAssertions")).click();
        $("#user-content-3-using-junit5-extend-test-class").
                closest("h4").
                sibling(0).
                shouldHave(text(
                        "@ExtendWith({SoftAssertsExtension.class})\n" +
                                "class Tests {\n" +
                                "  @Test\n" +
                                "  void test() {\n" +
                                "    Configuration.assertionMode = SOFT;\n" +
                                "    open(\"page.html\");\n" +
                                "\n" +
                                "    $(\"#first\").should(visible).click();\n" +
                                "    $(\"#second\").should(visible).click();\n" +
                                "  }\n" +
                                "}"));
    }
}
