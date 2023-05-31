package edu;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class StreamMain {

	void readByte(String fname) throws Exception {
		int b;
		try (FileInputStream fis = new FileInputStream(fname)) {
			while((b = fis.read()) != -1) {
				System.out.println(b);
			}
		}
	}
	
	void writeByte(String fname) throws Exception {
		
		byte [] arr = { 1, 2, 3, 4, 5 };
		
		try(FileOutputStream fos = new FileOutputStream(fname);) {
			
			for (byte b : arr) {
				fos.write(b);
			}
		}
	}

	void readString(String fname) throws Exception {
		
		int b;
		try(FileInputStream fis = new FileInputStream(fname);) {

			while((b = fis.read()) != -1) {
				System.out.println(b);
			}
		}
	}
	
	void writeString(String fname) throws Exception {
		
		List<String> list = new ArrayList<>();
		list.add("대한민국");
		list.add("Republic of Korea");
		
		try(FileOutputStream fos = new FileOutputStream(fname);) {
			
			for (String s : list) {
				fos.write(s.getBytes());
			}
		}
	}	
	
	public static void main(String[] args) throws Exception {
		StreamMain sm = new StreamMain();

		sm.writeByte("testByte.bin");
		sm.readByte("testByte.bin");

		System.out.println("-".repeat(50));
		
		sm.writeString("testString.bin");
		sm.readString("testString.bin");
		
		System.out.println("Done");
	}

}
