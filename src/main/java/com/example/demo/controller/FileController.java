package com.example.demo.controller;


import com.example.demo.config.FileResponse;
import com.example.demo.service.FileService;
import com.example.demo.service.impl.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/upload")
public class FileController {


    @Autowired
    private FileService fileService;

    @Value("${project.image}")
    private String path;


    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileUpload(
            @RequestParam("image")MultipartFile image
            ) throws IOException {
        String fileName = this.fileService.uploadImage(path,image);

        return new ResponseEntity<FileResponse>(new FileResponse(fileName,"uploaded successfully"),HttpStatus.OK);

    }
}
