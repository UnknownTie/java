package product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommandForm;

public class CommandProductList implements CommandForm {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductsDAO dao = new ProductsDAO();
		
		ArrayList<ProductsVO> vos = dao.getPriductList();
		for(ProductsVO vo: vos)
			System.out.println(vo);
		
		request.setAttribute("vos", vos);
		
		return null;
	}

}
