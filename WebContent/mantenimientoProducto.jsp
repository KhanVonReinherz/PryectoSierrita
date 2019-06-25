<%@page import="pe.kamwha.model.MenuModel"%>
<%@page import="java.util.List"%>
<%@page import="pe.kamwha.service.CategoriaService"%>
<%@page import="pe.kamwha.model.CategoriaModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    CategoriaService categoriaService = new CategoriaService();
    List<CategoriaModel> lista = categoriaService.listarCategoria();
    List<MenuModel> listaMenu = (List) request.getAttribute("listaMenu");
    HttpSession sesionOK = request.getSession();
%>

<!DOCTYPE html>
<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Mantenimiento" />
</jsp:include>  

<script src="js/modernizr.custom.js"></script>
<link href="css/tabla.css" rel="stylesheet" type="text/css"/>

</head>
<body>
    <div id="set-4">
        <div class="hi-icon-wrap hi-icon-effect-4 hi-icon-effect-4a">
            <%-- CAMBIAR AL  HREF  CORRECTO --%>
            <a href="index.jsp" class="hi-icon hi-icon-contract"></a>
            <a class="icon-letra" href="index.jsp" >Salir</a>
        </div>

    </div>
    <div id="main-container">

        <form action="ListarPorCategoria">
            <table>
                <thead>
                    <tr align="center">
                        <th colspan="4">
                            Seleccione una Categoria:
                        </th>
                        <th colspan="3">
                            <select name="cbxCategoria">
                                <%
                                    for (CategoriaModel bean : lista) {
                                %>
                                <option value="<%= bean.getCategoriaDescripcion()%>"> <%= bean.getCategoriaDescripcion()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </th>

                    </tr>
                </thead>
            </table>
            <div class="CTA">
                <input type="submit" value="LISTAR" id="submit" class="btn btn-success">
            </div>
        </form> 
    </div>
    <div id="main-container">
        <p>
            <a href="agregarProducto.jsp" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span>Nuevo</a>
        </p>
        <table>
            <thead>
                <tr>
                    <th>Codigo</th><th>Nombre</th><th>Descripción</th><th>Precio</th><th>Categoría</th><th>Condición</th><th>Acción</th>
                </tr>
            </thead>
            <tr>
                <%
                    if (listaMenu != null) {
                        for (MenuModel menu : listaMenu) {
                %>

                <td><%= menu.getMenuID()%></td>
                <td><%= menu.getMenuNombre()%></td>
                <td><%= menu.getMenuDescripcion()%></td>
                <td><%= menu.getMenuPrecio()%></td>
                <td><%= menu.getCategoria().getCategoriaDescripcion()%></td>
                <td><%= menu.getMenuAgotado()%></td>
                <td><a href="EliminarMenu?cod=<%= menu.getMenuID()%>&condi=<%= menu.getMenuAgotado() %>">Eliminar</a>
                    || <a href="editarMenu?cod=<%= menu.getMenuID()%>">Editar</a></td>

            </tr>
            <%
                    }
                }
            %>

        </table>
    </div>
    <div class="container">
        <jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
            <jsp:param name="sesionOK" value="<%= sesionOK %>" />
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
            
    <script>
        var hash = window.location.hash,
                current = 0,
                demos = Array.prototype.slice.call(document.querySelectorAll('#codrops-demos > a'));

        if (hash === '')
            hash = '#set-1';
        setDemo(demos[ parseInt(hash.match(/#set-(\d+)/)[1]) - 1 ]);

        demos.forEach(function (el, i) {
            el.addEventListener('click', function () {
                setDemo(this);
            });
        });

        function setDemo(el) {
            var idx = demos.indexOf(el);
            if (current !== idx) {
                var currentDemo = demos[ current ];
                currentDemo.className = currentDemo.className.replace(new RegExp("(^|\\s+)" + 'current-demo' + "(\\s+|$)"), ' ');
            }
            current = idx;
            el.className = 'current-demo';
        }
    </script>
</body>
</html>
