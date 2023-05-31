package fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;


import membership.MemberDTO;

public class ObjectMain2 {

	public void serialize(MemberDTO obj, String fileName) throws IOException {
		Object m = null;
		List<MemberDTO> list = ArrayList<>();
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(obj);
		}
	}

//	public MemberDTO deserialize(String fileName) throws IOException, ClassNotFoundException {
//		MemberDTO m = null;
//		try (FileInputStream fis = new FileInputStream(fileName);
//				ObjectInputStream ois = new ObjectInputStream(fis);) {
//
//			m = (MemberDTO)ois.readObject();
//		}		
//		return m;
//	}	
	public MemberDTO deserialize1(String fileName) throws IOException, ClassNotFoundException {
		Object m = null;
		List<MemberDTO> list = ArrayList<>();
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			for(int i = 0; i < 3; i++) {
				m = ois.readObject();
				list.add((MemberDTO));
			}
			return list;
		}		

	}	
	
	public static void main(String[] args) throws Exception {
		
		ObjectMain2 om = new ObjectMain2();

		List<MemberDTO> list = ArrayList<>();
		list.add(new MemberDTO("100", "1234", "홍일동", "2023-05-31"));
		list.add(new MemberDTO("200", "1234", "홍이동", "2023-05-31"));
		list.add(new MemberDTO("300", "1234", "홍삼동", "2023-05-31"));
//		list.add(new MemberDTO("400", "1234", "홍사동", "2023-05-31"));
				
		MemberDTO m = om.deserialize1("testObject.dat");
		System.out.println(m);
	}
}
