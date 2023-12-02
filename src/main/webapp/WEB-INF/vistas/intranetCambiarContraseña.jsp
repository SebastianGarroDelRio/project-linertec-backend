<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Expires" content="-1"/>
    <meta http-equiv="Cache-Control" content="private"/>
    <meta http-equiv="Cache-Control" content="no-store"/>
    <meta http-equiv="Pragma" content="no-cache"/>

    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrapValidator.js"></script>

    <link rel="stylesheet" href="css/form-elements.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/bootstrapValidator.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="css/estilos.css">


    <title>Intranet</title>
    <!--<%@ include file="../web/header2.jsp"%> -->
</head>
<body>
<main>
    <c:if test="${requestScope.mensaje != null}">
        <div class="alert alert-danger fade in" id="success-alert">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            <strong>${requestScope.mensaje}</strong>
        </div>
    </c:if>
    <c:if test="${requestScope.register != null}">
        <div class="success alert-success fade in" id="success-alert">
            <a href="#" class="close" data-dismiss="success">&times;</a>
            <strong>${requestScope.register}</strong>
        </div>
    </c:if>
    <div class="contenedor__todo">
        <div class="caja__trasera">
            <div class="caja__trasera-login">
                <h1>¿Ya tienes una cuenta?</h1>
                <p>Inicia sesion para entrar en la pagina</p>
                <button id="btn__iniciar-sesion">Direcci&oacute;n de correo electr&oacute;nico</button>
            </div>
            <div class="caja__trasera-register">
                <h1>Restablecer contrase&ntilde;a</h1>
                <p>Introduce la direcci&oacute;n de correo que<br> usaste en el registro.
                    Te enviaremos un correo con un codigo para<br> que puedas restablecer tu contrase&ntilde;a.</p>
                <a href="verLogin" class="btn btn-primary btn-lg">Iniciar Sesi&oacute;n </a>
            </div>
        </div>

        <!--Formulario de Login y registro-->
        <div class="contenedor__login-register">
            <!--Login-->
            <form id="id_form" action="enviarCodigoEmail" method="post" class="formulario__login login-form">
                <h1>Direcci&oacute;n de correo electr&oacute;nico</h1>
                <div class="form-group">
                    <label class="sr-only" for="form-username">Email</label>
                    <input type="email" name="email" placeholder="Ingrese correo" class="form-username form-control"
                           id="form-username" maxlength="50" value="luis">
                </div>

                <button type="submit" id="id_btn_enviar">Enviar</button>
            </form>

            <!--Register-->
            <form action="registerUser" method="post" class="formulario__register">
                <div>
                    <h1>Registrarse</h1>
                    <input type="text" name="nombres" placeholder="Nombre completo">
                    <input type="text" name="apellidos" placeholder="Apellidos">
                    <input type="email" name="correo" placeholder="Correo Electronico">
                    <input type="text" name="login" placeholder="Usuario">
                    <input type="password" name="password" placeholder="Contrase&ntilde;a">
                    <button>Registrarse</button>
                </div>
            </form>
        </div>
    </div>

</main>

<script src="js/script.js"></script>

<script type="text/javascript">
    $("#success-alert").fadeTo(1000, 500).slideUp(500, function () {
        $("#success-alert").slideUp(500);
    });
</script>
<script type="text/javascript">
    function mostrarPassword() {
        let pass = document.getElementById('form-password');
        let ocultar = document.getElementById('id_icon_ocultar');
        let ver = document.getElementById('id_icon_ver');
        if (pass.type === 'password') {
            pass.type = 'text';
            ver.style.display = 'none';
            ocultar.style.display = 'block';
        } else {
            pass.type = 'password';
            ver.style.display = 'block';
            ocultar.style.display = 'none';
        }

    }

</script>

<script type="text/javascript">
    $(document).ready(function () {
        $('#id_form').bootstrapValidator({
            message: 'This value is not valid',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                login: {
                    validators: {
                        notEmpty: {
                            message: 'Ingresar su usuario'
                        },
                        stringLength: {
                            message: 'El usuario es de 3 a 20 caracteres',
                            min: 3,
                            max: 20
                        }
                    }
                },
                password: {
                    validators: {
                        notEmpty: {
                            message: 'Ingresar su constrase�a'
                        },
                        stringLength: {
                            message: 'La contrase�a es de 3 a 20 caracteres',
                            min: 3,
                            max: 20
                        }
                    }
                }
            }
        });

        $('#validateBtn').click(function () {
            $('#id_form').bootstrapValidator('validate');
        });
    });
</script>


</body>
</html>



