
<?php
include "conexion.inc.php";
    $user=$_POST['usuario'];
    $clave=$_POST['clave'];

    $sql=mysqli_query($conn,"SELECT * FROM login WHERE clave='$clave'");
    if($fila=mysqli_fetch_assoc($sql)){
        if($clave==$fila['clave']){
            session_start();
            $_SESSION['usuario']=$fila['usuario'];
            header("Location: motor.php");

        }else{
            echo '<script>alert("LA CONTRASEÑA ES INCORRECTA")</script> ';
            echo "<script>location.href='index.php'</script>";
        }
    }else{
    
        echo '<script>alert("ESTE USUARIO NO EXISTE, PORFAVOR REGISTRESE PARA PODER INGRESAR")</script> ';      
        echo "<script>location.href='index.php'</script>";  
    }   
?>