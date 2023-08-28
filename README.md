# New github repo: XXX

# Developer Guide

This guide is an instruction to set up development environment to integration project.

## Prerequisite

### For Mac OS X

* Command Line Developer Tools
* JDK 11

### Intellij Plugin

We adopted `lombok` to make Java code better.

Click [Here](https://github.com/mplushnikov/lombok-intellij-plugin) to learn how to install this plugin for Intellij
IDEA.

## Source code

```sh
$ git clone XXX
```

## Infrastructure of dev env

### Setup Git Hook

Run following command, if you update pre-commit.sh script, you need run this command again.

```bash
sh ./scripts/git-hook-setup.sh
```

### Local Database

Run following command on master branch

```bash
docker search mysql
docker pull mysql
docker run  --name integration-mysql8 -p 13306:13306 -e MYSQL_ROOT_PASSWORD=123456 -d mysql
docker exec -it integration-mysql8 /bin/bash
mysql -u root -p
create database demo_mysql

```

The application will be running at port 8080.

## Build

```sh
$ ./gradlew build
```

## Test

```sh
$ ./gradlew test
```
