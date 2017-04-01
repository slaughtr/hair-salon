--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: Er
--

CREATE TABLE clients (
    id integer NOT NULL,
    name character varying,
    appointment_date date,
    appointment_time time without time zone,
    stylist_id integer
);


ALTER TABLE clients OWNER TO "Er";

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: Er
--

CREATE SEQUENCE clients_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE clients_id_seq OWNER TO "Er";

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Er
--

ALTER SEQUENCE clients_id_seq OWNED BY clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: Er
--

CREATE TABLE stylists (
    id integer NOT NULL,
    name character varying,
    specialty character varying
);


ALTER TABLE stylists OWNER TO "Er";

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: Er
--

CREATE SEQUENCE stylists_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE stylists_id_seq OWNER TO "Er";

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Er
--

ALTER SEQUENCE stylists_id_seq OWNED BY stylists.id;


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: Er
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: stylists id; Type: DEFAULT; Schema: public; Owner: Er
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: Er
--

COPY clients (id, name, appointment_date, appointment_time, stylist_id) FROM stdin;
44	Joe Schmo	2017-04-06	01:30:00	26
45	Joe Schmo	2017-04-06	01:30:00	26
46	Terry The Tank	2017-04-16	03:10:00	26
47	Nameso Are Hardo	2017-04-26	06:30:00	24
49	Mememe Meme	2017-03-06	04:30:00	26
48	Thereaseaseasea	2017-05-06	13:00:00	27
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Er
--

SELECT pg_catalog.setval('clients_id_seq', 49, true);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: Er
--

COPY stylists (id, name, specialty) FROM stdin;
24	Stylist name	Stylist specialty
25	Stylist name	Stylist specialty
26	Judy	Judgement
27	Joe Mathis	Justics
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Er
--

SELECT pg_catalog.setval('stylists_id_seq', 27, true);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: Er
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: Er
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

