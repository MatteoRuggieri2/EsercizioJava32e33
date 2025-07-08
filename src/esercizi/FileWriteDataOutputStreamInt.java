package esercizi;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileWriteDataOutputStreamInt {
	
	private List<Integer> integerList = new ArrayList<>();

	// Questo metodo legge e salva i dati dal file chiamato con il nome passato come argomento
	public List<Integer> readAndStoreFileData(String fileName) {
		
		// Metto il file in un oggetto e inizializzo uno scanner
		File fileToRead = new File(fileName);
		Scanner sc = null;
		try {
			sc = new Scanner(fileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Finchè sono presenti dati nel file, li salvo nella lista
		while (sc.hasNext()) {
			this.integerList.add(sc.nextInt());
		}
		sc.close();
		
		return integerList;

	}
	
	// Questo metodo stampa i dati nel file passato come parametro
	public void printDataInFile(String fileName, List<Integer> integerList) {
		
		try {
			
			// Scrivo sul file
			DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
			for (Integer integer : integerList) {
				
					out.writeInt(integer);
				
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Questo metodo legge i numeri interi dal file fornito
	public void readIntFromWritedFile(String fileToRead) {
		
		
		DataInputStream in = null;
		try {
			in = new DataInputStream(new FileInputStream(fileToRead));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// NON LEGGE I NUMERI
		int unit = 0;
		int sum = 0;
		
			
			
		try {
			System.out.println("\n--- NUMERI CONVERTITI ---");
			while (true) {
				unit = in.readInt(); // Converto i byte in int
				sum += unit; // Faccio la somma di tutti i miei numeri
				System.out.println(unit);
			}
				
		} catch (IOException e) {
			System.out.println("\n--- SOMMA DEI NUMERI CONVERTITI ---");
			System.out.println(sum);
//				return new ArrayList<Integer>();
		}
			
		
		
		
		

		
		
//		return new ArrayList<Integer>();
	

}
}
