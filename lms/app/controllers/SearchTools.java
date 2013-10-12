package controllers;

public class SearchTools {
	private static String firstOrLastRegex = "";
	private static String firstThenLastRegex = "";
	private static String lastThenFirstRegex = "";
	
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
