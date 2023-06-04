import static org.junit.Assert.*;

import org.junit.Test;
import csvsaver.CsvReader;

public class CsvReaderTest {

	@Test
	public void ReadFileTest() {
		CsvReader reader = new CsvReader("./src/test/resources/readerTest.csv");
		
		assertTrue(reader.ReadFile());
		assertNotNull(reader.getFileEntries());
		assertEquals("CsvReaderTest", reader.getFileEntries().get(0));
	}

}
