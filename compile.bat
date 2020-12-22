@ECHO off
javac -encoding utf8 -cp src src\charater\*.java
javac -encoding utf8 -cp src src\charater\Player\*.java
javac -encoding utf8 -cp src src\charater\Monster\*.java
javac -encoding utf8 -cp src src\ClientServer\Client\*.java
javac -encoding utf8 -cp src src\ClientServer\*.java
javac -encoding utf8 -cp src src\ClientServer\Server\*.java
javac -encoding utf8 -cp src src\draw10AtStart\*.java
javac -encoding utf8 -cp src src\draw10AtStart\PlayGround\*.java
javac -encoding utf8 -cp src src\draw10AtStart\PlayGround\LoginFrame\*.java
javac -encoding utf8 -cp src src\draw10AtStart\PlayGround\BattleFiled\*.java
javac -encoding utf8 -cp src src\draw10AtStart\PlayGround\Connection\*.java
ECHO finish
pause