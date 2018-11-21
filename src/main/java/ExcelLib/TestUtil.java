package ExcelLib;

import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;

import com.prod.base.Xls_Reader;

public class TestUtil {
	
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getEventDataFromFile(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			
			
			reader = new Xls_Reader("E:/TestData/TestData1.xlsx");
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		for(int rowNum = 2 ; rowNum <= reader.getRowCount("Event");  rowNum++ ) {
			
			DataFormatter formatter = new DataFormatter();
			//Cell cell = sheet.getRow(rowno).getCell(colNo);
			//String result = formatter.formatCellValue(cell);
			
			
			String userName = reader.getCellData("Event", "userName", rowNum);
			String password = reader.getCellData("Event", "password", rowNum);
			String orgName = reader.getCellData("Event", "orgName", rowNum);
			String eventName = reader.getCellData("Event", "eventName", rowNum);
			String oppDetails = reader.getCellData("Event", "oppDetails", rowNum);
			String volNeed = reader.getCellData("Event", "volNeed", rowNum);
			String impactSocity = reader.getCellData("Event", "impactSocity", rowNum);
			String volAgain = reader.getCellData("Event", "volAgain", rowNum);
			String eventDate = reader.getCellData("Event", "eventDate", rowNum);
			String eventStart = reader.getCellData("Event", "eventStart", rowNum);
			String eventEnd = reader.getCellData("Event", "eventEnd", rowNum);
			String volunteers = reader.getCellData("Event", "volunteers", rowNum);
			String eventLocation = reader.getCellData("Event", "eventLocation", rowNum);
			String imagePath = reader.getCellData("Event", "imagePath", rowNum);
			
			
			Object ob[] = {userName,password,orgName,eventName,oppDetails,volNeed,impactSocity,volAgain,eventDate,eventStart,eventEnd,volunteers,eventLocation,imagePath};
			myData.add(ob);
			
			
			
		}
		
		
		return myData;
		
		
		
	}
	
	
	public static ArrayList<Object[]> getListingDataFromFile(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			
			
			reader = new Xls_Reader("E:/TestData/TestData1.xlsx");
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		for(int rowNum = 2 ; rowNum <= reader.getRowCount("Listing");  rowNum++ ) {
			
			DataFormatter formatter = new DataFormatter();
			//Cell cell = sheet.getRow(rowno).getCell(colNo);
			//String result = formatter.formatCellValue(cell);
			
			
			String userName = reader.getCellData("Listing", "userName", rowNum);
			String password = reader.getCellData("Listing", "password", rowNum);
			String selectOrg = reader.getCellData("Listing", "selectOrg", rowNum);
			String listTitle = reader.getCellData("Listing", "listTitle", rowNum);
			String listLocation = reader.getCellData("Listing", "listLocation", rowNum);
			String listContact = reader.getCellData("Listing", "listContact", rowNum);
			String listDescription = reader.getCellData("Listing", "listDescription", rowNum);
			String imagePath = reader.getCellData("Listing", "imagePath", rowNum);
			
			Object ob[] = {userName,password,selectOrg,listTitle,listLocation,listContact,listDescription,imagePath};
			myData.add(ob);
			
			
			
		}
		
		
		return myData;
		
		
		
	}

	public static ArrayList<Object[]> getNoticeDataFromFile(){
	
	ArrayList<Object[]> myData = new ArrayList<Object[]>();
	
	try {
		
		
		reader = new Xls_Reader("E:/TestData/TestData1.xlsx");
	}catch (Exception e) {
		
		e.printStackTrace();
	}
	
	for(int rowNum = 2 ; rowNum <= reader.getRowCount("Listing");  rowNum++ ) {
		
		DataFormatter formatter = new DataFormatter();
		//Cell cell = sheet.getRow(rowno).getCell(colNo);
		//String result = formatter.formatCellValue(cell);
		
		
		String userName = reader.getCellData("Notice", "userName", rowNum);
		String password = reader.getCellData("Notice", "password", rowNum);
		String noticeTitle = reader.getCellData("Notice", "noticeTitle", rowNum);
		String noticeDes = reader.getCellData("Notice", "noticeDes", rowNum);
		String imagePath = reader.getCellData("Notice", "imagePath", rowNum);
		
		
		Object ob[] = {userName,password,noticeTitle,noticeDes,imagePath};
		myData.add(ob);
		
		
		
	}
	
	
	return myData;
	
	
	
}
	
	public static ArrayList<Object[]> getStoryDataFromFile(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			
			
			reader = new Xls_Reader("E:/TestData/TestData1.xlsx");
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		
		for(int rowNum = 2 ; rowNum <= reader.getRowCount("Listing");  rowNum++ ) {
			
			DataFormatter formatter = new DataFormatter();
			//Cell cell = sheet.getRow(rowno).getCell(colNo);
			//String result = formatter.formatCellValue(cell);
			
			
			String userName = reader.getCellData("Story", "userName", rowNum);
			String password = reader.getCellData("Story", "password", rowNum);
			String storyTitle = reader.getCellData("Story", "storyTitle", rowNum);
			String story = reader.getCellData("Story", "story", rowNum);
			String imagePath = reader.getCellData("Story", "imagePath", rowNum);
			
			
			Object ob[] = {userName,password,storyTitle,story,imagePath};
			myData.add(ob);
			
			
			
		}
		
		
		return myData;
		
		
		
	}

}
