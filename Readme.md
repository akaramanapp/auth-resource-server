## Using MySQL on Docker

> docker run --name some-mysql -h localhost -p 3306:3306 -e MYSQL_ROOT_PASSWORD=sifre -d mysql

## Sample users and roles (run sql command)

> ./iniital_sql.sql

## Data Source Configuration

application.yml file in auth-server

```
  datasource:
    driverClassName: com.mysql.cj.jdbc.Driver
    url: "jdbc:mysql://localhost:3306/USERSERVICE?autoreconnect=true"
    password: "sifre"
    username: "root"
```
