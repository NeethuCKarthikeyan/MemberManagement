CREATE SEQUENCE public.member_id_sequence
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.member_id_sequence
    OWNER TO postgres;
	
	
CREATE TABLE public.member
(
    id integer NOT NULL DEFAULT nextval('member_id_sequence'::regclass),
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    email_id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    mob_num integer NOT NULL,
    gender character(1) COLLATE pg_catalog."default",
    address character varying(50) COLLATE pg_catalog."default",
    city character varying(50) COLLATE pg_catalog."default",
    state character varying(50) COLLATE pg_catalog."default",
    country character varying(50) COLLATE pg_catalog."default",
    pin_num integer,
    created_date TimeStamp NOT NULL,
    last_mod_date TimeStamp,
    is_active boolean NOT NULL DEFAULT false,
    is_deleted boolean NOT NULL DEFAULT false
)

TABLESPACE pg_default;

ALTER TABLE public.member
    OWNER to postgres;	