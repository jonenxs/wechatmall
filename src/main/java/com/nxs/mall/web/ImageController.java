package com.nxs.mall.web;

import com.nxs.mall.entity.ImageWithBLOBs;
import com.nxs.mall.entity.ImageWithBLOBsUseMultipartFile;
import com.nxs.mall.entity.Items;
import com.nxs.mall.service.ImageService;
import com.nxs.mall.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * Created by 57014 on 2017/2/15.
 */
@Component
@RequestMapping("/images")//url:模块/资源/{}/细分
public class ImageController {

    @Autowired
    private ImageService imageService;

    @RequestMapping(value="/insert",method=RequestMethod.POST)
    public String insert(ImageWithBLOBs imageWithBLOBs,MultipartFile image,Model model) throws Exception {
        String msg = imageService.imageInsert(imageWithBLOBs,image);
        return msg;
    }

    @RequestMapping(value = "/{id}/image")
    public void getImageById (@PathVariable("id") Integer id, final HttpServletResponse response,Model model) throws IOException{
        ImageWithBLOBs imageWithBLOBs = imageService.getImageById(id);
        byte[] data = imageWithBLOBs.getImageContent();
        response.setContentType("image/jpeg");
        response.setCharacterEncoding("UTF-8");
        OutputStream outputSream = response.getOutputStream();
        InputStream in = new ByteArrayInputStream(data);
        int len = 0;
        byte[] buf = new byte[1024];
        while ((len = in.read(buf, 0, 1024)) != -1) {
            outputSream.write(buf, 0, len);
        }
        outputSream.close();
    }

    @RequestMapping(value = "/{id}/imageid",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String list(@PathVariable("id") Integer id,Model model)
    {
        ArrayList<Integer> list = imageService.getImageidsByItemId(id);
        model.addAttribute("list",list);
        return "list";
    }

}
