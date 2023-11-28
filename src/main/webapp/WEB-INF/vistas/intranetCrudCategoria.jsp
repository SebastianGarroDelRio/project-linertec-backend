<jsp:include page="intranetValida.jsp" />
<!DOCTYPE html>
<html lang="esS" >
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
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

<link rel="stylesheet" href="css/bootstrap.css"/>
<link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
<link rel="stylesheet" href="css/bootstrapValidator.css"/>

<title>Categoria</title>
</head>
<body>
	<jsp:include page="intranetCabecera.jsp" />
	<div class="container text-center" style="margin-top: 4%">
		<h3> CRUD DE CATEGORIA</h3>
	</div>

<div class="container" style="margin-top: 1%">
    <div class="panel-group" id="accordion">
        <!-- Panel con todo el contenido -->
        <div class="panel panel-default">
            <div class="panel-heading" style="background-color: #0063AE;">
                <h4 class="panel-title">
                    <a  data-parent="#accordion" href="#collapseAll" style="color: white;">CATEGORIA</a>
                </h4>
            </div>
            <div id="collapseAll" class="panel-collapse collapse in">
                <div class="panel-body">
                    <!-- Contenido de FILTRAR -->
                    <div class="row" style="height: 70px">
                        <div class="col-md-2">
                            <input class="form-control" id="id_txt_filtro" name="filtro"
                                placeholder="Ingrese el Categoria" type="text" maxlength="30" />
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-primary" id="id_btn_filtrar"
                                style="width: 150px">FILTRAR</button>
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
                                            <th style="width: 85%">Descripcion</th>
                                            <th style="width: 5%">Actualizar</th>
                                            <th style="width: 50%">Eliminar</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!-- Aquí puedes agregar filas si es necesario -->
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
                <hr> <!-- Línea divisoria entre secciones -->

                
<!-- Contenido de REGISTRAR -->
<div class="modal fade" id="id_div_modal_registra">
    <div class="modal-dialog" style="width: 60%">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="padding: 35px 50px">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4>
                    <span class="glyphicon glyphicon-ok-sign"></span> REGISTRO DE CATEGORIA
                </h4>
            </div>
            <div class="modal-body" style="padding: 20px 10px;">
                <form id="id_form_registra" accept-charset="UTF-8" class="form-horizontal" method="post">
                    <div class="panel-group" id="steps">
                        <!-- Step 1 -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos de la Categoria</a>
                                </h4>
                            </div>
                            <div id="stepOne" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_reg_descripcion">Descripcion</label>
                                        <div class="col-lg-8">
                                            <input class="form-control" id="id_reg_descripcion" name="descripcionCategoria" placeholder="Ingrese la descripcion" type="text" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-9 col-lg-offset-3">
                                            <button type="button" class="btn btn-primary" id="id_btn_registra">REGISTRAR</button>
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

<hr> <!-- Línea divisoria entre secciones -->

