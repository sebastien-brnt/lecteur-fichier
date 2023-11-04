package fileReader.myFileReader;

import java.io.File;
import java.io.FileInputStream;

public abstract class MyFilesReader implements ActionFileReader {

    // Attributes
    private final String path;
    private FileInputStream file;

    // Constructor
    public MyFilesReader(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path cannot be null or empty");
        } else {
            this.path = path;
        }
    }

    // Open the file
    @Override
    public void openFile() {
        File file = new File(path);
        try {
            this.file = new FileInputStream(file);
        } catch (Exception e){
            e.getStackTrace();
        }
    }

    // Close the file
    @Override
    public void closeFile() {
        if (this.file != null) {
            try {
                this.file.close();
            } catch (Exception e){
                e.getStackTrace();
            }
        }
    }

    // Get the file
    @Override
    public FileInputStream getFile() {
        return this.file;
    }

    // Get path of file
    @Override
    public String getPath() {
        return path;
    }

    //Abstract methods to be implemented by subclasses
    public abstract void normalRead();
    public abstract void reverseRead();
    public abstract void palindromicRead();
}
