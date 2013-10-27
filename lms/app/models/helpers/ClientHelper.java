package models.helpers;

import models.Client;

public class ClientHelper {

	public static Client getClientForViewing(Client theClient){
		String officePhone = theClient.getOfficePhone();
		String formattedOfficePhone = officePhone.format("()", officePhone);
		return theClient;
	}
	
	private static final String formatPhoneNumber(String number){
		String toReturn = number;
		if(number.length() == 10){
			
		}
		return toReturn;
	}

}
