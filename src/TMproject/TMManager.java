package TMproject;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TMManager {

static Scanner scan = new Scanner(System.in);
static ArrayList<Object> listStations = new ArrayList<>();
static ArrayList<Double> listPrices = new ArrayList<>();
static ArrayList<Object> listid = new ArrayList<>();
static String[] stations = {"Kamphaeng Phet","Lat Phrao","Ratchadaphisek","Phra Ram9","Sukhumvit","Lumphini","Si lorm","Sam Yan","Hua Lamphong"};
static double[] prices = {45.00,47.00,50.00,52.25,55.50,60.00,61.75,64.00,67.00};
static int numid = 10000000 ;
static String idsave = "src/TMproject/Data/id.txt";
public static void readFile(){
	try
	{
		BufferedReader reader = new BufferedReader(new FileReader(idsave));
		String datacount;
		while((datacount = reader.readLine()) != null)
		{
			listid.add(Integer.parseInt(datacount));
		}
		reader.close();
	}
	catch(FileNotFoundException e)
	{
		System.out.println("File not found!!");
	}
	catch(IOException e){
		System.out.println("File not found!!");
	}
}

public static void writeFile(String numberid){
	try 
	{
		BufferedWriter writeid = new BufferedWriter(new FileWriter(idsave,true));
		
			writeid.append(numberid);
			writeid.newLine();
			writeid.close();
		
	} 
	catch (IOException e) 
	{
		System.out.println("Cannot writefile!!");
	}
	
}
public static void ticketStation(){
	System.out.println("---- Station name ------------ Price ---");
	
	for(int i=0 ; i < stations.length ; i++)
	{
		System.out.printf("| [%d]  %-18s | %10.2f |\n",i+1,stations[i],prices[i]);
		listStations.add(stations[i]);
		listPrices.add(prices[i]);
	}
	System.out.printf("| [10] %-31s |\n","<< Previous");
	System.out.println("----------------------------------------");
	System.out.println();
}

public static void printTicket(int select){
	readFile();
	while(listid.contains(numid))
	{
		numid++ ;
	}
		System.out.printf("%-18s : %d \n","Your ticket ID",numid);
		System.out.printf("%-18s : %s \n","Destination","Here -> "+listStations.get(select-1));
		System.out.printf("%-18s : %.2f \n","Price",listPrices.get(select-1));
		writeFile(Integer.toString(numid));
}

public static void payTicket(int select,double money){
	
	if(money == listPrices.get(select-1)){
		System.out.println("Thank you for purchase.");
		return;
	}
	else if(money > listPrices.get(select-1)){
		System.out.printf("Your charge: %.2f\n",money-listPrices.get(select-1));
		System.out.println("Thank you for purchase.");
		return;
	}
	else
	{
		while(money < listPrices.get(select-1))
		{
			System.out.println("Not enough !!");
			System.out.print("Enter your amount: ");
			double moneyadd = scan.nextDouble();
			money += moneyadd;
		}
		
		if(money > listPrices.get(select-1))
		{
			System.out.printf("Your charge: %.2f\n",money-listPrices.get(select-1));
			System.out.println("Thank you for purchase.");
			return;
		}
		else
		{
			System.out.println("Thank you for purchase.");
			return;
		}
		
	}
	
}

//public static void main(String[]args){
//	ticketStation();
//	payTicket(2,49);
//	
//}
}
