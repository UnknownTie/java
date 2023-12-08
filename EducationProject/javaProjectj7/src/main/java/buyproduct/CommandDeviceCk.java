package buyproduct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommandForm;

public class CommandDeviceCk implements CommandForm {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BuyProductsDAO dao = new BuyProductsDAO();

		String idx = request.getParameter("idx")==null ? "" : request.getParameter("idx");
		String productName = request.getParameter("productName")==null ? "" : request.getParameter("productName");
		
		HttpSession session = request.getSession();
		int userIdx = session.getAttribute("sUserIdx")==null ? 0 : (int) session.getAttribute("sUserIdx");
		
		System.out.println("idx :"+idx);
		System.out.println("userIdx :"+userIdx);
		
		ArrayList<BuyProductsVO> vos = dao.getBuyProuctList(idx , userIdx);
		
		if(vos.size() <= 0) {

			BuyProductsVO vo = new BuyProductsVO();
			vo.setAddress("예시");
			
      // 현재시간      
			LocalDateTime now = LocalDateTime.now();            
			String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));              
			vo.setCkTime(formatedNow);
			
			//api를 이용해서 온습도를 가져와서 삽입
			vos.add(vo);
		}
		
		for(BuyProductsVO vo: vos) {

			ArrayList<Buyproductids_VO> chartvos = dao.getBuyProuctData(Integer.toString(vo.getProductsSerial())  , "" , "");
			vo.setChartvos(chartvos);
			
			System.out.println(vo);
		}
		
		
		request.setAttribute("productName", productName);
		request.setAttribute("vos", vos);
		
		return null;
	}

}
