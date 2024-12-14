package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Bean.nhanvienBEAN;
//import Model.Bean.nhanvienBEAN;
import Model.Bean.phongbanBEAN;

public class phongbanDAO {
	public ArrayList<phongbanBEAN> xemdanhsachpb() {
		//ArrayList<nhanvienBEAN> DSnhanvien = new ArrayList<>();
		ArrayList<phongbanBEAN> DSphongban = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLphongban", "root", "");
	    	Statement stm = conn.createStatement();
	    	String sql = "SELECT * FROM phongban";
	    	ResultSet rs = stm.executeQuery(sql);
	    	while (rs.next()) {
	    		phongbanBEAN pb = new phongbanBEAN();
	    		pb.setIdpb(rs.getString(1));
	    		pb.setTenpb(rs.getString(2));
	    		pb.setMota(rs.getString(3));
	    		DSphongban.add(pb);
	    	}
	    	
		}catch (ClassNotFoundException e1) {
	        System.out.println("JDBC Driver not found: " + e1.getMessage());
	    } catch (SQLException e1) {
	        System.out.println("SQL Exception: " + e1.getMessage());
	    }
		return DSphongban;
	}
	
	public ArrayList<nhanvienBEAN> xemdanhsachNVtrongPB(String idpb) {
		ArrayList<nhanvienBEAN> DSnhanvien = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QLphongban", "root", "");
	    	String sql = "SELECT id, hoten, idpb, diachi FROM nhanvien WHERE idpb = ?";
	    	PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, idpb);
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
