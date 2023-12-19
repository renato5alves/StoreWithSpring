create table produtos(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    categoria varchar(100) not null,
    preco decimal not null,
    primary key(id)

);