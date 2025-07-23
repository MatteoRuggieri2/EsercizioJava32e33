package esercizi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileWriteDataOutputStreamIntTest {
	
	static FileWriteDataOutputStreamInt fwdosi;
	static String integerFileTxt = "src/text_files/integer.txt";
	static String integerFileDat = "src/text_files/integer.dat";
	static int[] expFileIntegerArr = { 1, 3, 5, 6, 25, 60, 345, 89, 45, 2, 4, 98 };
	static List<Integer> fileInteger = List.of(1, 3, 5, 6, 25, 60, 345, 89, 45, 2, 4, 98);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		fwdosi = new FileWriteDataOutputStreamInt();
	}
	
	@Test
	void testReadIntegerFromFile() throws FileNotFoundException {
		
		int[] fileIntArr = fwdosi.readIntegerFromFile(integerFileTxt)
                .stream()
                .mapToInt(Integer::intValue) // Questo serve per passare da Stream<Integer> a IntStream, cioè da oggetti wrapper a tipi primitivi.
                .toArray();

		assertArrayEquals(expFileIntegerArr, fileIntArr);
	}
	
	@Test
	void testReadIntegerFromFileKO() {
	    assertThrows(FileNotFoundException.class, () -> {
	        fwdosi.readIntegerFromFile("src/text_files/integer.err")
	              .stream()
	              .mapToInt(Integer::intValue)
	              .toArray();
	    });
	}
	
	@Test
	void testReadByteIntegerFromFile() throws FileNotFoundException {

		int[] fileByteIntArr = fwdosi.readByteIntegerFromFile(integerFileDat)
				.stream()
				.mapToInt(Integer::intValue)
				.toArray();
				
		assertArrayEquals(expFileIntegerArr, fileByteIntArr);
	}
	
	@Test
	void testReadByteIntegerFromFileKO() {
		assertThrows(FileNotFoundException.class, () -> {
	        fwdosi.readByteIntegerFromFile("src/text_files/integer.err")
	              .stream()
	              .mapToInt(Integer::intValue)
	              .toArray();
	    });
	}
	
	@Test
	void testSumIntegerList() {
		assertEquals(683, fwdosi.sumIntegerList(fileInteger));
		assertEquals(30, fwdosi.sumIntegerList(List.of(10, 10, 10)));
	}

}
