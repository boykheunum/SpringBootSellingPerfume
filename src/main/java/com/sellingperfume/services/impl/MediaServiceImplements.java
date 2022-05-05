package com.sellingperfume.services.impl;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.sellingperfume.services.IQRCode;
import com.sellingperfume.services.IUploadFile;

@Service
public class MediaServiceImplements implements IUploadFile, IQRCode {
	@Autowired
	public JavaMailSender emailSender;

	@Override
	public int UploadFile(String path, MultipartFile file) {
		// TODO Auto-generated method stub
		File avatarRootPathFile = new File(path);
		if (!avatarRootPathFile.exists()) {
			avatarRootPathFile.mkdir();
		}
		List<File> uploadedFiles = new ArrayList<File>();
		// ten file goc tai client
		String fileName = file.getOriginalFilename();
		// tao file tai server
		File fileSever = new File(avatarRootPathFile.getAbsoluteFile() + File.separator + fileName);
		try {
			BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileSever));
			stream.write(file.getBytes());
			stream.close();
			uploadedFiles.add(fileSever);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -2;
		}
		return 1;
	}

	@Override
	public byte[] GenarateQR(String SerectKey, String username) {
		// TODO Auto-generated method stub
		String data = String.format("otpauth://totp/%s?secret=%s&issuer=%s", username, SerectKey, "SellingPerFume");
		return ConfigQRCode(data, 300, 300);
	}

	@Override
	public byte[] ConfigQRCode(String data, int width, int height) {
		// TODO Auto-generated method stub
		QRCodeWriter qrCodeWriter = new QRCodeWriter();
		try {
			BitMatrix matrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			MatrixToImageWriter.writeToStream(matrix, "PNG", outputStream);
			byte[] pngByteArray = outputStream.toByteArray();
			return pngByteArray;
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String sendEmail(String email, String Supbject, String setText) {
		// TODO Auto-generated method stub
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject(Supbject);
		message.setText(setText);
		// Send Message!
		this.emailSender.send(message);
		return "Email Sent!";

	}
}
