package x.x.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import x.x.service.IImageService;

@RestController
@RequestMapping("/image")
public class ImageController {
    
    @Resource(name = "imageServiceImpl")
    private IImageService imageService;
    
    @RequestMapping("/out")
    public String out() {
        return imageService.ImageOCR();
    }
}
