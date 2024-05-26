#author:
  #information
  Feature: Ver lista de pasajeros
    Scenario: Ver lista de pasajeros con sus asientos asignados
      Given tengo una reserva
      When abro la pagina de la reserva
      Then veo todos los pasajeros de la reserva

    Scenario: Ver lista de pasajeros cuando no hay asientos asignados.
      Given tengo una reserva
      When abro la pagina de la reserva
      Then veo todos los pasajeros de la reserva
      And para cada pasajero sin asiento, veo el texto "N/A" con la opción de seleccionar asiento para cada pasajero.
