package com.checkr.interviews.refactored;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FundingRaisedController {
	
	private final CSVReaderService csvReaderService;
    private final FundingFilterService fundingFilterService;
    private final DataMapperService dataMapperService;

    public FundingRaisedController() {
        this.csvReaderService = new CSVReaderService();
        this.fundingFilterService = new FundingFilterService();
        this.dataMapperService = new DataMapperService();
    }

    public List<Map<String, String>> where(Map<String, String> options) throws IOException {
        List<String[]> csvData = csvReaderService.readCSV("startup_funding.csv");
        csvData = fundingFilterService.filter(csvData, options);
        return dataMapperService.mapToOutput(csvData);
    }

    public Map<String, String> findBy(Map<String, String> options) throws IOException, NoSuchEntryException {
        List<String[]> csvData = csvReaderService.readCSV("startup_funding.csv");
        List<String[]> filteredData = fundingFilterService.filter(csvData, options);
        if (filteredData.isEmpty()) {
            throw new NoSuchEntryException();
        }
        return dataMapperService.mapToOutput(filteredData).get(0);
    }

}

class NoSuchEntryException extends Exception {}