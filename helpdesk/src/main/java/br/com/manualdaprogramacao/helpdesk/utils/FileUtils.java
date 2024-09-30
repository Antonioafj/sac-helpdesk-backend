package br.com.manualdaprogramacao.helpdesk.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class FileUtils {

        public static byte[] convertBase64ToByteArray(String base64String) throws IOException {
            String[] base64Parts = base64String.split(",");
            byte[] fileBytes = Base64.getDecoder().decode(base64Parts[1]);
            return fileBytes;

        }

        public static void saveByteArrayToFile(byte[] data,   File file) throws IOException {
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
        }

        public static String extractFileExtensionFromBase64String(String base64String) {
            String[] parts = base64String.replace("data:", "").split(";base64,");
            if (parts.length == 2) {
                String contentType = parts[0];
                if (contentType.contains("/")) {
                    return contentType.split("/")[1];
                }
            }
            return null;
        }
}

























