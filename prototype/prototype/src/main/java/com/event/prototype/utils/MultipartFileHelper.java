package com.event.prototype.utils;

import com.event.prototype.exceptions.ServiceException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class MultipartFileHelper {

    public static byte[] getData(MultipartFile multipartFile) {
        byte[] fileData;

        try {
            fileData = multipartFile.getBytes();
        } catch (IOException e) {
            throw new ServiceException("Can`t get bytes from multipartFile. " + e.getCause());
        }
        return fileData;
    }
}
