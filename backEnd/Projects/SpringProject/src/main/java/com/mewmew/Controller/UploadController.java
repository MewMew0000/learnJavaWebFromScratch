package com.mewmew.Controller;

import com.mewmew.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @PostMapping("upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception {
        log.info("upload username:{},age:{},image:{}", username, age, image);
        String originalFilename = image.getOriginalFilename();
        int index = originalFilename.lastIndexOf(".");
        String suffix = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + suffix;
        log.info("upload image:{}", newFileName);
        image.transferTo(new File("C:\\Users\\MewMew\\Pictures\\test\\" + newFileName));
        return Result.success();
    }
}
