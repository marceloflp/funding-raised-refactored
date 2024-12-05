package com.checkr.interviews.refactored;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.checkr.interviews.refactored.exceptions.NoSuchEntryException;

public class FundingRaisedController {
	
	private static CSVReaderService csvReaderService;
    private static FundingFilterService fundingFilterService;
    private static DataMapperService dataMapperService;

    static {
        csvReaderService = new CSVReaderService();
        fundingFilterService = new FundingFilterService();
        dataMapperService = new DataMapperService();
    }

    public static List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<String[]> csvData = csvReaderService.readCSV("startup_funding.csv");
        csvData = fundingFilterService.filter(csvData, options);
        return dataMapperService.mapToOutput(csvData);
    }

    public static Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<String[]> csvData = csvReaderService.readCSV("startup_funding.csv");
        List<String[]> filteredData = fundingFilterService.filter(csvData, options);
        if (filteredData.isEmpty()) {
            throw new NoSuchEntryException();
        }
        return dataMapperService.mapToOutput(filteredData).get(0);
    }

}
