package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Bean.nhanvienBEAN;

public class nhanvienDAO {
	public ArrayList<nhanvienBEAN> xemdanhsachNV() {
		ArrayList<nhanvienBEAN> DSnhanvien = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcnw3", "root", "");
	    	Statement stm = conn.createStatement();
	    	String sql = "SELECT * FROM nhanvien";
	    	ResultSet rs = stm.executeQuery(sql);
	    	while (rs.next()) {
	    		nhanvienBEAN nv = new nhanvienBEAN();
	    		nv.setId(rs.getString(1));
	    		nv.setName(rs.getString(2));
	    		nv.setIdpb(rs.getString(3));
	    		nv.setAddress(rs.getString(4));
	    		DSnhanvien.add(nv);
	    	}
	    	
		}catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
		return DSnhanvien;
	}
	
	public nhanvienBEAN laythongtinNV(String idnv) {
		nhanvienBEAN nv = new nhanvienBEAN();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLphongban", "root", "");
	    	String sql = "SELECT * FROM nhanvien WHERE id = ?";
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idnv);
	        ResultSet rs = pstmt.executeQuery();
	    	while (rs.next()) {
	    		nv.setId(rs.getString(1));
	    		nv.setName(rs.getString(2));
	    		nv.setIdpb(rs.getString(3));
	    		nv.setAddress(rs.getString(4));
	    	}
	    	
		}catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
		return nv;
	}
	
	public boolean checkIdNV(String idnv) {
		boolean isExist = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLphongban", "root", "");
	    	String sql = "SELECT COUNT(*) FROM nhanvien WHERE id = ?";
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idnv);
            ResultSet rowsAffected = pstmt.executeQuery(); 
            if (rowsAffected.next()) {
                isExist = rowsAffected.getInt(1) > 0; 
            }
	    	conn.close();
		}catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
		return isExist;
	}
	
	
	public boolean themNV(String idnv, String hoten, String idpb, String diachi) {
		boolean isUpdated = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcnw3", "root", "");
	    	String sql = "INSERT INTO nhanvien VALUES(?,?,?,?)";
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idnv);
	    	pstmt.setString(2, hoten);
            pstmt.setString(3, idpb);
            pstmt.setString(4, diachi);
            int rowsAffected = pstmt.executeUpdate(); 
            isUpdated = (rowsAffected > 0);
	    	conn.close();
		}catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
		return isUpdated;
	}
	
	
	public boolean suathongtinNV(String idnv, String hoten, String idpb, String diachi) {
		boolean isUpdated = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testcnw3", "root", "");
	    	String sql = "update nhanvien Set hoten = ? gioitinh = ? , khoa = ?  WHERE msv";
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
	    	pstmt.setString(1, hoten);
            pstmt.setString(2, idpb);
            pstmt.setString(3, diachi);
            pstmt.setString(4, idnv);
            int rowsAffected = pstmt.executeUpdate(); 
            isUpdated = (rowsAffected > 0);
	    	conn.close();
		}catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
		return isUpdated;
	}
	
	public boolean xoathongtinNV(String idnv) {
		boolean isUpdated = false;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLphongban", "root", "");
	    	String sql = "DELETE FROM nhanvien WHERE id = ?";
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, idnv);
            int rowsAffected = pstmt.executeUpdate(); 
            isUpdated = (rowsAffected > 0);
	    	conn.close();
		}catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
		return isUpdated;
	}
	
	public ArrayList<nhanvienBEAN> timkiemNV(String info, String input) {
		ArrayList<nhanvienBEAN> DSnhanvien = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLphongban", "root", "");
	    	String sql = "SELECT * FROM nhanvien WHERE " + info + " LIKE ?";
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "%" + input + "%"); 
	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            nhanvienBEAN nv = new nhanvienBEAN();
	            nv.setId(rs.getString(1));
	    		nv.setName(rs.getString(2));
	    		nv.setIdpb(rs.getString(3));
	    		nv.setAddress(rs.getString(4));
	    		DSnhanvien.add(nv);
	        }
	    	conn.close();
		}catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
		return DSnhanvien;
	}
}
