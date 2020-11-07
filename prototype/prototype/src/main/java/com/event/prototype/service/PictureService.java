package com.event.prototype.service;

import com.event.prototype.data.entity.Picture;
import com.event.prototype.data.enums.PictureSize;
import org.springframework.web.multipart.MultipartFile;


public interface PictureService{


    Picture findById(Long id);
    String getPicInBase64(byte[] picData, String mimeType);
    byte[] getPicBySize(Picture picture, PictureSize size);
    Picture create(MultipartFile multipartFile);
}
