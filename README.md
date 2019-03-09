# vw-test

This project is the solution for the Volkswagen test challenge

This project is composed of 2 containers:

Marcelo Mysql Container, that runs an empty mysql image to persist measures data.
Marcelo VW Test Container, that runs a SpringBoot application that reads measures information from UCI repository (http://archive.ics.uci.edu/ml/datasets/air+quality)
as a CSV file. Then it parses the file, validates the rows and saves all measures in the Mysql instance.

The Marcelo VW Test Container also exposes a webserver for showing data from the database.




