@TestProduct
Feature: Product-Store

  @Prueba
  Scenario Outline: Validacion del precio del producto
    Given estoy en la pagina de la tienda
    And me logeo con mi usuario: "<usuario>"y clave:"<password>"
    Then valido que la autenticación fue exitosa
    When navego a la "<categoria>" Clothes y "<subcategoria>" Men
    And agrego: "<cantidad>" unidades del primer producto al carrito
    Then valido en el popup la confirmación del producto agregado
    And valido en el popup que el monto total sea calculado correctamente
    Then finalizo la compra
    Then valido el titulo de la pagina del carrito
    And vuelvo a validar el calculo de precios en el carrito

    Examples:
      | usuario               | password  | categoria | subcategoria | cantidad |
      | david@gmail.com      | 123      | Clothes   | Men          | 2        |




