package com.metanonia.form_sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/")
public class CommonController {
    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/form_data")
    public String formData(@RequestParam HashMap<String,Object>map,
                           @RequestPart(value="file1", required = false) MultipartFile file1,
                           @RequestPart(value="file2", required = false) MultipartFile file2) {
        log.info(map.toString());
        if(file1 != null) {
            log.info("file1=>"+file1.getName() + ":" + file1.getOriginalFilename() + ":" + file1.getContentType() + ":" + file1.getSize());
        }
        if(file2 != null) {
            log.info("file2=>"+file2.getName() + ":" + file2.getOriginalFilename() + ":" + file2.getContentType() + ":" + file2.getSize());
        }
        return "form";
    }
}
