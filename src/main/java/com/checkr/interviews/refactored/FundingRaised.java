package com.checkr.interviews.refactored;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FundingRaised {
	
	public static void main(String[] args) throws NoSuchEntryException {
        try {
            FundingRaisedController fundingRaised = new FundingRaisedController();
            Map<String, String> options = new HashMap<>();
            options.put("company_name", "Facebook");
            options.put("round", "a");
            System.out.print(fundingRaised.where(options).size());
        } catch(IOException e) {
            System.out.print(e.getMessage());
            System.out.print("error");
        }
    }

}