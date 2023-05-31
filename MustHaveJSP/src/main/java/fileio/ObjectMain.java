package edu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edu.domain.Member;

public class ObjectMain {

	public void serialize(Member obj, String fileName) throws IOException {
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {

			oos.writeObject(obj);
		}
	}

	public Member deserialize(String fileName) throws IOException, ClassNotFoundException {
		Member m = null;
		try (FileInputStream fis = new FileInputStream(fileName);
				ObjectInputStream ois = new ObjectInputStream(fis);) {

			m = (Member)ois.readObject();
		}		
		return m;
	}	
	
	public static void main(String[] args) throws Exception {
		
		ObjectMain om = new ObjectMain();

		om.serialize(new Member(100, "홍길동", 1000), "testObject.dat");
		
		Member m = om.deserialize("testObject.dat");
		System.out.println(m);
	}
}
