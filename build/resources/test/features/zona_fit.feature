Feature: Compra de productos
  como cliente quiero ingresar al portal de zonafit y comprar productos
  que tengan descuento y/o productos que consumo frecuentemente con el fin de obtener dos productos por categoria.

  Background:
    Given El cliente se encuentra en el dominio de compras de la página de zonafit
    Then la página deberá mostrar un mensaje indicando su pedido

  @ofertas
  Scenario: Selección de productos con descuento
    When el cliente selecciona los productos que desea comprar
    And el cliente llena el formulario de la compra y confirma su acción

    @frecuente
    Scenario: Selección de productos frecuentes
      When el cliente selecciona los productos que desea comprar
      And  llena el formulario para la compra y confirma su acción