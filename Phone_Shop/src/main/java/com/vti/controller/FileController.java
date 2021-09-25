package com.vti.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.vti.service.IFileService;
import com.vti.ultis.FileManager;

@RestController
@RequestMapping(value = "/api/v1/files")
@CrossOrigin("*")
public class FileController {

	@Autowired
	private IFileService fileService;

	/**
	 * API upload Image
	 */
	
	@PostMapping(value = "/image")
	public ResponseEntity<?> upLoadImage(@RequestParam(name = "image") MultipartFile image,
			@RequestParam(name = "id", required = false) Long id) throws IOException {

		if (!new FileManager().isTypeFileImage(image)) {
			return new ResponseEntity<>("File must be image!", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<String>(fileService.uploadImage(image, id), HttpStatus.OK);
	}

	/**
	 * API dowload Image
	 */
	
	@GetMapping(value = "/image")
	public ResponseEntity<?> downloadImage(@RequestParam String nameImage) throws IOException {

		// TODO validate

		File imageFile = fileService.dowwnloadImage(nameImage);
		InputStreamResource imageStream = new InputStreamResource(new FileInputStream(imageFile));

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", nameImage));
		headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
		headers.add("Pragma", "no-cache");
		headers.add("Expires", "0");

		return ResponseEntity.ok().headers(headers).contentLength(imageFile.length())
				.contentType(MediaType.parseMediaType("image/jpeg")).body(imageStream);
	}
	
	/**
	 * API get ImageName by ImageID
	 */

	@GetMapping(value = "/image/{id}")
	public ResponseEntity<?> getImgNameByID(@PathVariable(name = "id") Long id) {
		String imgName = fileService.getImgNameByID(id);
		return new ResponseEntity<String>(imgName, HttpStatus.OK);
	}

}
