package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbGrup.Conn;
import dbGrup.DAO;
import user.UsersVO;

public class ProductsDAO extends DAO{
	
	private final Connection conn = Conn.conn.getConnection();
	private ProductsVO vo;
	
	public ArrayList<ProductsVO> getPriductList() {

		ArrayList<ProductsVO> vos = new ArrayList<ProductsVO>();
		
		try {
			String sql = "select * from products ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo = new ProductsVO();
				
				vo.setIdx(rs.getInt("productsIdx"));
				vo.setName(rs.getString("productsName"));
				vo.setPhoto(rs.getString("productsPhoto"));
				vo.setVer(rs.getFloat("productscVer"));
				vo.setCreateTime(rs.getString("productsTime"));
				vo.setExplain(rs.getString("productsExplain"));

				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vos;
	}
	



}
