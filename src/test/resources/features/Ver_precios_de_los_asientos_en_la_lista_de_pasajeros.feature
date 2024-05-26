#author:
  #information
  Feature: Ver precios de los asientos en la lista de pasajeros.
    Scenario: Consulta exitosa de precios de asientos asignados a pasajeros.
      Given que tengo una reserva con pasajeros
      When abro la pagina de la reserva
      And selecciono los asientos
      Then debo ver en la lista de pasajeros los precios de los asientos seleccionados en formato COP
      And debo ver el total adicional de la reserva por los asientos

    Scenario: uno o mas pasajeros no tienen asientos seleccionados.
      Given que tengo una reserva con pasajeros pero uno o mas no tienen asientos seleccionados
      When abro la pagina de la reserva
      Then debo ver la lista de precios de asientos por cada pasajero en formato COP
      And debo ver el total adicional de la reserva por los asientos
      And debo ver que los pasajeros sin asientos tengan un valor de 0
