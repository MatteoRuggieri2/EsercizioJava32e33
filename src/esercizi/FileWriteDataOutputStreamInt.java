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
		FileWriteDataOutputStreamInt fwdosi = new FileWriteDataOutputStreamInt();
		fwdosi.runEx1();
		fwdosi.runEx2();
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
		System.out.println("\nSCRITTURA NEL FILE 'integer.dat' COMPLETATA!");
		
		
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
		
		// Leggo i numeri dal file .dat
		List<Integer> intRead = readByteIntegerFromFile(integerFileDat);
		
		// Sommo i numeri letti
		System.out.println("\nSomma degli interi: " + sumIntegerList(intRead));
		
		
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
	
	// Questo metodo somma tutti gli interi contenuti nella lista passata come argomento
	public int sumIntegerList(List<Integer> intList) {
		return intList.stream()
                .reduce(0, Integer::sum);
	}

}
