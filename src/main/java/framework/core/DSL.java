package framework.core;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DSL {

    public DSL() {
    }

    public void escrever(String id_campo, String texto) {
        DriverFactory.getDriver().findElement(By.id(id_campo)).sendKeys(texto);
    }

    public String obterValorCampo(String id_campo) {
        return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");
    }

    public void clicar(String id_campo) {
        DriverFactory.getDriver().findElement(By.id(id_campo)).click();
    }

    public boolean checkRadio(String id_campo) {
        return DriverFactory.getDriver().findElement(By.id(id_campo)).isSelected();
    }

    public void selecionarCombo(String id_campo, String valor) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        combo.selectByVisibleText(valor);
    }

    public void deselecionarCombo(String id_campo, String texto) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        combo.deselectByVisibleText(texto);
    }

    public String obterValorCombo(String id_campo) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        return combo.getFirstSelectedOption().getText();
    }

    public int obterListaComboQuantidade (String id_campo) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        return options.size();
    }

    public boolean verificarOpcoesCombo (String id_campo, String texto) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        List<WebElement> options = combo.getOptions();
        boolean encontrou = false;
        for (WebElement option: options) {
            if (option.getText().equals(texto)) {
                encontrou = true;
                break;
            }
        }
        return encontrou;
    }

    public List obterOpcoesSelecionadasCombo (String id_campo) {
        WebElement element = DriverFactory.getDriver().findElement(By.id(id_campo));
        Select combo = new Select(element);
        List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
        List<String> valores = new ArrayList<>();
        for (WebElement opcao: allSelectedOptions) {
            valores.add(opcao.getText());
        }
        return valores;
    }

    public void clicarLink(String link) {
        DriverFactory.getDriver().findElement(By.linkText(link)).click();
    }

    public String obterValorTexto(By by) {
        return DriverFactory.getDriver().findElement(by).getText();
    }

    public String interagirAlertObterTexto() {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        String textoAlert = alert.getText();
        return textoAlert;
    }

    public String interagirAlertObterTextoConfirm() {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        String textoAlert = alert.getText();
        alert.accept();
        return textoAlert;
    }

    public String interagirAlertObterTextoCancel() {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        String textoAlertCancel = alert.getText();
        alert.dismiss();
        return textoAlertCancel;
    }

    public void interagirAlertEscrever(String value) {
        Alert alert = DriverFactory.getDriver().switchTo().alert();
        alert.sendKeys(value);
        alert.accept();
    }
}
