package p.com.product.model;

import java.util.List;

public class ProdService {
	private ProdDAO dao;
	public ProdService() {
		dao = new ProdDAOimpl();
		
	}
	
	public List<ProdVO> getAllProd() {
		return dao.findAllProd();
	}
	
	

}
