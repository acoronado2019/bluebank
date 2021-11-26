--
-- PostgreSQL database dump
--

-- Dumped from database version 13.3 (Debian 13.3-1.pgdg100+1)
-- Dumped by pg_dump version 13.3

-- Started on 2021-11-25 21:02:32

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2942 (class 1262 OID 13395)
-- Name: postgres; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE postgres WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'en_US.utf8';


ALTER DATABASE postgres OWNER TO postgres;

\connect postgres

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2936 (class 0 OID 16403)
-- Dependencies: 202
-- Data for Name: account; Type: TABLE DATA; Schema: bluebank; Owner: postgres
--

-- Table: bluebank.account

-- DROP TABLE bluebank.account;

CREATE TABLE IF NOT EXISTS bluebank.account
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name_person character varying COLLATE pg_catalog."default",
    initial_value double precision,
    "number" integer NOT NULL,
    balance integer
)


ALTER TABLE bluebank.account
    OWNER to postgres;

INSERT INTO bluebank.account OVERRIDING SYSTEM VALUE VALUES (11, 'yourOtherValue', 12555, 6547, 47);


--
-- TOC entry 2944 (class 0 OID 0)
-- Dependencies: 201
-- Name: account_id_seq; Type: SEQUENCE SET; Schema: bluebank; Owner: postgres
--

SELECT pg_catalog.setval('bluebank.account_id_seq', 11, true);


-- Completed on 2021-11-25 21:02:32

--
-- PostgreSQL database dump complete
--

