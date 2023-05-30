alter table public.boards
    add "parentCategory" bigint default 0 not null;