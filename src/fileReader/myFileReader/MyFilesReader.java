package fileReader.myFileReader;

import java.io.FileInputStream;

public abstract class MyFilesReader implements ActionFileReader {

    private String path;

    private FileInputStream file;

    public MyFilesReader(String path) {
        this.path = path;
    }

    public void openFile() {
        java.io.File file = new java.io.File(path);

        try {
            this.file = new FileInputStream(file);
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    public void closeFile() {
        try {
            this.file.close();
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    public FileInputStream getFile() {
        return this.file;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public abstract void normalRead();
    public abstract void reverseRead();
    public abstract void palindromicRead();
}
