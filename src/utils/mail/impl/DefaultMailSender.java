package utils.mail.impl;

import utils.mail.MailSender;

public class DefaultMailSender implements MailSender{
	
	
	private static DefaultMailSender instance;
	
	private DefaultMailSender() {};
	
	public static DefaultMailSender getInstance() {
		if (instance == null) {
			instance = new DefaultMailSender();
		}
		return instance;
		
	};


	public void sendEmail(String sendTo, String messageToSend) {
		
	}
	

}
