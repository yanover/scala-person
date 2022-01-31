# scala-personnes
A user management API


## Purpose of this project
The aim of this project is to extend my skills with the following stack: 

* Scala language
* Play framework
* Build process (docker)

## Build process
A `dockerfile` is declared at the root of the project. It is used to create the image containing Scala, Play and our project's files.

The **docker-compose.yml** file declares two containers:
* The one created from our Dockerfile
* A Mysql Database

## Configuration
// In progress