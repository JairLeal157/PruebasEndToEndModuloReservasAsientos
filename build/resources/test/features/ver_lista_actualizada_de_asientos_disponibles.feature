#author:
  #information

  Feature: Ver lista actualizada de asientos disponibles durante la selección.
    Scenario: Ver lista actualizada de asientos disponibles.
      Given no tengo asiento asignado
      And estoy en la página de gestión de asientos de la reserva
      When selecciono la opción de seleccionar asiento para un pasajero
      Then  veo la lista de asientos disponibles
      And veo el número de asiento, la clase y la ubicación para cada asiento
      And el 33% de los asientos disponibles corresponden a clase turista, el 33% a primera clase y el 33% a clase ejecutiva
