Feature: Compra de productos
  como cliente quiero ingresar al portal de zonafit a las secciones de productos
  que estén en oferta y más productos, filtrarlos y generar un pedido.

  @ofertas
  Scenario: Productos en oferta
    Given El cliente se encuentra en el portal de compras de la página de zonafit
    When el cliente ingresa a la opción de ofertas, selecciona los productos que desea comprar
    And el cliente llena el formulario de detalles del pago y confirma su acción
    Then la página deberá mostrar un mensaje indicando pedido recibido

  @masProductos
  Scenario: Más productos
    Given El cliente se encuentra en el home de zonafit
    When el cliente ingresa a la opción de más productos y selecciona que desea comprar
    And el cliente llena el formulario de detalles del pago, selecciona Bancolombia y confirma su acción
    Then la página deberá mostrar un código qr para realizar el pago