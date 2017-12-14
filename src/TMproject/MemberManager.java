package TMproject;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberManager {
	static String datamember = "src/TMproject/Data/member_id.txt";
	static ArrayList<Object> listMname = new ArrayList<>();
	static ArrayList<Double> listMpocket = new ArrayList<>();
	static ArrayList<Object> listMid = new ArrayList<>();
	static ArrayList<Object> formatMember = new ArrayList<>();
	
	public static void readmemberFile(){
		try
		{
			Scanner reader = new Scanner(new File(datamember));

			while(reader.hasNextLine())
			{
				String[] tempfile = reader.nextLine().replaceAll(";", "  ").split("  ");
				if(!tempfile[0].isEmpty())
				{
					listMid.add(tempfile[0]);
					listMname.add(tempfile[1]);
					listMpocket.add(Double.parseDouble(tempfile[2]));
				}
			}
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found!!");
		}
	}

	public static void writememberFile(){
		try 
		{

				Path file = Paths.get(datamember);
	            BufferedWriter writerMember = Files.newBufferedWriter(file, StandardCharsets.UTF_8);   
	            
	            for(int i = 0; i<listMid.size() ; i++){
	            	
	            	writerMember.write(""+listMid.get(i)+";"+listMname.get(i)+";"+Double.toString(listMpocket.get(i)));
	                writerMember.newLine();
	                
	            }
	                  
	            writerMember.close();       
		}
		catch (IOException e) 
		{
			System.out.println("Cannot writefile!!");
		}
	}
	
//	public static void main(String[]args){
//		readmemberFile();
//		System.out.println(listMname.get(0));
//		System.out.println(listMname.get(1));
//		listMpocket.set(1, 50000.00-25000.00);
//		writememberFile();
//	}
}