@echo off
if exist "../jdk8" goto existe
if exist "jdk8" rd /s /q  "jdk8"
if exist "java-se-8u43-ri" rd /s /q  "java-se-8u43-ri"
if exist "jdk8.zip" del  /f /q "jdk8.zip"
:: descargar JDK 
curl -o jdk8.zip https://download.java.net/openjdk/jdk8u43/ri/openjdk-8u43-windows-i586.zip
:: descomprimir
tar -xf jdk8.zip
:: eliminar zip
del /f /q "jdk8.zip"
:: renombrar directorio 
ren java-se-8u43-ri jdk8 
:: mover al directorio padre
move jdk8 ../jdk8
:: variable de entorno
set JAVA_HOME=../jdk8
:: salir
exit /b 0
:existe
echo Ya existe el directorio jdk8 en el directorio superior.