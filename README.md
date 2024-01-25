# mule-sample-project

## Introduction

The Goal of this project is just to serve as a sample project to build a CI/CD pipeline on top of. 

## Necessary Authentication

The sample application uses AVIO's Custom Logger which is deployed to their Exchange. This was to present an issue where you would need to authenticate to a specific Exchange in order to build the project. The sample project also uses a single simple MUnit requiring authentication to the MuleSoft EE Repository. This will need to be done **prior to** building the project successfully. 

## How to build
To build and test the project run the following command: 
```
mvn clean package -Dmule.key=<enter super secret key> -Dmule.env=DEV
```

## How to deploy
This project utilizes the Mule Maven Plugin configuration for deploying to MuleSoft's CloudHub 1.0. It currently is set to authenticate with Client Credentials that are provided at deployment time. You can run the following command to deploy this application to your MuleSoft CloudHub 1.0 environment.

> A few updates you will need to make is changing the `<environment>` tag inside your desired profile to the same name as the environment you intend to deploy to, as well as updating the `<businessGroup>` in the Mule Maven Plugin configuration for your intended business group.

```
mvn mule:deploy -e -P <Name of profile. existing ones are DEV, UAT, and PROD> \
-Dmule.key=<super secret key> \
-DartifactPath=<path to jar file after successful build> \
-DconnectedAppClientId=<connected app client ID> \
-DconnectedAppClientSecret=<connected app client Secret>
```

## Contact

Tanner Sherman