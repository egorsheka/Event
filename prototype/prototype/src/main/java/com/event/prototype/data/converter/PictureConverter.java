package com.event.prototype.data.converter;

import com.event.prototype.data.entity.Picture;
import com.event.prototype.utils.MultipartFileHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class PictureConverter {

    public Picture fromMultipartFile(Picture picture, MultipartFile multipartFile) {
        byte[] picData = MultipartFileHelper.getData(multipartFile);
        picture.setSourcePic(picData);
        picture.setMimeType(multipartFile.getContentType());
        return picture;
    }
}
