package x.x.service.impl;

import java.io.File;

import org.springframework.stereotype.Service;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import x.x.service.IImageService;

@Service 
public class ImageServiceImpl implements IImageService {

    //待识别的图片路径
    private static final String IMAGE_WAIT_FOR_OCR_PATH = "F:/a.png";
    
    //识别训练库存放路径
    private static final String TESSDATA_PATH ="F:/tessdata";
    
    @Override
    public String ImageOCR() {
        String result = null;
        
        File imageFile = new File(IMAGE_WAIT_FOR_OCR_PATH);
        Tesseract tessreact = new Tesseract();
        tessreact.setDatapath(TESSDATA_PATH);
        //设置识别训练库为中文
        tessreact.setLanguage("chi_sim");
        try {  
            result = tessreact.doOCR(imageFile);  
            System.out.println(result);  
        } catch (TesseractException e) {  
            System.err.println(e.getMessage());  
        }  
        return result;
    }

}
