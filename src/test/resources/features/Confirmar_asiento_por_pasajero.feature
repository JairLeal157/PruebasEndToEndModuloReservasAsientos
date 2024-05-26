#author:
  #information
Feature: Confirmar asiento por pasajero.
  Scenario: Confirmación exitosa de selección de asiento.
    Given que tengo una reserva con pasajeros
    When abro la pagina de la reserva
    And selecciono y confirmo un asiento disponible para un pasajero
    Then debo recibir un aviso informando que el asiento quedó confirmado
    And el asiento seleccionado debe quedar ocupado
