

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTest {
	File inFile;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void printTreeTest()
	{
		
		String obtain = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
		String str = MorseCodeConverter.printTree();
		str = str.trim();
		assertEquals(obtain, str);
	}

	@Test
	public void testConvertToEnglishToString() {	
		String firstConvert = MorseCodeConverter.convertToEnglish(".... ../.--- .- ...- .-");
		assertEquals("hi java", firstConvert);
	
		String secondConvert = MorseCodeConverter.convertToEnglish("--. .-. . .- -/- . -..- -/.-- .-. .. - . .-. ");
		assertEquals("great text writer", secondConvert);
	}

	@Test
	public void testConvertToEnglishToFile() throws FileNotFoundException {
		String text1="it is not too far although i cannot reach there";		
		getFile("file1.txt");
		String converterToFile = MorseCodeConverter.convertToEnglish(inFile);
		assertEquals(text1,converterToFile);

		String text2="studying java this semester";		
		getFile("file2.txt");
		String converterToFile2 = MorseCodeConverter.convertToEnglish(inFile);
		assertEquals(text2,converterToFile2);

	}

	public void getFile(String file) throws FileNotFoundException {		
		JFileChooser jFile = new JFileChooser();
		int currStatus;

		jFile.setDialogTitle("Input File: " + file);
		currStatus = jFile.showOpenDialog(jFile);

		if(currStatus == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				inFile = jFile.getSelectedFile();
			}
			catch (Exception exp) {
				JOptionPane.showMessageDialog(null, "There is some problem with this file", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
