package techtest.bdd.shared;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Utilities {

	public static String getRandomString(int len) {
        String SALTCHARS = "ABCDE FGHIJKLMNO PQRSTUVWXYZ abcdefghijk lmnopqrst uvwxyz";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < len) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	public static String getRandomDate() {
		//Return random date +/- 1 year from today in String format for API

		
		LocalDate localDate = LocalDate.now().minusDays(365);
		
		Random rnd = new Random();

		localDate.plusDays(rnd.nextInt(730));
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatDate = localDate.format(formatter);
		
		return formatDate;//+"T00:00:00.000Z";
		
		

    }
	
	public static String getTodayPlusDays(long days) {
		LocalDate localDate = LocalDate.now().plusDays(days);
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formatDate = localDate.format(formatter);
		
		return formatDate;
	}
	
	
	
}
