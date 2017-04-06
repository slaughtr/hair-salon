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
-- Name: appointments; Type: TABLE; Schema: public; Owner: Er
--

CREATE TABLE appointments (
    id integer NOT NULL,
    appointment_date date,
    appointment_time time without time zone,
    client_id integer,
    stylist_id integer,
    shop_id integer
);


ALTER TABLE appointments OWNER TO "Er";

--
-- Name: appointments_id_seq; Type: SEQUENCE; Schema: public; Owner: Er
--

CREATE SEQUENCE appointments_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE appointments_id_seq OWNER TO "Er";

--
-- Name: appointments_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Er
--

ALTER SEQUENCE appointments_id_seq OWNED BY appointments.id;


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
-- Name: products; Type: TABLE; Schema: public; Owner: Er
--

CREATE TABLE products (
    id integer NOT NULL,
    name character varying,
    brand character varying,
    size real,
    price real,
    shop_id integer
);


ALTER TABLE products OWNER TO "Er";

--
-- Name: products_id_seq; Type: SEQUENCE; Schema: public; Owner: Er
--

CREATE SEQUENCE products_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE products_id_seq OWNER TO "Er";

--
-- Name: products_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Er
--

ALTER SEQUENCE products_id_seq OWNED BY products.id;


--
-- Name: shops; Type: TABLE; Schema: public; Owner: Er
--

CREATE TABLE shops (
    id integer NOT NULL,
    name character varying,
    location character varying
);


ALTER TABLE shops OWNER TO "Er";

--
-- Name: shops_id_seq; Type: SEQUENCE; Schema: public; Owner: Er
--

CREATE SEQUENCE shops_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE shops_id_seq OWNER TO "Er";

--
-- Name: shops_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Er
--

ALTER SEQUENCE shops_id_seq OWNED BY shops.id;


--
-- Name: styles; Type: TABLE; Schema: public; Owner: Er
--

CREATE TABLE styles (
    id integer NOT NULL,
    name character varying,
    price real
);


ALTER TABLE styles OWNER TO "Er";

--
-- Name: styles_id_seq; Type: SEQUENCE; Schema: public; Owner: Er
--

CREATE SEQUENCE styles_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE styles_id_seq OWNER TO "Er";

--
-- Name: styles_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: Er
--

ALTER SEQUENCE styles_id_seq OWNED BY styles.id;


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
-- Name: appointments id; Type: DEFAULT; Schema: public; Owner: Er
--

ALTER TABLE ONLY appointments ALTER COLUMN id SET DEFAULT nextval('appointments_id_seq'::regclass);


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: Er
--

ALTER TABLE ONLY clients ALTER COLUMN id SET DEFAULT nextval('clients_id_seq'::regclass);


--
-- Name: products id; Type: DEFAULT; Schema: public; Owner: Er
--

ALTER TABLE ONLY products ALTER COLUMN id SET DEFAULT nextval('products_id_seq'::regclass);


--
-- Name: shops id; Type: DEFAULT; Schema: public; Owner: Er
--

ALTER TABLE ONLY shops ALTER COLUMN id SET DEFAULT nextval('shops_id_seq'::regclass);


--
-- Name: styles id; Type: DEFAULT; Schema: public; Owner: Er
--

ALTER TABLE ONLY styles ALTER COLUMN id SET DEFAULT nextval('styles_id_seq'::regclass);


--
-- Name: stylists id; Type: DEFAULT; Schema: public; Owner: Er
--

ALTER TABLE ONLY stylists ALTER COLUMN id SET DEFAULT nextval('stylists_id_seq'::regclass);


--
-- Data for Name: appointments; Type: TABLE DATA; Schema: public; Owner: Er
--

COPY appointments (id, appointment_date, appointment_time, client_id, stylist_id, shop_id) FROM stdin;
\.


--
-- Name: appointments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Er
--

SELECT pg_catalog.setval('appointments_id_seq', 1, false);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: Er
--

COPY clients (id, name, appointment_date, appointment_time, stylist_id) FROM stdin;
44	Joe Schmo	2017-04-06	01:30:00	26
45	Joe Schmo	2017-04-06	01:30:00	26
46	Terry The Tank	2017-04-16	03:10:00	26
47	Nameso Are Hardo	2017-04-26	06:30:00	24
48	Thereaseaseasea	2017-05-06	13:00:00	27
51	client name	2018-01-01	13:00:00	26
49	Mememe Meme	2017-04-06	19:30:00	27
52	Test Client	2019-03-02	14:00:00	26
53	Asdf Fdsaerson	2018-12-30	12:45:00	24
54	Joe Schmo	2017-04-06	01:30:00	33
55	Joe Schmo	2017-04-06	01:30:00	33
56	Terry The Tank	2017-04-16	03:10:00	33
57	Nameso Are Hardo	2017-04-26	06:30:00	34
58	Thereaseaseasea	2017-05-06	05:00:00	34
59	Mememe Meme	2017-03-06	04:30:00	34
60	Joe Schmo	2017-04-06	01:30:00	35
61	Joe Schmo	2017-04-06	01:30:00	35
62	Terry The Tank	2017-04-16	03:10:00	35
63	Nameso Are Hardo	2017-04-26	06:30:00	36
64	Thereaseaseasea	2017-05-06	05:00:00	36
65	Mememe Meme	2017-03-06	04:30:00	36
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Er
--

SELECT pg_catalog.setval('clients_id_seq', 65, true);


--
-- Data for Name: products; Type: TABLE DATA; Schema: public; Owner: Er
--

COPY products (id, name, brand, size, price, shop_id) FROM stdin;
\.


--
-- Name: products_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Er
--

SELECT pg_catalog.setval('products_id_seq', 1, false);


--
-- Data for Name: shops; Type: TABLE DATA; Schema: public; Owner: Er
--

COPY shops (id, name, location) FROM stdin;
\.


--
-- Name: shops_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Er
--

SELECT pg_catalog.setval('shops_id_seq', 1, false);


--
-- Data for Name: styles; Type: TABLE DATA; Schema: public; Owner: Er
--

COPY styles (id, name, price) FROM stdin;
\.


--
-- Name: styles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Er
--

SELECT pg_catalog.setval('styles_id_seq', 1, false);


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: Er
--

COPY stylists (id, name, specialty) FROM stdin;
24	Stylist name	Stylist specialty
25	Stylist name	Stylist specialty
32	Stylist name	Stylist specialty
33	Judy	Judgement
34	Joe Mathis	Justics
35	Judy	Judgement
36	Joe Mathis	Justics
\.


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: Er
--

SELECT pg_catalog.setval('stylists_id_seq', 36, true);


--
-- Name: appointments appointments_pkey; Type: CONSTRAINT; Schema: public; Owner: Er
--

ALTER TABLE ONLY appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (id);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: Er
--

ALTER TABLE ONLY clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: public; Owner: Er
--

ALTER TABLE ONLY products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: shops shops_pkey; Type: CONSTRAINT; Schema: public; Owner: Er
--

ALTER TABLE ONLY shops
    ADD CONSTRAINT shops_pkey PRIMARY KEY (id);


--
-- Name: styles styles_pkey; Type: CONSTRAINT; Schema: public; Owner: Er
--

ALTER TABLE ONLY styles
    ADD CONSTRAINT styles_pkey PRIMARY KEY (id);


--
-- Name: stylists stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: Er
--

ALTER TABLE ONLY stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

