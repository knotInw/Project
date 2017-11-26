package TMproject;

import java.util.Scanner;

public class TicketMachine {

	static Scanner sc = new Scanner(System.in);
	static int choice = 0;
	static int stationselect = 0; 
	static double amount;
public static void ticketMenu(){
	System.out.println();
	System.out.println("===== Welcome to Ticket Machine =====");
	System.out.println("[1] Buy Ticket");
	System.out.println("[2] See Data");
	System.out.println("[3] Exit");
	System.out.println();
}

public static void ticketSystem(){
	do{
		if(choice==1)
		{
			buyticketChoice();
		}
		else if(choice==2)
		{
			//coming
		}
		ticketMenu();
		System.out.print("Enter command : ");
		choice = sc.nextInt();
	}while(choice!=3);
	System.out.println("Thank you.");
}

public static void buyticketChoice(){
	
	TMManager.ticketStation();
	
	System.out.print("Select your station: ");
	stationselect = sc.nextInt();
	TMManager.printTicket(stationselect);
	
	System.out.println("=====================================");
	System.out.print("Enter your amount : ");
	amount = sc.nextDouble();
	TMManager.payTicket(stationselect,amount);
	
}
	public static void main(String[] args) {
		ticketSystem();
	}

}
