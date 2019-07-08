package com.jarvis.RestDemo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jarvis.RestDemo.model.Alien;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class AlienRepository {

	Connection con = null;

	public AlienRepository() {
  
		String url = "jdbc:mysql://localhost:3306/rest";
		String Username = "Shrikant";
		String Password = "shrikant5513";
		
		
		try { 
			Class.forName("com.mysql.jdbc.Driver"); 
			con = DriverManager.getConnection(url,Username,Password);
			
			  
		} catch (Exception e) {
			System.out.println(e);
		}
	
	}

	public List<Alien> getAliens() {
		List<Alien> aliens = new ArrayList<Alien>();
		String sql="select * from alien";
		
		try {
			Statement st =(Statement) con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 while(rs.next()) {
				 
				 Alien a = new Alien();
				 a.setId(rs.getInt(1));
				 a.setName(rs.getString(2));
				 a.setPoints(rs.getInt(3));
				 
				 aliens.add(a);
			 }
			 
			 
		} catch (Exception e) {
			System.out.println(e);
		} 
		
		return aliens;
	}

	public Alien getAlien(int id) {
     String sql="select * from alien where id="+id;
     Alien a = new Alien();
		
		try {
			Statement st =(Statement) con.createStatement();
			 ResultSet rs = st.executeQuery(sql);
			 if(rs.next()) {
				 
				
				 a.setId(rs.getInt(1));
				 a.setName(rs.getString(2));
				 a.setPoints(rs.getInt(3));
				 
				}
			 
			 
		} catch (Exception e) {
			System.out.println(e);
		} 
		return a;
	}

	public void addAlien(Alien alien) {
		
		String sql ="insert into alien values(?,?,?)";
		
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			 
			st.setInt(1, alien.getId());
			st.setString(2, alien.getName());
			st.setInt(3, alien.getPoints());
			st.executeUpdate();
			 
		} catch (Exception e) {
			System.out.println(e);
		}

	}
   public void update(Alien alien) {
		
		String sql ="update alien set name=?,points=? where id=?";
		
		try {
			PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
			 
			
			st.setString(1, alien.getName());
			st.setInt(2, alien.getPoints());
			st.setInt(3, alien.getId());
			st.executeUpdate();
			 
		} catch (Exception e) {
			System.out.println(e);
		}

	}

public void delete(int id) {
	String sql ="delete from alien where id=?";
	
	try {
		PreparedStatement st = (PreparedStatement) con.prepareStatement(sql);
		 
		st.setInt(1, id);
		st.executeUpdate();
		 
	} catch (Exception e) {
		System.out.println(e);
	}
	
	
}
}
