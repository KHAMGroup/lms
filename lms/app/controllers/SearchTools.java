package controllers;

public class SearchTools {
	private static String firstOrLastRegex = " *[a-zA-Z0-9]* *";
	private static String firstThenLastRegex = " *[a-zA-Z0-9]* *[a-zA-Z0-9]* *";
	private static String lastThenFirstRegex = " *[a-zA-Z0-9]* *, *[a-zA-Z0-9]* *";
	
	public static boolean isFirstOrLast(String name){
		return name.matches(firstOrLastRegex);
	}
	
	public static boolean isFirstThenLast(String name){
		return name.matches(firstThenLastRegex);
	}
	
	public static boolean isLastThenFirst(String name){
		return name.matches(lastThenFirstRegex);
	}

}
