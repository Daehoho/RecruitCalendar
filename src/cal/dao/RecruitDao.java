package cal.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cal.vo.Recruit;

public class RecruitDao {
	Connection connection;
	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public List<Recruit> selectList() throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(
					"SELECT NO, KIND, NAME, START, END, LINK, END_STATE" +
					" FROM RECRUIT" +
					" ORDER BY END ASC");
			
			ArrayList<Recruit> recruits = new ArrayList<Recruit>();
			
			while (rs.next()) {
				recruits.add(new Recruit()
						.setNo(rs.getInt("NO"))
						.setKind(rs.getString("KIND"))
						.setName(rs.getString("NAME"))
						.setStart(rs.getDate("START"))
						.setEnd(rs.getDate("END"))
						.setUrl(rs.getString("LINK"))
						.setEndState(rs.getBoolean("END_STATE")));
			}
			return recruits;
			
		} catch (Exception e) {
			throw e;
		} finally {
			try {if (rs != null) rs.close();} catch(Exception e) {}
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
		}
	}
	
	public void insert(Recruit recruit) throws Exception {
		PreparedStatement stmt = null;
		//SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		 try {
			 stmt = connection.prepareStatement(
					 "INSERT INTO RECRUIT(KIND, NAME, START, END, LINK)"
					  + " VALUES (?, ?, ?, ? ,?)");
			 stmt.setString(1, recruit.getKind());
			 stmt.setString(2, recruit.getName());
			 stmt.setDate(3, (Date) recruit.getStart());
			 stmt.setDate(4, (Date) recruit.getEnd());
			 stmt.setString(5, recruit.getUrl());
			 stmt.executeUpdate();
			
		 } catch (Exception e) {
			 throw e;
		 } finally {
			try {if (stmt != null) stmt.close();} catch(Exception e) {}
		 }
	}
}
