package com.sellingperfume.services;

import org.springframework.web.multipart.MultipartFile;

public interface IUploadFile {
  public int UploadFile(String path, MultipartFile file); 
    
}
