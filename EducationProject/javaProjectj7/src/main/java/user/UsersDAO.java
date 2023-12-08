package user;

import java.sql.Connection;
import java.sql.SQLException;

import dbGrup.Conn;
import dbGrup.DAO;

public class UsersDAO extends DAO{
	
	private final Connection conn = Conn.conn.getConnection();
	private UsersVO vo;

	public UsersVO getUserCheck(String id) {
		vo = new UsersVO();
		try {
			String sql = "select * from users where usersId = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("usersIdx"));
				vo.setId(rs.getString("usersId"));
				vo.setPswd(rs.getString("usersPswd"));
				vo.setUsers_buyersIdx(rs.getInt("users_buyersIdx"));
			}
		} catch (SQLException e) {
			System.out.println("sql오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vo;
	}

	public int getUserJoin(UsersVO vo) {
		int res = 0;
		try {
			sql = "INSERT INTO users(usersId,usersPswd) VALUES (? , ? )";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPswd());

			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("sql오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
		
	}

}
