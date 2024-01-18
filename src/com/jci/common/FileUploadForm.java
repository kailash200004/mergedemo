package com.jci.common;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadForm {

	private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		System.out.println("INFO : set file method of bean class");
		this.files = files;
	}


}
