


<%@page import="pe.kamwha.model.MenuModel"%>
<%@page import="pe.kamwha.service.MenuService"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    MenuService menuService = new MenuService();

    List<MenuModel> listadoPostre = menuService.listarEntrada("Postre");
    List<MenuModel> listadoEntrada = menuService.listarEntrada("Entrada");
    List<MenuModel> listadoPlato = menuService.listarEntrada("Plato");
    List<MenuModel> listadoBebida = menuService.listarEntrada("Bebida");

    HttpSession sesionOK = request.getSession();
    System.out.println("ENTRO A INDEX.JSP");
%>

<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Bienvenidos" />
</jsp:include>
</head>
<body>

    <div class="container">
        <header>
            <h1>Chifa Kam Wha <span>El Restaurante hecho para ti <a href="index.jsp">Chifa Kam Wha</a> Sitio Web</span></h1>
        </header>
        <div id="rm-container" class="rm-container">

            <div class="rm-wrapper">

                <div class="rm-cover">

                    <div class="rm-front">
                        <div class="rm-content">

                            <div class="rm-logo"></div>
                            <h2>Menú Kam Wha</h2>
                            <h3>Disfruta &amp; Degusta </h3>

                            <a href="#" class="rm-button-open">Mira el  menú</a>
                            <div class="rm-info">
                                <p>
                                    <strong>Chifa Kam Wha</strong><br>
                                    246 La casa de Karuro Ln.<br>
                                    Pueblo Libre, CA 91101<br>
                                    <strong>Telf.</strong> 984-622-652<br>

                            </div>

                        </div><!-- /rm-content -->
                    </div><!-- /rm-front -->

                    <div class="rm-back">
                        <div class="rm-content">
                            <h4>Postres</h4>
                            <dl>
                                <%                                        if (listadoPostre != null) {
                                        for (MenuModel postre : listadoPostre) {
                                %>
                                <dt> <a href="AgregarCompra?id=<%= postre.getMenuID() %>" class="rm-viewdetails" data-thumb="ImagenMenu?id=<%= postre.getMenuID() %>">  <%= postre.getMenuNombre()%> </a></dt>
                                <dd> <%= postre.getMenuDescripcion()%></dd>
                                <%
                                        }
                                    } else {
                                        System.out.println("Error en Listado POSTRE VACIO.");
                                    }
                                %>

                            </dl>

                            <h4>Entradas &amp; Más</h4>


                            <dl>
                                <%
                                    if (listadoEntrada != null) {
                                        for (MenuModel entrada : listadoEntrada) {
                                %>
                                <dt> <a href="AgregarCompra?id=<%= entrada.getMenuID() %>" class="rm-viewdetails" data-thumb="ImagenMenu?id=<%= entrada.getMenuID() %>">  <%= entrada.getMenuNombre()%> </a></dt>
                                <dd> <%= entrada.getMenuDescripcion()%></dd>
                                <%
                                        }
                                    } else {
                                        System.out.println("Error en Listado ENTRADAS VACIO.");
                                    }
                                %>

                            </dl>
                        </div><!-- /rm-content -->
                        <div class="rm-overlay"></div>

                    </div><!-- /rm-back -->

                </div><!-- /rm-cover -->

                <div class="rm-middle">
                    <div class="rm-inner">
                        <div class="rm-content">
                            <h4>Platos Fuertes</h4>
                            <dl>
                                <div class="rm-content" id="platorm-content">
                                    <%
                                        if (listadoPlato != null) {
                                            for (MenuModel menu : listadoPlato) {
                                    %>
                                    <dt> <a href="AgregarCompra?id=<%= menu.getMenuID() %>" class="rm-viewdetails" data-thumb="ImagenMenu?id=<%= menu.getMenuID() %>"> <%= menu.getMenuNombre()%> </a> </dt>
                                    <dd> <%= menu.getMenuDescripcion()%></dd>
                                    <%
                                            }
                                        } else {
                                            System.out.println("Error en Listado MENU VACIO.");
                                        }
                                    %>
                                </div>
                            </dl>
                        </div><!-- /rm-content -->
                        <div class="rm-overlay"></div>
                    </div><!-- /rm-inner -->
                </div><!-- /rm-middle -->

                <div class="rm-right">

                    <div class="rm-front">

                    </div>

                    <div class="rm-back">
                        <span class="rm-close">Cerrar</span>
                        <div class="rm-content">
                            <h4>Bebidas</h4>
                            <dl>
                                <%
                                    if (listadoBebida != null) {
                                        for (MenuModel bebida : listadoBebida) {
                                %>
                                <dt><a href="AgregarCompra?id=<%= bebida.getMenuID() %>" class="rm-viewdetails" data-thumb="ImagenMenu?id=<%= bebida.getMenuID() %>"> <%= bebida.getMenuNombre()%> </a></dt>
                                <dd> <%= bebida.getMenuDescripcion()%></dd>

                                <%
                                        }
                                    } else {
                                        System.out.println("Error en Listado BEBIDA VACIO.");
                                    }
                                %>

                            </dl>
                            <!--<div class="rm-order">
                                    <p><strong>Organizamos tu evento</strong> Llama ya  &amp;  <strong>626.511.1170</strong></p>
                            </div>-->
                        </div><!-- /rm-content -->
                    </div><!-- /rm-back -->

                </div><!-- /rm-right -->
            </div><!-- /rm-wrapper -->

        </div><!-- /rm-container -->

        <jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
            <jsp:param name="sesionOK" value="<%= sesionOK%>" />
        </jsp:include>



    </div><!-- /container -->


    <section class="main">



    </section>

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
    <script type="text/javascript">

        function DropDown(el) {
            this.dd = el;
            this.initEvents();
        }
        DropDown.prototype = {
            initEvents: function () {
                var obj = this;

                obj.dd.on('click', function (event) {
                    $(this).toggleClass('active');
                    event.stopPropagation();
                });
            }
        }

        $(function () {

            var dd = new DropDown($('#dd'));

            $(document).click(function () {
                // all dropdowns
                $('.wrapper-dropdown-2').removeClass('active');
            });

        });

    </script>
    

</body>
</html>


