<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<jsp:include page="intranetValida.jsp" />

<!DOCTYPE html>
<html lang="esS">
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

    <link rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet" href="css/bootstrapValidator.css"/>

    <title>Intranet</title>
</head>
<body>

    <jsp:include page="intranetCabecera.jsp" />

    <div class="container" style="margin-top: 5%">
        <h3>Intranet Linertec</h3>
        <br><br>
        <h4>Bienvenido Sr(a): ${sessionScope.objUsuario.nombreCompleto}</h4><br>                
        <h4>DNI: ${sessionScope.objUsuario.dni}</h4><br>
        <h4>Roles:</h4>
        <ul class="list-group">
            <c:forEach var="x" items="${sessionScope.objRoles}">
                <li class="list-group-item">${x.nombre}</li>
            </c:forEach>
        </ul><br>
    </div>

    <div class="container">
        <div class="row">
            <div class="col-md-12 text-center" style="height: 150px"> 
                <!-- Contenido del div -->
            </div>
        </div>
    </div>

</body>
</html>
