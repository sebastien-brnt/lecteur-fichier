package fileReader.fileReader;

import java.io.FileInputStream;
import java.io.FileReader;

public abstract class FilesReader implements ActionFileReader {

    private String path;

    private FileInputStream file;

    public FilesReader(String path) {
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

    public abstract void normalRead();
    public abstract void reverseRead();
    public abstract void palindromicRead();
}
