package com.pravin.util;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class RandomUtil {
	
	public static int getAge(LocalDate date) {
		
		int years = Period.between(date, LocalDate.now()).getYears();
		
		return years;
	}

}
