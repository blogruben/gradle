package org.java.ruben.compilarJar.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;



/*
 * Clase properties, es un singleton (safe-thead) para poder leer los propiedades
 * La primera vez que se le llama carga las propiedades del
 * archivo que se le indique, y luego accedemos a ellas
 * a traves de la funcion getValor()
 */
public class SingletonProperties {


    private Properties	_oProperties;
    private String _archivo;

    public SingletonProperties(String archivo)  {
        _archivo = archivo;
        //Leemos en properties. 
		try(FileInputStream fileProperties = new FileInputStream(archivo)){
			_oProperties = new Properties( System.getProperties() );
			_oProperties.load( fileProperties );
		}
        catch(IOException exp){
            throw new RuntimeException("Error al leer el archivo de properties. "+archivo, exp);
        }

    }

    private static ThreadLocal<SingletonProperties> _threadLoca;

    public static SingletonProperties getInstance(String archivo)  {
        //crear un singleton protegido contra multihilo
        _threadLoca = ThreadLocal.withInitial(() -> new SingletonProperties(archivo));
        return _threadLoca.get();
    }

	public String getValor( String sClave )
	{
        String ValorPropiedad = _oProperties.getProperty( sClave );
        if (ValorPropiedad == null ||ValorPropiedad.equals("")){
            throw new RuntimeException("Error al leer la propiedad: "+sClave+" del properties: "+_archivo);
        }
		return _oProperties.getProperty( sClave );
	}

    
}


