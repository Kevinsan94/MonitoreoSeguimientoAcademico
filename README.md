# Monitoreo Seguimiento Academico

TABLES

create table Estudiante (
id_estudiante int not null auto_increment,
nombre varchar(50),
apellido varchar(50),
telefono int,
email varchar(50),
password varchar(50),
primary key(id_estudiante)
);

create table Docente (
id_docente int not null auto_increment,
nombre varchar(50),
apellido varchar(50),
telefono int,
email varchar(50),
contraseña varchar(50),
primary key(id_docente)
);

create table Administrador (
id_administrador varchar(10) not null,
password varchar(50),
primary key(id_administrador)
);

create table Notas (
id_estudiante int not null,
materia varchar(50),
p1 int,
p2 int,
p3 int,
final int,
foreign key (id_estudiante) references Estudiante (id_estudiante)
);


INITIAL INSERTS

insert into Notas values ('28716','Bioinformatica','54','80', '75', '70');
insert into Notas values ('28716','Programacion I', '75', '94', '74', '80');
insert into Notas values ('28716','Programacion II','80','31', '100', '73');
insert into Notas values ('28716','Calculo I','75','65', '68', '69');
insert into Notas values ('28716','Calculo II','100','100', '100', '100');
insert into Notas values ('28716','Calculo III','50','54', '65', '57');


insert into estudiante values ('28715','Matheus','GarciaMeza','70160458','monkeymon@gmail.com','mono1371');
insert into estudiante values ('28716','Kevin','Viscafe','77524896','kevinviscafe@gmail.com','Prueba1234*');
insert into estudiante values ('28717','Byronth','Paz','79170718','enriquepaz@gmail.com','enriquepaZ2%');


insert into Administrador values('admin', 'Prueba1234*');


insert into Docente values ('2871','Alexis','Marechal','70160458','alexis@gmail.com','Alexis1234*');
insert into Docente values ('2872','Osman','Burgoa','77560458','osman@gmail.com','Osman1234*');
insert into Docente values ('2873','Carlos','Anibarro','60660458','carlos@gmail.com','Carlos1234*');
insert into Docente values ('2874','Mauricio','Hubner','71260458','mauricio@gmail.com','Mauricio1234*');
insert into Docente values ('2875','Jose','Gil','78960458','josegil@gmail.com','Jose1234*');


