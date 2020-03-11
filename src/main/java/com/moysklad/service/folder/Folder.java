package com.moysklad.service.folder;

import java.io.File;

public class Folder {
  private File folder;

    public void createFolder(String applicationPath, String folder, String subdirectory) {
        String filePath = applicationPath + File.separator + folder + File.separator + subdirectory + File.separator;
        this.folder = new File(filePath);
        if (!this.folder.exists()) {
            this.folder.mkdirs();
        }
    }
    public String[] getFilesInDir(String applicationPath, String folder, String subdirectory) {
        String filepath = applicationPath + File.separator+folder+ File.separator + subdirectory + File.separator;
        File dir = new File(filepath);
        return dir.list();
    }
    public File getFolder(String applicationPath, String folder, String subdirectory) {
        String filepath = applicationPath + File.separator+folder+ File.separator + subdirectory + File.separator;
        File dir = new File(filepath);
        return dir;
    }
    public String getFolderString(String applicationPath, String folder, String subdirectory) {
        String filepath = applicationPath + File.separator+folder+ File.separator + subdirectory + File.separator;
        return filepath;
    }
    public void deleteListFolder(String applicationPath, String folder, String subdirectory) {
        File dir = new File(applicationPath + File.separator + folder + File.separator + subdirectory + File.separator);
        try {
            for (File file : dir.listFiles()
            ) {
                if (file.delete()) {
                }
            }
        } catch (NullPointerException e )
        {
            e.printStackTrace();
        }
    }
}
