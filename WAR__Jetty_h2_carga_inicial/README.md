

# Requisitos 
- JDK8 


# Arrancar servidor 
``gradle appStart``
ctrl+C para cerrar jetty

H2 genera los archivos test.h2.db y test.trace.db en el directorio home
Para reiniciar la bd borrar estos archivos.

Vamos http://localhost:8080/ 

Creamos un servlet que se ejecuta al desplegarse para hacer la carga inicial en H2

