create table if not exists paysystem.client
(
	id serial not null
		constraint client_pk
			primary key,
	login varchar not null,
	pswd varchar not null,
	firstname varchar not null,
	secondname varchar not null,
	surname varchar
);

comment on table paysystem.client is 'Таблица клиентов';

comment on column paysystem.client.id is 'Идентификатор';

alter table paysystem.client owner to postgres;

create unique index if not exists client_id_uindex
	on paysystem.client (id);

create unique index if not exists client_login_uindex
	on paysystem.client (login);