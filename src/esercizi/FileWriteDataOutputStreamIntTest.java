package esercizi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileWriteDataOutputStreamIntTest {
	
	static FileWriteDataOutputStreamInt fwdosi;
	String integerFileTxt = "src/text_files/integer.txt";
	String integerFileDat = "src/text_files/integer.dat";

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		fwdosi = new FileWriteDataOutputStreamInt();
	}

	@Test
	void testReadAndStoreFileData() {
//		this.testIntegerListOutput.add(1);
//		this.testIntegerListOutput.add(3);
//		this.testIntegerListOutput.add(5);
//		this.testIntegerListOutput.add(6);
//		this.testIntegerListOutput.add(25);
//		this.testIntegerListOutput.add(60);
//		this.testIntegerListOutput.add(345);
//		this.testIntegerListOutput.add(89);
//		this.testIntegerListOutput.add(45);
//		this.testIntegerListOutput.add(2);
//		this.testIntegerListOutput.add(4);
//		this.testIntegerListOutput.add(98);
//		
//		Integer[] testArr1 = this.testIntegerListOutput.toArray(new Integer[0]);
//		Integer[] testArr2 = fwdosi.readAndStoreFileData(this.integerFileTxt).toArray(new Integer[0]);


		System.out.println("Risultato readAndStoreFileData():\n" + fwdosi.readAndStoreFileData(this.integerFileTxt));
//		assertEquals(testArr1, testArr2);
				
		
	}
	
	@Test
	void testPrintDataInFile() {
		List<Integer> integerList = new ArrayList<>();
		integerList.add(1);
		integerList.add(3);
		integerList.add(5);
		integerList.add(6);
		integerList.add(25);
		integerList.add(60);
		integerList.add(345);
		integerList.add(89);
		integerList.add(45);
		integerList.add(2);
		integerList.add(4);
		integerList.add(98);
		
		fwdosi.printDataInFile(this.integerFileDat, integerList);
		
	}
	
	@Test
	void testReadIntFromWritedFile() {

		fwdosi.readIntFromWritedFile(this.integerFileDat);
		
	}

}
