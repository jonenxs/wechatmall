package com.nxs.mall.service.impl;

import com.nxs.mall.dao.ImageDao;
import com.nxs.mall.entity.ImageWithBLOBs;
import com.nxs.mall.service.ImageService;
import com.nxs.mall.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by 57014 on 2017/2/20.
 */
@Service
public class ImageServiceImpl implements  ImageService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ImageDao imageDao;

    @Override
    public String imageInsert(ImageWithBLOBs imageWithBLOBs,MultipartFile  image) throws IOException {
        //上传图片


        //转换图片格式 :MultipartFile --> byte
        byte[] imageBytes = image.getBytes();
        imageWithBLOBs.setImageName(image.getOriginalFilename());
        imageWithBLOBs.setImageContent(imageBytes);//将转换后的byte[]存入到imageWithBLOBs类中byte[]字段
        imageDao.imageInsert(imageWithBLOBs);
        return "success";
    }

    @Override
    public ImageWithBLOBs getImageById(Integer id) {
        return imageDao.getImageById(id);
    }

    @Override
    public ArrayList<Integer> getImageidsByItemId(Integer id) {
        return imageDao.getImageidsByItemId(id);
    }

}
