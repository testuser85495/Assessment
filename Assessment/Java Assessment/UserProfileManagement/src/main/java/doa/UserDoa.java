package doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import connection.DBconnection;
import model.user;

public class UserDoa {
	public static void statuschange(String email,user u) {
		try {
			Connection conn = DBconnection.driverConnection();
			String sql = "update user set status ='complete' where email=?" ;
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			pst.executeUpdate();
			System.out.println("complete");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}

	public static boolean checkEmail(String email) {
		boolean flag= false;
		try {
			Connection conn = DBconnection.driverConnection();
			String sql = "select * from user where email =? and status='complete'";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1,email);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public static void register(user u) {
		try {
			Connection conn = DBconnection.driverConnection();
			String sql = "insert into user(fname,lname,email,mobile,address,gender,password,status)values(?,?,?,?,?,?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getFname());
			pst.setString(2, u.getLname());
			pst.setString(3, u.getEmail());
			pst.setLong(4, u.getMobile());
			pst.setString(5, u.getAddress());
			pst.setString(6, u.getGender());
			pst.setString(7, u.getPassword());
			pst.setString(8, u.getStatus());
			pst.executeUpdate();
			System.out.println("Register");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}

	}
	public static user login(user u) {
		user u1=null;
		try {
			Connection conn = DBconnection.driverConnection();
			String sql = "select * from user where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, u.getEmail());
			pst.setString(2, u.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				u1= new user();
				u1.setId(rs.getInt("id"));
				u1.setFname(rs.getString("fname"));
				u1.setLname(rs.getString("lname"));
				u1.setEmail(rs.getString("email"));
				u1.setMobile(rs.getLong("mobile"));
				u1.setAddress(rs.getString("address"));
				u1.setGender(rs.getString("gender"));
				u1.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return u1;
	}
	public static boolean passwordcheck(int id,String opd) {
		boolean flag= false;
		try {
			Connection conn = DBconnection.driverConnection();
			String sql = "select * from user where id=? and password=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.setString(2, opd);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				flag = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return flag;
	}
	public static void updatepassword(int id,String npd) {
		try {
			Connection conn = DBconnection.driverConnection();
			String sql = "update user set password=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, npd);
			pst.setInt(2, id);
			pst.executeUpdate();
			System.out.println("pass update");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	public static void changepassword(String email,String npassword) {
		try {
			Connection conn = DBconnection.driverConnection();
			String sql = "update user set password=? where email=?";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, npassword);
			pst.setString(2, email);
			pst.executeUpdate();
			System.out.println("pass change");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
