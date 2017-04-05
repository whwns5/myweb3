package yong.memo.model;

import java.sql.*;

public class MemoDAOImple implements MemoDAO {

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public int memoWrite(MemoDTO dto) {
		try{
			conn = yong.db.yongDB.getConn();
			
			String sql = "INSERT INTO memo VALUES(?, ?, ?)";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getIdx());
			ps.setString(2, dto.getTitle());
			ps.setString(3, dto.getContent());
			
			int count = ps.executeUpdate();
			
			return count;
			
		} catch (Exception e){
			e.printStackTrace();
			return -1;
		} finally {
			try{
				if(ps!=null)ps.close();
				if(conn!=null)ps.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

}
