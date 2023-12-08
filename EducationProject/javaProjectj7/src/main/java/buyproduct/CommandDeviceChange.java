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

public class CommandDeviceChange implements CommandForm {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		BuyProductsDAO dao = new BuyProductsDAO();

		String idx = request.getParameter("idx")==null ? "" : request.getParameter("idx");
		String productName = request.getParameter("productName")==null ? "" : request.getParameter("productName");
		
		HttpSession session = request.getSession();
		int userIdx = session.getAttribute("sUserIdx")==null ? 0 : (int) session.getAttribute("sUserIdx");
		


		
		return null;
	}

}
