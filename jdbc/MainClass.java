package com.jdbc;

import java.util.Scanner;
import java.sql.Connection;

public class MainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		CRUD_methods c = new CRUD_methods();
		int choice = 0;
		Scanner sc = new Scanner(System.in);

//		before performing operation make the connection to the database 

		Connection con = c.makeConnection();
		
		System.out.println("1. Insert data operation");
		System.out.println("2. fetching operation");
		System.out.println("3. Update operation");
		System.out.println("4. Delete operation");
		System.out.println("5. Exit ");

//		CRUD Operations 
		do {
			System.out.println();
			System.out.println("Enter choice : ");
			if(sc.hasNextInt()) {
				choice=sc.nextInt();
				sc.nextLine();//consume the leftover space 
			}
			else {
				System.out.println("Please enter proper choice (1-5)");
				continue;
			}
			switch (choice) {
			case 1:
				c.insertData(con,sc);
				break;
			case 2:
				c.fetchData(con);
				break;
			case 3:
				c.updateData(con,sc);
				break;
			case 4:
				c.deleteData(con,sc);
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Please enter valid choice (1-5)");
			}
		} while (choice != 5);
		
		sc.close();
	}

}
