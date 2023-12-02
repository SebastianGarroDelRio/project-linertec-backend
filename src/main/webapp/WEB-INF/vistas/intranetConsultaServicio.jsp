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

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/@mdi/font@7.3.67/css/materialdesignicons.min.css" />

<title>Intranet</title>
</head>
<body>
	<jsp:include page="intranetCabecera.jsp" />

	<div class="panel panel-default">
		<div class="panel-heading">
			<div class="container text-center" style="margin-top: 4%">
				<h4 class="panel-title">
					<span class="mdi mdi-book-multiple"></span> Consulta Servicio
				</h4>
			</div>
		</div>

		<div class="panel-body">
			<div class="container" style="margin-top: 1%">

				<form id="id_form">
					<div class="row">

						<div class="form-group col-md-3">
							<label class="control-label" for="">Nombre</label>
							<input class="form-control" type="text"
								id="" name="" placeholder="Buscar ...">
						</div>
						
						<div class="form-group col-md-2">
							<label class="control-label" for="id_fechainicio">Fecha
								Inicio</label> <input class="form-control" type="date"
								id="id_fechainicio" name="pmFInicio">
						</div>

						<div class="form-group col-md-2">
							<label class="control-label" for="id_fechafin">Fecha
								Fin</label> <input class="form-control" type="date" id="id_fechafin"
								name="pmFFin">
						</div>

						<div class="form-group col-md-2">
							<label class="control-label" for="id_estado">Estado</label> <select
								class="form-control" id="id_estado" name="pmEstado">
								<option value="-1">[Todos]</option>
							</select>
						</div>

						<div class="form-group col-md-2">
							<button type="button" class="btn btn-primary" id="id_btn_filtrar">
								<span class="mdi mdi-filter">FILTRA</span>
							</button>
							<button type="button" class="btn btn-danger" id="id_btn_filtrar">
								<span class="mdi mdi-filter">PDF</span>
							</button>
						</div>

					</div>

					<!-- INICIO GRILLA -->
					<div class="col-md-12">
						<div class="row" style="margin-top: 2%">
							<table id="id_table" class="table table-striped table-bordered">
								<thead>
									<tr>
										<th style="width: 5%">CÓDIGO</th>
										<th style="width: 10%">FECHA INICIO</th>
										<th style="width: 10%">FECHA FIN</th>
										<th style="width: 15%">CLIENTE</th>
										<th style="width: 15%">CORREO</th>
										<th style="width: 10%">TIPO</th>
										<th style="width: 15%">NUMERO</th>
										<th style="width: 10%">ESTADO</th>
										<th style="width: 10%">VER</th>
									</tr>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
					</div>
					<!-- FIN GRILLA -->
					
				</form>
			</div>

		</div>
		
		
		<!-- Contenido de ACTUALIZAR -->
			<div class="modal fade" id="id_div_modal_actualiza">
				<div class="modal-dialog" style="width: 60%">
					<!-- Modal content-->
					<div class="modal-content">
					
						<div class="modal-header" style="padding: 35px 50px">
							<button type="button" class="close" data-dismiss="modal">&times;</button>
							<h4>
								<span class="glyphicon glyphicon-ok-sign"></span> VER DETALLE
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
													href="#stepOne">Datos de Contrato</a>
											</h4>
										</div>
										<div id="stepOne" class="panel-collapse collapse in">
											<div class="panel-body">
												<div class="form-group">
													<label class="col-lg-3 control-label" for="id_ID">Codigo</label>
													<div class="col-lg-8">
														<input class="form-control" id="id_ID" readonly="readonly"
															name="idContrato" type="text" />
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-lg-3 control-label"
														for="id_act_fechainicio">Fecha Inicio</label>
													<div class="col-lg-8">
														<input class="form-control" id="id_act_fechainicio"
															name="fechainicio" type="date" />
													</div>
												</div>
												
												<div class="form-group">
													<label class="col-lg-3 control-label"
														for="id_act_fechafin">Fecha Fin</label>
													<div class="col-lg-8">
														<input class="form-control" id="id_act_fechafin"
															name="fechafin" type="date" />
													</div>
												</div>

												<div class="form-group">
													<label class="col-lg-3 control-label" for="id_act_estado">Estado</label>
													<div class="col-lg-6">
														<select id="id_act_estado" name="estado"
															class='form-control'>
															<option value=" ">[Seleccione]</option>
														</select>
													</div>
												</div>

												<div class="form-group">
													<div class="col-lg-9 col-lg-offset-3">
														<button type="button" class="btn btn-primary"
															id="id_btn_actualiza">ACTUALIZAR</button>
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
	<!-- FIN ACTUALIZAR -->
		
		
		
		
		
		
		

	<script type="text/javascript">
	<!-- LISTAR COMBO PAIS-->
		function realizarConsulta() {
			var varEstado = $("#id_estado").val().trim();
			var varFInicio = $("#id_fechainicio").val().trim();
			var varFFin = $("#id_fechafin").val().trim();

			$.getJSON("consultaContrato", {
				"idEstadoContrato" : varEstado,
				"fechaInicio" : varFInicio,
				"fechaFin" : varFFin,
			}, function(data) {
				agregarGrilla(data);
			});
		}

		$(document).ready(function() {
			realizarConsulta();
			$("#id_btn_filtrar").click(function() {
				realizarConsulta();
			});
		});

		$.getJSON("listaEstadoContrato", {}, function(data) {
			$.each(data,
					function(i, item) {
						$("#id_estado").append(
								"<option value="+item.idEstadoContrato +">"
										+ item.descripcionEstadoContrato
										+ "</option>");
						
						$("#id_act_estado").append(
								"<option value="+item.idEstadoContrato +">"
										+ item.descripcionEstadoContrato
										+ "</option>");
					});
		});

		$("#id_btn_filtrar").click(function() {
			var varEstado = $("#id_estado").val().trim();
			var varFInicio = $("#id_fechainicio").val().trim();
			var varFFin = $("#id_fechafin").val().trim();

			$.getJSON("consultaContrato", {
				"idEstadoContrato" : varEstado,
				"fechaInicio" : varFInicio,
				"fechaFin" : varFFin,
			}, function(data) {
				agregarGrilla(data);
			});
		});

		function agregarGrilla(lista) {
			$('#id_table').DataTable().clear();
			$('#id_table').DataTable().destroy();
			$('#id_table').DataTable({
				data : lista,
				searching : false,
				ordering : true,
				processing : true,
				pageLength : 5,
				lengthChange : false,
				columns : [ 
					{
						data : "idContrato"
					},
					{
						data : "fechaInicio"
					},
					{
						data : "fechaFin"
					},
					{
						data : "cliente.nombreCliente"
					},
					{
						data : "cliente.correo"
					},
					{
						data : "cliente.tipoDocumento.nombreDocumento"
					},
					{
						data : "cliente.numeroDocumento"
					},
					{
						data : "estadoContrato.descripcionEstadoContrato"
					},
					{
						data : function(row, type, val,
								meta) {
							var salida = '<button type="button" style="font-size: 20px" class="btn btn-info btn-sm  mdi mdi-eye" onclick="editar(\''
									+ row.idContrato
									+ '\',\''
									+ row.fechaInicio
									+ '\',\''
									+ row.fechaFin
									+ '\',\''
									+ row.estadoContrato.idEstadoContrato
									+ '\')"></button>';
									
							salida += '&nbsp;'; // Agrega un espacio en blanco entre los botones

							salida += '<button type="button" class="btn btn-danger btn-sm  mdi mdi-file-download-outline" style="font-size: 20px" onClick="eliminacionFisica(\''
								+ row.idContrato
								+ '\');" ></button>';
									
							return salida;
						},
						className : 'text-center'
					}, ]
			});
		}
		
		
		function editar(idContrato, fechaInicio, fechaFin, idEstadoContrato) {
			$('#id_ID').val(idContrato);
			$('#id_act_fechainicio').val(fechaInicio);
			$('#id_act_fechafin').val(fechaFin);
			$('#id_act_estado').val(idEstadoContrato);
			$('#id_div_modal_actualiza').modal("show");
		}
		
		
	</script>
</body>
</html>