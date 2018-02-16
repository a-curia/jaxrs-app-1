JAX-RS - Web API Demo

 

This demo uses PostgreSQL and also connect to external endpoint.

 

Endpoints:

| Scope                                                                                                                    | Verb | Endpoint                                                                 |
|--------------------------------------------------------------------------------------------------------------------------|------|--------------------------------------------------------------------------|
| health check                                                                                                             | GET  | http://localhost:8080/JaxRS-ApiDemo/webapi/test                          |
| external endpoint get access                                                                                             | GET  | http://localhost:8080/JaxRS-ApiDemo/webapi/mydata/external-data          |
|                                                                                                                          | POST | i do not have endpoint                                                   |
| will access the external url getting Posts and convert those Posts to Product and store into PRODUCT table on postgresql | GET  | http://localhost:8080/JaxRS-ApiDemo/webapi/products/posts-to-products-db |

 
