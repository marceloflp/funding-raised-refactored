package com.checkr.interviews.refactored;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class CSVReaderService {
	
	public List<String[]> readCSV(String filePath) throws IOException {
        List<String[]> csvData = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] row;
            while((row = reader.readNext()) != null) {
                csvData.add(row);
            }
            reader.close();
            csvData.remove(0);
        }
        return csvData;
    }

}
