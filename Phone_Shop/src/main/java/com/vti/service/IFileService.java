package com.vti.service;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {

	String uploadImage(MultipartFile image, Long id) throws IOException;

	File dowwnloadImage(String nameImage) throws IOException;

	String getImgNameByID(Long id);

}
