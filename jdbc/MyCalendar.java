package jdbc;

import java.util.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class MyCalendar {

	public static void main(String[] args) {
		
		Calendar cal=Calendar.getInstance();
		System.out.println(cal);
		int yr=cal.get(Calendar.YEAR);
		int mon=cal.get(Calendar.MONTH);
		int day=cal.get(Calendar.DATE);
		
		System.out.println(day+":"+(mon+1)+":"+yr);
		
		Date dt=new Date();
		long millis=dt.getTime();
		Calendar calndr=Calendar.getInstance();
		calndr.setTime(dt);
		calndr.setTimeInMillis(millis);
		
		LocalDate Id=LocalDate.now();
		System.out.println(Id);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-YYYY");
		System.out.println(dtf.format(Id));
		
		System.out.println(daysToDate("23-07-2020"));
		
	}
	
	public static long daysToDate(String date)
	{
		long  numDays=0;
		LocalDate today=LocalDate.now();
		System.out.println(today);
//		int thisyear=today.getYear();
//		int thismonth=today.getMonthValue();
//		int thisday=today.getDayOfMonth();
		
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy");
				
		LocalDate futureDate=LocalDate.from(dtf.parse(date));
//		int futureYear=futureDate.getYear();
//		int futuremonth=futureDate.getMonthValue();
//		int futureday=futureDate.getDayOfMonth();
//		
		numDays=ChronoUnit.DAYS.between(today,futureDate);

		//numDays=Idbday.compareTo(today);
		
		return numDays;
	}

}
