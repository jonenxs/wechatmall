package com.nxs.mall.service;

import com.nxs.mall.entity.ImageWithBLOBs;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by 57014 on 2017/2/20.
 */
public interface ImageService {
    public String imageInsert (ImageWithBLOBs imageWithBLOBs,MultipartFile  image) throws IOException ;
    public ImageWithBLOBs getImageById(Integer id);
    public ArrayList<Integer> getImageidsByItemId(Integer id);
}
