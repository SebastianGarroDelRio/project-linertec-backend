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



<title>Contrato</title>
</head>
<body>
	<jsp:include page="intranetCabecera.jsp" />

	<div class="container" style="margin-top: 4%">

		<form id="id_form" accept-charset="UTF-8" action="contrato"
			class="form-horizontal" method="post">
			<div class="panel-group" id="steps">

				<!-- INICIO CARTA DE CLIENTE -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<button type="button" id="id_btnCliente" data-toggle='modal'
							class='btn btn-primary' style="width: 170px; margin-left: 30px;">BUSCA
							CLIENTE</button>
						<!-- CONSULTAR -->
						<input type="hidden" name="idCliente" id="id_cliente_id"
							class="form-control" value="-1" />
					</div>
					<div class="panel-body">
						<div class="form-group col-md-4" style="margin-left: 10px;">
							<label class="control-label">Nombre Completo</label> <input
								type="text" id="id_cliente_nombre" class="form-control"
								readonly="readonly" />
						</div>

						<div class="form-group col-md-4" style="margin-left: 10px;">
							<label class="control-label">Correo electronico</label> <input
								type="text" id="id_cliente_correo" class="form-control"
								readonly="readonly" />
						</div>

						<div class="form-group col-md-4" style="margin-left: 10px;">
							<label class="control-label">Telefono</label> <input type="text"
								id="id_cliente_telefono" class="form-control"
								readonly="readonly" />
						</div>

						<div class="form-group col-md-4" style="margin-left: 10px;">
							<label class="control-label">Tipo de documento</label> <input
								type="text" id="id_cliente_documento" class="form-control"
								readonly="readonly" />
						</div>

						<div class="form-group col-md-4" style="margin-left: 10px;">
							<label class="control-label">Numero de documento</label> <input
								type="text" id="id_cliente_numdocumento" class="form-control"
								readonly="readonly" />
						</div>

						<div class="form-group col-md-4" style="margin-left: 10px;">
							<label class="control-label">Estado</label> <input type="text"
								id="id_cliente_estado" class="form-control" readonly="readonly" />
						</div>

					</div>
				</div>
				<!-- FIN CARTA DE CLIENTE -->

				<!-- INICIO CARTA DE SERVICIO -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<button type="button" id="id_btnServicio" data-toggle='modal'
							class='btn btn-primary' style="width: 170px; margin-left: 30px;">BUSCA
							SERVICIO</button>

						<input type="hidden" name="idServicio" id="id_servicio_id"
							class="form-control" value="-1" />

					</div>
					<div class="panel-body">
						<div class="form-group  col-md-3" style="margin-left: 10px;">
							<label class="control-label">Descripcion Servicio</label> <input
								type="text" name="descripcionServicio"
								id="id_servicio_descripcion" class="form-control"
								readonly="readonly" />
						</div>
						<div class="form-group  col-md-3" style="margin-left: 10px;">
							<label class="control-label">Costo del Servicio</label> <input
								type="text" name="costoServicio" id="id_servicio_costo"
								class="form-control" readonly="readonly" />
						</div>
						<div class="form-group  col-md-3" style="margin-left: 10px;">
							<label class="control-label">Tipo Servicio</label> <input
								type="text" name="tipoServicio" id="id_servicio_tipo"
								class="form-control" readonly="readonly" />
						</div>
						<div class="form-group  col-md-3" style="margin-left: 10px;">
							<label class="control-label">Estado</label> <input type="text"
								name="estadoServicio" id="id_servicio_estado"
								class="form-control" readonly="readonly" />
						</div>

						<div class="form-group  col-md-3" style="margin-left: 10px;">
							<label class="control-label">IGV</label> <input type="text"
								name="impuesto" id="id_servicio_impuesto" class="form-control"
								placeholder="Ingrese el impuesto"
								onkeypress="return validarSoloNumerosEnteros(event);" />
						</div>

						<div class="form-group  col-md-3" style="margin-left: 10px;">
							<label class="control-label">Fecha Inicio</label>
							<input
								type="date" name="fechainicio" id="id_servicio_fecinicio"
								class="form-control"  />
						</div>

						<div class="form-group  col-md-3" style="margin-left: 10px;">
							<label class="control-label">Fecha Fin</label>
							<input type="date"
								name="fechafin" id="id_servicio_fecfin" class="form-control"/>
						</div>

						<div class="form-group  col-md-3" style="margin-left: 10px;">
							<label class="col-lg-3 control-label" for="id_estado">Estado</label>
							<div class="col-lg-12">
								<select id="id_estado" name="estado" class='form-control'>
									<option value=" ">[Seleccione]</option>
								</select>
							</div>
						</div>

					</div>
				</div>
				<!-- FIN CARTA DE SERVICIO -->

				<!-- INICIO CARTA DE DETALLE -->
				<div class="panel panel-default">
					<div class="panel-heading">Detalle de Contrato</div>
					<div class="panel-body">
						<div class="form-group">
							<div class="col-lg-9 col-lg-offset-3">
								<button type="button" id="id_btnAgregar" class="btn btn-primary"
									style="width: 170px">AGREGA SERVICIO</button>
								<button type="button" id="id_btnRegistrar"
									class="btn btn-primary" style="width: 170px">REGISTRA
									CONTRATO</button>
							</div>
						</div>
						<div class="form-group">
							<div class="col-lg-12">
								<table id="id_table_contrato"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th style="width: 5%">CÓDIGO</th>
											<th style="width: 20%">NOMBRE</th>
											<th style="width: 10%">COSTO</th>
											<th style="width: 10%">IMPUESTO</th>
											<th style="width: 15%">FECHA INICIO</th>
											<th style="width: 15%">FECHA FIN</th>
											<th style="width: 10%">ESTADO</th>
											<th style="width: 10%">SUBTOTAL</th>
											<th style="width: 5%">ELIMINAR</th>
										</tr>
									</thead>
									<tbody id="id_table_contrato_body">
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!-- FIN CARTA DE DETALLE -->
			</div>

			<!-- El formulario de busqueda de Cliente (Modal) -->
			<div class="modal fade" id="idBuscaCliente">
				<div class="modal-dialog" style="width: 60%">

					<div class="modal-content">
						<div class="modal-header" style="padding: 35px 50px">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4>
								<span class="glyphicon glyphicon-ok-sign"></span> Busqueda de
								Cliente
							</h4>
						</div>
						<div class="modal-body" style="padding: 20px 10px;">
							<div class="panel-group" id="steps">
								<div class="panel panel-default">
									<div class="form-group">
										<label class="col-lg-3 control-label"> Cliente </label>
										<div class="col-lg-5">
											<input id="id_txtCliente" class="form-control" name="cliente"
												type="text" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-12">
											<table id="id_table_cliente"
												class="table table-striped table-bordered">
												<thead>
													<tr>
														<th style="width: 5%">Id</th>
														<th style="width: 20%">Nombre completo</th>
														<th style="width: 20%">correo</th>
														<th style="width: 20%">telefono</th>
														<th style="width: 10%">Tipo</th>
														<th style="width: 10%">Documento</th>
														<th style="width: 10%">estado</th>
														<th style="width: 5%"></th>
													</tr>
												</thead>
												<tbody>
												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- El formulario de busqueda de Servicio (Modal) -->
			<div class="modal fade" id="idBuscaServicio">
				<div class="modal-dialog" style="width: 60%">

					<div class="modal-content">
						<div class="modal-header" style="padding: 35px 50px">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4>
								<span class="glyphicon glyphicon-ok-sign"></span> Busqueda de
								Servicio
							</h4>
						</div>
						<div class="modal-body" style="padding: 20px 10px;">
							<div class="panel-group" id="steps">
								<div class="panel panel-default">
									<div class="form-group">
										<label class="col-lg-3 control-label"> Servicio </label>
										<div class="col-lg-5">
											<input id="id_txtServicio" class="form-control"
												name="producto" type="text" />
										</div>
									</div>
									<div class="form-group">
										<div class="col-lg-12">
											<table id="id_table_servicio"
												class="table table-striped table-bordered">
												<thead>
													<tr>
														<th style="width: 5%">Id</th>
														<th style="width: 30%">Descripcion</th>
														<th style="width: 20%">Costo Total</th>
														<th style="width: 20%">Tipo Servicio</th>
														<th style="width: 20%">Estado</th>
														<th style="width: 5%"></th>
													</tr>
												</thead>
												<tbody>

												</tbody>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Modal Mensaje -->
			<div class="modal fade" id="idMensaje">
				<div class="modal-dialog" style="width: 60%">

					<div class="modal-content">
						<div class="modal-header" style="padding: 20px 20px">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4>
								<span class="glyphicon glyphicon-ok-sign"></span> Mensaje
							</h4>
						</div>
						<div id="idMensajeTexto" class="modal-body"
							style="padding: 30px 30px; align-content: center;"></div>
					</div>
				</div>
			</div>


		</form>
	</div>


	<script type="text/javascript">
	$.getJSON("listaEstadoContrato", {}, function(data) {
		$.each(data, function(i, item) {
			$("#id_estado").append(
					"<option value="+item.idEstadoContrato +">"
							+ item.descripcionEstadoContrato + "</option>");
		});
	});
	
		$(document)
				.ready(
						function() {
							//tabla seleccion
							$
									.getJSON(
											"listaSeleccion",
											{},
											function(data) {
												$
														.each(
																data,
																function(index,
																		item) {
																	$(
																			'#id_table_contrato_body')
																			.append(
																					"<tr><td>"
																							+ item.idServicio
																							+ "</td><td>"
																							+ item.descripcionServicio
																							+ "</td><td>"
																							+ item.costoServicio
																							+ "</td><td>"
																							+ item.impuesto
																							+ "</td><td>"
																							+ item.fechainicio
																							+ "</td><td>"
																							+ item.fechafin
																							+ "</td><td>"
																							+ item.estado
																							+ "</td><td>"
																							+ item.totalParcial
																							+ "</td><td><button type='button' onclick='f_elimina_seleccion("
																							+ item.idServicio
																							+ ");' class='btn btn-default' aria-label='Left Align' ><span class='glyphicon glyphicon-remove' aria-hidden='true'></span></button></td></tr>");
																});
											});
						});

		//Se anula el enter
		$(document).on("keypress", "form", function(event) {
			return event.keyCode != 13;
		});

		//Al pulsar el botón cliente
		$("#id_btnCliente").click(function() {
			muestraCliente();
			$("#idBuscaCliente").modal("show");
		});

		//Al pulsar el botón servicio
		$("#id_btnServicio").click(function() {
			muestraServicio();
			$("#idBuscaServicio").modal("show");
		});

		//Al escribir en la caja de texto del cliente
		$("#id_txtCliente").keyup(function(e) {
			muestraCliente();
		});

		//Al escribir en la caja de texto del servicio
		$("#id_txtServicio").keyup(function(e) {
			muestraServicio();
		});

		function muestraCliente() {
			var var_cliente = $("#id_txtCliente").val();
			//limpiar la tabla
			$("#id_table_cliente tbody").empty();
			//Se añade los clientes a la tabla
			$
					.getJSON(
							"cargaCliente",
							{
								"filtro" : var_cliente
							},
							function(data) {
								$
										.each(
												data,
												function(index, item) {
													$('#id_table_cliente')
															.append(
																	"<tr><td>"
																			+ item.idCliente
																			+ "</td><td>"
																			+ item.nombreCliente
																			+ "</td><td>"
																			+ item.correo
																			+ "</td><td>"
																			+ item.telefono
																			+ "</td><td>"
																			+ item.tipoDocumento.nombreDocumento
																			+ "</td><td>"
																			+ item.numeroDocumento
																			+ "</td><td>"
																			+ item.estado.descripcionestado
																			+ "</td><td><button type='button' class='btn btn-default' aria-label='Left Align' onclick=\"f_seleccione_cliente('"
																			+ item.idCliente
																			+ "','"
																			+ item.nombreCliente
																			+ "','"
																			+ item.correo
																			+ "','"
																			+ item.telefono
																			+ "','"
																			+ item.tipoDocumento.nombreDocumento
																			+ "','"
																			+ item.numeroDocumento
																			+ "','"
																			+ item.estado.descripcionestado
																			+ "');\" ><span class='glyphicon glyphicon-ok' aria-hidden='true'></span></button></td></tr>");
												});
							});
		}

		//Al pulsar selecciona cliente
		function f_seleccione_cliente(id, nombreCliente, correo, telefono,
				tipoDocumento, numeroDocumento, estado) {
			$("#id_cliente_id").val(id);
			$("#id_cliente_nombre").val(nombreCliente);
			$("#id_cliente_correo").val(correo);
			$("#id_cliente_telefono").val(telefono);
			$("#id_cliente_documento").val(tipoDocumento);
			$("#id_cliente_numdocumento").val(numeroDocumento);
			$("#id_cliente_estado").val(estado);
			$("#idBuscaCliente").modal("hide");
		}

		function muestraServicio() {
			var var_servicio = $("#id_txtServicio").val();

			//limpiar la tabla
			$("#id_table_servicio tbody").empty();

			//Se añade el servicio a la tabla
			$
					.getJSON(
							"cargaServicio",
							{
								"filtro" : var_servicio
							},
							function(data) {
								$
										.each(
												data,
												function(index, item) {
													$('#id_table_servicio')
															.append(
																	"<tr><td>"
																			+ item.idServicio
																			+ "</td><td>"
																			+ item.descripcionServicio
																			+ "</td><td>"
																			+ item.costoServicio
																			+ "</td><td>"
																			+ item.tipoServicio.descripcionTipoServicio
																			+ "</td><td>"
																			+ item.estadoServicio.descripcionEstadoServicio
																			+ "</td><td><button type='button' class='btn btn-default' aria-label='Left Align' onclick=\"f_seleccione_servicio('"
																			+ item.idServicio
																			+ "','"
																			+ item.descripcionServicio
																			+ "','"
																			+ item.costoServicio
																			+ "','"
																			+ item.tipoServicio.descripcionTipoServicio
																			+ "','"
																			+ item.estadoServicio.descripcionEstadoServicio
																			+ "');\" ><span class='glyphicon glyphicon-ok' aria-hidden='true'></span></button></td></tr>");
												});
							});
		}

		//Al pulsar selecciona servicio
		function f_seleccione_servicio(id, descripcionServicio, costoServicio,
				tipoServicio, estadoServicio) {
			$("#id_servicio_id").val(id);
			$("#id_servicio_descripcion").val(descripcionServicio);
			$("#id_servicio_costo").val(costoServicio);
			$("#id_servicio_tipo").val(tipoServicio);
			$("#id_servicio_estado").val(estadoServicio);
			$("#idBuscaServicio").modal("hide");
		}

		//Solo numeros en caja de texto
		function validarSoloNumerosEnteros(e) { // 1
			tecla = (document.all) ? e.keyCode : e.which; // 2
			if (tecla == 8)
				return true; // 3
			patron = /[0-9]/;// Solo acepta números
			te = String.fromCharCode(tecla); // 5
			return patron.test(te); // 6
		}

		//Al pulsar el botón agregar
		$("#id_btnAgregar")
				.click(
						function() {
							var var_ser = $("#id_servicio_id").val();
							var var_imp = $("#id_servicio_impuesto").val();
							var var_feci = $("#id_servicio_fecinicio").val();
							var var_fecf = $("#id_servicio_fecfin").val();
							var var_estc = $("#id_estado").val();

							//Validar duplicados
							var yaExiste = false;
							$("#id_table_contrato_body tr")
									.each(
											function() {
												if ($(this).find('td:eq(0)')
														.html() == var_ser) {
													yaExiste = true;
												}
											});

							if (var_ser == '-1') {
								$("#idMensajeTexto").text(
										"Seleccione un Servicio");
								$("#idMensaje").modal("show");
							} else if (var_imp == '') {
								$("#idMensajeTexto").text("Agrege un impuesto");
								$("#idMensaje").modal("show");
							} else if ($.isNumeric(var_imp) == false) {
								$("#idMensajeTexto").text(
										"El impuesto debe ser númerico");
								$("#idMensaje").modal("show");
							} else if (parseInt(var_imp) <= 0) {
								$("#idMensajeTexto").text(
										"El impuesto debe ser postivo");
								$("#idMensaje").modal("show");
							} else if (yaExiste) {
								$("#idMensajeTexto").text(
										"Existe el producto elegido");
								$("#idMensaje").modal("show");
							} else {

								var var_des = $("#id_servicio_descripcion")
										.val();
								var var_cos = $("#id_servicio_costo").val();

								//limpiar la tabla
								$("#id_table_contrato_body").empty();

								var jsonParam = {
									"idServicio" : var_ser,
									"descripcionServicio" : var_des,
									"costoServicio" : var_cos,
									"impuesto" : var_imp,
									"fechainicio" : var_feci,
									"fechafin" : var_fecf,
									"estado" : var_estc
								};

								$
										.ajax({	
											url : 'agregarSeleccion',
											type : 'POST',
											dataType : 'json',
											data : jsonParam,
											success : function(data) {
												console.log(data);
												if (data != null) {
													$
															.each(
																	data,
																	function(
																			index,
																			item) {
																		$(
																				'#id_table_contrato_body')
																				.append(
																						"<tr><td>"
																								+ item.idServicio
																								+ "</td><td>"
																								+ item.descripcionServicio
																								+ "</td><td>"
																								+ item.costoServicio
																								+ "</td><td>"
																								+ item.impuesto
																								+ "</td><td>"
																								+ item.fechainicio
																								+ "</td><td>"
																								+ item.fechafin
																								+ "</td><td>"
																								+ item.estado
																								+ "</td><td>"
																								+ item.totalParcial
																								+ "</td><td><button type='button' onclick='f_elimina_seleccion("
																								+ item.idServicio
																								+ ");' class='btn btn-default' aria-label='Left Align' ><span class='glyphicon glyphicon-remove' aria-hidden='true'></span></button></td></tr>");
																	});

												} else
													swal(
															"Error al agregar la selección del producto",
															"", "error");
												return false;
											},
											error : function(jqXhr) {
												swal("Error en la conexión",
														"", "error");
											}
										});
								//limpia las cajas de texto
								$("#id_servicio_id").val("-1");
								$("#id_servicio_impuesto").val("");
								$("#id_servicio_fecinicio").val("");
								$("#id_servicio_fecfin").val("");
								$("#id_estado").val(" ");
							}
						});

		//Al pulsar el botón registrar
		$("#id_btnRegistrar").click(function() {
			var var_cli = $("#id_cliente_id").val();
			var var_nom = $("#id_cliente_nombre").val();
			var var_cor = $("#id_cliente_correo").val();
			var var_tel = $("#id_cliente_telefono").val();
			var var_doc = $("#id_cliente_documento").val();
			var var_ndc = $("#id_cliente_numdocumento").val();
			var var_est = $("#id_cliente_estado").val();

			var var_count = 0;
			$("#id_table_contrato_body tr").each(function() {
				var_count = var_count + 1;
			});

			if (var_cli == "-1") {
				$("#idMensajeTexto").text("Seleccione un cliente");
				$("#idMensaje").modal("show");
			} else if (var_count < 1) {
				$("#idMensajeTexto").text("Seleccione un servicio");
				$("#idMensaje").modal("show");
			} else {
				var jsonParam = {
					"idCliente" : var_cli
				};
				$.ajax({
					url : 'registraContrato',
					type : 'POST',
					dataType : 'json',
					data : jsonParam,
					success : function(data) {
						if (data.texto != "-1") {
							console.log(data.texto);
							$("#idMensajeTexto").html(data.texto);
							$("#idMensaje").modal("show");
							$("#id_table_contrato_body").empty();
							$("#id_cliente_id").val("-1");
							$("#id_cliente_nombre").val("");
							$("#id_cliente_correo").val("");
							$("#id_cliente_telefono").val("");
							$("#id_cliente_documento").val("");
							$("#id_cliente_numdocumento").val("");
							$("#id_cliente_estado").val("");
						} else
							swal("Error al agregar el contrato", "", "error");
						return false;
					},
					error : function(jqXhr) {
						swal("Error en la conexión", "", "error");
					}
				});
			}
		});

		//Al pulsar el botón eliminar
		function f_elimina_seleccion(id) {
			//limpiar la tabla
			$("#id_table_contrato_body").empty();

			//Se añade los clientes a la tabla
			$
					.getJSON(
							"eliminaSeleccion",
							{
								"idServicio" : id
							},
							function(data) {
								$
										.each(
												data,
												function(index, item) {
													$('#id_table_contrato_body')
															.append(
																	"<tr><td>"
																			+ item.idServicio
																			+ "</td><td>"
																			+ item.descripcionServicio
																			+ "</td><td>"
																			+ item.costoServicio
																			+ "</td><td>"
																			+ item.impuesto
																			+ "</td><td>"
																			+ item.fechainicio
																			+ "</td><td>"
																			+ item.fechafin
																			+ "</td><td>"
																			+ item.estado
																			+ "</td><td>"
																			+ item.totalParcial
																			+ "</td><td><button type='button' onclick='f_elimina_seleccion("
																			+ item.idServicio
																			+ ");' class='btn btn-default' aria-label='Left Align' ><span class='glyphicon glyphicon-remove' aria-hidden='true'></span></button></td><tr>");
												});
							});

			//limpia las cajas de texto
			$("#id_servicio_id").val("-1");
			$("#id_servicio_impuesto").val("");
			$("#id_servicio_fecinicio").val("");
			$("#id_servicio_fecfin").val("");
			$("#id_estado").val(" ");
		}
	</script>
</body>
</html>