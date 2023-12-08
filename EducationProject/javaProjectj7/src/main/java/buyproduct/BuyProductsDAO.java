package buyproduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dbGrup.Conn;
import dbGrup.DAO;
import product.ProductsVO;
import user.UsersVO;

public class BuyProductsDAO extends DAO{
	
	private final Connection conn = Conn.conn.getConnection();

	public ArrayList<BuyProductsVO> getBuyProuctList(String idx ,int useridx ) {
		ArrayList<BuyProductsVO> vos = new ArrayList<BuyProductsVO>();
		
		try {
			String sql = "select * from buyproducts where buyProducts_productsIdx = ? and buyProducts_usersIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx);
			pstmt.setInt(2, useridx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BuyProductsVO vo = new BuyProductsVO();
				
				vo.setAddress(rs.getString("buyProductsAddress"));
				vo.setUsersIdx(rs.getInt("buyProducts_usersIdx"));
				vo.setExplain(rs.getString("buyProductsExplain"));
				vo.setIdx(rs.getInt("buyProductsIdx"));
				vo.setLinkTime(rs.getString("buyProductsLinkTime"));
				vo.setPhoto(rs.getString("buyProductsPhoto"));
				vo.setProductsIdx(rs.getInt("buyProducts_productsIdx"));
				vo.setProductsSerial(rs.getInt("buyProductsSerial"));
				vo.setType(rs.getString("buyProductsType"));
				
				vo.setCkTime(rs.getString("buyproductsCkTime"));
				vo.setState(rs.getBoolean("buyproductsState"));
				vo.setTemp(rs.getFloat("buyproductsTemp"));
				vo.setHumid(rs.getFloat("buyproductsHumid"));

				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("sql오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		
		return vos;
	}

	public ArrayList<Buyproductids_VO> getBuyProuctData(String serial , String StartTime ,String EndTime ) {
		ArrayList<Buyproductids_VO> vos = new ArrayList<Buyproductids_VO>();
		
		try {
			String sql = "select * from buyproductids_"+serial+" order by buyProductIdsCkTime desc";
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Buyproductids_VO vo = new Buyproductids_VO();
				
				vo.setCkTime(rs.getString("buyProductIdsCkTime"));
				vo.setExplain(rs.getString("buyProductIdsExplain"));
				vo.setHumid(rs.getFloat("buyProductIdsHumid"));
				vo.setIdx(rs.getInt("buyProductIdsIdx"));
				vo.setTemp(rs.getFloat("buyProductIdsTemp"));
				vo.setKey(rs.getString("buyProductIdsKey"));
				vo.setMenagersIdx(rs.getInt("buyProductIds_menagersIdx"));
				vo.setState(rs.getBoolean("buyProductIdsState"));

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
