package com.nxs.mall.dao;

import com.nxs.mall.entity.ImageWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by 57014 on 2017/2/20.
 */
public interface ImageDao {
    public void imageInsert(ImageWithBLOBs imageWithBLOBs);

    public ImageWithBLOBs getImageById(Integer id);

    public ArrayList<Integer> getImageidsByItemId(Integer id);
}
