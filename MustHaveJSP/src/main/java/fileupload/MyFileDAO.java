package fileupload;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import common.JDBCConnect3;



public class MyFileDAO extends JDBCConnect3 {
	
	public int insertFile(MyFileDTO dto) {
		Connection con = getConnection();
		if (con == null) return 0;
		
		PreparedStatement psmt = null;

		int applyResult = 0;
		
		try {			
			String query = "insert into myfile (name, title, cate, ofile, sfile)"
					+ " values (?,?,?,?,?)";
			psmt = con.prepareStatement(query);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getTitle());
			psmt.setString(3, dto.getCate());
			psmt.setString(4, dto.getOfile());
			psmt.setString(5, dto.getSfile());
			
			applyResult = psmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("INSERT 중 예외 발생");
		} finally {
			try {
				if (psmt != null)
					psmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return applyResult;
	}
	
	public List<MyFileDTO> myFileList() {
		Connection con = getConnection();
//		if (con == null) return 0;		
		PreparedStatement psmt = null;
		ResultSet rs;
		List<MyFileDTO> fileList = new Vector<MyFileDTO>();
		
		String query = "select * from myfile order by idx DESC";
		try {
			psmt = con.prepareStatement(query);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				MyFileDTO dto = new MyFileDTO();
				dto.setIdx(rs.getString(1));
				dto.setName(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setCate(rs.getString(4));
				dto.setOfile(rs.getString(5));
				dto.setSfile(rs.getString(6));
				dto.setPostdate(rs.getString(7));
				
				fileList.add(dto);
			}
			
		}
		catch (Exception e) {
			System.out.println("select 시 예외 발생");
			e.printStackTrace();
		}
		return fileList;
		
		
	}
	

	public static void main(String[] args) {
//		1. 데이터 타입 객체를 만들고
		MyFileDAO dao = new MyFileDAO();
//		2. DTO 객체를 생성해서 입력한다.		
		MyFileDTO dto = new MyFileDTO();
		
//		3. 입력할 파일을 DTO 객체에 설정하고
		dto.setName("a1");
		dto.setTitle("b1");
		dto.setCate("c1");
		dto.setOfile("d1");
		dto.setSfile("e1");

//		4. 데이터를 입력한다.
		dao.insertFile(dto);
		
		
		
		
//		OR 2단계 만에 입력하는 법		
		
////		1. 데이터 타입 객체를 만들고		
//		MyFileDAO dao = new MyFileDAO();
////		2. DTO 객체를 생성해서 입력한다.				
//		dao.insertFile(new MyFileDTO("a", "b", "c", "d", "e") );
	}
	
	

}