<!-- Contenido de ACTUALIZAR -->
<div class="modal fade" id="id_div_modal_actualiza">
    <div class="modal-dialog" style="width: 60%">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header" style="padding: 35px 50px">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4>
                    <span class="glyphicon glyphicon-ok-sign"></span> ACTUALIZAR CATEGORIA
                </h4>
            </div>
            <div class="modal-body" style="padding: 20px 10px;">
                <form id="id_form_actualiza" accept-charset="UTF-8" class="form-horizontal" method="post">
                    <div class="panel-group" id="steps">
                        <!-- Step 1 -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#steps" href="#stepOne">Datos de la Categoria</a>
                                </h4>
                            </div>
                            <div id="stepOne" class="panel-collapse collapse in">
                                <div class="panel-body">
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_ID">Codigo</label>
                                        <div class="col-lg-8">
                                            <input class="form-control" id="id_ID" readonly="readonly" name="idCategoria" type="text" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-lg-3 control-label" for="id_act_descripcion">Descripcion</label>
                                        <div class="col-lg-8">
                                            <input class="form-control" id="id_act_descripcion" name="descripcionCategoria" placeholder="Ingrese la descripcion" type="text" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-lg-9 col-lg-offset-3">
                                            <button type="button" class="btn btn-primary" id="id_btn_actualiza">ACTUALIZAR</button>
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
		<!-- FIN ACTUALIZAR -->



	<script type="text/javascript">
	<!-- Agregar aquí -->
	
	$("#id_txt_filtro").keyup(function(){
	    var fil = $(this).val(); // Obtener el valor del campo de texto
	    $.getJSON("consultaCrudCategoria", {"filtro": fil}, function (lista){
	        agregarGrilla(lista); // Agregar la lista a la grilla
	    });
	});
	
	$(document).ready(function(){
	    var fil = $("#id_txt_filtro").val(); // Obtener el valor inicial del campo de texto
	    $.getJSON("consultaCrudCategoria", {"filtro": fil}, function (lista){
	        agregarGrilla(lista); // Agregar la lista a la grilla
	    });
	 });	
	
	$("#id_btn_filtrar").click(function(){
		var fil=$("#id_txt_filtro").val();
		$.getJSON("consultaCrudCategoria",{"filtro":fil}, function (lista){
			agregarGrilla(lista);
		});
	});
	
	function agregarGrilla(lista){
		 $('#id_table').DataTable().clear();
		 $('#id_table').DataTable().destroy();
		 $('#id_table').DataTable({
				data: lista,
				searching: false,
				ordering: true,
				processing: true,
				pageLength: 10,
				lengthChange: false,
				columns:[
					{data: "idCategoria"},
					{data: "descripcionCategoria"},
					{data: function(row, type, val, meta){
						var salida='<button type="button" style="width: 90px" class="btn btn-info btn-sm" onclick="editar(\''+row.idCategoria + '\',\'' + row.descripcionCategoria + '\')">Editar</button>';
						return salida;
					},className:'text-center'},	
					{data: function(row, type, val, meta){
					    var salida='<button type="button" style="width: 90px" class="btn btn-warning btn-sm" onclick="accionEliminar(\'' + row.idCategoria + '\')">'+ (row.estado == 1? 'Activo':'Inactivo') +  '</button>';
						return salida;
					},className:'text-center'},													
				]                                     
		    }); 
	}
	
	
	$("#id_btn_registra").click(function(){
		var validator = $('#id_form_registra').data('bootstrapValidator');
	    validator.validate();
	    if (validator.isValid()) {
	        $.ajax({
	          type: "POST",
	          url: "registraCrudCategoria", 
	          data: $('#id_form_registra').serialize(),
	          success: function(data){
	        	  agregarGrilla(data.lista);
	        	  $('#id_div_modal_registra').modal("hide");
	        	  mostrarMensaje(data.mensaje);
	        	  limpiarFormulario();
	        	  validator.resetForm();
	          },
	          error: function(){
	        	  mostrarMensaje(MSG_ERROR);
	          }
	        });
	    }
	});
	
	//validacion de registrar
	$('#id_form_registra').bootstrapValidator({
	    message: 'This value is not valid',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	    	"descripcionCategoria": {
	    		selector : '#id_reg_descripcion',
	            validators: {
	                notEmpty: {
	                    message: 'La decripción es un campo obligatorio'
	                },
	            }
	        },
	    }   
	});
	
	$("#id_btn_actualiza").click(function(){
		var validator = $('#id_form_actualiza').data('bootstrapValidator');
	    validator.validate();
	    if (validator.isValid()) {
	        $.ajax({
	          type: "POST",
	          url: "actualizaCrudCategoria", 
	          data: $('#id_form_actualiza').serialize(),
	          success: function(data){
	        	  agregarGrilla(data.lista);
	        	  $('#id_div_modal_actualiza').modal("hide");
	        	  mostrarMensaje(data.mensaje);
	          },
	          error: function(){
	        	  mostrarMensaje(MSG_ERROR);
	          }
	        });
	    }
	});

	//validacion de actualizar
	$('#id_form_actualiza').bootstrapValidator({
		message: 'This value is not valid',
	    feedbackIcons: {
	        valid: 'glyphicon glyphicon-ok',
	        invalid: 'glyphicon glyphicon-remove',
	        validating: 'glyphicon glyphicon-refresh'
	    },
	    fields: {
	    	"descripcionCategoria": {
	    		selector : '#id_act_descripcion',
	            validators: {
	                notEmpty: {
	                    message: 'La decripción es un campo obligatorio'
	                },
	            }
	        },
	    }   
	});
	
	function editar(idCategoria,descripcionCategoria){	
		$('#id_ID').val(idCategoria);
		$('#id_act_descripcion').val(descripcionCategoria);
		$('#id_div_modal_actualiza').modal("show");
	}
	
	function accionEliminar(id){	
	    $.ajax({
	          type: "POST",
	          url: "eliminaCrudCategoria", 
	          data: {"id":id},
	          success: function(data){
	        	  agregarGrilla(data.lista);
	          },
	          error: function(){
	        	  mostrarMensaje(MSG_ERROR);
	          }
	     });
	}
	
	function limpiarFormulario(){	
		$('#id_reg_descripcion').val('');
	}
	
	</script>
</body>
</html>