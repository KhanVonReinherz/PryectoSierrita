
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    System.out.println("ENTRO A LOGIN.JSP");
%>
<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Iniciar Sesion" />
</jsp:include>
 
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700|Raleway:300,600" rel="stylesheet">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel ="icon" type="image/png" href="images/traumado.png" >
        <link rel='stylesheet prefetch' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css'>
        <link rel="stylesheet" href="css/styleLogin.css">

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
                            <a href="Login.jsp" class="profile">Iniciar Sesión</a>
                        </div>
                    </div>


                    <!-- Form Box -->
                    <div class="col-sm-6 form">

                        <!-- Login Form -->
                        <div class="login form-peice" id="tengoCuenta">
                            <form class="login-form" action="LoginGeneral" method="post">
                                <div class="form-group">
                                    <label for="loginemail">Correo electrónico</label>
                                    <input type="email" name="loginemail" id="loginemail" required>
                                </div>

                                <div class="form-group">
                                    <label for="loginPassword">Contraseña</label>
                                    <input type="password" name="loginPassword" id="loginPassword" required>
                                </div>

                                <div class="CTA">
                                    <input type="submit" value="iniciar sesión">
                                    <a href="registrarCliente.jsp" >Soy nuevo</a>
                                </div>
                            </form>
                        </div><!-- End Login Form -->

                    </div>
                </div>

            </section>



        </div>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>



        <script  src="js/index.js"></script>




    </body>

</html>

