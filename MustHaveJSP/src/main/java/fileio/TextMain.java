package edu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TextMain {

	void readData(String fname) throws Exception {
		
		try(BufferedReader br = new BufferedReader(new FileReader(fname));) {
			String str;
			while((str = br.readLine()) != null) {
				System.out.println(str);
			}
		}
	}
	
	void writeData(String fname) throws Exception {
		
		List<String> list = new ArrayList<>();
		list.add("대한민국");
		list.add("Republic of Korea");

		try(PrintWriter pw = new PrintWriter(fname);) {
			for (String s : list) {
				pw.println(s);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		TextMain sm = new TextMain();

		sm.writeData("test.txt");
		sm.readData("test.txt");
		
		System.out.println("Done");
	}
}
