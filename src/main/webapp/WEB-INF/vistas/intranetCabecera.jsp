<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<div class="container">
 <div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
    </div>
    
    <div class="collapse navbar-collapse">
    <ul class="nav navbar-nav navbar-left">
       	<li><a href="verIntranetHome">Home</a></li>
    </ul>
    
    <ul class="nav navbar-nav">
    	<c:if test="${ !empty sessionScope.objMenusTipo1}">
	    	<li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		           Inventario<b class="caret"></b>
		        </a>
		        <ul class="dropdown-menu">
		        	<c:forEach var="x" items="${sessionScope.objMenusTipo1}">
						<li>
		        			<a href="${x.ruta}"> ${x.nombre} </a>
		        		</li>
		        	</c:forEach>
		        </ul>
	     	</li>
     	</c:if>
     	
     	<c:if test="${ !empty sessionScope.objMenusTipo3}">
	    	<li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		           Servicios<b class="caret"></b>
		        </a>
		        <ul class="dropdown-menu">
		        	<c:forEach var="x" items="${sessionScope.objMenusTipo3}">
						<li>
		        			<a href="${x.ruta}"> ${x.nombre} </a>
		        		</li>
		        	</c:forEach>
		        </ul>
	     	</li>
     	</c:if>
     	
      	<c:if test="${ !empty sessionScope.objMenusTipo2}">
	    	<li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		           Ventas<b class="caret"></b>
		        </a>
		        <ul class="dropdown-menu">
		        	<c:forEach var="x" items="${sessionScope.objMenusTipo2}">
						<li>
		        			<a href="${x.ruta}"> ${x.nombre} </a>
		        		</li>
		        	</c:forEach>
		        </ul>
	     	</li>
     	</c:if>    	
     	
     	<c:if test="${ !empty sessionScope.objMenusTipo4}">
	    	<li class="dropdown">
		        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
		          Administracion<b class="caret"></b>
		        </a>
		        <ul class="dropdown-menu">
		        	<c:forEach var="x" items="${sessionScope.objMenusTipo4}">
						<li>
		        			<a href="${x.ruta}"> ${x.nombre} </a>
		        		</li>
		        	</c:forEach>
		        </ul>
	     	</li>
     	</c:if>
     	
     </ul>
      
     <ul class="nav navbar-nav navbar-right">
       	<li><a href="logout">Salir</a></li>
     </ul>
      
    </div>
  </div>
</div>  
</div>