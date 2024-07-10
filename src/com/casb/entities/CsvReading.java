package com.casb.entities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReading {
	
	//File file = new File("csvFile");
	Scanner sc = null;

	public List<String> readFile(File file) {
		
		List<String> lines = null;
		try {
			sc = new Scanner(file);
			lines = new ArrayList<>();
			
			while(sc.hasNextLine()) {
				
				lines.add(sc.nextLine());
			}
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			if(sc != null) {
				sc.close();
			}
		}
		return lines;
	}
}
