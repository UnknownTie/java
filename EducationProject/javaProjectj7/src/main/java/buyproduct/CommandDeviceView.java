package buyproduct;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.stream.events.StartDocument;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import common.CommandForm;

public class CommandDeviceView implements CommandForm {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BuyProductsDAO dao = new BuyProductsDAO();

		String serial = request.getParameter("productSerial")==null ? "" : request.getParameter("productSerial");
		String address = request.getParameter("address")==null ? "" : request.getParameter("address");
		String productName = request.getParameter("productName")==null ? "" : request.getParameter("productName");
		String productIdx = request.getParameter("productIdx")==null ? "" : request.getParameter("productIdx");
		
		String temp = request.getParameter("temp")==null ? "" : request.getParameter("temp");
		String humid = request.getParameter("humid")==null ? "" : request.getParameter("humid");
		String state = request.getParameter("state")==null ? "" : request.getParameter("state");
		String ckTime = request.getParameter("ckTime")==null ? "" : request.getParameter("ckTime");
		
		System.out.println("serial:"+serial);
		System.out.println("address:"+address);
		System.out.println("productName:"+productName);
		System.out.println("productIdx:"+productIdx);

		
		System.out.println("temp:"+temp);
		System.out.println("humid:"+humid);
		System.out.println("state:"+state);
		System.out.println("ckTime:"+ckTime);
		
		

		HttpSession session = request.getSession();
	
		
		//1. 테이블의 값 가져오기 
		String StartTime="";
		String EndTime="";
 		

		ArrayList<Buyproductids_VO> vos = dao.getBuyProuctData(serial , StartTime , EndTime);


			
		request.setAttribute("address", address);
		request.setAttribute("productName", productName);
		request.setAttribute("productIdx", productIdx);
		request.setAttribute("productSerial", serial);
		
		request.setAttribute("temp", temp);
		request.setAttribute("humid", humid);
		request.setAttribute("state", state);
		request.setAttribute("ckTime", ckTime);
		
		if(vos == null) 
			return null;
		
		if(vos.size() <= 0) {
//			Buyproductids_VO vo = new Buyproductids_VO();
//			
//      // 현재시간      
//			LocalDateTime now = LocalDateTime.now();            
//			String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));              
//			vo.setCkTime(formatedNow);
//			
//			//api를 이용해서 온습도를 가져와서 삽입
//			vos.add(vo);
			
		}else {
//			for(Buyproductids_VO vo: vos)
//				System.out.println(vo);
		}


		request.setAttribute("vos", vos);
		
		//---
		JSONObject jObj = null;
		JSONArray jArray = new JSONArray();
		
		HashMap<String, String> map = new HashMap<>();
		
		for(Buyproductids_VO vo : vos) {
			map.put("idx",vo.getIdx()+"");
			map.put("memo",vo.getTemp()+"");
			map.put("time",vo.getHumid()+"");
			map.put("id",vo.isState()+"");
			map.put("id",vo.getCkTime());

			
			jObj = new JSONObject(map);
			jArray.add(jObj);
		}

		request.setAttribute("jsonVos", jArray.toString());
		
		
		return null;
	}

}
