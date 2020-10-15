package com.example.spingboottext.controller;

import com.example.spingboottext.model.Result;
import com.example.spingboottext.model.User;
import com.example.spingboottext.service.storage.StorageService;
import com.example.spingboottext.service.user.UserService;
import com.example.spingboottext.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class FileUploadController {
    @Autowired
    StorageService storageService;
    @Autowired
    UserService userService;
    // 跳转到上传图片的界面
    @GetMapping("/upload")
    public String showUploadPage(Model model) throws IOException {

        return "uploadForm";

    }

    // 以POST方式获得请求，图片上传成功后，以JSON格式将图片返回，用于回显 
    @PostMapping("/upload")
    @CrossOrigin
    @ResponseBody
    public Result handleFileUpload(@RequestParam("file") MultipartFile file,long userId) {
        String imgUrl = "/upload-dir/" + file.getOriginalFilename();
        storageService.store(file);
        User user=(User)userService.byIdgetUser(userId).getData();
        user.setPortrait(imgUrl);
        if(user!=null)
            userService.updatePortrait(imgUrl,userId);
        return ResultUtil.success(user);
    }
}