package Model.Bo;

import java.util.ArrayList;

import Model.Bean.nhanvienBEAN;
import Model.Dao.nhanvienDAO;

public class nhanvienBO {
	nhanvienDAO nvDAO = new nhanvienDAO();
	
	public ArrayList<nhanvienBEAN> xemdanhsachNV()  throws Exception{
		return nvDAO.xemdanhsachNV();
	}
	
	public boolean checkIdNV(String idnv) throws Exception {
		return nvDAO.checkIdNV(idnv);
	}
	
	public boolean themNV(String idnv, String hoten, String idpb, String diachi) throws Exception {
		return nvDAO.themNV(idnv, hoten, idpb, diachi);
	}
	
	public boolean suathongtinNV(String idnv, String hoten, String idpb, String diachi) throws Exception {
		return nvDAO.suathongtinNV(idnv, hoten, idpb, diachi);
	}
	
	public boolean xoathongtinNV(String idnv) throws Exception {
		return nvDAO.xoathongtinNV(idnv);
	}
	
	public nhanvienBEAN laythongtinNV(String idnv) throws Exception {
		return nvDAO.laythongtinNV(idnv);
	}
	
	public ArrayList<nhanvienBEAN> timkiemNV(String info, String input) throws Exception {
		return nvDAO.timkiemNV(info, input);
	}
}
