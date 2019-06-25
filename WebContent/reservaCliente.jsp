

<%@page import="pe.kamwha.model.MesaModel"%>
<%@page import="java.util.List"%>
<%@page import="pe.kamwha.service.MesaService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    MesaService mesaService = new MesaService();
    List<MesaModel> listaMesa = mesaService.listar("");
    HttpSession sesionOK = request.getSession();
    System.out.println("ENTRO A RESERVACLIENTE.JSP");
%>

<!DOCTYPE html>
<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Reservas" />
</jsp:include>  

<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css"/>
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/defaultButtom.css" />
<link rel="stylesheet" type="text/css" href="css/componente.css" />
<script src="js/modernizr.custom.js"></script>
<link href="css/tabla.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="css/styleLogin.css">
<link href="css/tabla.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div id="main-container">
        <form enctype="multipart/form-data" action="AgregarReserva" method="GET">
            <table>
                <thead>
                    <tr>
                        <th>Codigo</th><th>Mesa</th><th>Fecha</th>
                    </tr>
                </thead>

                <tr>
                    <td>  <input type="text" name="txtCod"  value="${ sessionScope.cliente.getClienteID() }" readonly="readonly"></td>

                    <td>
                        <select name="cbxMesa">
                            <%
                                for (MesaModel bean : listaMesa) {
                            %>
                            <option value="<%= bean.getMesaNro()%>"> <%= bean.getMesaNro()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td>
                        <input type="text" name="filter-date" id="filter-date" required/>
                    </td>
                </tr>

            </table>
            <div class="CTA">
                <input type="submit" value="Reservar" id="submit" class="btn btn-success">
            </div>
        </form>    
    </div>
    <div class="container">
        <jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
            <jsp:param name="sesionOK" value="<%= sesionOK %>" />
        </jsp:include>

    </div>





    <script src="js/jquery.js"></script>
    <script src="js/jquery.datetimepicker.full.js"></script>
    <script src="js/classie.js"></script>
    <script src="js/gnmenu.js"></script>

    <script type="text/javascript" src="js/menu.js"></script>
    <script type="text/javascript">
        $(function () {

            Menu.init();

        });
    </script>
    <script>
        new gnMenu(document.getElementById('gn-menu'));
    </script>
    <script>
        /*jslint browser:true*/
        /*global jQuery, document*/

        jQuery(document).ready(function () {
            'use strict';

            jQuery('#filter-date, #search-from-date, #search-to-date').datetimepicker();
        });
    </script>
</body>
</html>
