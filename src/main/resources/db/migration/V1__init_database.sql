drop table if exists book;
drop table if exists hibernate_sequence;

create table book (
        id bigint not null auto_increment,
        isbn varchar(255),
        publisher varchar(255),
        title varchar(255),
        primary key (id)
) engine=InnoDB;

-- in Hibernate 6 use book_seq (<table_name>_seq) NOT hibernate_sequence
create table hibernate_sequence (
    next_val bigint
)engine=InnoDB;

insert into hibernate_sequence values (1);
