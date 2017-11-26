package TMproject;

import java.util.ArrayList;
import java.util.Scanner;

public class TMManager {

static Scanner scan = new Scanner(System.in);
static ArrayList<Object> listStations = new ArrayList<>();
static ArrayList<Double> listPrices = new ArrayList<>();
static ArrayList<Object> listid = new ArrayList<>();
static String[] stations = {"Kamphaeng Phet","Lat Phrao","Ratchadaphisek","Phra Ram9","Sukhumvit","Lumphini","Si lorm","Sam Yan","Hua Lamphong"};
static double[] prices = {45.00,47.00,50.00,52.25,55.50,60.00,61.75,64.00,67.00};
static int ranid = (int)(Math.random()*89999999)+10000000;//not done

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
//not done it not save ID when reset.
	if(listid.contains(ranid))
	{
		ranid = (int)(Math.random()*89999999)+10000000;
	}
	else
	{
		System.out.printf("%-18s :%d \n","Your ticket ID",ranid);
		System.out.printf("%-18s :%s \n","Destination","Here -> "+listStations.get(select-1));
		System.out.printf("%-18s :%.2f \n","Price",listPrices.get(select-1));
		listid.add(ranid);
	}
}

public static void payTicket(int select,double money){
	
	if(money == listPrices.get(select-1)){
		System.out.println("Thank you for purchase.");
		return;
	}
	else if(money > listPrices.get(select-1)){
		System.out.printf("Your charge : %.2f\n",money-listPrices.get(select-1));
		System.out.println("Thank you for purchase.");
		return;
	}
	else
	{
		while(money < listPrices.get(select-1))
		{
			System.out.println("Not enough !!");
			System.out.print("Enter your amount : ");
			double moneyadd = scan.nextDouble();
			money += moneyadd;
		}
		
		if(money > listPrices.get(select-1))
		{
			System.out.printf("Your charge : %.2f\n",money-listPrices.get(select-1));
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
