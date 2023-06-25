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
sh deploy-dev-db.sh
```

this will help you to install the database of pg and redis
**please note: By 5.21, should please re-deploy the database after rm the dev containers and images**

```docker 
docker rm -f dmparts-db-dev
docker rmi  dmparts-db-dev
```

then re-import the data by follow Sample Data

### postgres db backup and restore

back up from dev environment; restore to local db

```
Backup: pg_dump -h localhost -p 5432 -U dmparts partstrading > pg-back-up.dmp
Restore: psql -h localhost -U dmparts -d partstrading -f pg-back-up.dmp
```

### Migration

Run this command on root path of this project

```sh
./gradlew flywayMigrate
```

### Init Sample Data

Make sure you are at master branch

```bash
psql --host=127.0.0.1 --port 5434 -U dmparts -d partstrading -W < env-build-scripts/master-data/20190808_DEV_DB.sql

password: r0ys1ngh4m
```

System init data put in the parts-trading/seed-data, as the sql script file each env.

### Boot Application

```bash
./gradlew bootRun
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

## Debug with frontend

### &nbsp;&nbsp;1. Deploy database locally

### &nbsp;&nbsp;2. Run database migration

### &nbsp;&nbsp;3. Import sample data

psql --host=127.0.0.1 --port 5434 -U dmparts -d partstrading -W < env-build-scripts/master-data/20190808_DEV_DB.sql

### &nbsp;&nbsp;4. Get JWT from ADCC environment && Set local redis

1. Visit https://genuineprodev-dealer.mercedes-benz.com/#/dashboard/dealer?_k=fz8btb and login using account given
   at https://itsc-confluence.daimler.com/confluence/display/PAR/Dev+Environment

2. Copy value of BUSCAR-PRODUCTION-STORE from developer console of Chrome, in Application -> Storage -> Session Storage

3. Visit https://jwt.io/ and paste the `token` value from step 2 into `Encoded` box, and we can find `payload` on the
   right side of the page

4. Run `docker ps` and find the redis docker instance

5. Run `docker exec -it dmparts-redis-dev /bin/bash`

6. Run `redis-cli`

7. Run `SET Authorization-[$jti] "\"[$token]\""`.Please replace `[$jti]` with content you can find at step 3
   labeled `jti`, and replace `[$token]` with the token mentioned on step 3

8. And you are done

### 5. Boot it up

```bash
./gradlew bootRun
```

## API Map

### swagger url

[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

### About the authorizations

#### Create token

##### isp

please use the `/isps/account/authorization` of the `isp-account-controller` by use the isp username and password to
post the authorization token

##### dealer

There are two ways to get the token of dealer:

- use the never expired token of TEST01

```redis
redis-cli -h 127.0.0.1 -p 6380
SET Authorization-615107b6-bd41-4032-8e2b-44d426c0513d "\"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJURVNUMDEiLCJyb2xlIjoiZGVhbGVyIiwiY3JlYXRlZCI6MTUyMDE2NDY4NzIwNSwiaXNTU08iOmZhbHNlLCJleHAiOjE3NzkzNjQ2ODcsIndvcmQiOiJkRHdBYyIsInZhbGlkYXRpb24iOjE0OTk0MTU0OTQzOTksImp0aSI6IjYxNTEwN2I2LWJkNDEtNDAzMi04ZTJiLTQ0ZDQyNmMwNTEzZCJ9.JlsRCMCae0fe0QE2tI5YpN4Rj4oOp-jABMMHTNCazSmuDNT98yUENFs67SLhGmCHCHLzZzmTBL8SYbuidm0lSg\""
```

- use the dev web to get the token from the session storage.   
  and use the [https://jwt.io/](https://jwt.io/) to get the jti  
  the key of the token in the redis is `Authorization-$jti`.

```redis
redis-cli -h 127.0.0.1 -p 6380
SET Authorization-$jti "\"$token\""
```

**The old login api (username and password) should not be recommended, this api will be deleted as soon as possible.**

### the usual sample data

#### Basic data

- ISP： itest
- Dealer: TEST01
- PartNo: A0000002800/A0000000300

#### 业务数据

There are two ways to get the data to make data for using swagger to test api

- use the dev website to get the data of sample
- use the sample data
    - enquiry
    ```json
    {
       "enquiryRows": [
          {
             "partsCount": 10,
             "partNo": "A0000002800",
             "vin": "",
             "partName": "",
             "help": {}
          }
       ],
       "biddingTime": "1440",
       "logisticsStatus": "DEALER_PAY",
       "demandStatus": "NORMAL"
    }
    ```
    - qutation the enquiryId should be changed by GET /dealers/enquiries/todo
    ```json
    {
       "enquiryId": "$enquiryId",
       "leadTime": "1440",
       "remark": "",
       "quotationRows": [
          {
             "enquiryRowNo": 0,
             "partPrice": 2725.24,
             "quotedPartNo": "A0000002800",
             "quotedCount": "10"
          }
       ],
       "priceSummary": {
          "discount": 1,
          "reducePrice": 2725,
          "originalPrice": 27252.4,
          "discountPrice": 0.24,
          "taxPoint": 0.17,
          "tax": 0.04,
          "totalPriceWithTax": 0.28
       }
    }
    ```

