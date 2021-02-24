package com.cgd.ebook.boighor.lib;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.Random;




//import Decoder.BASE64Decoder;
//import Decoder.BASE64Encoder;

public class Xiaolong 
{
	private static Random rand = new Random((new Date()).getTime());

	public static String encrypt(String str) 
	{

//		BASE64Encoder encoder = new BASE64Encoder();
//		byte[] salt = new byte[8];
//		rand.nextBytes(salt);
//		return new String(Base64.encodeBase64(str.getBytes()));;
		String originalInput = "test input";
		String encodedString = null;
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
			encodedString = Base64.getEncoder().encodeToString(str.getBytes());
		}
		return encodedString;
	}

	public static String decrypt(String encstr) 
	{
		byte[] decodedBytes = new byte[0];
		if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
			decodedBytes = Base64.getDecoder().decode(encstr);
		}
		String decodedString = new String(decodedBytes);
		return decodedString;
//		if (encstr.length() > 12)
//		{
//			String cipher = encstr.substring(12);
////			BASE64Decoder decoder = new BASE64Decoder();
//			try
//			{
//				byte[] decodedBytes = Base64.getDecoder().decode(encodedString);
//				String decodedString = new String(decodedBytes);
//			}
//			catch (IOException e)
//			{
//				// throw new InvalidImplementationException(
//				// Fail
//			}
//		}
//		return null;
	}
}