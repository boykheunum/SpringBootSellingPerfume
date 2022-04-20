package com.sellingperfume.services.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sellingperfume.services.IUploadFile;
@Service
public class MediaServiceImplements implements IUploadFile {

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
}
