# blog-middleware
A middleware to provide data to web app

Middleware service providing REST API, and sending message to RabbitMQ queues based on route, request method and request body.
Spring Security will be used to authenticate user and provide JWT(Java Web Token).
JWT wll be verified everytime secured route is invoked.
Message will contain route information (path, method) and request body (object as JSON string).
This service send a message to RabbitMQ queue and waits for reponse to provide data to web application as JSON string.

TODO
1. implement Spring Security
2. provide JWT and verify for secured routes
