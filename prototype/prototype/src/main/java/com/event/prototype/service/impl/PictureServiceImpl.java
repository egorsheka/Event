package com.event.prototype.service.impl;

import com.event.prototype.data.converter.PictureConverter;
import com.event.prototype.data.entity.Picture;
import com.event.prototype.repository.PictureRepository;
import com.event.prototype.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureConverter pictureConverter;
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureConverter pictureConverter, PictureRepository pictureRepository) {
        this.pictureConverter = pictureConverter;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Picture update(Picture picture, MultipartFile multipartFile) {

        Picture newPicture = pictureConverter.fromMultipartFile(new Picture(), multipartFile);
        newPicture = pictureRepository.save(newPicture);
        return newPicture;
    }
}
