Feature: Pruebas PetStore

  @API
  Scenario Outline: Crear order

    When creo una orden con  id "<id>", id de la mascota "<mascota>" y la cantidad es "<catindad>"
    Then el código de respuesta es "<statusCode>"
    And el id de la mascota es "<mascota>"

    Examples:
      | id       | mascota | catindad | statusCode |
      | 26012024 | 26      | 10       | 200        |
      | 98745631 | 10      | 20       | 200        |
      | 124563   | 15      | 200      | 200        |

    
  @API
  Scenario Outline: Consultar order

    When consulto la orden con id "<id>"
    Then el código de respuesta es "<statusCode>"
    And el id de la orden es "<id>"

    Examples:
      | id       | statusCode |
      | 26012024 | 200        |
      | 98745631 | 200        |
      | 124563   | 200        |