
<%@page import="pe.kamwha.model.MenuModel"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
    HttpSession sesionOK = request.getSession();
    List<MenuModel> carro = (List) session.getAttribute("carro");
    float total = 0;

    System.out.println("ENTRO A carro.JSP");
%>

<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Carro" />
</jsp:include>
<link href="css/carro.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="l-main ed-container">
        <div class="ed-item">
            <h1>Mi Carro de Compras</h1>
            <div class="">
                <%
                    if (carro != null) {
                        for (MenuModel menu : carro) {
                            total += menu.getMenuPrecio();
                %>
                <div class="producto-carro">
                    <div class="producto-carro__img">
                        <img src="ImagenMenu?id=<%= menu.getMenuID()%>" alt="Menu">
                    </div>
                    <div class="producto-carro__info">
                        <h3> <%= menu.getMenuNombre()%></h3>
                        <p> <%= menu.getMenuDescripcion()%></p>
                    </div>
                    <div class="producto-carro__precio">
                        <h3>Precio</h3>
                        <p>S.<%= menu.getMenuPrecio()%></p>
                    </div>
                    <div class="producto-carro__del">
                        <a href="EliminarCarrito?id=<%= menu.getMenuID()%>">
                            <img src="WebContent/images/delete.png" alt="Eliminar" title="Eliminar">
                        </a>
                    </div>

                </div>
                <%
                        }
                    }
                %>
            </div>
            <div class="producto-carro__footer">
                <div class="">
                    <a class="boton icon-cart espacio product__page__buy" href="index.jsp">Seguir Comprando</a>
                </div>
                <div class="producto-carro__total">
                    <h2>Total a Pagar <span class="">S.<%= total%></span></h2>
                </div>
            </div>

            <form method="get" action="VenderCarrito" class="ed-container web-60 contact-form">
                <input type="hidden" id="nombre" name="ClienteID" value="${ sessionScope.cliente.getClienteID() }">
                <div class="ed-item">
                    <button class="boton icon-cart espacio product__page__buy">Confirmar Compra</button>
                </div>
            </form>
        </div>
    </div>
    <div class="container">            
        <jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
            <jsp:param name="sesionOK" value="<%= sesionOK%>" />
        </jsp:include>
    </div>


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

