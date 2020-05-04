## About

#### This is a small app created  by Spiros Tzoras.

The main purpose is to showcase his programming flexibility and the knowledge of several tools and frameworks

This is always WIP (Work In Progress). New pieces of code will be added regularly.

This is a working, multi module, Spring Boot application. 

## Insights:

#### Rest Controller:

[Rest Controller](https://github.com/spirostz/spirosShowcase/blob/master/view/src/main/java/com/spiros/view/api/v1/UserController.java)

[MockMvc Test](https://github.com/spirostz/spirosShowcase/blob/master/view/src/test/java/com/spiros/view/api/v1/UserControllerTest.java)

#### API Documentation with Swagger

[Swagger Configuration](https://github.com/spirostz/spirosShowcase/blob/master/view/src/main/java/com/spiros/view/configuration/SwaggerConfiguration.java)

[Swagger info in Model](https://github.com/spirostz/spirosShowcase/blob/master/view/src/main/java/com/spiros/view/model/UserVo.java)

#### Hibernate, JPA, Repo:

[Entity](https://github.com/spirostz/spirosShowcase/blob/master/persistence/src/main/java/com/spiros/persistance/entity/UserEntity.java)

[Repo](https://github.com/spirostz/spirosShowcase/blob/master/persistence/src/main/java/com/spiros/persistance/repository/UserRepo.java)

#### Flyway DB migration tool:

[SQL version files](https://github.com/spirostz/spirosShowcase/tree/master/persistence/src/main/resources/db/migration)

#### Transforming Entities and Visual models to Transfer Objects

[EntityTransformer](https://github.com/spirostz/spirosShowcase/blob/master/persistence/src/main/java/com/spiros/persistance/transformer/UserTransformer.java)

[Visual Transformer](https://github.com/spirostz/spirosShowcase/blob/master/view/src/main/java/com/spiros/view/transformer/UserVoTransformer.java)
