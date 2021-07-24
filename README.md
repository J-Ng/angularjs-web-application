# angularjs-web-application

# How to setup

1. Install NPM in your local which you can find in https://nodejs.org/en/download/
2. Install the necessary modules for this application by running below on your computer

```shell
npm install -g @angular/cli
npm install bootstrap@3.3.7 --save -g
npm install angular-datatable --save -g
```

# How to use

Start up the MySQL Server

```shell
    mysqld
```

Build and start-up backend server

```shell
    mvn clean install spring-boot:run
```

Trigger starting up of Angular JS web app via angular cli

```shell
    ng serve
```