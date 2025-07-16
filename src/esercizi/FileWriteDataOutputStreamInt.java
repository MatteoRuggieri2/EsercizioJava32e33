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
	private String integerFileTxt = "src/text_files/integer.txt";
	private String integerFileDat = "src/text_files/integer.dat";
	
	//TODO LIST
	// - Analizzare la consegna dell'esercizio
	// - Controllare i metodi già scritti
	// - Individuare eventuali bug
	// - Risolvere problemi riscontrati
	// - Scrivere i test JUnit
	
	public static void main(String[] args) {
		new FileWriteDataOutputStreamInt().runEx1();
	}
	
	
	
	// EX 1
	
	private void runEx1() {
		
		// Leggere int da integer.txt
		this.integerList = readIntegerFromFile(this.integerFileTxt);
		
		System.out.println("INTERI LETTI DAL FILE:\n");
		for (Integer integer : this.integerList) {
			System.out.println(integer);
		}
		
		printIntegerInFile(integerList, integerFileDat);
		System.out.println("\nINTERI SCRITTI IN 'integer.dat'");
		
		
	}
	
	// Questo metodo legge gli interi contenuti nel file con nome l'argomento passato.
	public List<Integer> readIntegerFromFile(String fileName) {
		List<Integer> result = new ArrayList<>();
		
		File fileToRead = new File(fileName);
		Scanner sc = null;
		
		try {
			sc = new Scanner(fileToRead);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Finchè sono presenti dati nel file, li salvo nella lista
		while (sc.hasNext()) {
			result.add(sc.nextInt());
		}
		
		sc.close();
		
		return result;
	}
	
	// Questo metodo stampa nel file .dat fornito la lista di byte in formato byte.
	public void printIntegerInFile(List<Integer> intList, String file) {
		try {
			DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
			
			for (Integer integer : intList) {
				out.writeInt(integer);
			}
			
			out.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	// EX 2
	
	private void runEx2() {
		
		// Leggi gli interi dal file e stampali
		
		
		// Fai la somma degli interi
		
		
	}
	
	// Questo metodo legge da un file ".dat" gli interi sotto forma di byte
	public List<Integer> readByteIntegerFromFile(String fileName) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		DataInputStream in = null;
		
		try {
			in = new DataInputStream(new FileInputStream(this.integerFileDat));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			while (true) {
				result.add(in.readInt());
			}
		} catch (IOException e) {
			return result;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	// TO CHECK
	// ---------------------
	
	// Questo metodo stampa i dati nel file passato come parametro
	public void printDataInFile(String fileName, List<Integer> integerList) {
		
		try {
			
			// Scrivo sul file
			DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
			for (Integer integer : integerList) {
				out.writeInt(integer);
			}
			out.close();
			
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
		
		//BUG -> NON LEGGE I NUMERI
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
