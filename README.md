# Calculator API: Jenkins CI/CD with Nexus Deployment

A Java Calculator API built with Maven and Eclipse, with a fully automated CI/CD pipeline. Every push to the `main` branch triggers Jenkins to compile the code, run the test cases, package the application, and deploy the artifact to a Sonatype Nexus repository.

---

## Table of Contents

- [Overview](#overview)
- [Tech Stack](#tech-stack)
- [CI/CD Workflow](#cicd-workflow)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Setup Guide](#setup-guide)
  - [1. Nexus Repository](#1-nexus-repository)
  - [2. Maven settings.xml](#2-maven-settingsxml-nexus-login)
  - [3. pom.xml Distribution Management](#3-pomxml-distribution-management)
  - [4. Jenkins Job](#4-jenkins-job)
- [Pipeline Output](#pipeline-output)
- [Screenshots](#screenshots)
- [Security Notes](#security-notes)
- [Author](#author)

---

## Overview

This project demonstrates a complete DevOps flow for a simple Calculator API:

1. Code is written in **Eclipse** and pushed to GitHub.
2. A push to the `main` branch **automatically triggers** the Jenkins pipeline.
3. Jenkins **compiles**, **tests**, and **packages** the application using Maven.
4. The built artifact (`.jar` and `.pom`) is **deployed to a Nexus repository**.

## Tech Stack

| Area | Tool |
|------|------|
| Language | Java |
| IDE | Eclipse |
| Build tool | Apache Maven |
| Version control | Git and GitHub |
| CI/CD | Jenkins |
| Artifact repository | Sonatype Nexus Repository OSS 3.67.1-01 |

## CI/CD Workflow

```
Eclipse  -->  GitHub (main)  -->  Jenkins  -->  Nexus
 code         git push          compile        deploy
                                test           artifact
                                package
```

| Stage | Maven command | Description |
|-------|---------------|-------------|
| Checkout | n/a | Jenkins pulls the latest code from `main` |
| Compile | `mvn compile` | Compiles the source code |
| Test | `mvn test` | Runs the unit test cases |
| Package | `mvn package` | Builds the `.jar` file |
| Deploy | `mvn deploy` | Uploads the artifact to Nexus |

## Project Structure

```
Calculator_API/
├── src/
│   ├── main/java/        # Calculator API source code
│   └── test/java/        # Unit test cases
├── Assets/               # Screenshots of the working project
├── pom.xml               # Maven configuration
└── README.md
```

## Prerequisites

- JDK 8 or later
- Apache Maven
- Eclipse IDE
- Git
- Jenkins (running on `http://localhost:8080`)
- Nexus Repository OSS (running on `http://localhost:8081`)

## Setup Guide

### 1. Nexus Repository

1. Open Nexus at `http://localhost:8081` and log in as an admin.
2. Create a Maven hosted repository named **MavenRepo**.
3. Create a user (for example `TeamLead`) with permission to deploy to this repository.

### 2. Maven settings.xml (Nexus Login)

Jenkins authenticates to Nexus through a `settings.xml` file in the `.m2` folder (`~/.m2/settings.xml`). The `<id>` here must match the `<id>` used in `pom.xml`.

```xml
<settings>
  <servers>
    <server>
      <id>Ganesh_Calci</id>
      <username>YOUR_NEXUS_USERNAME</username>
      <password>YOUR_NEXUS_PASSWORD</password>
    </server>
  </servers>
</settings>
```

> Never commit this file with real credentials. See [Security Notes](#security-notes).

### 3. pom.xml Distribution Management

Tell Maven where to deploy the artifact:

```xml
<groupId>Ganesh_Blk</groupId>
<artifactId>CalculatorAPI_Div</artifactId>
<version>4.0</version>

<distributionManagement>
  <repository>
    <id>Ganesh_Calci</id>
    <url>http://localhost:8081/repository/MavenRepo</url>
  </repository>
</distributionManagement>
```

### 4. Jenkins Job

1. Create a Jenkins job named **Calculator_API** (Dev Build).
2. Under **Source Code Management**, select Git and add your repository URL with branch `*/main`.
3. Under **Build Triggers**, enable a trigger so a push to `main` starts the build (GitHub webhook or Poll SCM).
4. Add a build step that runs Maven:
   ```
   clean compile test package deploy
   ```
5. Save and click **Build Now** to test it.

Once configured, any push to `main` runs the full pipeline automatically.

## Pipeline Output

A successful run (build #10) uploads the artifacts to Nexus and ends with `BUILD SUCCESS`:

```
Uploaded to Ganesh_Calci: .../Ganesh_Blk/CalculatorAPI_Div/4.0/CalculatorAPI_Div-4.0.pom
Uploaded to Ganesh_Calci: .../Ganesh_Blk/CalculatorAPI_Div/4.0/CalculatorAPI_Div-4.0.jar
Uploaded to Ganesh_Calci: .../Ganesh_Blk/CalculatorAPI_Div/maven-metadata.xml
[INFO] BUILD SUCCESS
Finished: SUCCESS
```

The deployed artifact in Nexus:

```
MavenRepo
└── Ganesh_Blk
    └── CalculatorAPI_Div
        ├── 4.0/
        ├── maven-metadata.xml
        ├── maven-metadata.xml.md5
        └── maven-metadata.xml.sha1
```

## Screenshots

Rename your screenshots in the `Assets` folder to match the names below, or edit the paths.

### Jenkins Job: Calculator_API
![Jenkins Job](Assets/jenkins-job.png)

### Jenkins Build History
![Build History](Assets/jenkins-build-history.png)

### Jenkins Console Output (BUILD SUCCESS)
![Console Output](Assets/jenkins-console-output.png)

### Nexus Repository: Deployed Artifact
![Nexus Repository](Assets/nexus-repository.png)

### Maven settings.xml (Nexus Server Config)
![settings.xml](Assets/settings-xml.png)

> The `settings.xml` screenshot shows plain-text credentials. Replace it with a redacted version before publishing (see below).

## Security Notes

- Do not commit `settings.xml` with real usernames or passwords. Keep it in `~/.m2/` only, and add it to `.gitignore`.
- Blur or crop the username and password in any screenshot before pushing it to a public repository.
- Change the Nexus password if it has already been pushed publicly.
- Prefer **Jenkins Credentials** or Maven password encryption (`mvn --encrypt-password`) for production setups.

## Author

**Ganesh Balekundri**
GitHub: [ganeshbalekundri25](https://github.com/ganeshbalekundri25)
