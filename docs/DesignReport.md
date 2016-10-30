# Design Report

The mission of this project is to create a game of Tic Tac Toe. On the first meeting the team desigded how the main structure should be and how we wanted to implement.

+ We use Github as source controle system
+ Use Gradle for automatic build scripts
+ Use Travis as a Automated Continuous Integration Server
+ The logic is written in Java
+ All feautures made on branches and pull requests made for a merge
+ The business logic is coded using Test Driven Development
+ The webUi is clean and simple
+ Use Heroku for continious deployment
+ Make end to end test using Selenium

We will start by making a repository on github and imlement Gradle to it. Then adding Travis for CI tests and connecting Travis to Heroku for continious deployment as a Heroku app. We decided that we wanted to use branches for all new implements. And when we want to merge our branch we have to open a pull request and another member in the team has to review the pull request and accept it before it can be merged. We will start by writing a basic web UI and than we add the game logic. In the end we will make Selenium end to end test.

Below is the class diagram.

![Class Diagram](https://github.com/HugbBestiHopurinn/TicTacToe/blob/master/docs/TicTacToeClassDiagram.png)
