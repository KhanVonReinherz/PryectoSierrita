

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="WEB-INF/partials-dynamic/head.jsp">
    <jsp:param name="title" value="Registro" />
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


                        <!-- Signup Form -->
                        <div class="signup form-peice">
                            <form class="signup-form" action="CrearCliente" method="post">

                                <div class="form-group">
                                    <label for="name">Nombre</label>
                                    <input type="text" name="name" id="name" class="name" required>
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="name">Apellido Paterno</label>
                                    <input type="text" name="surnamepaterno" id="name" class="name" required>
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="name">Apellido Materno</label>
                                    <input type="text" name="surnamematerno" id="name" class="name" required>
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="name">D.N.I.</label>
                                    <input type="text" name="dni" id="dni" class="dni" required>
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="email">Correo electrónico</label>
                                    <input type="email" name="emailAdress" id="email" class="email" required>
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="phone">Número de teléfono</label>
                                    <input type="text" name="phone" id="phone" required>
                                </div>

                                <div class="form-group">
                                    <label for="password">Contraseña</label>
                                    <input type="password" name="password" id="password" class="pass" required>
                                    <span class="error"></span>
                                </div>

                                <div class="form-group">
                                    <label for="passwordCon">Confirmar contraseña</label>
                                    <input type="password" name="passwordCon" id="passwordCon" class="passConfirm" required>
                                    <span class="error"></span>
                                </div>

                                <div class="CTA">
                                    <input type="submit" value="Registrarse" id="submit">
                                    <a href="Login.jsp" >Tengo una cuenta</a>
                                </div>

                            </form>
                        </div><!-- End Signup Form -->
                    </div>
                </div>

            </section>



        </div>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js'></script>
        <script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js'></script>



        <script  src="js/index.js"></script>




    </body>

</html>
