/*8.1) Write a program for file copy.  
  Note: Destination file should have same contents as Source file.  
  */
package asst8_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyFile {

	public static void main(String[] args) {

		/* Source file, from which content will be copied */
		//We will create the object of FileInputStream and will pass the object of File containing file Path to its constructor.
		 File sourceFile = new File("D:\\Destination_file.txt");
		 System.out.println("\n*******Contents in Destination file*******");
		 System.out.println("BEST WINE PAIRING IN INDIA: " 
		 		+ "\n1) Sauvignon Blanc with seafood "
		 		+ "\n2) Chenin Blanc with biryani "
		 		+ "\n3) MS Red and Chardonnay for pasta, risotto, lasagne "
		 		+ "\n4) Fratelli’s Merlot wine with tandoori tikkas or kebabs"
		        + "\n5)  Sette or Vitae Sangiovese with Steaks and barbeque");

		/* destination file, where the content to be pasted */
		//We will create the object of FileOutputStream and will pass the object of File containing filePath to its constructors.
		File destFile = new File("E:\\Source_file.txt");
		 System.out.println("\nNow Copying file from Destination to Source location............");
		
		/* if file not exist then create one */
		if (!destFile.exists()) {
			try {
				destFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		InputStream input = null;
		OutputStream output = null;

		try {

			/* FileInputStream to read streams */
			input = new FileInputStream(sourceFile);

			/* FileOutputStream to write streams */
			output = new FileOutputStream(destFile);

			byte[] buf = new byte[1024];
			int bytesRead;

			//While loop to read from the file and printing on the console.
			while ((bytesRead = input.read(buf)) > 0) {
				output.write(buf, 0, bytesRead);
			}
			//Printing the output.
		 System.out.println("\n***** Text File is copied successfully ******");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		finally {
			try {

				if (null != input) {
					input.close();
				}
				
				if (null != output) {
					output.close();
				}

			}
			//catching exceptions if found any.
			catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}

		