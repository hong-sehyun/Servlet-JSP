package membership;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import common.JDBCConnect3;

public class MemberDAO extends JDBCConnect3 {
	public MemberDAO() {}
	
	 public MemberDAO(ServletContext application) {
	        super(application);
	    }



//	public JDBCConnect3 (String drv, String url, String id, String pwd) {
//		this.drive = drive;
//		this.url = url;
//		this.id = id;
//		this.pwd = pwd;
//	}
//	
	public MemberDAO(String drv, String url, String id, String pw) {
		super(drv, url, id, pw);
	}
	
	//executeQuery 사용----------------

	
	public ArrayList<MemberDTO> getAllMemberDTO() {

		ArrayList<MemberDTO> list = null;
		Connection con = getConnection();
		if (con == null) return null;
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from member");
			
			list = new ArrayList<>();
			
			while ( rs. next()) {
				MemberDTO dto = new MemberDTO();		
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));
				
				list.add(dto);
			}
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();			
				if(st != null) st.close();			
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();	
			}
		}
		return list;	
		}
	

//	public MemberDTO getMemberDTO(String uid, String upass) {
//		return null;
//	}

	public MemberDTO getMemberDTO(String uid, String upass) {
		MemberDTO dto = new MemberDTO();		
		
		String query = "select * from member where id=? and pass=?";
		
		Connection con = getConnection();
		if (con == null) return null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, uid);
			psmt.setString(2, upass);
			rs = psmt.executeQuery();
			
			if ( rs. next()) {
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString(3));
				dto.setRegidate(rs.getString(4));

			}
		}  catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();			
				if(psmt != null) psmt.close();			
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();	
			}
		}
		return dto;
	}
	//executeUpdate 사용----------------
	public int insertMemberDTO(MemberDTO member) {
		Connection con = getConnection();
		if (con == null) return 0;
		PreparedStatement psmt = null;
		int ret = 0;
		String query = "insert into member(id, pass, name) values (?, ?, ?)";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getId());
			psmt.setString(2, member.getPass());
			psmt.setString(3, member.getName());
			ret = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(psmt != null) psmt.close();			
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();	
			}
		}
		return ret;
	}

	public int updateMemberDTO(MemberDTO member) {
		Connection con = getConnection();
		if (con == null) return 0;
		PreparedStatement psmt = null;
		int ret = 0;
		String query = "update  member set pass=?";
		try {
			psmt = con.prepareStatement(query);
			psmt.setString(1, member.getPass());
			ret = psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(psmt != null) psmt.close();			
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();	
			}
		}
		return ret;
	}

//	public int deletetMemberDTO(String uid) {
//
//	}
}
