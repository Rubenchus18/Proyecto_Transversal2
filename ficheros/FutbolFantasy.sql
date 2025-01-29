drop database if exists liga_fantasy;
CREATE  DATABASE  LIGA_FANTASY;
USE LIGA_FANTASY;

create table equipo(
	id_equipo int not null auto_increment,
    nombre varchar(50) not null,
    
    victorias int(2) not null default 0,
    empates int(2) not null default 0,
    derrotas int(2) not null default 0,
    puntos int(3) not null default 0,
    
	portero int(1) not null default 1,
    defensa int(1) not null default 4,
    centrocampista int(1) not null default 4,
    delantero int(1) not null default 2,
    
    constraint pk_equipo primary key(id_equipo)
    
);

create table jugador (
	id_jugador int not null auto_increment,
    
    equipo varchar(100) not null,
	nombre varchar(100) not null,
	posicion varchar(3) not null,
	fuerza_ataque int(2) not null,
	fuerza_tecnica int(2) not null,
    fuerza_defensa int(2) not null,
    fuerza_portero int(2) not null,
   
    seleccionado boolean not null default false,
	id_equipo int  null,
    
	constraint PK_jugadores PRIMARY KEY(id_jugador),
    constraint FK_equipo foreign key(id_equipo)references equipo(id_equipo)
    
);

