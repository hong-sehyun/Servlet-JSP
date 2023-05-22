package membership;

import java.util.ArrayList;

public class MemeberDAOTest {
	private static MemberDAO memberDAO = new MemberDAO();

	//static 인스턴트(객체) 생성없이 호출 가능
	public static void main(String[] args) {
	//	MemberDTO memberDTO = memberDTO.getMemberDTO("test1", "1111");
	//	System.out.println(memberDTO);

//	ArrayList<MemberDTO> list = memberDAO.getAllMemberDTO();
//	for (MemberDTO m : list) {
//		System.out.println(m);
//	}
		
		//insertMemberDTO
//		MemberDTO memberDTO = new MemberDTO();
//		memberDTO.setId("hong");
//		memberDTO.setPass("1234");
//		memberDTO.setName("홍길동");
//		memberDAO.insertMemberDTO(memberDTO);
		
		
		//updateMemberDTO
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setPass("1111");
		memberDAO.insertMemberDTO(memberDTO);
	
	}
}
