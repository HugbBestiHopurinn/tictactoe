rm -r classes/*
javac src/main/java/is/ru/tictactoe/TicTacToe.java -d classes
javac -classpath "classes/;lib/junit-4.11.jar;lib/hamcrest-core-1.3.jar" src/test/java/is/ru/tictactoe/*.java -d classes
java -cp "classes/;lib/junit-4.11.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore is.ru.tictactoe.TicTacToeTest 
