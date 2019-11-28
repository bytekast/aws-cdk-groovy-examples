# aws-cdk-groovy-examples

This repository contains a set of example projects for the [AWS Cloud Development Kit](https://github.com/awslabs/aws-cdk) in [Groovy](http://groovy-lang.org/)

## 📦 Prerequisites

Install [Node](https://www.npmjs.com/get-npm).

Install the [aws-cdk](https://github.com/aws/aws-cdk) command line tool:

```bash
npm install -g aws-cdk
```

Install **Java** and **Groovy**. The easiest way to install is to use [SDK MAN](https://sdkman.io/):

```bash
➜ curl -s "https://get.sdkman.io" | bash
➜ sdk install java 8.0.222-amzn
➜ sdk install groovy
```

## 🛵 Examples

| Example | Description | Command 
|---------|-------------|---------
| [lambda-cron](lambda-cron/) | Running a Lambda on a schedule | `cdk deploy --app='groovy lambda-cron.groovy'`