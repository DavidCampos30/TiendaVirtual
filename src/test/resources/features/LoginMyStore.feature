@testLoginMyStore
  Feature: Login
    Yo, como usuario
    Quiero, tener una opcion para iniciar sesion
    Para ver todos los items

  @testLogin
  Scenario: Iniciar sescion
    Given que me encuentro en la pagina de login de MyStore
    When inicio sesión con las credenciales usuario: "usuario@gmail.com" y pass: "Peru123.$"
    Then valido que deberia aparecer el texto de "Products"