create table if not exists elettori (
    codfiscale char(16) primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    sex char(1) not null,
    data date not null,
    votato boolean not null,
    password char(64) not null,
    email varchar(40) not null unique,
    luogonascita char(2),
    telefono varchar(15) not null,
    nazione char(3)
);

create table if not exists scrutinatori (
    codfiscale char(16) primary key,
    nome varchar(30) not null,
    cognome varchar(30) not null,
    sex char(1) not null,
    data date not null,
    password char(64) not null,
    luogonascita char(2),
    nazione char(3)
);

create table if not exists sessioni(
    titolo varchar(30) primary key ,
    descrizione varchar(70) not null,
    inizio date not null,
    fine date not null,
    tipo varchar(30)
);

create table if not exists referendum(
    titolo varchar(30) primary key,
    si int not null,
    no int not null,
    quorum boolean not null,
    foreign key (titolo) references sessioni(titolo)
);

-- elettori di prova
insert into elettori values('FLPLNZ00M11F205W', 'LORENZO', 'FILIPPONI', 'M', '2000-08-11',  0, '77696C7A64E9BC7DE8F7F65E22148AF210E3A6204F877307F9C8DF34220118EC', 
'pippolor3@gmail.com', 'MI', '3663183309', 'ITA'
);

insert into elettori values('MZZSRA01A71D969X', 'SARA', 'MUZZI', 'F', '2001-01-31',  0, '77696C7A64E9BC7DE8F7F65E22148AF210E3A6204F877307F9C8DF34220118EC', 
'saretta2001@gmail.com', 'GE', '2583642269', 'ITA'
);

insert into elettori values('FLPLNZ06L55F205F', 'MATTEO', 'FILIPPONI', 'M', '2006-07-15',  0, '77696C7A64E9BC7DE8F7F65E22148AF210E3A6204F877307F9C8DF34220118EC', 
'matte0filipponi@gmail.com', 'MI', '181767887', 'ITA'
);


-- scrutinatori di prova
insert into scrutinatori values('FLPLNZ00M11F205W', 'LORENZO', 'FILIPPONI', 'M', '2000-08-11', '77696C7A64E9BC7DE8F7F65E22148AF210E3A6204F877307F9C8DF34220118EC', 
'MI', 'ITA'
);

insert into scrutinatori values('MZZSRA01A71D969X', 'SARA', 'MUZZI', 'F', '2001-01-31', '77696C7A64E9BC7DE8F7F65E22148AF210E3A6204F877307F9C8DF34220118EC', 
'GE', 'ITA'
);


