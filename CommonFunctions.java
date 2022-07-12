import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonFunctions {



	static String pdfToText(PDDocument pd, int startPage, int endPage) throws IOException {

		PDFTextStripper pdfTextStripper=new PDFTextStripper();
		pdfTextStripper.setStartPage(startPage);
		pdfTextStripper.setEndPage(endPage);

		return pdfTextStripper.getText(pd);

	}


	static ArrayList<Integer> getPageNumbersFor(PDDocument pd,String pattern1,String pattern2) throws IOException {
		ArrayList<Integer> pageNumbers = new ArrayList<Integer>();
		PDFTextStripper pdfTextStripper=new PDFTextStripper();
		int pages=pd.getNumberOfPages();

		Pattern p1 = Pattern.compile(pattern1);
		Pattern p2 = Pattern.compile(pattern2);

		for(int i=1;i<=pages;i++){
			pdfTextStripper.setStartPage(i);
			pdfTextStripper.setEndPage(i);
			String data=pdfTextStripper.getText(pd);

			Matcher m1 = p1.matcher(data);
			Matcher m2 = p2.matcher(data);

			if(m1.find() && m2.find()){
				pageNumbers.add(i);
			}

		}
		return pageNumbers;
	}


	static int getSubfoldersCount(String dirPath){

		File dir = new File(dirPath);
		int numberOfSubfolders = 0;
		File listDir[] = dir.listFiles();
		for (int i = 0; i < listDir.length; i++) {
			if (listDir[i].isDirectory()) {
				numberOfSubfolders++;
			}
		}

		return numberOfSubfolders;
	}

	static File[]  getTextFiles(File[] files){
		
		File[] textFiles=new File[3];

		for (int i=0,j=0;i<files.length && j<3;i++) {

			if(files[i].getName().split("\\.")[1].matches("txt")){
				
				textFiles[j]=files[i];
				j++;
			}
		}
		
		return textFiles;

	}
	
	static void compareFiles(File[] textFiles) throws IOException{
		boolean compareResult=FileUtils.contentEquals(textFiles[0],textFiles[1]);
        System.out.println("Before and After files are the files same? " + compareResult);
        
        boolean compareResult1=FileUtils.contentEquals(textFiles[0],textFiles[2]);
        System.out.println("Before and After files are the files same? " + compareResult1);
 

	}
}
