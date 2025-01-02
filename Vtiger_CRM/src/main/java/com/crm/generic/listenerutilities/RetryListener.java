package com.crm.generic.listenerutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{

	@Override
	public boolean retry(ITestResult result) {
		int count = 0, limitcount =5;
		if(count<limitcount) {
			count++;
			return true;
		}
		return false;
	}

}
