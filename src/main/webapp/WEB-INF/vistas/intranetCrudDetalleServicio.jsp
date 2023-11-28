<jsp:include page="intranetValida.jsp" />
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Expires" content="-1" />
<meta http-equiv="Cache-Control" content="private" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/bootstrapValidator.js"></script>
<script type="text/javascript" src="js/global.js"></script>

<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrapValidator.css" />

<title>Detalle Servicio</title>
</head>
<body>
	<jsp:include page="intranetCabecera.jsp" />

	<div class="container text-center" style="margin-top: 4%">
		<h3>CRUD DE DETALLE SERVICIO</h3>
	</div>
	<div class="container" style="margin-top: 1%">
		<!-- Primer panel -->
		<div class="panel panel-default">
			<div class="panel-heading" style="background-color: #0063AE;">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#steps" href="#stepOne"
						style="color: white;">Datos Detalle Servicio 1</a>
				</h4>
			</div>
			<div id="stepOne" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="form-group col-md-3">
						<label class="control-label" for="id_servicio">Servicio</label> <select
							class="form-control" id="id_servicio"
							name="servicio.descripcionServicio">
							<option value=" ">[Seleccione]</option>
						</select>
					</div>

					<div class="form-group col-md-6">
						<label class="control-label" for="id_descripcion">Descripcion</label>
						<input class="form-control" type="text" id="id_descripcion"
							name="descripcionServicio" placeholder="Ingrese la cantidad"
							disabled>
					</div>

					<div class="form-group col-md-6">
						<label class="control-label" for="id_costo">Costo del
							Servicio</label> <input class="form-control" type="text" id="id_costo"
							name="costoServicio" placeholder="Ingrese la cantidad" disabled>
					</div>

					<div class="form-group col-md-3">
						<label class="control-label" for="id_tipo">Tipo de
							Servicio</label> <select class="form-control" id="id_tipo"
							name="descripcionTipoServicio" disabled>
							<option value=" ">[Seleccione]</option>
						</select>
					</div>

					<div class="form-group col-md-3">
						<label class="control-label" for="id_estado">Estado</label> <select
							class="form-control" id="id_estado"
							name="descripcionEstadoServicio" disabled>
							<option value=" ">[Seleccione]</option>
						</select>
					</div>
				</div>
			</div>
		</div>

		<!-- Segundo panel -->
		<div class="panel panel-default">
			<div class="panel-heading" style="background-color: #0063AE;">
				<h4 class="panel-title">
					<a data-toggle="collapse" data-parent="#steps" href="#stepTwo"
						style="color: white;">Datos Detalle Producto 2</a>
				</h4>
			</div>
			<div id="stepTwo" class="panel-collapse collapse in">
				<div class="panel-body">
					<div class="form-group col-md-3">
						<label class="control-label" for="id_producto">Producto</label> <select
							class="form-control" id="id_producto"
							name="producto.descripcionProducto">
							<option value=" ">[Seleccione]</option>
							<!-- Agrega aquí más opciones si es necesario -->
						</select>
					</div>

					<div class="form-group col-md-3">
						<label class="control-label" for="id_cantidad">Cantidad</label> <input
							class="form-control" type="number" id="id_cantidad"
							name="cantidad" placeholder="Ingrese la cantidad"
							oninput="calcularTotal()">
					</div>

					<div class="form-group col-md-3">
						<label class="control-label" for="id_precioUnitario">Precio
							Unitario</label> <input class="form-control" type="number"
							id="id_precioUnitario" name="precioUnitario"
							placeholder="Ingrese el precio unitario"
							oninput="calcularTotal()">
					</div>

					<div class="form-group col-md-3">
						<label class="control-label" for="id_total">Total</label> <input
							class="form-control" type="text" id="id_total" name="total"
							readonly>
					</div>
				</div>
				   
			</div>
		</div>
		<!-- Botón Registrar -->
		<div class="form-group col-md-12 mx-auto" align="center"
			style="margin-top: 20px;">
			<button id="id_registrar" type="button" class="btn btn-primary">REGISTRAR</button>
		</div>
	</div>


	<script type="text/javascript">
	<!-- Agregar aquí -->

    function calcularTotal() {
        // Obtener la cantidad y el precio unitario
        var cantidad = document.getElementById('id_cantidad').value;
        var precioUnitario = document.getElementById('id_precioUnitario').value;

        // Calcular el total
        var total = cantidad * precioUnitario;

        // Mostrar el total en el campo correspondiente
        document.getElementById('id_total').value = total;
    }

	
	
	
		$.getJSON("listaServicio", {}, function(data) {
			$.each(data, function(i, item) {
				$("#id_servicio").append(
						"<option value="+item.idServicio +">"
								+ item.descripcionServicio + "</option>");
			});
		});

		$(document)
				.ready(
						function() {
							// Llenar combo de tipo de servicio
							$
									.getJSON(
											"listaTipoServicio",
											{},
											function(data) {
												$
														.each(
																data,
																function(i,
																		item) {
																	$(
																			"#id_tipo")
																			.append(
																					"<option value=" + item.idTipoServicio + ">"
																							+ item.descripcionTipoServicio
																							+ "</option>");
																});
											});

							// Llenar combo de estado
							$
									.getJSON(
											"listaEstadoServicio",
											{},
											function(data) {
												$
														.each(
																data,
																function(i,
																		item) {
																	$(
																			"#id_estado")
																			.append(
																					"<option value=" + item.idEstadoServicio + ">"
																							+ item.descripcionEstadoServicio
																							+ "</option>");
																});
											});

							// Resto del código para el cambio en el combo de servicio
							$("#id_servicio")
									.change(
											function() {
												var idServicioSeleccionado = $(
														this).val();

												$
														.getJSON(
																"obtenerServicioPorId",
																{
																	idServicio : idServicioSeleccionado
																},
																function(data) {
																	if (data.mensaje === "Obtención exitosa") {
																		$(
																				"#id_descripcion")
																				.val(
																						data.descripcionServicio);
																		$(
																				"#id_costo")
																				.val(
																						data.costoServicio);
																		$(
																				"#id_tipo")
																				.val(
																						data.idTipoServicio);
																		$(
																				"#id_estado")
																				.val(
																						data.idEstadoServicio);

																		// Aquí puedes seguir llenando los demás campos si es necesario
																	} else {
																		alert("Error al obtener detalles del servicio");
																	}
																});
											});

							// Código para llenar el combo de productos
							$.getJSON("listaProducto", {}, function(data) {
								$.each(data, function(i, item) {
									$("#id_producto").append(
											"<option value=" + item.idProducto + ">"
													+ item.descripcionProducto
													+ "</option>");
								});
							});
						});
	</script>
</body>
</html>