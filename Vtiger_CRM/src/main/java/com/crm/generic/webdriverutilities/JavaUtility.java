package com.crm.generic.webdriverutilities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(1000);
	}
	
	public StringBuilder getRandomPhoneNumber() {
		Random random = new Random();
		int firstdigit = random.nextInt(4) + 6;
		StringBuilder mobilenumber = new StringBuilder();
		mobilenumber.append(firstdigit);
		for(int i=0;i<9;i++) {
			mobilenumber.append(random.nextInt(10));
		}
		return mobilenumber;
	}
	
	public String getLocalDateTime() {
		return LocalDateTime.now().toString().replace(":", "-");
	}
	
	public String getSystemDate() {
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		return simple.format(date);
	}
	
	public String getCalculatedDate(int days) {
		Date date = new Date();
		SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		simple.format(date);
		Calendar calendar = simple.getCalendar();
		calendar.add(Calendar.DAY_OF_MONTH,days);
		return simple.format(calendar.getTime());
		
	}
}
