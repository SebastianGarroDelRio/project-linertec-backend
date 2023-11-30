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


<title>Usuario</title>

</head>
<body>
	<jsp:include page="intranetCabecera.jsp" />
	<div class="container text-center" style="margin-top: 4%">
		<h3>CRUD DE USUARIO</h3>
		<span> <i class="bi bi-people-fill"></i>
		</span>

	</div>

	<div class="container" style="margin-top: 1%">
		<div class="panel-group" id="accordion">
			<!-- Panel con todo el contenido -->
			<div class="panel panel-default">
				<div class="panel-heading" style="background-color: #0063AE;">
					<h4 class="panel-title">
						<a data-parent="#accordion" href="#collapseAll"
							style="color: white;">USUARIO</a>
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
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="content">
									<table id="id_table" class="table table-striped table-bordered">
										<thead>
											<tr>
												<th style="width: 5%">Código</th>
												<th style="width: 20%">Nombres</th>
												<th style="width: 20%">Apellidos</th>
												<th style="width: 20%">DNI</th>
												<th style="width: 25%">Correo</th>
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
										Usuario
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
															href="#stepOne">Datos de Usuario</a>
													</h4>
												</div>
												<div id="stepOne" class="panel-collapse collapse in">
													<div class="panel-body">

														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_reg_nombre">Nombre</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_nombre"
																	name="nombres" placeholder="Ingrese el nombre"
																	type="text" />
															</div>
														</div>

														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_reg_apellido">Apellido</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_apellido"
																	name="apellidos" placeholder="Ingrese el apellido"
																	type="text" />
															</div>
														</div>

														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_reg_dni">DNI</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_dni" name="dni"
																	placeholder="Ingrese el dni" type="text" />
															</div>
														</div>

														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_reg_login">Username</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_login"
																	name="login" placeholder="Ingrese el Username"
																	type="text" />
															</div>
														</div>

														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_reg_password">Password</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_password"
																	name="password" placeholder="Ingrese el Password"
																	type="password" />
															</div>
														</div>

														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_reg_correo">Correo</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_reg_correo"
																	name="correo" placeholder="Ingrese el correo"
																	type="email" />
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
																for="id_reg_fecha_nacimiento">Fecha Nacimiento</label>
															<div class="col-lg-3">
																<input class="form-control" id="id_reg_fecha_nacimiento"
																	name="fechaNacimiento" type="date" />
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
										Usuario
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
															href="#stepOne">Datos de Usuario</a>
													</h4>
												</div>
												<div id="stepOne" class="panel-collapse collapse in">
													<div class="panel-body">
														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_ID">Código</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_ID"
																	readonly="readonly" name="idUsuario" type="text" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_act_nombre">Nombre</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_act_nombre"
																	name="nombres" placeholder="Ingrese el nombre"
																	type="text" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_act_apellido">Apellido</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_act_apellido"
																	name="apellidos" placeholder="Ingrese el nombre"
																	type="text" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_act_dni">DNI</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_act_dni" name="dni"
																	placeholder="Ingrese el dni" type="text" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_act_login">Username</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_act_login"
																	name="login" placeholder="Ingrese el Username"
																	type="text" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_act_password">Password</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_act_password"
																	name="password" placeholder="Ingrese el Password"
																	type="password" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label" for="id_act_correo">Correo</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_act_correo"
																	name="correo" placeholder="Ingrese el correo"
																	type="email" />
															</div>
														</div>
														<div class="form-group">
															<label class="col-lg-3 control-label"
																for="id_act_direccion">Direccion</label>
															<div class="col-lg-8">
																<input class="form-control" id="id_act_direccion"
																	name="direccion" placeholder="Ingrese el direccion"
																	type="text" />
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
				</div>
			</div>
		</div>
		<!-- FIN ACTUALIZAR -->

	</div>



	<script type="text/javascript">
	<!-- Agregar aquí -->
		$("#id_txt_filtro").keyup(function() {
			var fil = $(this).val(); // Obtener el valor del campo de texto
			$.getJSON("consultaCrudUsuario", {
				"filtro" : fil
			}, function(lista) {
				agregarGrilla(lista); // Agregar la lista a la grilla
			});
		});

		$(document).ready(function() {
			var fil = $("#id_txt_filtro").val(); // Obtener el valor inicial del campo de texto
			$.getJSON("consultaCrudUsuario", {
				"filtro" : fil
			}, function(lista) {
				agregarGrilla(lista); // Agregar la lista a la grilla
			});
		});

		$("#id_btn_filtrar").click(function() {
			var fil = $("#id_txt_filtro").val();
			$.getJSON("consultaCrudUsuario", {
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
								pageLength : 5,
								lengthChange : false,
								columns : [
										{
											data : "idUsuario"
										},
										{
											data : "nombres"
										},
										{
											data : "apellidos"
										},
										{
											data : "dni"
										},
										{
											data : "correo"
										},
										{
											data : function(row, type, val,
													meta) {
												var salida = '<button type="button" style="width: 90px" class="btn btn-info btn-sm" onclick="editar(\''
														+ row.idUsuario
														+ '\',\''
														+ row.nombres
														+ '\',\''
														+ row.apellidos
														+ '\',\''
														+ row.dni
														+ '\',\''
														+ row.login
														+ '\',\''
														+ row.password
														+ '\',\''
														+ row.correo
														+ '\',\''
														+ row.direccion
														+ '\',\''
														+ row.fechaNacimiento
														+ '\')">Editar</button>';
												return salida;
											},
											className : 'text-center'
										},
										{
											data : function(row, type, val,
													meta) {
												var salida = '<button type="button" style="width: 90px" class="btn btn-warning btn-sm" onclick="accionEliminar(\''
														+ row.idCategoria
														+ '\')">'
														+ (row.estado == 1 ? 'Activo'
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
					url : "registraCrudUsuario",
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
								"nombres" : {
									selector : '#id_reg_nombre',
									validators : {
										notEmpty : {
											message : 'El nombre es un campo obligatorio'
										},
									}
								},
								"apellidos" : {
									selector : '#id_reg_apellidos',
									validators : {
										notEmpty : {
											message : 'El apellido es un campo obligatorio'
										},
									}
								},
								"dni" : {
									selector : '#id_reg_dni',
									validators : {
										notEmpty : {
											message : 'El dni es un campo obligatorio'
										},
									}
								},
								"login" : {
									selector : '#id_reg_login',
									validators : {
										notEmpty : {
											message : 'El login es un campo obligatorio'
										},
									}
								},
								"password" : {
									selector : '#id_reg_password',
									validators : {
										notEmpty : {
											message : 'El password es un campo obligatorio'
										},
									}
								},
								"correo" : {
									selector : '#id_reg_correo',
									validators : {
										notEmpty : {
											message : 'El correo contacto es un campo obligatorio'
										},
									}
								},
								"direccion" : {
									selector : '#id_reg_direccion',
									validators : {
										notEmpty : {
											message : 'La direccion contacto es un campo obligatorio'
										},
									}
								},
								"fechaNacimiento" : {
									selector : '#id_reg_fecha_nacimiento',
									validators : {
										notEmpty : {
											message : 'La Fecha Nacimiento un campo obligatorio'
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
					url : "actualizaCrudUsuario",
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
								"nombres" : {
									selector : '#id_act_nombre',
									validators : {
										notEmpty : {
											message : 'El nombre es un campo obligatorio'
										},
									}
								},
								"apellidos" : {
									selector : '#id_act_apellido',
									validators : {
										notEmpty : {
											message : 'El apellido es un campo obligatorio'
										},
									}
								},
								"dni" : {
									selector : '#id_act_dni',
									validators : {
										notEmpty : {
											message : 'El dni es un campo obligatorio'
										},
									}
								},
								"login" : {
									selector : '#id_act_login',
									validators : {
										notEmpty : {
											message : 'El login es un campo obligatorio'
										},
									}
								},
								"password" : {
									selector : '#id_act_password',
									validators : {
										notEmpty : {
											message : 'El password es un campo obligatorio'
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
								"direccion" : {
									selector : '#id_act_direccion',
									validators : {
										notEmpty : {
											message : 'El direccion Contacto es un campo obligatorio'
										},
									}
								},
								"tipo_documento" : {
									selector : '#id_act_fecha_nacimiento',
									validators : {
										notEmpty : {
											message : 'La fecha nacimiento un campo obligatorio'
										},
									}
								},
							}
						});

		function editar(idUsuario, nombres, apellidos, dni, login, password, correo,
				direccion, fechaNacimiento) {
			$('#id_ID').val(idUsuario);
			$('#id_act_nombre').val(nombres);
			$('#id_act_apellido').val(apellidos);
			$('#id_act_dni').val(dni);
			$('#id_act_login').val(login);
			$('#id_act_password').val(password);
			$('#id_act_correo').val(correo);
			$('#id_act_direccion').val(direccion);
			$('#id_act_fecha_nacimiento').val(fechaNacimiento);
			$('#id_div_modal_actualiza').modal("show");
		}

		function accionEliminar(id) {
			$.ajax({
				type : "POST",
				url : "eliminaCrudUsuario",
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
			$('#id_reg_apellido').val('');
			$('#id_reg_dni').val('');
			$('#id_reg_login').val('');
			$('#id_reg_password').val('');
			$('#id_reg_correo').val('');
			$('#id_reg_direccion').val('');
			$('#id_reg_fecha_nacimiento').val('');
		}
	</script>
</body>
</html>