package fileReader.fileType;


import fileReader.fileReader.FilesReader;

import java.io.FileInputStream;

public class TextFile extends FilesReader {

    public TextFile(String path) {
        super(path);
    }
    public void normalRead() {
        FileInputStream myFile = this.getFile();
        System.out.println("normalRead");
    }

    public void reverseRead() {
        System.out.println("reverseRead");
    }

    public void palindromicRead() {
        System.out.println("palindromicRead");
    }
}
