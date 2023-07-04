# building project
I create my resources for the customer, order, product, stock, and product order,
then make the relationship between them. I've added a controller,DTO, models, repository, and services to each one. 
I use the JWT token to ensure that the user (customer) is authorized.
___
# All method

|HTTP MEHTOD|URL PATH|STATUS CODE | DESCRPITON|
|-----|-----|-----|-----|
|POST|http://localhost:8085/api/v1/auth|200 OK|Login using JWT authntioction|
|POST|localhost:8085/api/customers|201 CREATED| add new customer|
|GET|localhost:8085/api/customers/{id}|200 OK| get customer by id|
|GET|localhost:8085/api/customers/|200 OK| get all customer |
|PUT|localhost:8085/api/customers/|201 CREATED| update customer by id|
|DELETE|localhost:8085/api/customers/{id}|202 ACCEPTED| delete customer by id|
|POST|localhost:8085/api/products|201 CREATED| add new product|
|GET|localhost:8085/api/products/{id}|200 ok| get product by id|
|GET|localhost:8085/api/products/|200 OK| get all products |
|PUT|localhost:8085/api/products/|201 CREATED| update product by id|
|DELETE|localhost:8085/api/products/{id}|202 ACCEPTED| delete products by id|
|POST|localhost:8085/api/orders|201 CREATED| add new order|
|GET|localhost:8085/api/orders/{id}|200 OK| get order by id|
|GET|localhost:8085/api/orders/|200 OK| get all order |
|PUT|localhost:8085/api/orders/|201 CREATED| update order by id|
|DELETE|localhost:8085/api/orders/{id}|202 ACCEPTED| delete order by id|
|POST|localhost:8085/api/stocks|201 CREATED| add new stock|
|GET|localhost:8085/api/stocks/{id}|200 OK| get stock by id|
|GET|localhost:8085/api/stocks/|200 OK| get all stocks |
|PUT|localhost:8085/api/stocks/|201 CREATED| update stock by id|
|DELETE|localhost:8085/api/stocks/{id}|202 ACCEPTED| delete stock by id|
|POST|localhost:8085/api/productorder|201 CREATED| add new product order|
|GET|localhost:8085/api/productorder|200 OK| get all product order|
___
# postman testing JSON File:
order-managment.postman_collection.json
# Build docker image



