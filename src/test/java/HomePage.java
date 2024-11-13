import org.openqa.selenium.*;

public class HomePage {

    protected WebDriver driver;
    public final String urlRoot = "https://todomvc.com/examples/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() throws InterruptedException {
        driver.get("https://todomvc.com");
    }

    public void navigateToReact() {
        driver.get(urlRoot + "react/dist/");
    }

    public void navigateToReactRedux() {
        driver.get(urlRoot + "react-redux/dist/#/");
    }

    public void navigateToVue() {
        driver.get(urlRoot + "vue/dist/#/");
    }

    public void navigateToPreact() {
        driver.get(urlRoot + "preact/dist/");
    }

    public void navigateToBackbone() {
        driver.get(urlRoot + "backbone/dist/");
    }

    public void navigateToAngular() {
        driver.get(urlRoot + "angular/dist/browser/#/all");
    }

    public void navigateToEmber() {
        driver.get(urlRoot + "emberjs/todomvc/dist/");
    }

    public void navigateToLit() {
        driver.get(urlRoot + "lit/dist/");
    }

    public void navigateToKnockout() {
        driver.get(urlRoot + "knockoutjs/");
    }

    public void navigateToDojo() {
        driver.get(urlRoot + "dojo/");
    }

    public void navigateToKnockback() {
        driver.get(urlRoot + "knockback/");
    }

    public void navigateToCan() {
        driver.get(urlRoot + "canjs/");
    }

    public void navigateToPolymer() {
        driver.get(urlRoot + "polymer/index.html");
    }

    public void navigateToMithril() {
        driver.get(urlRoot + "mithril/#/");
    }

    public void navigateToMarionette() {
        driver.get(urlRoot + "backbone_marionette/");
    }

    public void navigateToJavaScriptES5() {
        driver.get(urlRoot + "javascript-es5/dist/");
    }

    public void navigateToJavaScriptES6() {
        driver.get(urlRoot + "javascript-es6/dist/");
    }

    public void navigateToJQuery() {
        driver.get(urlRoot + "jquery/dist/#/all");
    }

    public void navigateToWebComponents(){
        driver.get(urlRoot + "web-components/dist/");
    }

    public void navigateToSvelte() {
        driver.get(urlRoot + "svelte/dist/");
    }

    public void navigateToElm() {
        driver.get(urlRoot + "elm/");
    }

    public void navigateToTSAndAngular() {
        driver.get(urlRoot + "typescript-angular/#/");
    }

    public void navigateToTSAndReact() {
        driver.get(urlRoot + "typescript-react/#/");
    }

    public void navigateToGWT() {
        driver.get(urlRoot + "gwt/");
    }

    public void navigateToScala() {
        driver.get(urlRoot + "binding-scala/#/");
    }

    public void navigateToAngularDart() {
        driver.get(urlRoot + "angular-dart/web/");
    }

    public void navigateToJSofOcaml() {
        driver.get(urlRoot + "js_of_ocaml/");
    }

    public void navigateToClosure() {
        driver.get(urlRoot + "closure/#/");
    }

    public void navigateToTSAndBackbone() {
        driver.get(urlRoot + "typescript-backbone/");
    }

    public void navigateToReagent() {
        driver.get(urlRoot + "reagent/");
    }

    public void navigateToHumbleAndGopher() {
        //link doesn't work
        driver.get(urlRoot + "humble/");
    }

    public void navigateToBackboneAndRequire() {
        driver.get(urlRoot + "backbone_require/");
    }

    public void navigateToCanAndRequire() {
        driver.get(urlRoot + "canjs_require/");
    }

    public void navigateToSoma() {
        //link doesn't work
        driver.get(urlRoot + "somajs/");
    }

    public void navigateToEnyoAndBackbone() {
        driver.get(urlRoot + "enyo_backbone/");
    }

    public void navigateToAurelia() {
        //buggy page
        driver.get(urlRoot + "aurelia/");
    }

    public void navigateToKnockoutAndRequire() {
        driver.get(urlRoot + "knockoutjs_require/");
    }

    public void navigateToLavacaAndRequire() {
        driver.get(urlRoot + "lavaca_require/#/#@1");
    }

    public void navigateToDuel() {
        driver.get(urlRoot + "duel/www/");
    }

    public void navigateToExoskeleton() {
        driver.get(urlRoot + "exoskeleton/");
    }

    public void navigateToRiot() {
        driver.get(urlRoot + "riotjs/");
    }

    public void navigateToAngularAndRequire() {
        driver.get(urlRoot + "angularjs_require/#/");
    }

    public void navigateToCujo() {
        driver.get(urlRoot + "cujo/index.html");
    }

    public void navigateToDijon() {
        driver.get(urlRoot + "dijon/");
    }

    public void navigateToRactive() {
        driver.get(urlRoot + "ractive/");
    }

    public void navigateToJSBlocks() {
        driver.get(urlRoot + "jsblocks/");
    }







}
