# ☕🚀 Java Basic Skeleton: Save the boilerplate in your new projects

<img src="http://codely.tv/wp-content/uploads/2016/05/cropped-logo-codelyTV.png" align="left" width="192px" height="192px"/>
<img align="left" width="0" height="192px" hspace="10"/>

> ⚡ Start your Java projects as fast as possible

[![CodelyTV](https://img.shields.io/badge/codely-tv-green.svg?style=flat-square)](https://codely.tv)
[![Workflow Status](https://github.com/CodelyTV/java-basic-skeleton/workflows/Main%20Workflow/badge.svg)](https://github.com/CodelyTV/java-basic-skeleton/actions)

## ℹ️ Introduction

This is a repository intended to serve as a starting point if you want to bootstrap a Java project with JUnit and Gradle.

## 🏁 How To Start

1. Install Java 8: `brew cask install corretto8`
2. Set it as your default JVM: `export JAVA_HOME='/Library/Java/JavaVirtualMachines/amazon-corretto-8.jdk/Contents/Home'`
3. Clone this repository: `git clone https://github.com/CodelyTV/java-basic-skeleton`.
4. Execute some [Gradle lifecycle tasks](https://docs.gradle.org/current/userguide/java_plugin.html#lifecycle_tasks) in order to check everything is OK:
    1. Create [the project JAR](https://docs.gradle.org/current/userguide/java_plugin.html#sec:jar): `make build`
    2. Run the tests and plugins verification tasks: `make test`
5. Start developing!

## ☝️ How to update dependencies

* Gradle (current version: 5.6 - [releases](https://gradle.org/releases/)):
`./gradlew wrapper --gradle-version=5.6 --distribution-type=bin` or modifying the [gradle-wrapper.properties](gradle/wrapper/gradle-wrapper.properties#L3)
* JUnit (current version: 5.5.1 - [releases](https://junit.org/junit5/docs/snapshot/release-notes/index.html)):
[`build.gradle:11`](build.gradle#L11-L12)

## 💡 Related repositories

### ☕ Java

* 📂 [Java Basic Skeleton](https://github.com/CodelyTV/java-basic-skeleton)
* ⚛ [Java OOP Examples](https://github.com/CodelyTV/java-oop-examples)
* 🧱 [Java SOLID Examples](https://github.com/CodelyTV/java-solid-examples)
* 🥦 [Java DDD Example](https://github.com/CodelyTV/java-ddd-example)

### 🐘 PHP

* 📂 [PHP Basic Skeleton](https://github.com/CodelyTV/php-basic-skeleton)
* 🎩 [PHP DDD Skeleton](https://github.com/CodelyTV/php-ddd-skeleton)
* 🥦 [PHP DDD Example](https://github.com/CodelyTV/php-ddd-example)

### 🧬 Scala

* 📂 [Scala Basic Skeleton](https://github.com/CodelyTV/scala-basic-skeleton)
* ⚡ [Scala Basic Skeleton (g8 template)](https://github.com/CodelyTV/scala-basic-skeleton.g8)
* ⚛ [Scala Examples](https://github.com/CodelyTV/scala-examples)
* 🥦 [Scala DDD Example](https://github.com/CodelyTV/scala-ddd-example)

For run test with mysql adapter:
- Comment '@Service' in InMemory adapter and add it to MySql adapter
- Command for run mysql docker container: `docker run -d --name mysql_server -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123456 mysql`

NOTE: use JDK 8 for avoid this warning:
- 'an illegal reflective access operation has occurred...'

For run mooc_backend commands:
- `./gradlew :run --args="mooc_backend server"`
- `./gradlew :run --args="mooc_backend fake"`
- `./gradlew :run --args="mooc_backend another_fake"`

For run rabbitmq container:
- `docker run -d -p 15672:15672 -p 5672:5672 --name rabbitmq_server rabbitmq:3-management`
- Go to [localhost:15672](http://localhost:15672)
- Default login is `guest` `guest`

For run elasticsearch container:
- `docker run -d -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" --name elasticsearch_server elasticsearch:6.8.4`
