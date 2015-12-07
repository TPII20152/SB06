package br.ufc.banco.dados.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialObject{
	
	public static void serializeObj(Object obj,String dir){
		
		try{
			FileOutputStream outFile = new FileOutputStream(dir);
			ObjectOutputStream outObj = new ObjectOutputStream(outFile);
			
			outObj.writeObject(obj);
			outObj.flush();
			outObj.close();
			
			outFile.flush();
			outFile.close();
		}
		catch(Exception e){
			e.printStackTrace( );
		}
	}
	
	public static Object loadObj(String dir){
		
		Object obj = null;
		
		try{
		FileInputStream inputFile = new FileInputStream(dir);
		ObjectInputStream inputObj = new ObjectInputStream(inputFile);
		
		obj = inputObj.readObject();
		
		inputObj.close();
		inputFile.close();
		}
		catch(Exception e){
			e.printStackTrace( );
		}
		
		return obj;
	}

}
