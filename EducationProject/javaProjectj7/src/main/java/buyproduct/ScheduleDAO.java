package buyproduct;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dbGrup.Conn;
import dbGrup.DAO;

public class ScheduleDAO extends DAO{

	private final Connection conn = Conn.conn.getConnection();
	private String sql = "";
	
	ScheduleVO vo = null;
	
	// pstmt 객체 반납
	public void pstmtClose() {
		if(pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {}
		}
	}
	
	// rs 객체 반납
	public void rsClose() {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {}
			finally {
				pstmtClose();
			}
		}
	}

	public ArrayList<ScheduleVO> getScheduleList(String serial,String ym) {
		ArrayList<ScheduleVO> vos = new ArrayList<ScheduleVO>();
		try {

		  sql = "select * from schedules where schedulesDiviceId = ? and date_format(schedulesTime, '%Y-%m') = ? ";
		  
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, serial);
			pstmt.setString(2, ym);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new ScheduleVO();
				vo.setCreateTime(rs.getString("schedulesCreateTime"));
				vo.setDiviceId(rs.getInt("schedulesDiviceId"));
				vo.setIdx(rs.getInt("schedulesIdx"));
				vo.setMemo(rs.getString("schedulesMemo"));
				vo.setTime(rs.getString("schedulesTime"));
				vo.setUserId(rs.getString("schedulesUsersId"));
				
				vos.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			rsClose();
		}
		return vos;
	}

	public int setScheduleInputOk(ScheduleVO vo) {
		int res = 0;
		try {
			sql = "insert into schedules (schedulesUsersId , schedulesMemo , schedulesTime , schedulesDiviceId) values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getMemo());
			pstmt.setString(3, vo.getTime());
			pstmt.setInt(4, vo.getDiviceId());
			
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 스케줄 삭제처리
	public int setScheduleDeleteOk(int idx) {
		int res = 0;
		try {
			sql = "delete from schedule where idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

	// 스케줄 수정처리하기
	public int setScheduleUpdateOk(ScheduleVO vo) {
		int res = 0;
		try {
			sql = "update schedules set schedulesMemo =? where schedulesIdx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getMemo());
			pstmt.setInt(2, vo.getIdx());
			res = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 오류 : " + e.getMessage());
		} finally {
			pstmtClose();
		}
		return res;
	}

}
