<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%    
    HttpSession sesionOK = request.getSession();

%>

<!DOCTYPE html>
<html lang="en" >

    <head>
        <meta charset="UTF-8">
        <title>Registro Gerente| Kam Wha </title>
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700|Raleway:300,600" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel ="icon" type="image/png" href="images/traumado.png" >
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
        <link rel="stylesheet" href="css/styleLoginEmpleado.css">
        <noscript><link rel="stylesheet" type="text/css" href="css/noJS.css" /></noscript>
        <link rel="stylesheet" type="text/css" href="css/component.css" />
        <script src="js/modernizr.custom.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Raleway:300,500|Arvo:700' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <script type="text/javascript" src="js/modernizr.custom.79639.js"></script>

    </head>

    <body>


        <div class="container">
            <section id="formHolder">

                <div class="row">

                    <!-- Brand Box -->
                    <div class="col-sm-6 brand">


                        <div class="heading">
                            <h2>Chifa Kam Wha</h2>
                            <p>El mejor chifa del Perú</a></p>
                        </div>

                        <div class="success-msg">
                            <p>¡Estupendo! Eres uno de nuestros miembros ahora.</p>
                            <a href="index.jsp" class="profile">Mi perfil</a>
                        </div>
                    </div>


                    <!-- Form Box -->
                    <div class="col-sm-6 form">

                        


                        <!-- Signup Form -->
                        <div class="signup form-peice">
                            <form class="signup-form" action="LoginGerente" method="post">

                                <div class="form-group">
                                    <label for="name">Nombre</label>
                                    <input type="text" name="name" id="name" class="name">
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="name">Apellido Paterno</label>
                                    <input type="text" name="surnamepaterno" id="name" class="name">
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="name">Apellido Materno</label>
                                    <input type="text" name="surnamematerno" id="name" class="name">
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="name">D.N.I.</label>
                                    <input type="text" name="dni" id="name" class="name">
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="email">Correo electrónico</label>
                                    <input type="email" name="emailAdress" id="email" class="email">
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="phone">Número de teléfono - <small>Opcional</small></label>
                                    <input type="text" name="phone" id="phone">
                                </div>
                                
                                <div class="form-group">
                                    <label for="password">Contraseña</label>
                                    <input type="password" name="password" id="password" class="pass">
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="passwordCon">Confirmar contraseña</label>
                                    <input type="password" name="passwordCon" id="passwordCon" class="passConfirm">
                                    <span class="error"></span>
                                </div>
                                
                                <div class="CTA">
                                    <input type="submit" value="Registrarse" id="submit">
                                </div>

                            </form>
                        </div><!-- End Signup Form -->
                    </div>
                </div>

            </section>

            <jsp:include page="WEB-INF/partials-dynamic/menu-navegacion.jsp">
            	<jsp:param name="sesionOK" value="<%= sesionOK %>" />
        	</jsp:include>

        </div>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>
		<script type="js/index.js"></script>
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
