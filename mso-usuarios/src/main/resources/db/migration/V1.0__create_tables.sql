
create table usuario (
idUsuario SERIAL PRIMARY KEY,
nombreUsuario VARCHAR ( 50 ) UNIQUE NOT NULL,
contrasenia VARCHAR ( 50 ) NOT NULL,
correo VARCHAR ( 50 ) UNIQUE NOT NULL,
direccion varchar(50),
estado varchar(50));

create table contacto(
id SERIAL PRIMARY KEY,
idUsuarioOrigen INT NOT NULL,
idUsuarioContacto INT NOT NULL);

create table conversacion(
idConversacion SERIAL PRIMARY KEY,
idUsuarioOrigen INT NOT NULL,
idUsuarioDestino INT NOT NULL);

create table mensaje(
idMensaje SERIAL PRIMARY KEY,
idConversacion INT NOT NULL,
fechaHora varchar( 50 ),
texto VARCHAR ( 500 ) NOT NULL,
visto BOOLEAN);


insert  into contacto (idUsuarioOrigen,idUsuarioContacto) values (1,2);
insert  into contacto (idUsuarioOrigen,idUsuarioContacto) values (1,3);
insert  into contacto (idUsuarioOrigen,idUsuarioContacto) values (3,2);
insert  into contacto (idUsuarioOrigen,idUsuarioContacto) values (3,1);

insert  into conversacion (idUsuarioOrigen,idUsuarioDestino) values (1,2);
insert  into conversacion (idUsuarioOrigen,idUsuarioDestino) values (1,3);
insert  into conversacion (idUsuarioOrigen,idUsuarioDestino) values (3,2);

insert  into mensaje (idConversacion,fechaHora,texto,visto) values (1,'24/12/2022','Hola feliz navidad',true);
insert  into mensaje (idConversacion,fechaHora,texto,visto) values (1,'24/12/2022','gracias',false);
insert  into mensaje (idConversacion,fechaHora,texto,visto) values (2,'01/01/2023','Hola 2023',true);

insert  into usuario (nombreusuario,contrasenia,correo,direccion, estado) values ('Julio Cesar Moreno Guzman','123','juliocmoreno@gmail.com','Trueno 118, Col. Pircantos, CP 42088','Hidalgo');
insert  into usuario (nombreusuario,contrasenia,correo,direccion, estado) values ('Cesar Moreno Guzman','1234','cesar@gmail.com','Trueno 118, Col. Pircantos, CP 42088','Hidalgo');
insert  into usuario (nombreusuario,contrasenia,correo,direccion, estado) values ('Julio Guzman M','1234','julio@gmail.com','Trueno 118, Col. Pircantos, CP 42088','Hidalgo');


