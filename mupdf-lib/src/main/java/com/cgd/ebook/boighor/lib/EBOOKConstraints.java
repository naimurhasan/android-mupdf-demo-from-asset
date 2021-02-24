package com.cgd.ebook.boighor.lib;


public interface EBOOKConstraints 
{
	
	//Encrypted Code Password: pis618
	public static final String EBOOK_ENCRYPTED_CODE = "ww2Z7hmA1LE=cGlzNjE4";
	public static final String APP_ID = "CGD102";
	
	// Dont's change these values.
	public static final String EBOOK_CHAPTER	= "chapter";
	public static final String EBOOK_LINK		= "link";
	public final static String SER_KEY			= "com.cgd.ebook.boighor.ser";

	public final static String AUTH_INPUT_ERROR_MSG = "Please enter all fields value.";
	public final static String AUTH_INTERNET_CONN_MSG = "Please enable your internet connectivity.";
	public final static String MAC_ADDR_ERROR = "Device don't have mac address or wi-fi is disabled.";

	public final static String REMOTE_AUTH_URL			= "http://chorui.com/activate/activate.php";
	//public final static String REMOTE_AUTH_URL		= "https://posttestserver.com/post.php?dir=yzaman&status_code=200&sleep=2";

	public final static boolean DEV_MODE = false;
	
	public final static String DEV_TOKEN_NUMBER = "cgddipu@gmail.com";
	public final static String DEV_EMAIL_ADDRESS = "cgddipu@gmail.com";
}
