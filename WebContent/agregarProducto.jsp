

<%@page import="pe.kamwha.model.CategoriaModel"%>
<%@page import="pe.kamwha.service.CategoriaService"%>
<%@page import="java.util.List"%>
<%@page import="pe.kamwha.service.MenuService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    MenuService menuService = new MenuService();
    CategoriaService categoriaService = new CategoriaService();
    List<CategoriaModel> lista = categoriaService.listarCategoria();
    HttpSession sesionOK = request.getSession();
%>
<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Agregar Productos" />
</jsp:include>
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/defaultButtom.css" />
<link rel="stylesheet" type="text/css" href="css/componente.css" />

<script src="js/modernizr.custom.js"></script>
<link href="css/tabla.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="css/styleLogin.css">

</head>
<body>
    
    <div id="main-container" style="position:relative ;left: -150px;">
        <form enctype="multipart/form-data" action="AgregarProducto" method="POST">
            <table>
                <thead>
                    <tr>
                        <th>Codigo</th><th>Nombre</th><th>Descripción</th><th>Precio</th><th>Categoría</th><th>Condición</th>
                    </tr>
                </thead>

                <tr>
                    <td>
                        <input type="text" name="txtCodigo" value="<%= menuService.generarCodigo()%>" readonly="readonly">
                    </td>
                    <td>
                        <input type="text" name="txtNom" required>
                    </td>
                    <td>
                        <input type="text" name="txtDesc" required>
                    </td>
                    <td>
                        <input type="text" name="txtPrecio" required>
                    </td>
                    <td>
                        <select name="cbxCategoria">
                            <%
                                for (CategoriaModel bean : lista) {
                            %>
                            <option value="<%= bean.getCategoriaID()%>"> <%= bean.getCategoriaDescripcion()%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td>
                        <select name="cbxCondicion">
                            <option value="N">NO AGOTADO</option>
                            <option value="A">AGOTADO</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colspan="6">
                        <input type="file" name="Imgfichero" value="" id="btn" class="btn" required> 
                    </td>
                </tr>
            </table>
            <div class="CTA">
                <input type="submit" value="Registrarse" id="submit" class="btn btn-success">
            </div>
        </form>    
    </div>

    <div class="container">
        <jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
            <jsp:param name="sesionOK" value="<%= sesionOK%>" />
        </jsp:include>

    </div>
    <script src="js/classie.js"></script>
    <script src="js/gnmenu.js"></script>
    <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
    <script type="text/javascript" src="js/menu.js"></script>
    <script type="text/javascript">
        $(function () {

            Menu.init();

        });
    </script>
    <script>
        new gnMenu(document.getElementById('gn-menu'));
    </script>                   
</body>
</html>
