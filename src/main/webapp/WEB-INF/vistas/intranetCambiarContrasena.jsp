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
    <script>
        $(document).ready(function () {
            // Manejar el evento de entrada en los campos de contraseña
            $("#form_pass, #form_repeat_pass").on("input", function () {
                // Obtener los valores de los campos
                var pass = $("#form_pass").val();
                var repeatPass = $("#form_repeat_pass").val();

                // Validar que sean iguales y cumplan con los requisitos
                if (pass === repeatPass && /^[a-zA-Z0-9]{1,15}$/.test(pass)) {
                    // Habilitar el botón si son iguales y cumplen con los requisitos
                    $("#id_btn_guardar").prop("disabled", false);
                    // Ocultar el mensaje de alerta
                    $("#alert_message").hide();
                } else {
                    // Deshabilitar el botón si no cumplen con los requisitos
                    $("#id_btn_guardar").prop("disabled", true);
                    // Mostrar el mensaje de alerta
                    $("#alert_message").show();
                }
            });

            // Limitar la longitud de los campos a 15 caracteres
            $("#form_pass, #form_repeat_pass").attr("maxlength", 15);

            // Asegurarse de que solo se puedan ingresar letras y números
            $("#form_pass, #form_repeat_pass").on("input", function () {
                var value = $(this).val();
                var sanitizedValue = value.replace(/[^a-zA-Z0-9]/g, '');
                $(this).val(sanitizedValue);
            });
        });
    </script>

    <title>Intranet</title>
    <!--<%@ include file="../web/header2.jsp"%> -->
</head>
<body>
<main>

    <div class="contenedor__todo">
        <div class="caja__trasera">
            <div class="caja__trasera-login">
                <h1>Restablecer contrase&ntilde;a</h1>
                <label id="id_texto_enviar">Te hemos enviado un correo electr&oacute;nico.
                    Solo tienes que seguir las instrucciones para restablecer tu contrase&ntilde;a.</label>
                <form method="post" action="password-reset-send-code-validation-changepass" id="id_form">
                    <div class="form-group">
                        <label for="form_pass">Contrase&ntilde;a</label>
                        <input type="text" name="password" placeholder="Contrase&ntilde;a"
                               class="form-username form-control"
                               id="form_pass" maxlength="20">
                    </div>
                    <div class="form-group">
                        <label for="form_repeat_pass">Repetir Contrase&ntilde;a</label>
                        <input type="text" placeholder="Repetir Contrase&ntilde;a" class="form-username form-control"
                               id="form_repeat_pass" maxlength="20">
                    </div>
                    <div id="alert_message" class="alert alert-danger" style="display: none;">Las contraseñas no coinciden o no cumplen con los requisitos.</div>


                    <button type="submit" id="id_btn_guardar">Guardar</button>
                </form>
            </div>

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


    $("#id_btn_guardar").click(function () {

        $.ajax({
            type: "POST",
            url: "password-reset-send-code-validation-changepass",
            data: $('#id_form').serialize(),
            success: function (data) {
                mostrarMensaje(data.MSG);
            },
            error: function () {
                mostrarMensaje(ERROR_MSG);
            }
        });

    });
</script>


</body>
</html>



