# Development Manual

+ You need to have java 8, `which java` in command line. You can download it [here](https://en.wikipedia.org/wiki/OpenJDK) 
```sh
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update 
sudo apt-get install openjdk-8-jdk
```
+ Download Gradle, you have to have version 3.1 running
```sh
curl -s https://get.sdkman.io | bash
source "~/.sdkman/bin/sdkman-init.sh"
sdk install gradle 3.1
```
+ Setup the [Heroku Toolbelt](https://devcenter.heroku.com/articles/heroku-command-line)
+ To run locally you can use heroku local -p <port number>
