package esercizi;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FileWriteDataOutputStreamIntTest {
	
	static FileWriteDataOutputStreamInt fwdosi;
	static String integerFileTxt = "src/text_files/integer.txt";
	static String integerFileDat = "src/text_files/integer.dat";
	static int[] expFileIntegerArr = { 1, 3, 5, 6, 25, 60, 345, 89, 45, 2, 4, 98 };

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

}
