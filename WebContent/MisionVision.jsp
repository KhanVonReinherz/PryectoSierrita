

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    HttpSession sesionOK = request.getSession();
%>

<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Mision Vision" />
</jsp:include>
<link href="css/carro.css" rel="stylesheet" type="text/css"/>
</head>
<body>

    <div class="container">
        <jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
            <jsp:param name="sesionOK" value="<%= sesionOK%>" />
        </jsp:include>


    </div><!-- /container -->
    <br><br><br><br>
	<div class="l-main ed-container">
        <div class="ed-item">
        <div class="ed-item offset-20 web-60">
                <table class="listado">
                    <thead>
                        <tr>
                            <th>Misión</th>
                        </tr>
                    </thead>
                    <tbody>
                    	<tr>
                       		<td> Somos un grupo especializado que brinda la mejor calidad en sus servicios como restaurante para poder satisfacer las necesidades del cliente en todo nuestro alcance.</td>
                    	</tr>
                    </tbody>
                    <thead>
                        <tr>
                            <th>Visión</td>
                        </tr>
                    </thead>
                    <tbody>
                    	<tr>
                       		<td> Ser el restaurante mas importante de todo Perú con los mejores servicios y una calidad inigualable. </td>
                    	</tr>
                    </tbody>
                </table>
            </div>
        </div>
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


