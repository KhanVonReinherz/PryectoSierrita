<%
    HttpSession sesionOK = request.getSession();
%>

<ul id="gn-menu" class="gn-menu-main">
    <li class="gn-trigger">
        <a  class="gn-icon gn-icon-menu"><span>Menu</span></a>
        <nav class="gn-menu-wrapper">
            <div class="gn-scroller">
                <ul class="gn-menu">
                    <li>
                        <a class="gn-icon gn-icon-download">Conócenos</a>
                        <ul class="gn-submenu">
                            <li><a class="gn-icon gn-icon-illustrator" href="MisionVision.jsp">Misión y Visión</a></li>
                        </ul>
                    </li>
                    <%
                        if (sesionOK.getAttribute("gerente") != null || sesionOK.getAttribute("empleado") != null) {

                    %>
                    <li>
                        <a class="gn-icon gn-icon-download" href="mantenimientoProducto.jsp">Mantenimiento</a>
                    </li>

                    <%                                    }
                    %>
                    <%
                        if (sesionOK.getAttribute("gerente") != null) {
                    %>
                    <li>
                        <a class="codrops-icon codrops-icon-drop" href="loginEmpleado.jsp"> <span> Registrar Empleado </span></a>
                    </li>
                    <li>
                        <a class="codrops-icon codrops-icon-drop" href="loginGerente.jsp"> <span> Registrar Gerente </span></a>
                    </li>
                    <%
                        }
                    %>
                    <li><a class="gn-icon gn-icon-help" href="calidadServicio.jsp">Calidad de Servicio</a></li>

                </ul>
            </div>
        </nav>
    </li>
    <li><a href="index.jsp">Menu</a></li>

    


    <%
        if (sesionOK.getAttribute("gerente") != null) {
            System.out.println("Si hay sesion");


    %>
    <li>
        <div id="dd" class="wrapper-dropdown-2" tabindex="1">
            <b class="icon-tutio" href="#">${ sessionScope.gerente.getGerenteNombres()}</b>
            <ul class="dropdown">
                <li><a href="Home.jsp"><i class="icon-twitter icon-large"></i>Reporte Ventas Esperadas</a></li>
                <li><a href="Proyectos.jsp"><i class="icon-twitter icon-large"></i>Reporte de Menu Mensuales</a></li>
                <li><a href="ReservaEsperada.jsp"><i class="icon-twitter icon-large"></i>Reporte de Reservas  Mensuales</a></li>
                <li><a href="LogonSalirCliente"><i class="icon-github icon-large"></i>Cerrar Sesión</a></li>
            </ul>
        </div>
    </li> 



    <%                    } 
        if (sesionOK.getAttribute("empleado") != null) {

    %>

    <li>
        <div id="dd" class="wrapper-dropdown-2" tabindex="1">
            <b class="icon-tutio" href="#">${ sessionScope.empleado.getEmpleadoNombres()}</b>
            <ul class="dropdown">
                <li><a href="LogonSalirCliente"><i class="icon-github icon-large"></i>Cerrar Sesión</a></li>
            </ul>
        </div>
    </li> 

    <%    } 
        if (sesionOK.getAttribute("cliente") != null) {
    %>  

    <li>
        <div id="dd" class="wrapper-dropdown-2" tabindex="1">
            <b class="icon-tutio" href="#">${ sessionScope.cliente.getClienteNombres()}</b>
            <ul class="dropdown">
                <li><a class="codrops-icon codrops-icon-prev" href="reservaCliente.jsp"><span>Reservas</span></a></li>
                <li><a href="LogonSalirCliente"><i class="icon-github icon-large"></i>Cerrar Sesión</a></li>
            </ul>
        </div>
    </li> 

    <%
    } 
    if(sesionOK.getAttribute("cliente") == null && sesionOK.getAttribute("empleado") == null && sesionOK.getAttribute("gerente") == null){
    %>

    <li><a class="codrops-icon codrops-icon-drop" href="Login.jsp"><span>Login</span></a>
    </li>
    
    <%
        }
    %>
</ul>


