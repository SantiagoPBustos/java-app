package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileTextManager {
	
	public ArrayList<String> readFile(String pathFile) throws Exception{
		ArrayList<String> linesRead=new ArrayList<String>();
		FileReader fileReader=new FileReader(pathFile);
		BufferedReader bufferedReader=new BufferedReader(fileReader);
		String lineRead;
		
		while ( (lineRead = bufferedReader.readLine() ) !=null ) {
			linesRead.add(lineRead);
		}
		bufferedReader.close();
		return linesRead;
	}
	
	public void writeFile(String pathFile , ArrayList<String> arraylist) {
		FileWriter fileWriter=null;
		try {
			fileWriter=new FileWriter(pathFile);
			for (String line : arraylist) {
				fileWriter.write( line + "\n" );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
