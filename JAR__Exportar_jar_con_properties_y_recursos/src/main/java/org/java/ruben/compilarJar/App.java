package org.java.ruben.compilarJar;

import java.io.IOException;

import org.java.ruben.compilarJar.properties.Prop;


public class App {
    public String getGreeting() {
        return "Inicio.";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new App().getGreeting());
        System.out.println("EL directorio de lectura es:  "+Prop.DIRECTORIO_DE_LECTURA.get());
        System.out.println("El numero de hilos es:  "+Prop.NUMERO_DE_HILOS.get());
		
        //Resultado:
        //Inicio.
        //EL directorio de lectura es:  ruta/del/nombre/Del/Directorio/
        //El numero de hilos es:  4
	
        //faltan TESTS
        //test existe directorio properties
        //test existen todas las propiedades
        //no hay propiedades que no se usen en el codigo
		
    }
}
