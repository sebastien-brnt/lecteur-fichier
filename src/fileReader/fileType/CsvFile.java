package fileReader.fileType;

import fileReader.fileReader.FilesReader;

public class CsvFile extends FilesReader {

    public CsvFile(String path) {
        super(path);
    }
    public void normalRead() {
        System.out.println("normalRead");
    }

    public void reverseRead() {
        System.out.println("reverseRead");
    }

    public void palindromicRead() {
        System.out.println("palindromicRead");
    }
}
