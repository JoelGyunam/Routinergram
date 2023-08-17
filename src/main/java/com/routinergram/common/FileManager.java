package com.routinergram.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.web.multipart.MultipartFile;

public class FileManager {
	
	public static final String FILE_UPLOAD_PATH = "C:\\Users\\gynpa\\Documents\\projects\\routinergram\\files";

	public static String saveFile(int UID, MultipartFile files) {
		
		if(files==null) {
			return null;
		}
		
		String directoryName = "/" + UID + "_" + System.currentTimeMillis() + "/";
		String directoryPath = FILE_UPLOAD_PATH + directoryName;
		
		File directory = new File(directoryPath);
		if(!directory.mkdir()) {
			return null;
		};
		
		try {
			byte[] bytes = files.getBytes();
			String filePath = directoryPath + files.getOriginalFilename();
			Path path = Paths.get(filePath);
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "/images" + directoryName + files.getOriginalFilename();
	};
	
	public static boolean deleteFile(String filePath) {
		if(filePath=="") {
			return false;
		}
		
		String fullFilePath = FILE_UPLOAD_PATH + filePath.replace("/images", "");
		
		Path path = Paths.get(fullFilePath);
		if(Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		Path dirPath = path.getParent();
		if(Files.exists(dirPath)) {
			try {
				Files.delete(dirPath);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
