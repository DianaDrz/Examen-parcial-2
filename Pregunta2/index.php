<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/estilo2.css" type="text/css">
    <title>Login</title>
</head>
<body id="inicio">

    <div id="a1">
        <form action="controladorLogin.php" method="POST">
            <h2>INICIAR SECIÓN</h2>
          <label>Usuario</label><input type="text" placeholder="Ingrese su usuario" name="usuario" ><br><br>
          <label >Contraseña</label><input type="password" placeholder="Ingrese su contraseña" name="clave" ><br><br>
          <input type="submit" name="aceptar" value="Iniciar Sesión">
        </form>
    </div>
</body>
</html>