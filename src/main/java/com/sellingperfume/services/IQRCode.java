package com.sellingperfume.services;

public interface IQRCode {
	public byte[] GenarateQR(String SerectKey, String username);

	public byte[] ConfigQRCode(String data, int width, int height);
	
	public String sendEmail(String email, String Supbject, String setText);
}
