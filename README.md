## Sample spring boot application template using VAVR
1. [VAVR](http://vavr.io/) is functional programming library for Java  

2. Spring boot does not need any introduction

The aim of this seed project is to provide a simple template using OOP based Spring MVC and functional constructs from VAVR like Try, Either and Optional monads. We take a combined FP + OOP approach. 

> **Note:** The code is targeted to run only on JDK 11, if you want to try with earlier versions upto JDK 8 please remove the below line from `build.gradle`

```groovy
targetCompatibility = 1.11
```

#### Steps to run

1. Clone the repo to your local
2. Change to root folder
3. Run below command
`./gradlew clean bootRun`
4. The application will start listening on port 8080.
5. Execute below CURL commands to test the APIs
```bash
curl -X GET \
  http://localhost:8080/employees \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: e815e9ae-3147-49a2-8bee-f58861633eaf' \
  -H 'cache-control: no-cache'

curl -X GET \
  http://localhost:8080/employees/1 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 7d005679-fbb8-4a3f-b052-b6e44a47cd81' \
  -H 'cache-control: no-cache'  

curl -X POST \
  http://localhost:8080/employees \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 1c1c3aec-8def-4c1f-bd54-76e8f7c9cdad' \
  -H 'cache-control: no-cache' \
  -d '{
	"name":"Ramasubramanian",
	"designation": "DEVELOPER",
	"salary": 100000.00
}'

curl -X POST \
  http://localhost:8080/employees \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 30712a11-8e78-4abf-8958-63d9ed897f67' \
  -H 'cache-control: no-cache' \
  -d '{
	"name":"Ram",
	"designation": "TESTER",
	"salary": 100000.00
}'
```