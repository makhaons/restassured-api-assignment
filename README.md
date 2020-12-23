`Introduction`
-------------

Api automation assignment project for Backbase.

`Running Tests`
--------------

 * Use command `mvn clean verify` within the root project path.
   This will run your tests with default settings

 * By default cucumber will execute every scenario except ones with `@ignore` you can also override
   this behaviour

`Reporting`
-----------

  * After the test execution you can find generated HTML report in `/target/site/serenity` folder

`Requirements`
-------------

You need to check Apache Maven & Java 8 is already installed on your computer.

`Technologies`
------------

- Java 8
- Maven
- Serenity
- RestAssured
- Cucumber