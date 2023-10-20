package fileReader.fileType;


import fileReader.fileReader.FilesReader;

import java.io.FileInputStream;

public class TextFile extends FilesReader {

    public TextFile(String path) {
        super(path);
    }

    public void normalRead() {
        System.out.println("======= Normal file playback =======");
        char[] buffer = new char[50];

        try {
            FileInputStream myFile = this.getFile();
            int data = myFile.read();

            int i = 0;
            while (data != -1) {
                buffer[i] = (char) data;
                data = myFile.read();

                i++;
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        System.out.println(buffer);
    }


    public void reverseRead() {
        System.out.println("reverseRead");
    }

    public void palindromicRead() {
        System.out.println("palindromicRead");
    }
}
