package ge.unknown.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static ge.unknown.utils.constants.Constants.UploadHelpers.*;

public class MGLUploadHelper {


    public static List<String> uploadFiles(MultipartFile[] files, String objectName) {
        List<String> fileNames = new ArrayList<>(files.length);
        for (int i = 0; i < files.length; i++) {
            String uploadPath = getPath(objectName);
            MultipartFile file = files[i];
            try {
                String extension;
                int index = file.getOriginalFilename().lastIndexOf('.');
                if (index >= 0) extension = file.getOriginalFilename().substring(index + 1);
                else continue;
                if (!MGLIOUtils.isValidExtension(extension.toLowerCase())) continue;
                byte[] bytes = file.getBytes();
                String ap = MGLIOUtils.checkDirs(uploadPath);
                String md5String = GeneralUtil.encodeMD5(GeneralUtil.generateString(11));
                String md5FileName = String.format("%s%s%s", md5String, ".", extension);
                String serverFileName = String.format("%s%s%s", ap, File.separator, md5FileName);
                File serverFile = new File(serverFileName);
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();

                makeThumbs(extension, serverFileName);
                fileNames.add(md5FileName);
            } catch (Exception e) {
            }
        }
        return fileNames;
    }

    private static String makeThumbs(String extension, String path) {
        if (extension.equals("png") || extension.equals("jpg")) {
            return MGLIOUtils.ImageUtils.resizeImage(path);
        }
        return "";
    }

    private static String getPath(String path) {
        switch (path) {
            case "USER_IMG":
                return USER_IMG;
            case "SLIDER_IMG":
                return SLIDER_IMG;
            case "TEAM_IMG":
                return TEAM_IMG;
            case "HOTEL_IMG":
                return HOTEL_IMG;
            case "HOTEL_GALLERY":
                return HOTEL_GALLERY;
            case "TOUR_IMG":
                return TOUR_GALLERY;
            default:
                return UPLOADS;
        }
    }
}
