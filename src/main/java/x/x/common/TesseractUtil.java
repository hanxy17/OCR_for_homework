package x.x.common;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/*
 * 关于单例模式的实现,如果采用double check+volatile的方式,如何重现无volatile的弊端
 * 弊端详解 http://blog.csdn.net/bitcarmanlee/article/details/71179709
 */
public class TesseractUtil {

    private volatile static TesseractUtil tcUtil = null;
    private static Tesseract tessreact = null;
    
    //识别训练库存放路径
    private static final String TESSDATA_PATH ="F:/tessdata";
    
    private TesseractUtil(){
        initTesseract();
    }
    
    private static synchronized void syncInit() {
        if(tcUtil == null) {
            tcUtil = new TesseractUtil();
        }
    }
    
    public static TesseractUtil getInstance () {
        if(tcUtil == null) {
            syncInit();
        }
        return tcUtil;
    }
    
    private void initTesseract() {
        tessreact = new Tesseract();
        tessreact.setDatapath(TESSDATA_PATH);
        //设置识别训练库为中文
        tessreact.setLanguage("chi_sim");
    }
    
    public String doOCR(File imageFile) {
        String result = null;
        try {
            result = tessreact.doOCR(imageFile);
        } catch (TesseractException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    
    public void setLanguage(String language) {
        tessreact.setLanguage(language);
    }
    
}
