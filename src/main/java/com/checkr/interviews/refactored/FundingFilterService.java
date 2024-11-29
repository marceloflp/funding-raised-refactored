package com.checkr.interviews.refactored;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FundingFilterService {
	
	public List<String[]> filter(List<String[]> csvData, Map<String, String> options) {
        if (options.containsKey("company_name")) {
            csvData = filterByColumn(csvData, 1, options.get("company_name"));
        }
        if (options.containsKey("city")) {
            csvData = filterByColumn(csvData, 4, options.get("city"));
        }
        if (options.containsKey("state")) {
            csvData = filterByColumn(csvData, 5, options.get("state"));
        }
        if (options.containsKey("round")) {
            csvData = filterByColumn(csvData, 9, options.get("round"));
        }
        return csvData;
    }

    private List<String[]> filterByColumn(List<String[]> csvData, int columnIndex, String value) {
        List<String[]> results = new ArrayList<>();
        for (String[] row : csvData) {
            if (row[columnIndex].equals(value)) {
                results.add(row);
            }
        }
        return results;
    }
	

}
