CREATE TABLE public.categories
(
    id bigserial NOT NULL,
    name character varying,
    boards bigint[] NOT NULL default '{}',
    CONSTRAINT categories_pk PRIMARY KEY (id)
);