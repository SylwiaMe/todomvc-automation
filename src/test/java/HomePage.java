import org.openqa.selenium.*;

public class HomePage {

    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() throws InterruptedException {
        driver.get("https://todomvc.com");
        Thread.sleep(2000);
    }

    public void navigateToReact() {
        driver.get("https://todomvc.com/examples/react/dist/");
    }

    public void navigateToReactRedux() {
        driver.get("https://todomvc.com/examples/react-redux/dist/#/");
    }

    public void navigateToVue() {
        driver.get("https://todomvc.com/examples/vue/dist/#/");
    }

    public void navigateToPreact() {
        driver.get("https://todomvc.com/examples/preact/dist/");
    }

    public void navigateToBackbone() {
        driver.get("https://todomvc.com/examples/backbone/dist/");
    }

    public void navigateToAngular() {
        driver.get("https://todomvc.com/examples/angular/dist/browser/#/all");
    }

    public void navigateToEmber() {
        driver.get("https://todomvc.com/examples/emberjs/todomvc/dist/");
    }

    public void navigateToLit() {
        driver.get("https://todomvc.com/examples/lit/dist/");
    }

    public void navigateToKnockout() {
        driver.get("https://todomvc.com/examples/knockoutjs/");
    }

    public void navigateToDojo() {
        driver.get("https://todomvc.com/examples/dojo/");
    }

    public void navigateToKnockback() {
        driver.get("https://todomvc.com/examples/knockback/");
    }

    public void navigateToCan() {
        driver.get("https://todomvc.com/examples/canjs/");
    }

    public void navigateToPolymer() {
        driver.get("https://todomvc.com/examples/polymer/index.html");
    }

    public void navigateToMithril() {
        driver.get("https://todomvc.com/examples/mithril/#/");
    }

    public void navigateToMarionette() {
        driver.get("https://todomvc.com/examples/backbone_marionette/");
    }

    public void navigateToJavaScriptES5() {
        driver.get("https://todomvc.com/examples/javascript-es5/dist/");
    }

    public void navigateToJavaScriptES6() {
        driver.get("https://todomvc.com/examples/javascript-es6/dist/");
    }

    public void navigateToJQuery() {
        driver.get("https://todomvc.com/examples/jquery/dist/#/all");
    }

    public void navigateToWebComponents(){
        driver.get("https://todomvc.com/examples/web-components/dist/");
    }

    public void navigateToSvelte() {
        driver.get("https://todomvc.com/examples/svelte/dist/");
    }

    public void navigateToElm() {
        driver.get("https://todomvc.com/examples/elm/");
    }

    public void navigateToTSAndAngular() {
        driver.get("https://todomvc.com/examples/typescript-angular/#/");
    }

    public void navigateToTSAndReact() {
        driver.get("https://todomvc.com/examples/typescript-react/#/");
    }

    public void navigateToGWT() {
        driver.get("https://todomvc.com/examples/gwt/");
    }

    public void navigateToScala() {
        driver.get("https://todomvc.com/examples/binding-scala/#/");
    }

    public void navigateToAngularDart() {
        driver.get("https://todomvc.com/examples/angular-dart/web/");
    }

    public void navigateToJSofOcaml() {
        driver.get("https://todomvc.com/examples/js_of_ocaml/");
    }

    public void navigateToClosure() {
        driver.get("https://todomvc.com/examples/closure/#/");
    }

    public void navigateToTSAndBackbone() {
        driver.get("https://todomvc.com/examples/typescript-backbone/");
    }

    public void navigateToReagent() {
        driver.get("https://todomvc.com/examples/reagent/");
    }

    public void navigateToHumbleAndGopher() {
        //link doesn't work
        driver.get("https://todomvc.com/examples/humble/");
    }

    public void navigateToBackboneAndRequire() {
        driver.get("https://todomvc.com/examples/backbone_require/");
    }

    public void navigateToCanAndRequire() {
        driver.get("https://todomvc.com/examples/canjs_require/");
    }

    public void navigateToSoma() {
        //link doesn't work
        driver.get("https://todomvc.com/examples/somajs/");
    }

    public void navigateToEnyoAndBackbone() {
        driver.get("https://todomvc.com/examples/enyo_backbone/");
    }

    public void navigateToAurelia() {
        //buggy page
        driver.get("https://todomvc.com/examples/aurelia/");
    }

    public void navigateToKnockoutAndRequire() {
        driver.get("https://todomvc.com/examples/knockoutjs_require/");
    }

    public void navigateToLavacaAndRequire() {
        driver.get("https://todomvc.com/examples/lavaca_require/#/#@1");
    }

    public void navigateToDuel() {
        driver.get("https://todomvc.com/examples/duel/www/");
    }

    public void navigateToExoskeleton() {
        driver.get("https://todomvc.com/examples/exoskeleton/");
    }

    public void navigateToRiot() {
        driver.get("https://todomvc.com/examples/riotjs/");
    }

    public void navigateToAngularAndRequire() {
        driver.get("https://todomvc.com/examples/angularjs_require/#/");
    }

    public void navigateToCujo() {
        driver.get("https://todomvc.com/examples/cujo/index.html");
    }

    public void navigateToDijon() {
        driver.get("https://todomvc.com/examples/dijon/");
    }

    public void navigateToRactive() {
        driver.get("https://todomvc.com/examples/ractive/");
    }

    public void navigateToJSBlocks() {
        driver.get("https://todomvc.com/examples/jsblocks/");
    }







}
