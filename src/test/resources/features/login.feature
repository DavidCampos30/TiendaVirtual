#language: es
@testfeature
Característica: Login
  Yo, como usuario
  Quiero, tener una opción para iniciar sesión
  Para ver todos los items

  @test
   Esquema del escenario: Iniciar sesión
    Dado que me encuentro en la página de login de Saucedemo
    Cuando inicio sesión con las credenciales usuario: "<usuario>" y contraseña: "<password>"
    Entonces valido que debería aparecer el título de "<titulo>"
    Y también valido que al menos exista un item

    Ejemplos:
    |usuario   |password|    titulo   |
    |standard_user| secret_sauce |Products|
