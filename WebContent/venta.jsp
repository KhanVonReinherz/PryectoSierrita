

<%@page import="pe.kamwha.model.DetalleBoletaModel"%>
<%@page import="pe.kamwha.model.BoletaModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    BoletaModel boleta = (BoletaModel) request.getAttribute("venta");
    float total = 0;
    HttpSession sesionOK = request.getSession();
    System.out.println("ENTRO A carro.JSP");
%>

<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Factura de Venta" />
</jsp:include>
<link href="css/carro.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <div class="l-main ed-container">
        <div class="ed-item">
            <div class="ed-container web-80">
                <div class="ed-item web-80">
                    <h1>Factura de Venta</h1>
                </div>
            </div>
            <div class="ed-container offset-25 web-50 contact-form">
                <div class="ed-item web-30">
                    <label for="factura">Factura Número: </label>
                </div>
                <div class="ed-item web-70">
                    <input type="text" id="factura" readonly value="<%= boleta.getBoletaID()%>">
                </div>
                <div class="ed-item web-30">
                    <label for="fecha">Fecha:</label>
                </div>
                <div class="ed-item web-70">
                    <input type="text" id="fecha" readonly value="<%= boleta.getBoletaFecha()%>">
                </div>
                <div class="ed-item web-30">
                    <label for="nombre">Nombre:</label>
                </div>
                <div class="ed-item web-70">
                    <input type="text" id="nombre" readonly value="<%= boleta.getCliente().getClienteNombres()%>">
                </div>
                <div class="ed-item web-30">
                    <label for="apellidoPaterno">Apellidos:</label>
                </div>
                <div class="ed-item web-70">
                    <input type="text" id="apellidos" readonly value="<%= boleta.getCliente().getClienteApePaterno() + " " + boleta.getCliente().getClienteApeMaterno()%>">
                </div>
                <div class="ed-item web-30">
                    <label for="dni">D.N.I.:</label>
                </div>
                <div class="ed-item web-70">
                    <input type="text" id="dni" readonly value="<%= boleta.getCliente().getClienteDni()%>">
                </div>
            </div>

            <div class="ed-item offset-20 web-60">
                <table class="listado">
                    <thead>
                        <tr>
                            <th>Menu</th>
                            <th>Descripción</th>
                            <th>Valor</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for(DetalleBoletaModel detalle: boleta.getDetalle()){
                                total += detalle.getMenu().getMenuPrecio();
                                System.out.println("Nombre Menu: " +  detalle.getMenu().getMenuNombre());
                        %>
                        <tr>
                            <td><%= detalle.getMenu().getMenuNombre() %></td>
                            <td><%= detalle.getMenu().getMenuDescripcion() %></td>
                            <td>S/ <%= detalle.getMenu().getMenuPrecio() %></td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2" class="suma-label">Total</td>
                            <td class="suma">S/ <%= total %></td>
                        </tr>
                    </tfoot>
                </table>
            </div>
            
            <div class="ed-item offset-25 web-50">
            <form class="ed-item main-center" name="_xclick" target="paypal" action="https://www.paypal.com/cgi-bin/webscr" method="post">
            <!-- <form class="ed-item main-center" name="_xclick" target="paypal" action="https://www.sandbox.paypal.com/cgi-bin/webscr" method="post"> -->
                <input type="hidden" name="cmd" value="_xclick">
                <input type="hidden" name="business" value="chifa.kam.wha1@gmail.com">
                <input type="hidden" name="currency_code" value="USD">
                <input type="hidden" name="item_name" value="Factura: <%= boleta.getBoletaID() %>">
                <input type="hidden" name="amount" value="<%= total/3.23f%>">
                <!-- <input type="image" src="http://www.paypal.com/es_ES/i/btn/sc-but-01.gif" border="0" name="submit" alt="Make payments with PayPal - it's fast, free and secure!"> -->
                <input type="hidden" name="add" value="1">
                <input type="hidden" name="charset" value="utf-8">
                <input type="hidden" name="on0" value="Comprador">
                <input type="hidden" name="os0" value="<%= boleta.getCliente().getClienteNombres() + " " + boleta.getCliente().getClienteApePaterno() + " " + boleta.getCliente().getClienteApeMaterno() %>">
                <input type="hidden" name="on1" value="D.N.I.">
                <input type="hidden" name="os1" value="<%= boleta.getCliente().getClienteDni() %>">
                <button type="submit" class="boton icon-cart espacio product__page__buy">
                    Pagar por Paypal
                </button>
            </form>
        </div>
                        
                        
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

