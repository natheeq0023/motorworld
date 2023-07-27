package com.moaddi.utility;

import java.security.SecureRandom;
import java.util.Random;

public class OTPUtility {
	public static String generateOTP() {
       /* String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                     + "0123456789";*/
		 String chars ="0123456789";

        final int PW_LENGTH = 4;
        Random rnd = new SecureRandom();
        StringBuilder pass = new StringBuilder();
      
        for (int i = 0; i < PW_LENGTH; i++)
            pass.append(chars.charAt(rnd.nextInt(chars.length())));
        return pass.toString();
    }
	
}
