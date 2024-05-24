#author:
  #information

  Feature: Ver lista actualizada de asientos disponibles durante la selección.
    Scenario: Ver lista actualizada de asientos disponibles.
      Given no tengo asiento asignado
      And estoy en la página de gestión de asientos de la reserva
      When selecciono la opción de seleccionar asiento para un pasajero
      Then  veo la lista de asientos disponibles
      And veo el número de asiento, la clase y la ubicación para cada asiento
      And la lista está ordenada alfabéticamente según la información del asiento
      And para cada asiento asignado por mi reserva, veo el número de reserva y el nombre del pasajero
      And el 80% de los asientos disponibles corresponden a clase turista, el 10% a primera clase y el 10% a clase ejecutiva
      And la distribución de ubicaciones (ventana, pasillo y centro) es equitativa para cada clase
      But no se muestra información de los asientos ocupados por otras reservas.
