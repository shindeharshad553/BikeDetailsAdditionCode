package com.jdbc;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Scanner;

public class CRUD_methods {

//	To make connection to the database 
	public Connection makeConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/bikes", "root", "root");
	}

//	Insert the values into the database 
	public void insertData(Connection con,Scanner sc) throws SQLException {
		System.out.println("Enter the id : ");
		int id = sc.nextInt();

		System.out.println("Enter the bike name : ");
		String name = sc.next();
		PreparedStatement ps = con.prepareStatement("insert into bikeDetails values(?,?)");
		ps.setInt(1, id);
		ps.setString(2, name);
		int count=ps.executeUpdate();
		if(count>0)
			System.out.println("Bike details added successfully!!!");
	}

	public void fetchData(Connection con) throws Exception {
		System.out.println("Displaying Bike details ");
		System.out.println();
		PreparedStatement ps = con.prepareStatement("Select * from bikeDetails");
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2));
		}
	}

	public void updateData(Connection con,Scanner sc) throws Exception {
		System.out.println("Enter the bike id : ");
		int bikeId = sc.nextInt();
		System.out.println("Enter the bike name to update : ");
		String name = sc.next();

		PreparedStatement ps = con.prepareStatement("update bikeDetails set bike_name=? where id =?");
		ps.setString(1, name);
		ps.setInt(2, bikeId);
		ps.executeUpdate();
	}

	public void deleteData(Connection con,Scanner sc) throws Exception {
		System.out.println("Enter the bike name to delete : ");
		String name = sc.next();

		PreparedStatement ps = con.prepareStatement("delete from bikeDetails where bike_name='?'");
		ps.setString(1, name);
		ps.executeUpdate();
	}
}
