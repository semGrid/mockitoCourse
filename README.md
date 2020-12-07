

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [GIT](https://git-scm.com/)

## Running the application locally

To start the application run all microservices one by one. There are several ways to run them on your local machine. 
One way is to execute the `main` method in the `*.*Application` classes from your IDE.

####Run Discovery Server first:
`com.griddynamics.discoveryserver.DiscoveryServerApplication::main`

####Run all microservices:

- **Banks Information API**
`com.griddynamics.banksinfo.BanksInformationApplication::main`

- **Currency Conversion API**
`com.griddynamics.conversion.CurrencyConversionApplication::main`

- **Money Transfer API** 
`com.griddynamics.transfer.MoneyTransferApplication::main`

Second is using maven wrapper (or just maven), run all the projects with `./mvnw` in separate terminal windows:

**Discovery Server:**
```shell
./mvnw -pl discoveryserver spring-boot:run
```

Run all microservices:

- **Banks Information API** 
```shell
./mvnw -pl banks-information-api spring-boot:run
```

- **Currency Conversion API** 
```shell
./mvnw -pl currency-conversion-api spring-boot:run
```

- **Money Transfer API** 
```shell
./mvnw -pl money-transfer-api spring-boot:run
```

## Architecture

Our sample microservices-based system consists of the following modules:
- **discoveryserver** - a module ...
- **banks-information-api** - an API that provides client bank information such as bank currency and income transactions commission percentage by bank code
- **currency-conversion-api** - an API responsible for transfer amount conversion to client bank account currency by predefined rates
- **money-transfer-api** - main API, perform money transactions to client and return sent amount converted to client bank currency and after commission deduction

The following picture illustrates the architecture described above.

<img src="https://github.com/griddynamics/gridu-qa-service-testing-mocks/blob/master/.img/full_application_structure.png" title="Architecture"><br/>


## Documentation
Each service has their own `Swagger`, you can access it, find available endpoints and try to execute some requests using links:

- Currency Conversion API - `http://localhost:9091/swagger-ui.html`
- Banks Information API - `http://localhost:9092/swagger-ui.html`
- Money Transfer API - `http://localhost:9093/swagger-ui.html` 

## Branches

