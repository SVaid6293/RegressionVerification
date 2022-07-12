
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegressionVerification {

	public static String folderLocation = "C:\\Users\\3755\\Desktop\\Reg TC\\";

	public static PDDocument pdDocument;

	public static void main(String[] args) throws IOException {


		// for loop for folders  Need to add support..

		int numOfDirectories=CommonFunctions.getSubfoldersCount(folderLocation);
		System.out.println("Number of TC to verify :::: "+numOfDirectories);

		// For Folders(TC's) inside the directory..

		for(int i=0;i<numOfDirectories;i++){

			File folder = new File(folderLocation+"\\"+new File(folderLocation).list()[i]);//get from properties file{Need to do}
			File[] listOfFiles = folder.listFiles();


			// For files inside each TC..
			for (File file : listOfFiles) {  


				if (file.isFile() && file.getName().split("\\.")[1].matches("pdf")) {
					PrintWriter writer;

					//Get filename of the pdf file...

					String fileName = file.getName().split("\\.")[0];//Get filename without extension
					writer = new PrintWriter(folder.getAbsoluteFile() + "\\" + fileName + ".txt", "UTF-8");


					//Loading the PDF file...
					InputStream inputStream = new FileInputStream(file);
					pdDocument = PDDocument.load(inputStream);
					//int pages = pdDocument.getNumberOfPages();
					//System.out.println(pages);


					//Calling PDF2Text function...
					String decData = CommonFunctions.pdfToText(pdDocument, 1, 1);
					//System.out.println(decData);
					writer.println("------------DECLARATION------------\n");

					getDecData(decData, writer);

					writer.println("\n------------FORMS------------\n");

					getFormsData(pdDocument, writer);

					writer.println("\n------------WORKSHEETS------------\n");

					getWorksheetData(pdDocument, writer);
					writer.close();
					pdDocument.close();


				}


			}
			//compare code for text files
			System.out.println("TC::: "+i);
			CommonFunctions.compareFiles( CommonFunctions.getTextFiles(folder.listFiles()));
			
			System.out.println("--------------------");



		}


	}
	//For Declaration Page of the policy...

	static void getDecData(String str, PrintWriter printWriter) {
		//Print matching text for given patters.
		for (String pattern : PatternsDefinition.patterns) {

			Pattern p = Pattern.compile(pattern);
			Matcher m = p.matcher(str);
			while (m.find()) {
				printWriter.println(m.group());
			}
		}

	}

	static void getFormsData(PDDocument pd, PrintWriter printWriter) throws IOException {
		ArrayList<Integer> formList = CommonFunctions.getPageNumbersFor(pd, "FORMS SCHEDULE", "FORMS");
		int count = 1;
		String formData;
		for (Integer formNum : formList
				) {
			formData = CommonFunctions.pdfToText(pd, formNum.intValue(), formNum.intValue());
			Pattern p1 = Pattern.compile(PatternsDefinition.patternForms);
			Matcher matcher = p1.matcher(formData);

			while (matcher.find()) {

				printWriter.println((count) + "." + matcher.group());
				count++;
			}
		}
	}

	static void getWorksheetData(PDDocument pd, PrintWriter printWriter) throws IOException {
		ArrayList<Integer> cpdData = CommonFunctions.getPageNumbersFor(pd, "COMMON POLICY DECLARATIONS", "WORKSHEET");
		int count = 1;
		String worksheetData;
		for (Integer wNum : cpdData
				) {
			worksheetData = CommonFunctions.pdfToText(pd, wNum.intValue(), wNum.intValue());
			getDecData(worksheetData, printWriter);
		}

		printWriter.println("\n--Commercial Property Worksheet Data--\n");
		ArrayList<Integer> cpData = CommonFunctions.getPageNumbersFor(pd, "COMMERCIAL PROPERTY", "WORKSHEET");
		String worksheetDataCP;
		for (String pattern : PatternsDefinition.worksheetPatternsCP) {

			for (Integer wNum : cpData) {
				worksheetDataCP = CommonFunctions.pdfToText(pd, wNum.intValue(), wNum.intValue());
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(worksheetDataCP);
				while (m.find()) {
					printWriter.println(count + ":" + m.group());
					count++;

				}

			}
		}
	}
}


