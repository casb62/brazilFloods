package com.casb.entities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReading {

	public List<String> readFile() {

		String path = "csvFile";
		List<String> list = null;
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line != null){
				list = new ArrayList<>();
				list.add(line);
				line = br.readLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return list;
	}
}