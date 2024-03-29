
# Turkish Citizenship Verification Service

There are **three services** to verify Turkish citizenship.

  - Simple Verification --> (/simple-verification)
  - Detailed Verification --> (/detailed-verification)
  - Foreigner Verification --> (/foreigner-verification)

## Purpose

The purpose of this project is to provide **REST** service.

This service uses the services provided by ***Republic of Turkey Ministry of Interior General Directorate of Population and Citizenship Affairs*** on the backside. nvi.gov.tr services use **SOAP**.

-   [https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx](https://tckimlik.nvi.gov.tr/Service/KPSPublic.asmx)
-   [https://tckimlik.nvi.gov.tr/Service/KPSPublicV2.asmx](https://tckimlik.nvi.gov.tr/Service/KPSPublicV2.asmx)
-   [https://tckimlik.nvi.gov.tr/Service/KPSPublicYabanciDogrula.asmx](https://tckimlik.nvi.gov.tr/Service/KPSPublicYabanciDogrula.asmx)

## Run the Application

Navigate to the root of the project. For building the project using command line, run below command :

``` mvn clean install```

Run service in command line. Navigate to *target* directory. 

``` java -jar turkish-citizenship-verification.jar ```

## REST Endpoints
The following REST endpoints are available:

| HTTP Methods | Path                    | Description                                    | Response |
|--------------|-------------------------|------------------------------------------------|----------|
| POST         | /simple-verification    | Simple Verificaiton for Turkish Citizenship    | boolean  |
| POST         | /detailed-verification  | Detailed Verificaiton for Turkish Citizenship  | boolean  |
| POST         | /foreigner-verification | Foreigner Verificaiton for Turkish Citizenship | boolean  |

 ### Simple Verification Example Request

Request URL

```https://trverification.omerfarukgenc.com.tr/simple-verification```

JSON

```json
{
  "identityNo": 11111111111,
  "name": "KÂZIM",
  "surname": "KARABEKİR",
  "birthYear": 1882,
}
```

cURL Request

    curl -X POST "https://trverification.omerfarukgenc.com.tr/simple-verification" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"birthYear\": 1882, \"identityNo\": 11111111111, \"name\": \"KÂZIM\", \"surname\": \"KARABEKİR\"}"

Response 

```
false
```

 ### Detailed Verification Example Request
 
Request URL

```https://trverification.omerfarukgenc.com.tr/detailed-verification```

JSON

```json
{
  "identityNo": 11111111111,
  "name": "MUSTAFA FEVZİ",
  "surname": "ÇAKMAK",
  "hasNotSurname": false,
  "birthDay": 12,
  "hasNotDayOfBirth": false,
  "birthMonth": 1,
  "hasNotMonthOfBirth": false,
  "birthYear": 1876,
  "serialCode": null,
  "serialNumber": null,
  "documentNo": "M99F11276"
}
```

cURL Request

```
curl -X POST "https://trverification.omerfarukgenc.com.tr/detailed-verification" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"identityNo\": 11111111111, \"name\": \"MUSTAFA FEVZİ\", \"surname\": \"ÇAKMAK\", \"hasNotSurname\": false, \"birthDay\": 12, \"hasNotDayOfBirth\": false, \"birthMonth\": 1, \"hasNotMonthOfBirth\": false, \"birthYear\": 1876, \"serialCode\": null, \"serialNumber\": null, \"documentNo\": \"M99F11276\"}"
```

Response 

```
false
```

 ### Foreigner Verification Example Request
 
Request URL

```https://trverification.omerfarukgenc.com.tr/foreigner-verification```

JSON

```json
{
  "identityNo": 99999999999,
  "name": "MUSA",
  "surname": "ESKENAZİ",
  "birthDay": 1,
  "birthMonth": 1,
  "birthYear": 1855
}
```

cURL Request

```
curl -X POST "https://trverification.omerfarukgenc.com.tr/foreigner-verification" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"identityNo\": 99999999999, \"name\": \"MUSA\", \"surname\": \"ESKENAZİ\", \"birthDay\": 1, \"birthMonth\": 1, \"birthYear\": 1855}"
```

Response 

```
false
```
### Error Handling

Request URL

```https://trverification.omerfarukgenc.com.tr/simple-verification```

JSON

```json
{
  "identityNo": 11111111111,
  "birthYear": 1882,
}
```

cURL Request

```
curl -X POST "https://trverification.omerfarukgenc.com.tr/simple-verification" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"birthYear\": 1882, \"identityNo\": 11111111111}"
```

Response 

```json
{
  "status": "BAD_REQUEST",
  "time": "2020-08-08T16:08:55.348",
  "errorList": [
    "Name cannot be blank!",
    "Surname cannot be blank!"
  ]
}
```
### Swagger UI

[https://trverification.omerfarukgenc.com.tr/swagger-ui.html](https://trverification.omerfarukgenc.com.tr/swagger-ui.html)

### Todo

 - [ ] Will be add new verification services for other citizenships. (e.g : british.citizenshipverification.online)

License
----

Apache License 2.0
