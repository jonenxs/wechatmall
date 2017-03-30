package com.nxs.mall.entity;

import com.nxs.wechat.message.response.*;

/**
 * Created by 57014 on 2017/2/20.
 */
public class ImageWithBLOBs extends Image {
    private byte[] imageContent;

    public byte[] getImageContent() {
        return imageContent;
    }

    public void setImageContent(byte[] imageContent) {
        this.imageContent = imageContent;
    }
}
