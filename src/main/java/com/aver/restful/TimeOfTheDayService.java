package com.aver.restful;

public interface TimeOfTheDayService {
	String getTimeOfTheDay();
	Time getTimeOfTheDayInXML(String name);
	Time getTimeOfTheDayInJSON(String name);
}
