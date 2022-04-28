package com.phonebook;

import java.util.Iterator;
import java.util.Scanner;

public class PhoneBook {

	public static String help_msg= "Press: -A Add contact -s Search -Q Exit :";
	public static void main(String[] args) {
		
		System.out.println("\n\n*** Welcome to My PhoneBook ***\n\n");
		Scanner s=new Scanner(System.in);
		for (;;) {
			System.out.print("[Main Menu] "+help_msg+"\n:");
			String command=s.nextLine().trim();
			
			if (command.equalsIgnoreCase("A")) {
				System.out.println("Type in contact details in the format: name, lastname, phone\n: ");
				
			}
			else if (command.equalsIgnoreCase("S")) {
				System.out.println("Type in the name you are searching for :\n:");
				
			}
			else if (command.equalsIgnoreCase("Q")) {
				System.out.println("Good Bye User...");
				System.exit(0);
			}
			else {
				System.out.println("Unknown command ! Try Again \n:");
			}
		}
	}
}
