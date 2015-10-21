package Funciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Implementacion {

	private File fichero1, fichero2;
	
	public Implementacion(){
		//Inicializacion de los File
		fichero1= new File("fichero1.txt");
		fichero2= new File("fichero2.txt");
		
		ordenarFichero(fichero1,fichero2,0);
		
	}
	
public void ordenarFichero(File origen, File destino, int tipoOrden){
		
		ArrayList<String> ficheroOrigen = new ArrayList<String>();
		String cadenaOrigen;
		
		try{
			
			if(origen.exists()==false){
				System.err.println("El fichero no existe o no se encuentra");
			}
			
			//Leemos el fichero de origen
			FileReader frOrigen = new FileReader(origen);
			BufferedReader brOrigen = new BufferedReader(frOrigen);
			
			//ESCRITURA EN FICHERO DESTINO
			FileWriter fwDestino = new FileWriter(destino);
			BufferedWriter bwDestino = new BufferedWriter(fwDestino);
			
			//Almacenamos por primera vez la primera linea del fichero de origen
			cadenaOrigen = brOrigen.readLine();
			
			//Continuamos leyendo mientras se pueda y lo almacenamos en un Arraylist
			while (cadenaOrigen != null){
				ficheroOrigen.add(cadenaOrigen);
				cadenaOrigen = brOrigen.readLine();
			}
			//Cerramos el buffer de lectura
			brOrigen.close();
			
			//Ya almacenados las lineas en un arrayList condicionamos los resultados de salida
 		   
			
			//Si el tipo de orden pasado por parámetro es diferente de 0 y 1 se mostrará un error
			if((tipoOrden!=0 && tipoOrden!=1)){
				System.err.println("Introduzca 0 o 1 para ordenar de forma natural o inversa");
			}
			else{
				
				switch(tipoOrden){
				case 0:
					//Escritura con orden natural
					for(int a=0;a<ficheroOrigen.size();a++){
						bwDestino.write(ficheroOrigen.get(a)+"\n");
					}
					System.out.println("Copiado natural correctamente realizado");
					break;
				case 1:
					//Escritura con orden inverso
					for(int a=(ficheroOrigen.size()-1);a>=0;a--){
						bwDestino.write(ficheroOrigen.get(a)+"\n");
					}
					System.out.println("Copiado inverso correctamente realizado.");
					break;
			}
			//Cerramos el buffer de escritura
				bwDestino.close();
			}
		}
		catch(IOException error){
			//En caso de error, informamos acerca de este
			System.err.println("Error al ordenar el texto al fichero destino.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
