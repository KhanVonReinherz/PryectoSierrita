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
    <jsp:param name="title" value="Calidad de Servicio" />
</jsp:include>  

<script src="js/modernizr.custom.js"></script>
<link href="css/carro.css" rel="stylesheet" type="text/css"/>

</head>
<body>
    <div id="fb-root"></div>
		<script async defer crossorigin="anonymous" src="https://connect.facebook.net/es_LA/sdk.js#xfbml=1&version=v3.3">
	</script>
   
    
    
    <div class="container">
        <jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
            <jsp:param name="sesionOK" value="<%= sesionOK %>" />
        </jsp:include>
    </div>
    <br><br><br><br><br><br><br><br>
    <br><br><br><br><br><br><br><br>
    
    <div class="l-main ed-container">
        <div class="ed-item">
        <div class="ed-item offset-20 web-60">
                <div class="fb-comments" data-href="http://localhost:8086/PryChifaKamWha/calidadServicio.jsp" data-width="100%" data-numposts="5"></div>
            </div>
        </div>
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
