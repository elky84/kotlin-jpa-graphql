# kotlin-jpa-graphql

[![Website](https://img.shields.io/website-up-down-green-red/http/shields.io.svg?label=elky-essay)](https://elky84.github.io)
![Made with](https://img.shields.io/badge/made%20with-Kotlin-brightgreen.svg)
![Made with](https://img.shields.io/badge/made%20with-SpringBoot3-blue.svg)
![Made with](https://img.shields.io/badge/made%20with-MySQL-red.svg)

![GitHub forks](https://img.shields.io/github/forks/elky84/kotlin-jpa-graphql.svg?style=social&label=Fork)
![GitHub stars](https://img.shields.io/github/stars/elky84/kotlin-jpa-graphql.svg?style=social&label=Stars)
![GitHub watchers](https://img.shields.io/github/watchers/elky84/kotlin-jpa-graphql.svg?style=social&label=Watch)
![GitHub followers](https://img.shields.io/github/followers/elky84.svg?style=social&label=Follow)

![GitHub](https://img.shields.io/github/license/mashape/apistatus.svg)
![GitHub repo size in bytes](https://img.shields.io/github/repo-size/elky84/kotlin-jpa-graphql.svg)
![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/elky84/kotlin-jpa-graphql.svg)

# kotlin-jpa-graphql

## 소개
* Kotlin + Spring Boot + JPA 예제입니다.
* DB는 PostgreSQL을 사용했습니다.
* GraphQL 지원을 보여주는 간단한 기능 예제입니다.

## 설정
* application.properties 혹은 가동하실 환경에 맞는 application-{환경}.properties 파일을 구성하시고, DB 설정을 하시면 됩니다.
    * 저의 경우에는 포트가 겹쳐 15432, 그리고 아이디 비번을 아래 SQL 스크립트에 맞춰서 작성해두었습니다. 적절히 편집해서 사용하시면 됩니다.

## PostgreSQL 계정 생성

```sql
CREATE DATABASE member;

CREATE USER local WITH PASSWORD 'local1234';

ALTER ROLE local CREATEDB REPLICATION;

GRANT ALL PRIVILEGES ON DATABASE member TO local;

GRANT ALL ON SCHEMA PUBLIC TO local;

GRANT ALL ON DATABASE member to local with grant OPTION;

GRANT ALL ON DATABASE member TO local;

ALTER DATABASE member OWNER TO LOCAL;
```