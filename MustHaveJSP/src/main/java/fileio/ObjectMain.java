package fileio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import membership.MemberDTO;

public class ObjectMain {

	public void serialize(MemberDTO obj, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(obj);
		}
	}

	public MemberDTO deserialize(String fileName) throws IOException, ClassNotFoundException {
		MemberDTO m = null;
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			m = (MemberDTO)ois.readObject();
		}		
		return m;
	}	
	
	public static void main(String[] args) throws Exception {
		
		ObjectMain om = new ObjectMain();

		om.serialize(new MemberDTO("dong", "1234", "홍길동","2023-05-31 18:01:50"), "testObject.dat");
		
		MemberDTO m = om.deserialize("testObject.dat");
		System.out.println(m);
	}
}
