package securityservices.datacheck;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {

	static Pattern pattern;
	static Matcher matcher;
	
	public static int checkDni(String dni){
		
		int error = -1;
		
		pattern = Pattern.compile("([0-9]{7,8})-?([A-Z])", Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(dni);
		
		if(matcher.matches()){
			
			int mod = Integer.parseInt(matcher.group(1)) % 23;
			error = digitControlDni(matcher.group(2), mod);
		}
		
		return error;
	}
	
	private static int digitControlDni(String letter, int mod){
		
		int error = -1;
		
		String[] controlDigit = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		
		if(controlDigit[mod].equals(letter.toUpperCase())) error = 0;
		
		return error;
	}
	
	public static int checkDate(String date ){
			
		int error = -1;
		
		Integer[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		pattern = Pattern.compile("(^\\d{1,2})[/-](\\d{1,2})[/-](\\d{1,4})$");
		matcher = pattern.matcher(date);
		
		if(matcher.matches()){
			
			int day = Integer.parseInt(matcher.group(1));
			int month = Integer.parseInt(matcher.group(2));
			int year = Integer.parseInt(matcher.group(3));
			
			if(!checkNumberDays(day, month, year, daysInMonth) && !checkNumberMonth(day, month, daysInMonth)) error = 0;
		}
		
		return error;
	}
	
	private static boolean checkNumberDays(int day, int month, int year, Integer[]daysInMonth){
		
		boolean error = true;
		
		if(checkIsLeapYear(year) && month == 2) day = day - 1;
		if(day <= daysInMonth[month-1]) error = false;
		
		return error;
	}
	
	private static boolean checkNumberMonth(int day, int month, Integer[]daysInMonth){
		
		boolean error = true;
				
		if(month <= daysInMonth.length+1) error = false;
		
		return error;
	}
	
	private static boolean checkIsLeapYear(int year){
		
		boolean isLeap = false;
		
		if ((year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0))) isLeap = true;
		
		return isLeap;
	}
	
	public static int diffDates(String firstDate, String secondDate){

		long diff = -1;
		
		String firstDateAlter = firstDate;
		String secondDateAlter = secondDate;
		
		if (containsDash(firstDate)) firstDateAlter = replaceDash(firstDate);
		if (containsDash(secondDate)) secondDateAlter = replaceDash(secondDate);
		if (containsSlash(firstDate)) firstDateAlter = replaceSlash(firstDate);
		if (containsSlash(secondDate)) secondDateAlter = replaceSlash(secondDate);
		
		if(checkOrderDates(Integer.parseInt(firstDateAlter), Integer.parseInt(secondDateAlter))){
			
			LocalDate dateBefore = null;
			LocalDate dateAfter = null;
			DateTimeFormatter formatter;
			
			if(containsDash(firstDate)) {
				
				formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
				dateBefore = LocalDate.parse(firstDate, formatter);
			}
			if (containsDash(secondDate)) {
				
				formatter = DateTimeFormatter.ofPattern("dd-M-yyyy");
				dateAfter = LocalDate.parse(secondDate, formatter);
			}
			if (containsSlash(firstDate)) {
				
				formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
				dateBefore = LocalDate.parse(firstDate, formatter);
			}
			if (containsSlash(secondDate)) {
				
				formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
				dateAfter = LocalDate.parse(secondDate, formatter);
			}
			
			diff = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		}
		
		return (int)diff;
	}
	
	private static boolean containsDash(String str) {
		
		boolean contains = false;
		
		if(str.contains("-")) contains = true;
		
		return contains;
	}
	
	private static boolean containsSlash(String str) {
	
		boolean contains = false;
		
		if(str.contains("/")) contains = true;
		
		return contains;
	}
	
	private static String replaceDash(String str) {
		
		return str.replaceAll("-", "");
	}
	
	private static String replaceSlash(String str) {

		return str.replaceAll("/", "");
	}
	
	private static boolean checkOrderDates(Integer dateBefore, Integer dateAfter){
	
		boolean order = false;
		
		if(dateBefore <= dateAfter) order = true;
		
		return order;
	}
	
	public static int checkEmail(String mail){
		
		int error = -1;
		
		pattern = Pattern.compile("^([\\w-\\.]+){2,64}@([\\w]+){2,64}.[a-z]{2,8}$", Pattern.CASE_INSENSITIVE);
		matcher = pattern.matcher(mail);
		
		if(matcher.matches()) error = 0;
		
		return error;
	}
}
