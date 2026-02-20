package com.movies.Movie_Api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileServiceImp implements FileService {

    @Override
    public String uploadFile(String path, MultipartFile file) throws IOException {

        // get name of file
        String fileName = file.getOriginalFilename();

        // to get the file path
        String filePath = path + File.separator + fileName;

        // create file object
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }

        // copy the file or upload the file to path
        Files.copy(file.getInputStream(), Paths.get(filePath));

        return fileName;
    }

    @Override
    public InputStream getFile(String path, String fileName) throws FileNotFoundException {
        String filePath = path + File.separator + fileName;

        return new FileInputStream(filePath);
    }
}
