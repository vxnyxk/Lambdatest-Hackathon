# TestNG Project

## Overview
This project is a TestNG-based testing framework designed for automated testing of web applications. It utilizes Maven for dependency management and build processes.

## Directory Structure
The project follows a standard Maven directory structure:

```
TestNGProject
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── App.java
│   │   └── resources
│   │       └── application.properties
│   ├── test
│       ├── java
│       │   └── com
│       │       └── example
│       │           └── AppTest.java
│       └── resources
│           └── testng.xml
├── pom.xml
└── README.md
```

## Setup Instructions
1. **Clone the Repository**
   ```bash
   git clone <repository-url>
   cd TestNGProject
   ```

2. **Install Maven**
   Ensure that Maven is installed on your machine. You can download it from [Maven's official website](https://maven.apache.org/download.cgi).

3. **Build the Project**
   Run the following command to build the project and download the necessary dependencies:
   ```bash
   mvn clean install
   ```

4. **Run Tests**
   To execute the tests, use the following command:
   ```bash
   mvn test
   ```

## Usage
- The `testng.xml` file defines the test suite and the test classes to be executed.
- Test classes are located in the `src/test/java` directory.
- Reports will be generated in the `reports/` directory after test execution.

## Additional Files
- **pom.xml**: Maven configuration file for managing dependencies and build settings.
- **testng.xml**: Configuration file for TestNG test suites.
- **requirements/credentials.properties**: Contains configuration properties, such as credentials needed for tests.
- **src/main/java/pages/**: Contains page object classes for interacting with the application.
- **src/test/java/tests/**: Contains test classes for verifying application functionality.
- **src/test/java/utils/**: Contains utility classes for test setup and configuration management.

## Conclusion
This project provides a structured approach to automated testing using TestNG and Maven, making it easier to manage and execute tests efficiently.