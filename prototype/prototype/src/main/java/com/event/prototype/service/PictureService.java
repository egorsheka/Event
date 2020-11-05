package com.event.prototype.service;

import com.event.prototype.data.entity.Picture;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService{

    Picture update(Picture picture, MultipartFile multipartFile);
}
