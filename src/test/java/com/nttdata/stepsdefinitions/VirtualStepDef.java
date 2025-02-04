package com.nttdata.stepsdefinitions;

import com.nttdata.page.*;
import com.nttdata.steps.InventorySteps;
import com.nttdata.steps.LoginSteps;
import com.nttdata.steps.VirtualSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class VirtualStepDef {
    private WebDriver driver;
    private InventorySteps inventorySteps(WebDriver driver){
        return new InventorySteps(driver);
    }

    @Given("estoy en la pagina de la tienda")
    public void estoyEnLaPaginaDeLaTienda() {
        driver = getDriver();
        driver.get("https://qalab.bensg.com/store/pe/iniciar-sesion?back=https%3A%2F%2Fqalab.bensg.com%2Fstore%2Fpe%2F");
        screenShot();
    }

    @And("me logeo con mi usuario: {string}y clave:{string}")
    public void meLogeoConMiUsuarioYClave(String user, String password) {
        VirtualSteps virtualSteps = new VirtualSteps(driver);
        virtualSteps.typeUs(user);
        virtualSteps.typePass(password);
        virtualSteps.Registro();
    }
    @Then("valido que la autenticación fue exitosa")
    public void validoQueLaAutenticacionFueExitosa() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement logoutButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(PagPrincipalPage.cerrarSeseionButton)
        );

        assert logoutButton.isDisplayed() : "Error: No se encontró el botón de cerrar sesión.";
        System.out.println("Autenticación exitosa: El botón de cerrar sesión está visible.");
    }

    @When("navego a la {string} Clothes y {string} Men")
    public void navegoALaClothesYMen(String cate, String subcate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Seleccionar categoría
        WebElement categoriaElement = wait.until(
                ExpectedConditions.elementToBeClickable(PagPrincipalPage.cate)
        );
        categoriaElement.click();
        System.out.println("Categoría seleccionada: " + cate);

        // Seleccionar subcategoría
        WebElement subCategoriaElement = wait.until(
                ExpectedConditions.elementToBeClickable(ClothesPage.subcate)
        );
        subCategoriaElement.click();
        System.out.println("Subcategoría seleccionada: " + subcate);
    }


    @And("agrego: {string} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(String cantidad) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Seleccionar el primer producto de Clothes
        WebElement producto = wait.until(
                ExpectedConditions.elementToBeClickable(ProductosDeClothesPage.productClothes)
        );
        producto.click();
        System.out.println("Producto seleccionado");
        WebElement cantidadInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(DescripClothesPage.cantiClothes)
        );
        cantidadInput.clear();
        cantidadInput.sendKeys(cantidad);
        System.out.println("Cantidad seleccionada: " + cantidad);

        // Añadir al carrito
        WebElement btnAñadirCarrito = wait.until(
                ExpectedConditions.elementToBeClickable(DescripClothesPage.añadirAlCarrito)
        );
        btnAñadirCarrito.click();
        System.out.println("Producto añadido al carrito");
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmacionDelProductoAgregado() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Esperamos que el popup sea visible
        WebElement popup = wait.until(
                ExpectedConditions.visibilityOfElementLocated(CarritoPopupPage.finaizarCompra)
        );

    }


    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {

    }

    @Then("finalizo la compra")
    public void finalizoLaCompra() {
        
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {
    }
}
