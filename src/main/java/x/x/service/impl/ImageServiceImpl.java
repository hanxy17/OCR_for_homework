package x.x.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;

import x.x.common.TesseractUtil;
import x.x.service.IImageService;

@Service 
public class ImageServiceImpl implements IImageService {

    //待识别的图片路径
    private static final String IMAGE_WAIT_FOR_OCR_PATH = "F:/a.png";
    
    @Override
    public String ImageOCR() {
        String result = null;
        File imageFile = new File(IMAGE_WAIT_FOR_OCR_PATH);
        /*
         * 1.引入单例 √
         * 2.动态传参
         * 3.构建页面
         * 4.上传文件
         */
        result = TesseractUtil.getInstance().doOCR(imageFile);  
        System.out.println(result);  
        return result;
    }

}
