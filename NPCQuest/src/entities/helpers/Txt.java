package entities.helpers;

public class Txt {
	public static final String ONE_SKULL = "Power of speech skull fills you.\nPress X to copy words.\nPress Z to ignore them.";
	
	public static final String ELLIPSE = "..."; 
	public static final String COPYING = "Stop copying me!";
	public static final String WARTKISS = "A kiss from the pox wart...";
	public static final String DESIRE = "What do you want?!";
	public static final String INQUIRY = "Then what is it!?";
	public static final String GRATITUDE = "...Thank you...";
	public static final String CONFIDENCE = "I know what I want.";
	public static final String NO_TIME = "We don't have much time left.";
	
	public static String PoxWartSpeak(String initiator){
		if (initiator.equals(DESIRE))
			return COPYING;
		if (initiator.equals(WARTKISS))
			return GRATITUDE;
		if (initiator.equals(CONFIDENCE))
			return INQUIRY;
		
		return DESIRE;
	}
	
	public static String TreeSpeak(String initiator){
		if (initiator.equals(DESIRE) || initiator.equals(INQUIRY))
			return WARTKISS;
		if (initiator.equals(CONFIDENCE))
			return ELLIPSE;
		if (initiator.equals(WARTKISS))
			return COPYING;

		return CONFIDENCE;
	}
	
	public static String CatSpeak(String initiator){
		return NO_TIME;
	}
}
