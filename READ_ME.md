# SimpleCrudTemplate
This is backend side of simple crud template project. Frontend side is [here](https://github.com/Badziohub/simple-crud-template-front/tree/master).

## Run requirements
  - docker
  - Java 17

## Pre-run

Run the following docker command to generate docker container of postgres for projects database.

` docker run --name simplecrud -p 5432:5432 -e POSTGRES_PASSWORD=simplecrud -e POSTGRES_USER=simplecrud -d postgres:13.2  `

## Running Backend

Run created docker container, and then application either within IDE of your choice or through javac command in CLI. 

# Running Front

## Run requirements
  - Node.js
  - npm package manager 

## Running Frontend

Either with project opened in IDE of your choice or through CLI (you have to be in main project directory) run following command:

`npm start`

# Then head to you browser to URI 'localhost:4200' and enjoy.
