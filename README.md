[![Build Status](https://www.travis-ci.com/MaxieMerge/bug-free-invention.svg?branch=main)](https://www.travis-ci.com/MaxieMerge/bug-free-invention)

# bug-free-invention
What could possibly go wrong?

## Running the project
To begin running the project:
 - `cd` into the root directory of the project
 - Run `node node/app.js`
 - The terminal window will start running the node endpoint, do not close this.
 - In intellij, run the springboot project in the java directory.
 - Navigate to `localhost:6555`

## Halt the project
Closing the project is very simple:
  - Either press ^C on the terminal window, or simply close it
  - Stop the java project in intellij

# Testing
Testing for this project is likley to evolve over time with new testing avenues being added as deemed nessessary. When this happens the readme will be updated with new testing information.

## Manual Tests
To run the unit tests locally, all you'll need to do it run `mvn test -B` will your terminal is pointed at `/JavaDirectory/`. This should be done before a PR is made.

## Travis CI
Travis is the automated unit testing pipeline that has been integrated into the repository. When any push or pull request has been made to the repo, travis will run the full suit of unit testing on the branch to ensure that it preforms as required. Every branch should contain a `.traivs.yml` file on the root directory of the project and should look like this:

```language: java
jdk: openjdk15

cache:
  directories: $HOME/.m2

before_install:
  - cd JavaDirectory/
```
If for some reason you've lost your travis file, just make a new one in the root (ie. the same location as the `package.json`) of the project and copy the above into it. Without this file, traivs will not run.

Once travis has run it's tests and they have all passed, the pull request will be good for review. If any of the tests fail, you will be required to inspect the travis page at [travis.com](https://travis-ci.com/github/MaxieMerge/bug-free-invention) and fix the erroring tests before it can be reviewed.

# Endpoints
TO document our backend endpoints on the Java side we have self documenting API's. The API Documnetation is available at our swagger [API Documentation](http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/). Only available when running the application.
TODO
