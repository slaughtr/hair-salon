# _hair-salon_

#### _hair-salon, 03-31-2017_

#### By _**Dallas Slaughter**_

## Description
_This is an app for hair salon owners. It allows the owner to create, update, or delete stylists and clients from their business. They can perform many essential tasks for both stylists and clients, such as changing names and appointments, specialties of stylists, firing stylists, or deleting clients._


## Setup/Installation Requirements

* _Clone the repository_
* _DB setup: in terminal, run 'psql'
then, 'CREATE DATABASE hair_salon;'
then, '\c hair_salon;'
then, 'CREATE TABLE clients (id serial PRIMARY KEY, name varchar, appointment_date date, appointment_time time, stylist_id int)'
then, 'CREATE TABLE stylists (id serial PRIMARY KEY, name varchar, specialty varchar)'
* _Run the command 'gradle run'_
* _Open browser and go to localhost:4567_


## Technologies Used

_Java, Spark, Velocity Template Engine, HTML, CSS, gradle_



### License

Copyright (c) 2017 **_slaughtr_**

This software is licensed under the MIT license.
