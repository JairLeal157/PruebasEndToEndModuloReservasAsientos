#author:
  #information

Feature: Ver precios de los asientos en la seleccion.
  Scenario: Visualización de precios de asientos disponibles.
    Given tengo una reserva
    And abro la pagina de la reserva
    When  abro la lista de asientos disponibles
    Then  debo ver el precio adicional de cada asiento en la lista en formato COP
