CREATE TABLE public.boards
(
    id bigserial NOT NULL,
    tag character varying NOT NULL UNIQUE,
    name character varying,
    description character varying,
    visible boolean NOT NULL default true,
    locked boolean NOT NULL default false,
    nsfw boolean NOT NULL default false,
    category bigint NOT NULL,
    header bigint,
    CONSTRAINT boards_pk PRIMARY KEY (id)
);

CREATE TABLE public.posts
(
    id bigserial NOT NULL,
    poster bigint NOT NULL,
    board bigint NOT NULL,
    parent bigint,
    creationtime timestamp NOT NULL,
    title character varying,
    message character varying,
    locked boolean NOT NULL default false,
    visible boolean NOT NULL default false,
    images bigint[] NOT NULL default '{}',
    CONSTRAINT posts_pk PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id bigserial NOT NULL,
    name character varying,
    country character varying,
    ip character varying NOT NULL,
    hash character varying,
    admin boolean NOT NULL default false,
    CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE public.images
(
    id bigserial NOT NULL,
    url character varying NOT NULL,
    squared character varying NOT NULL,
    filename character varying NOT NULL,
    width integer NOT NULL,
    height integer NOT NULL,
    filesize bigint NOT NULL,
    alt character varying NOT NULL,
    CONSTRAINT images_pk PRIMARY KEY (id)
);

CREATE TABLE public.categories
(
    id bigserial NOT NULL,
    name character varying,
    visible boolean NOT NULL default true,
    boards bigint[] NOT NULL default '{}',
    CONSTRAINT categories_pk PRIMARY KEY (id)
);