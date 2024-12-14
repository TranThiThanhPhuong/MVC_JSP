package Model.Bo;

import java.util.ArrayList;

import Model.Bean.nhanvienBEAN;
import Model.Dao.nhanvienDAO;
import Model.Bean.phongbanBEAN;
import Model.Dao.phongbanDAO;

public class phongbanBO {
	nhanvienDAO nvDAO = new nhanvienDAO();
	phongbanDAO pbDAO = new phongbanDAO();
	
	public ArrayList<phongbanBEAN> xemdanhsachPB() throws Exception {
		return pbDAO.xemdanhsachpb();
	}
	
	 public ArrayList<nhanvienBEAN> xemdanhsachNVtrongPB(String idpb)  throws Exception{
		return pbDAO.xemdanhsachNVtrongPB(idpb);
	} 
}
