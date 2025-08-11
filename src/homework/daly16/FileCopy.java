package homework.daly16;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
	public static void main(String[] args) {
		
		File orgFile = new File("d:/D_Other/Tulips.jpg");
		File newFile = new File("d:/D_Other/copy_Tulips.jpg");
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(orgFile);
			fos = new FileOutputStream(newFile);
			
			int data = 0;
			while((data = fis.read()) != -1) { 
				fos.write(data);
				//ystem.out.println(data);
			}
			
			System.out.println("복사성공");
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			try {
				fis.close();
				fos.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
}
