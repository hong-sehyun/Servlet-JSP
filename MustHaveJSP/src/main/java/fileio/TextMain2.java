package fileio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import membership.MemberDTO;

public class TextMain2 {

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
		TextMain2 sm = new TextMain2();
		
		List<MemberDTO> list = ArrayList<>();
		list.add(new MemberDTO("100", "1234", "홍이동", ))

		sm.writeData("test.txt");
		sm.readData("test.txt");
		
		System.out.println("Done");
	}
}
