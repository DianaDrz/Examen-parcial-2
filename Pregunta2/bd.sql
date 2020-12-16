create table proceso
(
codFlujo varchar(4),
codProceso varchar(4),
codProcesoSiguiente varchar(4),
tipo varchar(1),
rol varchar(10),
Pantalla varchar(30)
)

insert into proceso values('F1','P1','P2','I','E','inicio.php');
insert into proceso values('F1','P2','P3','P','E','selecciona.php');
insert into proceso values('F1','P3','null','C','K','verifica.inc.php');
insert into proceso values('F1','P5','P6','P','K','habilita.php');




create table procesocondicion(
codFlujo varchar(3), 
codProceso varchar(4), 
codProcesoSI varchar(4), 
codProcesoNO varchar(4) 
)

insert into procesocondicion values('F1','P3','P5','P4');

create table login(
usuario varchar(30),
clave varchar(30),
rol varchar(3)
)

insert into login values('administrador','123','K');
insert into login values('diana','321','E');
insert into login values('pepe','32','E');
insert into login values('doce','321','D');

create table rol
(
codusuario varchar(3),
descripcion varchar(20)
);

insert into rol values('K','kardex');
insert into rol values('E','Estudiante');
insert into rol values('D','Docente');









create table seguimiento
(
nroTramite	varchar(10)
codFlujo varchar(3),
codProceso varchar(3),
usuario varchar(20),
fechaini date,
fechafin date
);
-------------------------
create table usuario_rol
(
codusuario varchar(20),
codRol varchar(20)
);
