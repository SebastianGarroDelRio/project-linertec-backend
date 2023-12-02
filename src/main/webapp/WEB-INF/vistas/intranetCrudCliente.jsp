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

<title>Cliente</title>

</head>
<body>
	<jsp:include page="intranetCabecera.jsp" />
	<div class="container text-center" style="margin-top: 4%">
		<h3>CRUD DE CLIENTE</h3>
	</div>

	<div class="container" style="margin-top: 1%">
		<div class="panel-group" id="accordion">
			<!-- Panel con todo el contenido -->
			<div class="panel panel-default">
				<div class="panel-heading" style="background-color: #0063AE;">
					<h4 class="panel-title">
						<a data-parent="#accordion" href="#collapseAll"
							style="color: white;">CLIENTE</a>
					</h4>
				</div>
				<div id="collapseAll" class="panel-collapse collapse in">
					<div class="panel-body">
						<div class="row" style="height: 70px">
							<div class="col-md-2">
								<input class="form-control" id="id_txt_filtro" name="filtro"
									placeholder="Ingrese el nombre" type="text" maxlength="30" />
							</div>
							<div class="col-md-2">
								<button type="button" class="btn btn-primary"
									id="id_btn_filtrar" style="width: 150px">FILTRAR</button>
							</div>
							<div class="col-md-2">
								<button type="button" data-toggle='modal'
									data-target="#id_div_modal_registra" class='btn btn-success'
									style="width: 150px">REGISTRAR</button>
							</div>

							<div class="col-md-2">
								<button type="button" class="btn btn-danger" id="id_btn_reporte"
									style="width: 150px">
									<span class="mdi mdi-download" style="font-size: 15px">PDF</span>
								</button>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="content">
									<table id="id_table" class="table table-striped table-bordered">
										<thead>
											<tr>
												<th style="width: 5%">C�digo</th>
												<th style="width: 10%">Nombre</th>
												<th style="width: 10%">Correo</th>
												<th style="width: 10%">Tipo Documento</th>
												<th style="width: 10%">Numero documento</th>
												<th style="width: 5%">Actualizar</th>
												<th style="width: 5%">Eliminar</th>
											</tr>
										</thead>
										<tbody>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>

					<!-- INICIO REGISTRAR-->
					<div class="modal fade" id="id_div_modal_registra">
						<div class="modal-dialog" style="width: 60%">

							<!-- Modal content-->
							<div class="modal-content">
								<div class="modal-header" style="padding: 35px 50px">
									<button type="button" class="close" data-dismiss="modal">&times;</button>
									<h4>
										<span class="glyphicon glyphicon-ok-sign"></span> Registro de
										Cliente
									</h4>
								</div>
								<div class="modal-body" style="padding: 20px 10px;">
									<form id="id_form_registra" accept-charset="UTF-8"
										class="form-horizontal" method="post">
										<div class="panel-group" id="steps">
											<!-- Step 1 -->
											<div class="panel panel-default">
												<div class="panel-heading">
													<h4 class="panel-title">
														<a data-toggle="collapse" data-parent="#steps"
															href="#stepOne">Datos de Cliente</a>
													</h4>
												</div>
												<div id="stepOne" class="panel-collapse collapse in">
													<div class="panel-body">
														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_reg_nombre">Cliente</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_nombre"
																	name="nombreCliente" placeholder="Ingrese el nombre"
																	type="text" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_reg_correo">Correo
																electr�nico</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_correo"
																	name="correo" placeholder="Ingrese el correo"
																	type="email" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_reg_telefono">Tel�fono</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_telefono"
																	name="telefono" placeholder="Ingrese el telefono"
																	type="number" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_reg_direccion">Direccion</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_direccion"
																	name="direccion" placeholder="Ingrese el direccion"
																	type="text" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_reg_contacto">Nombre Contacto</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_contacto"
																	name="nombreContacto" placeholder="Ingrese el Contacto"
																	type="text" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_reg_telefono_contacto">Telefono Contacto</label>
															<div class="col-lg-8">
																<input class="form-control"
																	id="id_reg_telefono_contacto" name="telefonoContacto"
																	placeholder="Ingrese Numero del Contacto" type="number" />
															</div>
														</div>

														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_reg_fecha_nacimiento">Fecha Nacimiento</label>
															<div class="col-lg-3">
																<input class="form-control" id="id_reg_fecha_nacimiento"
																	name="fechaNacimiento" type="date" />
															</div>
														</div>

														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_reg_tipo_documento">Tipo Documento</label>
															<div class="col-lg-6">
																<select id="id_reg_tipo_documento" name="tipoDocumento"
																	class='form-control'>
																	<option value=" ">[Seleccione]</option>
																</select>
															</div>
														</div>

														<div class="form-group">
															<div class="col-lg-9 col-lg-offset-3">
																<button type="button" class="btn btn-primary"
																	id="id_btn_registra">REGISTRA</button>
															</div>
														</div>
													</div>
												</div>
											</div>

										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- FIN REGISTRAR -->

		<!-- INICIO ACTUALIZAR -->
		<div class="modal fade" id="id_div_modal_actualiza">
			<div class="modal-dialog" style="width: 60%">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="padding: 35px 50px">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4>
							<span class="glyphicon glyphicon-ok-sign"></span> Actualiza
							Cliente
						</h4>
					</div>
					<div class="modal-body" style="padding: 20px 10px;">
						<form id="id_form_actualiza" accept-charset="UTF-8"
							class="form-horizontal" method="post">
							<div class="panel-group" id="steps">
								<!-- Step 1 -->
								<div class="panel panel-default">
									<div class="panel-heading">
										<h4 class="panel-title">
											<a data-toggle="collapse" data-parent="#steps"
												href="#stepOne">Datos de Cliente</a>
										</h4>
									</div>
									<div id="stepOne" class="panel-collapse collapse in">
										<div class="panel-body">
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_ID">C�digo</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_ID" readonly="readonly"
														name="idCliente" type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_act_nombre">Nombre
													Cliente</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_act_nombre"
														name="nombreCliente" placeholder="Ingrese el nombre"
														type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_act_correo">Correo
													Electronico</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_act_correo"
														name="correo" placeholder="Ingrese el apellido"
														type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_act_telefono">Telefono
												</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_act_telefono"
														name="telefono" placeholder="Ingrese el telefono"
														type="number" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_act_direccion">Direccion</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_act_direccion"
														name="direccion" placeholder="Ingrese el DNI" type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label" for="id_act_contacto">Nombre
													Contacto</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_act_contacto"
														name="nombreContacto" placeholder="Ingrese el Contacto"
														type="text" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label"
													for="id_act_telefono_contacto">telefonoContacto</label>
												<div class="col-lg-8">
													<input class="form-control" id="id_act_telefono_contacto"
														name="telefonoContacto"
														placeholder="Ingrese el telefono Contacto" type="number" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label"
													for="id_act_fecha_nacimiento">Fecha Nacimiento</label>
												<div class="col-lg-3">
													<input class="form-control" id="id_act_fecha_nacimiento"
														name="fechaNacimiento" type="date" />
												</div>
											</div>
											<div class="form-group">
												<label class="col-lg-3 control-label"
													for="id_act_tipo_documento">Tipo Documento</label>
												<div class="col-lg-6">
													<select id="id_act_tipo_documento" name="tipoDocumento"
														class='form-control'>
														<option value=" ">[Seleccione]</option>
													</select>
												</div>
											</div>

											<div class="form-group">
												<div class="col-lg-9 col-lg-offset-3">
													<button type="button" class="btn btn-primary"
														id="id_btn_actualiza">ACTUALIZA</button>
												</div>
											</div>
										</div>
									</div>
								</div>

							</div>
						</form>

					</div>
				</div>
			</div>
		</div>
		<!-- FIN ACTUALIZAR -->

	</div>

	<script type="text/javascript">
	<!-- Agregar aqu� -->
		$.getJSON("listaTipoDocumento", {}, function(data) {
			$.each(data, function(i, item) {
				$("#id_reg_tipo_documento").append(
						"<option value="+item.idTipoDocumento +">"
								+ item.nombreDocumento + "</option>");
				$("#id_act_tipo_documento").append(
						"<option value="+item.idTipoDocumento +">"
								+ item.nombreDocumento + "</option>");
			});
		});

		$("#id_txt_filtro").on("input", function() {
			var fil = $(this).val(); // Obtener el valor del campo de texto
			$.getJSON("consultaCrudCliente", {
				"filtro" : fil
			}, function(lista) {
				agregarGrilla(lista); // Agregar la lista a la grilla
			});
		});

		// Esta funci�n se ejecutar� al cargar la p�gina para realizar la primera consulta
		$(document).ready(function() {
			var fil = $("#id_txt_filtro").val(); // Obtener el valor inicial del campo de texto
			$.getJSON("consultaCrudCliente", {
				"filtro" : fil
			}, function(lista) {
				agregarGrilla(lista); // Agregar la lista a la grilla
			});
		});

		$("#id_txt_filtro").on("input", function() {
			var fil = $(this).val(); // Obtener el valor del campo de texto
			$.getJSON("consultaCrudCliente", {
				"filtro" : fil
			}, function(lista) {
				agregarGrilla(lista); // Agregar la lista a la grilla
			});
		});

		// Esta funci�n se ejecutar� al cargar la p�gina para realizar la primera consulta
		$(document).ready(function() {
			var fil = $("#id_txt_filtro").val(); // Obtener el valor inicial del campo de texto
			$.getJSON("consultaCrudCliente", {
				"filtro" : fil
			}, function(lista) {
				agregarGrilla(lista); // Agregar la lista a la grilla
			});
		});

		$("#id_btn_filtrar").click(function() {
			var fil = $("#id_txt_filtro").val();
			$.getJSON("consultaCrudCliente", {
				"filtro" : fil
			}, function(lista) {
				agregarGrilla(lista);
			});
		});

		function agregarGrilla(lista) {
			$('#id_table').DataTable().clear();
			$('#id_table').DataTable().destroy();
			$('#id_table')
					.DataTable(
							{
								data : lista,
								searching : false,
								ordering : true,
								processing : true,
								pageLength : 10,
								lengthChange : false,
								columns : [
										{
											data : "idCliente"
										},
										{
											data : "nombreCliente"
										},
										{
											data : "correo"
										},
										{
											data : "tipoDocumento.nombreDocumento"
										},
										{
											data : "numeroDocumento"
										},
										{
											data : function(row, type, val,
													meta) {
												var salida = '<button type="button" style="width: 90px" class="btn btn-info btn-sm" onclick="editar(\''
														+ row.idCliente
														+ '\',\''
														+ row.nombreCliente
														+ '\',\''
														+ row.correo
														+ '\',\''
														+ row.telefono
														+ '\',\''
														+ row.direccion
														+ '\',\''
														+ row.nombreContacto
														+ '\',\''
														+ row.telefonoContacto
														+ '\',\''
														+ row.tipoDocumento.idTipoDocumento
														+ '\')">Editar</button>';
												return salida;
											},
											className : 'text-center'
										},
										{
											data : function(row, type, val,
													meta) {
												var salida = '<button type="button" style="width: 90px" class="btn btn-warning btn-sm" onclick="accionEliminar(\''
														+ row.idCliente
														+ '\')">'
														+ (row.estado.idestado == 1 ? 'Activo'
																: 'Inactivo')
														+ '</button>';
												return salida;
											},
											className : 'text-center'
										}, ]
							});
		}

		$("#id_btn_registra").click(function() {
			var validator = $('#id_form_registra').data('bootstrapValidator');
			validator.validate();
			if (validator.isValid()) {
				$.ajax({
					type : "POST",
					url : "registraCrudCliente",
					data : $('#id_form_registra').serialize(),
					success : function(data) {
						agregarGrilla(data.lista);
						$('#id_div_modal_registra').modal("hide");
						mostrarMensaje(data.mensaje);
						limpiarFormulario();
						validator.resetForm();
					},
					error : function() {
						mostrarMensaje(MSG_ERROR);
					}
				});
			}
		});

		//validacion de registrar
		$('#id_form_registra')
				.bootstrapValidator(
						{
							message : 'This value is not valid',
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							fields : {
								"nombreCliente" : {
									selector : '#id_reg_nombre',
									validators : {
										notEmpty : {
											message : 'El nombre es un campo obligatorio'
										},
									}
								},
								"correo" : {
									selector : '#id_reg_correo',
									validators : {
										notEmpty : {
											message : 'El correo es un campo obligatorio'
										},
									}
								},
								"telefono" : {
									selector : '#id_reg_telefono',
									validators : {
										notEmpty : {
											message : 'El telefono es un campo obligatorio'
										},
									}
								},
								"direccion" : {
									selector : '#id_reg_direccion',
									validators : {
										notEmpty : {
											message : 'El direccion es un campo obligatorio'
										},
									}
								},
								"nombreContacto" : {
									selector : '#id_reg_contacto',
									validators : {
										notEmpty : {
											message : 'El nombre contacto es un campo obligatorio'
										},
									}
								},
								"telefonoContacto" : {
									selector : '#id_reg_telefono_contacto',
									validators : {
										notEmpty : {
											message : 'El telefono contacto es un campo obligatorio'
										},
									}
								},
								"fechaNacimiento" : {
									selector : '#id_reg_fecha_nacimiento',
									validators : {
										notEmpty : {
											message : 'La Fecha Nacimiento es un campo obligatorio'
										},
									}
								},
								"tipoDocumento.idTipoDocumento" : {
									selector : '#id_reg_tipo_documento',
									validators : {
										notEmpty : {
											message : 'El Tipo Documento un campo obligatorio'
										},
									}
								},
							}
						});

		$("#id_btn_actualiza").click(function() {
			var validator = $('#id_form_actualiza').data('bootstrapValidator');
			validator.validate();
			if (validator.isValid()) {
				$.ajax({
					type : "POST",
					url : "actualizaCrudCliente",
					data : $('#id_form_actualiza').serialize(),
					success : function(data) {
						agregarGrilla(data.lista);
						$('#id_div_modal_actualiza').modal("hide");
						mostrarMensaje(data.mensaje);
					},
					error : function() {
						mostrarMensaje(MSG_ERROR);
					}
				});
			}
		});

		//validacion de actualizar
		$('#id_form_actualiza')
				.bootstrapValidator(
						{
							message : 'This value is not valid',
							feedbackIcons : {
								valid : 'glyphicon glyphicon-ok',
								invalid : 'glyphicon glyphicon-remove',
								validating : 'glyphicon glyphicon-refresh'
							},
							fields : {
								"nombreCliente" : {
									selector : '#id_act_nombre',
									validators : {
										notEmpty : {
											message : 'El nombre Cliente es un campo obligatorio'
										},
									}
								},
								"correo" : {
									selector : '#id_act_correo',
									validators : {
										notEmpty : {
											message : 'El correo es un campo obligatorio'
										},
									}
								},
								"telefono" : {
									selector : '#id_act_telefono',
									validators : {
										notEmpty : {
											message : 'El telefono es un campo obligatorio'
										},
									}
								},
								"direccion" : {
									selector : '#id_act_direccion',
									validators : {
										notEmpty : {
											message : 'El direccion es un campo obligatorio'
										},
									}
								},
								"nombreContacto" : {
									selector : '#id_act_contacto',
									validators : {
										notEmpty : {
											message : 'El nombre Contacto es un campo obligatorio'
										},
									}
								},
								"telefonoContacto" : {
									selector : '#id_act_telefono_contacto',
									validators : {
										notEmpty : {
											message : 'El Telefono Contacto es un campo obligatorio'
										},
									}
								},
								"fechaNacimiento" : {
									selector : '#id_act_fecha_nacimiento',
									validators : {
										notEmpty : {
											message : 'La Fecha de Nacimiento es un campo obligatorio'
										},
									}
								},
								"tipo_documento" : {
									selector : '#id_act_tipo_documento',
									validators : {
										notEmpty : {
											message : 'El Tipo Documento un campo obligatorio'
										},
									}
								},
							}
						});

		function editar(idCliente, nombreCliente, correo, telefono, direccion,
				nombreContacto, telefonoContacto, idTipoDocumento, idestado) {
			$('#id_ID').val(idCliente);
			$('#id_act_nombre').val(nombreCliente);
			$('#id_act_correo').val(correo);
			$('#id_act_telefono').val(telefono);
			$('#id_act_direccion').val(direccion);
			$('#id_act_contacto').val(nombreContacto);
			$('#id_act_telefono_contacto').val(telefonoContacto);
			$('#id_act_tipo_documento').val(idTipoDocumento);
			$('#id_div_modal_actualiza').modal("show");
		}

		function accionEliminar(id) {
			$.ajax({
				type : "POST",
				url : "eliminaCrudCliente",
				data : {
					"id" : id
				},
				success : function(data) {
					agregarGrilla(data.lista);
				},
				error : function() {
					mostrarMensaje(MSG_ERROR);
				}
			});
		}

		function limpiarFormulario() {
			$('#id_reg_nombre').val('');
			$('#id_reg_correo').val('');
			$('#id_reg_telefono').val('');
			$('#id_reg_direccion').val('');
			$('#id_reg_contacto').val('');
			$('#id_reg_telefono_contacto').val('');
			$('#id_reg_tipo_documento').val(' ');
		}
	</script>
</body>
</html>