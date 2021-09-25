package com.vti.service;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.vti.entity.Product;
import com.vti.repository.IProductRepository;
import com.vti.ultis.FileManager;

@Service
public class FileService implements IFileService {
	@Autowired
	private IProductRepository productRepo;

	private FileManager fileManager = new FileManager();
	private String linkFolder = "F:\\Code\\Frontend\\IMG";

	@Override
	public String uploadImage(MultipartFile image, Long id) throws IOException {

		String nameImage = new Date().getTime() + "." + fileManager.getFormatFile(image.getOriginalFilename());

		String path = linkFolder + "\\" + nameImage;

		fileManager.createNewMultiPartFile(path, image);

		// TODO save link file to database
		Product product = productRepo.getById(id);
		product.setImage(nameImage);
		productRepo.save(product);
		// return link uploaded file
		return path;
	}

	@Override
	public File dowwnloadImage(String nameImage) throws IOException {

		String path = linkFolder + "\\" + nameImage;

		return new File(path);
	}

	@Override
	public String getImgNameByID(Long id) {
		Product product = productRepo.getById(id);
		return product.getImage();
	}
}
