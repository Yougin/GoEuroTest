# GoEuroTest 

## Introduction
GoEuroTest is a test assignment application. It runs from a command line (see **Quick start** unit) taking city names as parameters in order to get a list of destination points which should be parsed, processed and stored in the file.

Application was mostly created using TDD approach. For this purpose the Dependecy Injection architectural pattern is used. Dagger or similar DI libraries are avoided deliberately.

The only Network connection failure is handled on the moment of writing. 

Retrofit library is used for network operations. 
Nullable jetbrains library to reduce the amount of null checks.

Mockito, JUnit 4 and AssertJ for unit testing purposes.

## Get project
git clone https://github.com/Yougin/GoEuroTest.git

## Quick Start
There are two ways to run the application:
  1. Use the GoEuroTest.jar executable jar: `java -jar GoEuroTest.jar <city_1> <city_2> <city_3>`
  2. Compile the application using `./gradlew distZip` in order to get an archive with all jars and scripts to run.
