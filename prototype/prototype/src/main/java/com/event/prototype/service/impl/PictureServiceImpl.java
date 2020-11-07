package com.event.prototype.service.impl;

import com.event.prototype.data.converter.PictureConverter;
import com.event.prototype.data.entity.Picture;
import com.event.prototype.data.enums.PictureSize;
import com.event.prototype.exceptions.ServiceException;
import com.event.prototype.repository.PictureRepository;
import com.event.prototype.service.PictureService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;

@Service
public class PictureServiceImpl implements PictureService {

    private final PictureConverter pictureConverter;
    private final PictureRepository pictureRepository;

    public PictureServiceImpl(PictureConverter pictureConverter, PictureRepository pictureRepository) {
        this.pictureConverter = pictureConverter;
        this.pictureRepository = pictureRepository;
    }

    @Override
    public Picture create(MultipartFile multipartFile) {
        Picture newPicture = pictureConverter.fromMultipartFile(multipartFile);
        newPicture = pictureRepository.save(newPicture);
        return newPicture;
    }

    @Override
    public Picture findById(Long id) {
        return pictureRepository.findById(id).get();
    }

    @Override
    public String getPicInBase64(byte[] picData, String mimeType) {
        String base64Prefix = "data:" + mimeType + ";base64,";
        return base64Prefix + Base64.getEncoder().encodeToString(picData);
    }

    @Override
    public byte[] getPicBySize(Picture picture, PictureSize size) {

        if (size == null || size == PictureSize.SOURCE) {
            return picture.getSourcePic();
        } else if (size == PictureSize.SMALL) {
            if (picture.getSmallPic() == null) {
                picture.setSmallPic(resize(picture.getSourcePic(), PictureSize.SMALL, picture.getMimeType()));
            }
            return picture.getSmallPic();

        } else throw new ServiceException("Incorrect picture`s size");
    }



    private byte[] resize(byte[] data, PictureSize size, String mimeType) {

        BufferedImage sourcePicture = byteArrayToBufferedImage(data);

        String formatName = mimeType.substring(mimeType.lastIndexOf("/") + 1);
        int sourcePictureWidth = sourcePicture.getWidth();
        int sourcePictureHeight = sourcePicture.getHeight();

        int newPictureWidth;
        int newPictureHeight;

        if (sourcePictureWidth < size.getValue() && sourcePictureHeight < size.getValue()) {
            newPictureWidth = sourcePictureWidth;
            newPictureHeight = sourcePictureHeight;
        } else if (sourcePictureWidth >= sourcePictureHeight) {
            newPictureWidth = size.getValue();
            newPictureHeight = newPictureWidth * sourcePictureHeight / sourcePictureWidth;
        } else {
            newPictureHeight = size.getValue();
            newPictureWidth = newPictureHeight * sourcePictureWidth / sourcePictureHeight;
        }

        BufferedImage resizedPicture = new BufferedImage(newPictureWidth, newPictureHeight, sourcePicture.getType());

        Graphics2D g2d = resizedPicture.createGraphics();
        g2d.drawImage(sourcePicture, 0, 0, newPictureWidth, newPictureHeight, null);
        g2d.dispose();

        ByteArrayOutputStream newPictureStream = new ByteArrayOutputStream();
        try {
            ImageIO.write(resizedPicture, formatName, newPictureStream);
        } catch (IOException e) {
            throw new ServiceException("Write picture error.");
        }

        return newPictureStream.toByteArray();
    }

    private BufferedImage byteArrayToBufferedImage(byte[] data) {

        Optional.ofNullable(data).orElseThrow(() -> new IllegalArgumentException("Empty picture data."));

        BufferedImage sourcePicture;
        try(ByteArrayInputStream stream = new ByteArrayInputStream(data)) {
            sourcePicture = ImageIO.read(stream);
        } catch (IOException e) {
            throw new ServiceException("Convert picture error.");
        }

        Optional.ofNullable(sourcePicture).orElseThrow(() -> new IllegalArgumentException("Empty picture data."));
        return sourcePicture;
    }

}
