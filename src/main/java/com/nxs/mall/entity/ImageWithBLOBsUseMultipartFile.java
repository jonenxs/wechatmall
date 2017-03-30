package com.nxs.mall.entity;

import com.nxs.wechat.message.response.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by 57014 on 2017/2/20.
 */
public class ImageWithBLOBsUseMultipartFile extends Image {
    private MultipartFile imageContentFile;

    public MultipartFile getImageContentFile() {
        return imageContentFile;
    }

    public void setImageContentFile(MultipartFile imageContentFile) {
        this.imageContentFile = imageContentFile;
    }
}
